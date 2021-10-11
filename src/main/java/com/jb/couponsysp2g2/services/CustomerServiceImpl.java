package com.jb.couponsysp2g2.services;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends ClientService implements CustomerService{
    @Override
    public boolean login(String email, String password) {
        return customerRepository.existsByEmailAndPassword(email, password);
    }
}
