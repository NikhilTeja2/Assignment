package com.example.Assessment.Controller;

import com.example.Assessment.Model.Category;
import com.example.Assessment.Model.Product;
import com.example.Assessment.Model.User;
import com.example.Assessment.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    @GetMapping("/findAll")
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @PostMapping("/addCategory")
    public Category addCategory(@RequestBody Category category){
        System.out.println("api hit");
        return categoryService.addCategory(category);
    }

    @GetMapping("/find/{id}")
    public Category findCategoryById(@PathVariable("id") int id)
    {
        return categoryService.findCategoryById(id);
    }

    @PostMapping("/update/{id}")
    public Category updateCategory(@PathVariable("id") int id , @RequestBody Category category){
        return categoryService.updateCategoryById(id,category);
    }

}
