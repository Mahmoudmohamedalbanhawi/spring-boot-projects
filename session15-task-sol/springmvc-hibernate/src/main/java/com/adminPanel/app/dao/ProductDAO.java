package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductDAO  {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveProduct(Product product)
    {
        Session session = sessionFactory.getCurrentSession();

        if (product.getProductDetails() != null) {
            product.getProductDetails().setProduct(product);
        }

        session.saveOrUpdate(product);
    }


    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        List<Product> products = session.createQuery("from Product" , Product.class).getResultList();
        return  products !=null ? products : Collections.emptyList();
    }
    public Product getProductById(int id)
    {
        return sessionFactory.getCurrentSession().get(Product.class,id);
    }

    public void deleteProductById(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class , id);
        if(product != null)
        {
            session.delete(product);
        }
    }
    public void saveOrUpdate(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
    }
    public List<Product> findByProductName(String productName) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Product p WHERE lower(p.productName) LIKE :name";
        return session.createQuery(hql, Product.class)
                .setParameter("name", "%" + productName.toLowerCase() + "%")
                .getResultList();
    }

}
