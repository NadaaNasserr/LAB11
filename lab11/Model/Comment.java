package com.example.lab11.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Comment {



    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer commentId;


    @Column(columnDefinition = "int not null")
    @NotNull(message = "userID must be not empty")
    private Integer userID;

    @Column(columnDefinition = "int not null")
    @NotNull(message = "postID must be not empty")
    private Integer postID;


    @Column(columnDefinition = "varchar(225) not null")
    @NotEmpty(message = "content must be not empty")
    private String content;


    private Date commentDate;
}
