package com.example.Assessment.Repository;

import com.example.Assessment.Model.Category;
import com.example.Assessment.Model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    @Query(value = "SELECT c FROM Category c where c.name like :categoryName")
    List<Category>getCategoryBycategoryName(String categoryName);

    @Query(value = "SELECT c FROM Category c where c.description like :categoryDescription")
    List<Category> getCategoryBycategoryDescription(String categoryDescription);


}
