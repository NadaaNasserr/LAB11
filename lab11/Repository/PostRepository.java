package com.example.lab11.Repository;


import com.example.lab11.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository  extends JpaRepository<Post, Indexed> {


    Post findAllByPostId(Integer id);

Post findByPostId(Integer id);
    @Query("select c from Post c where c.userID=?1")
    List<Post> getAllPostByAuthorId(Integer userID);


List<Post> findAllByTitleLike(String title);

    List<Post> findAllByPublicationDateAfter(Date PublicationDate);

}
