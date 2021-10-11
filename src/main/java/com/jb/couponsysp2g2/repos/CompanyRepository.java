package com.jb.couponsysp2g2.repos;

import com.jb.couponsysp2g2.beans.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Integer> {

    boolean existsByEmail(String email);
    boolean existsByName(String name);
    boolean existsByEmailAndPassword(String email ,String password);






}
