package com.example.lab11.Service;


import com.example.lab11.API.ApiException;
import com.example.lab11.Model.Category;
import com.example.lab11.Model.Comment;
import com.example.lab11.Model.Post;
import com.example.lab11.Model.User;
import com.example.lab11.Repository.CategoryRepository;
import com.example.lab11.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
private final PostRepository postRepository;

    public List<Category> getAllCategory(){

        return categoryRepository.findAll();
    }


    public void addCategory(Category category) {

        Post post = postRepository.findAllByPostId(category.getPostID());
        if(post == null){
            throw new ApiException("post  id not found");
        }
        categoryRepository.save(category);
    }

    public Category updateCategory(Integer id, Category category) {
        Post post = postRepository.findAllByPostId(category.getPostID());
        Category category1 = categoryRepository.findByCategoryId(id);

        if(category1 == null){
            throw new ApiException("category id not found");
        }
        if (post==null) {
            throw new ApiException("post id not found");
        }


        category1.setPostID(category1.getPostID());
        category1.setCategoryName(category.getCategoryName());

        categoryRepository.save(category1);
        return category1;

    }


    public void deleteCategory(Integer id){
        Category category = categoryRepository.findByCategoryId(id);
        if(category == null){
            throw new ApiException("category id not found");
        }
        categoryRepository.delete(category);

    }

    public List<Category> findAllByCategoryName(String categoryName){

        List<Category> categoryList =categoryRepository.findAllByCategoryName(categoryName);
        if(categoryList.isEmpty()){
            throw new ApiException("category Name not found");
        }
        return categoryList;
    }

    public List<Category> getAllCategoryByPostId(Integer id){

        List<Category> categoryList =categoryRepository.getAllCategoryByPostId(id);
        if(categoryList.isEmpty()){
            throw new ApiException("post id not found");
        }
        return categoryList;
    }

}
