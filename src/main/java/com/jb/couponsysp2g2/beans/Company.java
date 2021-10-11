package com.jb.couponsysp2g2.beans;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "companies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    @OneToMany(cascade =  CascadeType.ALL,mappedBy = "company")
    @Singular
    @ToString.Exclude
    private List<Coupon> coupons = new ArrayList<>();

}
