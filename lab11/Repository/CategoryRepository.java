package com.example.lab11.Repository;


import com.example.lab11.Model.Category;
import com.example.lab11.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository  extends JpaRepository<Category,Integer > {

    Category findByCategoryId(Integer id);



    List<Category> findAllByCategoryName(String Category);



    @Query("select c from Category c where c.postID=?1")
    List<Category> getAllCategoryByPostId(Integer userID);


}
