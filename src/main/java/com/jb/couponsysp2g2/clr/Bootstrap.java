package com.jb.couponsysp2g2.clr;

import com.jb.couponsysp2g2.beans.Category;
import com.jb.couponsysp2g2.beans.Company;
import com.jb.couponsysp2g2.beans.Coupon;
import com.jb.couponsysp2g2.beans.Customer;
import com.jb.couponsysp2g2.repos.CompanyRepository;
import com.jb.couponsysp2g2.repos.CouponRepository;
import com.jb.couponsysp2g2.repos.CustomerRepository;
import com.jb.couponsysp2g2.services.AdminServiceImpl;
import com.jb.couponsysp2g2.services.ClientService;
import com.jb.couponsysp2g2.utils.Art;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;

@Component
@Order(1)
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {

    private final CouponRepository couponRepository;
    private final CompanyRepository companyRepository;
    private final CustomerRepository customerRepository;


    @Override
    public void run(String... args) throws Exception {
        System.out.println(Art.BOOTSTRAP_1);

        System.out.println(Art.COMPANY);

        Company comp1 = Company.builder()
                .email("ivory@gmail.com")
                .name("ivory")
                .password("iv123")
                .build();

        Company comp2 = Company.builder()
                .email("ksp@gmail.com")
                .name("ksp")
                .password("ks123")
                .build();

        Company comp3 = Company.builder()
                .email("hp@gmail.com")
                .name("hp")
                .password("hp123")
                .build();

        Company comp4 = Company.builder()
                .email("lenovo@gmail.com")
                .name("lenovo")
                .password("ln123")
                .build();

        Company comp5 = Company.builder()
                .email("dell@gmail.com")
                .name("dell")
                .password("dl123")
                .build();

        companyRepository.saveAll(Arrays.asList(comp1,comp2,comp3,comp4,comp5));
        companyRepository.findAll().forEach(System.out::println);

        System.out.println(Art.CUSTOMER);
        Customer cust1 = Customer.builder()
                .email("yrga@gmail.com")
                .password("yr123")
                .firstName("yrga")
                .lastName("semay")
                .coupon(couponRepository.getById(1))
                .build();

        Customer cust2 = Customer.builder()
                .email("tajev@gmail.com")
                .password("tj123")
                .firstName("tajev")
                .lastName("semay")
                .coupon(couponRepository.getById(2))
                .build();

        Customer cust3 = Customer.builder()
                .email("yasmin@gmail.com")
                .password("ys123")
                .firstName("yasmin")
                .coupon(couponRepository.getById(2))
                .lastName("semay")
                .build();

        Customer cust4 = Customer.builder()
                .email("uvante@gmail.com")
                .password("uv123")
                .firstName("uvante")
                .lastName("semay")
                .build();

        Customer cust5 = Customer.builder()
                .email("tamar@gmail.com")
                .password("tm123")
                .coupon(couponRepository.getById(1))
                .firstName("tamar")
                .lastName("semay")
                .build();
        customerRepository.saveAll(Arrays.asList(cust1,cust2,cust3,cust4,cust5));
        customerRepository.findAll().forEach(System.out::println);

        System.out.println(Art.COUPON);

        Coupon coup1 = Coupon.builder()
                .title("gamer")
                .description("all facilities")
                .amount(8)
                .price(9000.0)
                .company(companyRepository.getById(1))
                .image("http://harta.com")
                .category(Category.PC)
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().minusWeeks(2)))
                .build();

        Coupon coup2 = Coupon.builder()
                .title("startup")
                .description("for programmer ")
                .amount(12)
                .price(8000.0)
                .company(companyRepository.getById(2))
                .image("http://harta.com")
                .category(Category.PC)
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().minusWeeks(2)))
                .build();

        Coupon coup3 = Coupon.builder()
                .title("water")
                .description("waterproof ")
                .amount(12)
                .price(7000.0)
                .company(companyRepository.getById(3))
                .image("http://harta.com")
                .category(Category.PC)
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().minusWeeks(2)))
                .build();

        Coupon coup4 = Coupon.builder()
                .title("student")
                .description("for studies ")
                .amount(20)
                .price(6000.0)
                .company(companyRepository.getById(4))
                .image("http://harta.com")
                .category(Category.PC)
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().minusWeeks(2)))
                .build();

        Coupon coup5 = Coupon.builder()
                .title("life")
                .description("for fun life ")
                .amount(30)
                .price(5000.0)
                .company(companyRepository.getById(5))
                .image("http://harta.com")
                .category(Category.PC)
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().minusWeeks(2)))
                .build();

        couponRepository.saveAll(Arrays.asList(coup1,coup2,coup3,coup4,coup5));
        couponRepository.findAll().forEach(System.out::println);

    }
}
