package com.example.Assessment.Service;

import com.example.Assessment.Model.Category;
import com.example.Assessment.Model.Product;
import com.example.Assessment.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    public Category addCategory(Category category){
        return categoryRepository.save(category);

    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }


    public boolean existsById(int id){
        return categoryRepository.existsById(id);
    }

    public Field[] getFields(){
        return Category.class.getDeclaredFields();
    }



    public Category findCategoryById(int id){
        Optional<Category> temp= categoryRepository.findById(id);
        if(!temp.isEmpty()){
            return temp.get();
        }
        System.out.println("Not Found");
        return null;
    }

    public Category updateCategoryById(int id, Category category) {
        Optional<Category>optionalCategory =  categoryRepository.findById(id);
        if(optionalCategory.isEmpty())return null;

        Category findCategory = optionalCategory.get();
        if(category.getName()!=null) {
            findCategory.setName(category.getName());
        }
        if(category.getDescription()!=null) {
            findCategory.setDescription(category.getDescription());
        }


        Category updatedCategory = categoryRepository.save(findCategory);
        return updatedCategory;

    }








}
