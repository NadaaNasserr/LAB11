package com.example.lab11.Service;


import com.example.lab11.API.ApiException;
import com.example.lab11.Model.Post;
import com.example.lab11.Model.User;
import com.example.lab11.Repository.PostRepository;
import com.example.lab11.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    private final UserRepository userRepository;
    private final UserService userService;


    public List<Post> getAllPosts() {

        return postRepository.findAll();
    }


    public void addPost(Post post) {

        User user = userRepository.findUserByUserId(post.getUserID());
        if (user == null) {
            throw new ApiException("author  id not found");
        }

            postRepository.save(post);
    }

    public Post updatePost(Integer id, Post post) {
        User user = userRepository.findUserByUserId(post.getUserID());
        Post post1 = postRepository.findAllByPostId(id);


        if (post1==null) {
            throw new ApiException("post id not found  ");
        }
        if(user == null){
            throw new ApiException("author id not found  ");
        }

        post1.setTitle(post.getTitle());
        post1.setUserID(post.getUserID());
        post1.setPublicationDate(post.getPublicationDate());
        postRepository.save(post1);
        return post1;


    }

    public void deletePost(Integer id){

        Post post = postRepository.findByPostId(id);
        if(post == null){
            throw new ApiException("post id not found");
        }
        postRepository.delete(post);

    }
    public List<Post> getAllPostByAuthorId(Integer userID){
        List<Post> postList = postRepository.getAllPostByAuthorId(userID);

        if(postList.isEmpty()){
            throw new ApiException("Author Id not found");

        }
        return postList;

    }

    public List<Post> findAllByPublicationDateAfter(Date cc){
        List<Post> postList = postRepository.findAllByPublicationDateAfter(cc);

        if(postList.isEmpty()){
            throw new ApiException("Date not found");

        }
        return postList;

    }

    public List<Post> findAllByTitleLike(String title ){
        List<Post> postList = postRepository.findAllByTitleLike(title);

        if(postList.isEmpty()){
            throw new ApiException("title not found");

        }
        return postList;

    }

}


