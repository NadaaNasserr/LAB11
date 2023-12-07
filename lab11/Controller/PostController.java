package com.example.lab11.Controller;


import com.example.lab11.Model.Post;
import com.example.lab11.Service.PostService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/post")
public class PostController {


    private final PostService postService;

    @GetMapping("/get")
    public ResponseEntity getAllPost() {

        return ResponseEntity.status(200).body(postService.getAllPosts());
    }


    @PostMapping("/add")
    public ResponseEntity addPost(@RequestBody @Valid Post post, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        postService.addPost(post);
        return ResponseEntity.status(200).body("post added");

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updatePost(@PathVariable Integer id, @RequestBody @Valid Post post, Errors errors) {

        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        Post postUpdate = postService.updatePost(id, post);
        return ResponseEntity.status(200).body(postUpdate);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePost(@PathVariable Integer id) {

        postService.deletePost(id);

        return ResponseEntity.status(200).body("post deleted");
    }



    @GetMapping("/AuthorId/{userID}")
    public ResponseEntity getAllPostByAuthorId(@PathVariable Integer userID) {
        List<Post> postList = postService.getAllPostByAuthorId(userID);
        return ResponseEntity.status(200).body(postList);

   }
    @GetMapping("/findAllByPOrderByPublicationDate/{date}")
    public ResponseEntity findAllByPOrderByPublicationDate(@PathVariable Date date){
        List<Post> postList = postService.findAllByPublicationDateAfter(date);
        return ResponseEntity.status(200).body(postList);

    }



    @GetMapping("/findAllByTitleLike/{title}")
    public ResponseEntity findAllByTitleLike(@PathVariable String title){
        List<Post> postList = postService.findAllByTitleLike(title);
        return ResponseEntity.status(200).body(postList);

    }
    }

