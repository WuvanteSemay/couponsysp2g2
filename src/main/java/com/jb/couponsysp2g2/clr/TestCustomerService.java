package com.jb.couponsysp2g2.clr;

import com.jb.couponsysp2g2.repos.CouponRepository;
import com.jb.couponsysp2g2.repos.CustomerRepository;
import com.jb.couponsysp2g2.services.CustomerService;
import com.jb.couponsysp2g2.services.CustomerServiceImpl;
import com.jb.couponsysp2g2.utils.Art;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(4)
@RequiredArgsConstructor
public class TestCustomerService implements CommandLineRunner {
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;
    private final CouponRepository couponRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(Art.CUSTOMER_SERVICE);
        System.out.println("=======================CHECK LOGIN ADMIN========================");
        System.out.println("wrong email for login");
        System.out.println(((CustomerServiceImpl) customerService).login("a@","rot"));
        System.out.println("correct email for login");
        System.out.println(((CustomerServiceImpl) customerService).login("yrga@gmail.com","yr123"));

        System.out.println();
        System.out.println("=======================COUPON JOIN CUSTOMER========================");
        couponRepository.getCouponJoinCustomer(2)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("=======================COUPON JOIN CUSTOMER by Category========================");
        couponRepository.getCouponJoinCustomerByCategory(2,1)
                .forEach(System.out::println);

        System.out.println("  █████    █████                                             █████\n" +
                " ░░███    ░░███                                             ░░███ \n" +
                " ███████   ░███████    ██████         ██████  ████████    ███████ \n" +
                "░░░███░    ░███░░███  ███░░███       ███░░███░░███░░███  ███░░███ \n" +
                "  ░███     ░███ ░███ ░███████       ░███████  ░███ ░███ ░███ ░███ \n" +
                "  ░███ ███ ░███ ░███ ░███░░░        ░███░░░   ░███ ░███ ░███ ░███ \n" +
                "  ░░█████  ████ █████░░██████       ░░██████  ████ █████░░████████\n" +
                "   ░░░░░  ░░░░ ░░░░░  ░░░░░░         ░░░░░░  ░░░░ ░░░░░  ░░░░░░░░ ");

    }
}
