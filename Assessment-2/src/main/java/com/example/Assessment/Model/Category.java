package com.example.Assessment.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="Assessment_Category")
public class Category {
    @Id
    @GeneratedValue
    @Column(name="category_id")
    private int id;
    @Column(name="category_name")
    private String name;

    @Column(name="category_description")
    private String description;

}
