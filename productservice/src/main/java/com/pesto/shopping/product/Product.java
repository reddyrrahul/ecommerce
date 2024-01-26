package com.pesto.shopping.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.type.TrueFalseConverter;

@Getter
@Setter
@Entity
public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @jakarta.persistence.Id
    private Long Id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    private String desc;

    private String seller;

    @Convert(converter = TrueFalseConverter.class)
    private String isDeleted;

}
