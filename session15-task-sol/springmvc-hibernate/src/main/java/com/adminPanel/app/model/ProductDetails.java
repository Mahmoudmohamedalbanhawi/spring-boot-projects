package com.adminPanel.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "product_details")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    @NotBlank(message = " name is required")
    @Size(min = 3 , max = 50 , message = " name must be between 3 and 50 characters")
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "expiration_date")
    @NotNull(message = "Expiration date is required")
    @Future(message = "Expiration must be in the future")
    private Date expirationDate;
    @Column(name = "manufacturer")
    @NotBlank(message = "Manufacturer is required")
    private String manufacturer;
    @Column(name = "price")
    @NotNull(message = "price is required")
    @DecimalMin(value = "1.0", inclusive = false, message = "Price must be greater than one")
    private double price;
    @Column(name = "available")
    private boolean available;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
