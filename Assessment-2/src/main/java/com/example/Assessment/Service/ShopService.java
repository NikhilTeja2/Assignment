package com.example.Assessment.Service;

import com.example.Assessment.Model.Category;
import com.example.Assessment.Model.Product;
import com.example.Assessment.Repository.CategoryRepository;
import com.example.Assessment.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShopService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    @Autowired
    public ShopService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public List<Product> getProductByAnyField(Product product) {

        if(product.getName()!=null) {
           return productRepository.getProductByproductName(product.getName());
        }
        if(product.getDescription()!=null) {
            return productRepository.getProductByproductDescription(product.getDescription());
        }
        if(product.getPrice()!=0) {
            return productRepository.getProductByPrice(product.getPrice());
        }
        return null;
       // return productRepository.getProductByAnyField(product.getName(),product.getPrice(),product.getDescription());
    }

    public List<Category> getCategoryByAnyField(Category category) {

        if(category.getName()!=null) {
            return categoryRepository.getCategoryBycategoryName(category.getName());
        }
        if(category.getDescription()!=null) {
            return categoryRepository.getCategoryBycategoryDescription(category.getDescription());
        }
        return null;
        // return productRepository.getProductByAnyField(product.getName(),product.getPrice(),product.getDescription());
    }
}
