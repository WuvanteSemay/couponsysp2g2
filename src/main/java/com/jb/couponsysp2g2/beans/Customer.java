package com.jb.couponsysp2g2.beans;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @ManyToMany
    @Singular
    private List<Coupon> coupons;
}
