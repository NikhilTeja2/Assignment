package com.example.Assessment.Controller;

import com.example.Assessment.Model.Category;
import com.example.Assessment.Model.Product;
import com.example.Assessment.Service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    ShopService shopService;

    @GetMapping("/findAllProducts")
    public List<Product>findAll(){
        return shopService.getAllProducts();
    }

    @GetMapping("/findAllCategories")
    public  List<Category>findAllCategories(){
        return shopService.getAllCategories();
    }

    @GetMapping("/getProductByField")
    public List<Product>getProducts(@RequestBody Product product){
        return shopService.getProductByAnyField(product);
    }

    @GetMapping("/getCategoryByField")
    public List<Category>getProducts(@RequestBody Category category){
        return shopService.getCategoryByAnyField(category);
    }


}
