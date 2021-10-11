package com.jb.couponsysp2g2.clr;

import com.jb.couponsysp2g2.beans.Category;
import com.jb.couponsysp2g2.beans.Coupon;
import com.jb.couponsysp2g2.repos.CompanyRepository;
import com.jb.couponsysp2g2.repos.CouponRepository;
import com.jb.couponsysp2g2.services.CompanyService;
import com.jb.couponsysp2g2.services.CompanyServiceImpl;
import com.jb.couponsysp2g2.utils.Art;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
@Order(3)
@RequiredArgsConstructor
public class TestCompanyService implements CommandLineRunner {
    private final CompanyService companyService;
    private final CompanyRepository companyRepository;
    private final CouponRepository couponRepository;


    @Override
    public void run(String... args) throws Exception {
        System.out.println(Art.COMPANY_SERVICE);
        System.out.println("=======================CHECK LOGIN ADMIN========================");
        System.out.println("wrong email for login");
        System.out.println(((CompanyServiceImpl) companyService).login("a@","rot"));
        System.out.println("correct email for login");
        System.out.println(((CompanyServiceImpl) companyService).login("ivory@gmail.com","iv123"));

        System.out.println("=======================CHECK TITLE COUPON========================");
//("Can't add  - Company With This Title already Exist, Enter Different Title");
        Coupon coup6 = Coupon.builder()
//                .title("gamer")
                .title("addSuccess")
                .description("all facilities")
                .amount(8)
                .price(9000.0)
                .company(companyRepository.getById(1))
                .image("http://harta.com")
                .category(Category.PC)
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().minusWeeks(2)))
                .build();
        companyService.addCoupon(coup6);
        companyService.getAllCoupons().forEach(System.out::println);

        System.out.println();
        System.out.println("=======================UPDATE COUPON WITH CHECKS========================");
//Can't Update  - CouponId Not Exist
        Coupon coup7 = Coupon.builder()
//                .id(7)
                .id(6)
                .title("updateSuccess")
                .description("all facilities")
                .amount(8)
                .price(9000.0)
                .company(companyRepository.getById(2))
//                .company(companyRepository.getById(1))
                .image("http://harta.com")
                .category(Category.PC)
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().minusWeeks(2)))
                .build();
        companyService.updateCoupon(6,coup7);
        companyService.getAllCoupons().forEach(System.out::println);

        System.out.println();
        System.out.println("=======================DELETE COUPON WITH CHECKS========================");
//        companyService.deleteCoupon(2);
        companyService.getAllCoupons().forEach(System.out::println);


        System.out.println();
        System.out.println("=======================SELECT COUPON BY COMPANYID -2========================");
        couponRepository.getAllCouponsWithCompanies(2)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("=======================SELECT COUPON BY CATEGORY AND COMPANYID ========================");
        couponRepository.getAllCouponsWithCategory(2,1)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("=======================SELECT COUPON BY MAX PRICE ========================");
        couponRepository.getAllCouponsByMaxPrice(2,8500.0)
                .forEach(System.out::println);


    }
}
