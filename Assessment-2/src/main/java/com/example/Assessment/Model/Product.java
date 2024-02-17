package com.example.Assessment.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="Product")
public class Product {
    @Id
    @GeneratedValue
    @Column(name="product_id")
    private int id;
    @Column(name="product_name")
    private String name;
    @Column(name="product_price")
    private int price;
    @Column(name="product_description")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="categoryJoin")
    private Category category;
}
