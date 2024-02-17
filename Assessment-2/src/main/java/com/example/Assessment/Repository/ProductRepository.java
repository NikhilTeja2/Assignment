package com.example.Assessment.Repository;

import com.example.Assessment.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "SELECT p FROM Product p where p.name like :productName")
    List<Product> getProductByproductName(String productName);

    @Query(value = "SELECT p FROM Product p where p.description like :productDescription")
    List<Product> getProductByproductDescription(String productDescription);

    @Query(value = "SELECT p FROM Product p where p.price = :productPrice")
    List<Product> getProductByPrice(int productPrice);
}
