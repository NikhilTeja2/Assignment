package com.example.Assessment.Controller;
import com.example.Assessment.Model.Product;
import com.example.Assessment.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add-product")
    public Product addProduct(@RequestBody Product product){
       return productService.addProduct(product);
    }
    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable("id") int id){
        productService.deleteById(id);
    }

    @GetMapping("/product-with-category/{productId}/{categoryId}")
    public void linkProduct(@PathVariable("productId") int productId,@PathVariable("categoryId") int categoryId){
        productService.linkProductWithCategoryId(productId, categoryId);
    }

    @GetMapping("/find/{id}")
    public Product findProduct(@PathVariable("id") int id){
        return productService.findById(id);
    }

    @PostMapping("/update/{id}")
    public Product updateProduct(@PathVariable("id") int id ,@RequestBody Product product){
        return productService.updateProductById(id,product);
    }




}
