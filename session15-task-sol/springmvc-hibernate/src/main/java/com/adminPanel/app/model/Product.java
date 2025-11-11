package com.adminPanel.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "product")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "product_name")
    @NotBlank(message = "Product name is required")
    @Size(min = 3 , max = 50 , message = "Product name must be between 3 and 50 characters")
    private String productName;

    @OneToOne(mappedBy = "product" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @Valid
    private ProductDetails productDetails;

}
