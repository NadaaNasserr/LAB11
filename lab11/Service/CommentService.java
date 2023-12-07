package com.example.lab11.Service;


import com.example.lab11.API.ApiException;
import com.example.lab11.Model.Comment;
import com.example.lab11.Model.Post;
import com.example.lab11.Model.User;
import com.example.lab11.Repository.CommentRepository;
import com.example.lab11.Repository.PostRepository;
import com.example.lab11.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {


    private final CommentRepository commentRepository;
private final UserRepository userRepository;
private final PostRepository postRepository;

    public List<Comment> getAllComment(){

        return commentRepository.findAll();
    }

    public void addComment(Comment comment) {


        Post post = postRepository.findAllByPostId(comment.getPostID());
        User user = userRepository.findUserByUserId(comment.getUserID());
        if(post == null){
            throw new ApiException("post  id not found");
        }
        if(user == null){
            throw new ApiException("author id not found");
        }
        commentRepository.save(comment);
    }

    public Comment updateComment(Integer id, Comment comment) {
        User user = userRepository.findUserByUserId(comment.getUserID());
        Post post = postRepository.findAllByPostId(comment.getPostID());
        Comment comment1 = commentRepository.findAllByCommentId(id);

        if(comment1 == null){
    throw new ApiException("comment id not found");
}
        if (post==null) {
            throw new ApiException("post id not found");
        }
        if(user == null){
            throw new ApiException("author id not found");
        }

        comment1.setPostID(comment.getPostID());
        comment1.setUserID(comment.getUserID());
        comment1.setContent(comment.getContent());
        comment1.setCommentDate(comment.getCommentDate());
        commentRepository.save(comment1);
        return comment1;

    }

    public void deleteComment(Integer id){

        Comment comment = commentRepository.findByCommentId(id);
        if(comment == null){
            throw new ApiException("comment id not found");
        }
        commentRepository.delete(comment);

    }



    public List<Comment> getAllCommentDateBefore(Date c){

        List<Comment> comments = commentRepository.getAllCommentDateBefore(c);
        if(comments.isEmpty()){
            throw new ApiException("Date not found");
        }

        return  comments;
              }

    }







//    public List<Comment> findCommentByCommentDateBefore(Date c){
//
//        List<Comment> comments = commentRepository.findAllByCommentDateAfter(c);
//
//        if(comments.isEmpty()){
//            throw new ApiException("Date not found");
//        }
//
//        return  comments;
  //  }



