package com.example.lab11.Repository;


import com.example.lab11.Model.Comment;
import com.example.lab11.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CommentRepository  extends JpaRepository<Comment,Integer> {


    Comment findAllByCommentId(Integer id);

    Comment findByCommentId(Integer id);
    Comment findByPostID(Integer postID);



    @Query("select c from Comment c where c.commentDate < ?1 ")
    List<Comment> getAllCommentDateBefore(Date comment);
   // List<Comment> findAllByCommentDateAfter(Date Comment);
}
