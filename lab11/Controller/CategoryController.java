package com.example.lab11.Controller;


import com.example.lab11.Model.Category;
import com.example.lab11.Model.Comment;
import com.example.lab11.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {


    private final CategoryService categoryService;


    @GetMapping("/get")
    public ResponseEntity getAllCategory() {

        return ResponseEntity.status(200).body(categoryService.getAllCategory());
    }

    @PostMapping("/add")
    public ResponseEntity addCategory(@RequestBody @Valid Category category, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        categoryService.addCategory(category);
        return ResponseEntity.status(200).body("Category added");

    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateCategory(@PathVariable Integer id, @RequestBody @Valid Category category, Errors errors) {

        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        Category CategoryUpdate = categoryService.updateCategory(id, category);
        return ResponseEntity.status(200).body(CategoryUpdate);
    }





    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable Integer id) {

        categoryService.deleteCategory(id);
        return ResponseEntity.status(200).body("Category deleted");
    }





    @GetMapping("/getCategory/{categoryName}")
    public ResponseEntity findAllByCategoryName(@PathVariable String categoryName){
        List<Category> categoryList = categoryService.findAllByCategoryName(categoryName);
        return ResponseEntity.status(200).body(categoryList);

    }




    @GetMapping("/getCategory/{postId}")
    public ResponseEntity getAllCategoryByPostId(@PathVariable Integer postId){
        List<Category> categoryList = categoryService.getAllCategoryByPostId(postId);
        return ResponseEntity.status(200).body(categoryList);

    }
}
