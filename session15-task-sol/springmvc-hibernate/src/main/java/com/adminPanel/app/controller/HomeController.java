package com.adminPanel.app.controller;

import com.adminPanel.app.error.ProductNotFoundException;
import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import com.adminPanel.app.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("/api")

public class HomeController
{

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/product")
    public List<Product> getAllProduct(Model model) {
        List<Product> products = productService.getAllProducts();
        return products;
    }
    @GetMapping(value = "/product/{id}")
    @Operation(summary = "Get product by Id" )
    @ApiResponses(value={
            @ApiResponse(code = 200 , message = "Product found"),
            @ApiResponse(code = 404 , message = "Product not found")
    })
    public Product getProductById(@PathVariable int id )
    {
        Product product = productService.getProductById(id);
        if(product == null)
        {
            throw new ProductNotFoundException("Product  with id " + id + " Not found ");
        }
        return product;
    }

    @PostMapping("/product")
    public ResponseEntity<?> createProduct(@Valid @RequestBody Product product, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        product.getProductDetails().setProduct(product);
        return ResponseEntity.ok(product);
    }
    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Integer id,
                                           @Valid @RequestBody Product product,
                                           BindingResult result) {

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        Product existing = productService.getProductById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        existing.setProductName(product.getProductName());

        ProductDetails details = existing.getProductDetails();
        details.setName(product.getProductDetails().getName());
        details.setManufacturer(product.getProductDetails().getManufacturer());
        details.setPrice(product.getProductDetails().getPrice());
        details.setExpirationDate(product.getProductDetails().getExpirationDate());
        details.setAvailable(product.getProductDetails().isAvailable());

        return ResponseEntity.ok(product);
    }
    @DeleteMapping(value = "/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id) {

        Product existing = productService.getProductById(id);

        if (existing == null) {
            throw new ProductNotFoundException("Product not found with ID: " + id);
        }

        productService.deleteProduct(id);


        Map<String, String> response = new HashMap<>();
        response.put("message", "Product deleted successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/product/search")
    public List<Product> searchProductsByName(@RequestParam("query") String query) {
        List<Product> products = productService.searchProductsByName(query);
        if(products.isEmpty())
        {
            throw new ProductNotFoundException("No products found matching " + query);
        }
        return products;
    }
}
