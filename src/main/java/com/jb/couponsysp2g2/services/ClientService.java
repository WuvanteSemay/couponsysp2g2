package com.jb.couponsysp2g2.services;

import com.jb.couponsysp2g2.repos.CompanyRepository;
import com.jb.couponsysp2g2.repos.CouponRepository;
import com.jb.couponsysp2g2.repos.CustomerRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
public abstract class ClientService {

    @Autowired
    protected CompanyRepository companyRepository;

    @Autowired
    protected CustomerRepository customerRepository;

    @Autowired
    protected CouponRepository couponRepository;

    public abstract boolean login (String email , String password);

}
