package com.jb.couponsysp2g2.clr;

import com.jb.couponsysp2g2.beans.Company;
import com.jb.couponsysp2g2.beans.Customer;
import com.jb.couponsysp2g2.services.AdminService;
import com.jb.couponsysp2g2.services.AdminServiceImpl;
import com.jb.couponsysp2g2.utils.Art;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
@RequiredArgsConstructor
public class TestAdminService implements CommandLineRunner {

    private final AdminService adminService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(Art.ADMIN_SERVICE);

        System.out.println("=======================CHECK LOGIN ADMIN========================");
        System.out.println("wrong email for login");
        System.out.println(((AdminServiceImpl) adminService).login("a@","rot"));
        System.out.println("correct email for login");
        System.out.println(((AdminServiceImpl) adminService).login("admin@admin.com","admin"));

        System.out.println();
        System.out.println("=======================ADD COMPANY WITH CHECKS========================");
        //email company is already exist

//        Company comp6 = Company.builder()
//                .email("ivory@gmail.com")
//                .name("dror")
//                .password("iv123")
//                .build();

        //name company is already exist

        Company comp7 = Company.builder()
                .email("dror@gmail.com")
                .name("ivory")
                .password("iv123")
                .build();

        Company comp8 = Company.builder()
                .email("dror@gmail.com")
                .name("dror")
                .password("dr123")
                .build();

//email company is already exist
//        adminService.addCompany(comp6)

//name company is already exist
//        adminService.addCompany(comp7);

        adminService.addCompany(comp8);
        adminService.getAllCompanies().forEach(System.out::println);

        System.out.println();
        System.out.println("=======================UPDATE COMPANY WITH CHECKS========================");
//Can't Update  - CompanyId Not Exist
//        adminService.updateCompany(7,comp7);

        Company comp9 = Company.builder()
                .id(6)
                .email("dror@gmail.com")
                .name("moshe")
                .password("dr123")
                .build();
        adminService.updateCompany(6,comp9);
        adminService.getAllCompanies().forEach(System.out::println);

        System.out.println();
        System.out.println("=======================DELETE COMPANY WITH CHECKS========================");

        adminService.deleteCompany(6);
        adminService.getAllCompanies().forEach(System.out::println);

        System.out.println();
        System.out.println("=======================SELECT ALL COMPANY ========================");

        adminService.getAllCompanies().forEach(System.out::println);

        System.out.println();
        System.out.println("=======================SELECT ONE COMPANY ========================");
        System.out.println(adminService.getSingleCompany(1));

        System.out.println();
        System.out.println("=======================ADD CUSTOMER WITH CHECKS ========================");
        Customer cust6 = Customer.builder()
                .email("tajev@gmail.com")
                .password("tj123")
                .firstName("tajev")
                .lastName("semay")
                .build();
//Can't add  - Customer With This Email already Exist, Enter Different Email
//        adminService.addCustomer(cust6);

        Customer cust7 = Customer.builder()
                .email("dror@gmail.com")
                .password("dr123")
                .firstName("dror")
                .lastName("semay")
                .build();
        adminService.addCustomer(cust7);

        System.out.println();
        System.out.println("=======================UPDATE CUSTOMER WITH CHECKS ========================");
        Customer cust8 = Customer.builder()
                .email("yrga@gmail.com")
                .password("yr123")
                .firstName("yrga")
                .lastName("semay")
                .build();
//Can't Update  - CustomerId already Exist
//        adminService.updateCustomer(1,cust8);

        System.out.println();
        System.out.println("=======================DELETE CUSTOMER  ========================");

        adminService.deleteCustomer(5);

        System.out.println();
        System.out.println("=======================SELECT ALL CUSTOMER ========================");

        adminService.getAllCustomers().forEach(System.out::println);

        System.out.println();
        System.out.println("=======================SELECT ONE CUSTOMER ========================");
        System.out.println(adminService.getSingleCustomer(1));


    }
}
