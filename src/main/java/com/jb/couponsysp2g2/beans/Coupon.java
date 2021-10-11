package com.jb.couponsysp2g2.beans;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name = "coupons")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.ORDINAL)
    private Category category;
    @ManyToOne
    @ToString.Exclude
    private Company company;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private int amount;
    private Double price;
    private String image;
}
