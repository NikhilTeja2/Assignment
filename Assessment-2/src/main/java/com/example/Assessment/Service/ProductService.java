package com.example.Assessment.Service;


import com.example.Assessment.Model.Category;
import com.example.Assessment.Model.Product;
import com.example.Assessment.Repository.CategoryRepository;
import com.example.Assessment.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    public Product addProduct(Product product){
        return productRepository.save(product);
    }
    public void deleteById(int id){
        productRepository.deleteById(id);
    }

    public boolean linkProductWithCategoryId(int productId,int categoryId){
        Optional<Product> productOptional = productRepository.findById(productId);
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);

        if(categoryOptional.isEmpty() || productOptional.isEmpty())return false;
        Product product = productOptional.get();
        product.setCategory(categoryOptional.get());
        productRepository.save(product);
        return true;


    }

    public Product findById(int id){

        Optional<Product>optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty())return null;
        return  optionalProduct.get();
    }

    public Product updateProductById(int id, Product product) {
        Optional<Product>optionalProduct=productRepository.findById(id);
        if(optionalProduct.isEmpty())return null;
        Product findProduct = productRepository.findById(id).get();
        if(product.getName()!=null) {
            findProduct.setName(product.getName());
        }
        if(product.getDescription()!=null) {
            findProduct.setDescription(product.getDescription());
        }
        if(product.getPrice()!=0) {
            findProduct.setPrice(product.getPrice());
        }
        if(product.getCategory()!=null) {
            findProduct.setCategory(product.getCategory());
        }
        Product updatedProduct = productRepository.save(findProduct);
        return updatedProduct;

    }






}
