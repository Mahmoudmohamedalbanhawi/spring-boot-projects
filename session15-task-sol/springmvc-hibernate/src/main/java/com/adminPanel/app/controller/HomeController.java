package com.adminPanel.app.controller;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import com.adminPanel.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController
{

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String homePage(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("productsList", products);
        return "homePage";
    }
    @RequestMapping("/showProductDetails")
    public String showProductDetails(@RequestParam("id") int id , Model model)
    {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "viewDetailsPage";
    }
    @RequestMapping("/addProduct")
    public String showAddProductForm(Model model) {
        Product product = new Product();
        product.setProductDetails(new ProductDetails());
        model.addAttribute("product", product);
        return "addProductForm";
    }
    @PostMapping("/saveProduct")
    public String saveProduct(@Valid @ModelAttribute("product") Product product , BindingResult result) {
        if(result.hasErrors())
        {
            return "addProductForm";
        }
        if (product.getId() != null) {
            Product existing = productService.getProductById(product.getId());
            if (existing != null) {
                existing.setProductName(product.getProductName());


                ProductDetails details = existing.getProductDetails();
                details.setName(product.getProductDetails().getName());
                details.setManufacturer(product.getProductDetails().getManufacturer());
                details.setPrice(product.getProductDetails().getPrice());
                details.setExpirationDate(product.getProductDetails().getExpirationDate());
                details.setAvailable(product.getProductDetails().isAvailable());

                productService.saveOrUpdateProduct(existing);
            }
        } else {
            product.getProductDetails().setProduct(product);
            productService.saveOrUpdateProduct(product);
        }
        return "redirect:/?saved=true";
    }
    @RequestMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("id") int id) {
        productService.deleteProduct(id);
        return "redirect:/?deleted=true";
    }
    @RequestMapping("/editProduct")
    public String showEditProductForm(@RequestParam("id") int id, Model model) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return "redirect:/?error=notfound";
        }
        model.addAttribute("product", product);
        return "addProductForm";
    }

    @RequestMapping("/search")
    public String searchProducts(@RequestParam("query") String query, Model model) {
        List<Product> products = productService.searchProductsByName(query);
        model.addAttribute("productsList", products);
        model.addAttribute("searchQuery", query);
        return "homePage";
    }
}
