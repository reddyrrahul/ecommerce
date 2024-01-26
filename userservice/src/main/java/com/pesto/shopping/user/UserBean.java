package com.pesto.shopping.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class UserBean {

    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @jakarta.persistence.Id
    private Long Id;

    @Getter
    @Setter
    private String name;

    @Setter
    @Getter
    private String email;

    @Getter
    @Setter
    private String address;

}
