package com.jb.couponsysp2g2.repos;

import com.jb.couponsysp2g2.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    boolean existsByEmail(String email);
    boolean existsByEmailAndPassword(String email ,String password);

}
