package com.example.lab11.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Category {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @Column(columnDefinition = "int not null")
    @NotNull(message = "postID must be not empty")
    private Integer postID;


    @Column(columnDefinition = "varchar(225) not null")
    @NotEmpty(message = "category name must be not empty")
    private String categoryName;



}
