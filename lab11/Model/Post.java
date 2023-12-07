package com.example.lab11.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;




    @Column(columnDefinition = "varchar(225) not null")
    @Size(min = 4 , message = "title length more than 4 ")
    @NotEmpty(message = "title must be not empty")
    private String title;


    @Column(columnDefinition = "int not null")
    @NotNull(message = "userID must be not empty")
    private Integer userID;


    private Date publicationDate;
}
