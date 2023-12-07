package com.example.lab11.Controller;


import com.example.lab11.Model.Comment;
import com.example.lab11.Model.Post;
import com.example.lab11.Service.CommentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/comment")
public class CommentController {


    private final CommentService commentService;


    @GetMapping("/get")
    public ResponseEntity getAllComment() {

        return ResponseEntity.status(200).body(commentService.getAllComment());
    }

    @PostMapping("/add")
    public ResponseEntity addComment(@RequestBody @Valid Comment comment, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        commentService.addComment(comment);
        return ResponseEntity.status(200).body("Comment added");

    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateComment(@PathVariable Integer id, @RequestBody @Valid Comment comment, Errors errors) {

        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        Comment commentUpdate = commentService.updateComment(id, comment);
        return ResponseEntity.status(200).body(commentUpdate);
    }





    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteComment(@PathVariable Integer id) {

        commentService.deleteComment(id);
        return ResponseEntity.status(200).body("Comment deleted");
    }



    @GetMapping("/getByDate/{c}")
    public ResponseEntity getAllCommentDateBefore(@PathVariable Date c){
        List<Comment> comments = commentService.getAllCommentDateBefore(c);
        return ResponseEntity.status(200).body(comments);

    }
}
