package com.adminPanel.app.service;

import com.adminPanel.app.dao.ProductDAO;
import com.adminPanel.app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ProductService  {
    @Autowired
    private ProductDAO productDAO;


    @Transactional
    public void saveProduct(Product product) {
        this.productDAO.saveProduct(product);
    }


    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return this.productDAO.getAllProducts();
    }
    @Transactional
    public Product getProductById(int id) {
        return productDAO.getProductById(id);
    }
    @Transactional
    public void deleteProduct(int id) {
        this.productDAO.deleteProductById(id);
    }

    @Transactional
    public void saveOrUpdateProduct(Product product) {

        if (product.getProductDetails() != null) {
            product.getProductDetails().setProduct(product);
        }
        productDAO.saveOrUpdate(product);
    }
    @Transactional
    public List<Product> searchProductsByName(String productName) {
        return productDAO.findByProductName(productName);
    }

}
