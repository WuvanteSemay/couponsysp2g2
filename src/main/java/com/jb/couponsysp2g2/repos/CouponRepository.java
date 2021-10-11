package com.jb.couponsysp2g2.repos;

import com.jb.couponsysp2g2.beans.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface CouponRepository extends JpaRepository<Coupon,Integer> {

    boolean existsByTitleAndCompanyId(String title, int companyId);
    boolean existsByIdAndCompanyId(int id , int companyId);
    List<Coupon> existsByCompanyId(int companyId);

    @Transactional
    @Modifying
    @Query(value = "delete from `couponsys-p2-g2`.customers_coupons where coupons_id = :couponId" , nativeQuery = true)
    void deleteFromCustomerCoupon(@Param("couponId") int couponId);

    @Query(value = "SELECT * FROM `couponsys-p2-g2`.coupons where company_id = :companyId" , nativeQuery = true)
    List<Coupon> getAllCouponsWithCompanies(@Param("companyId") int companyId);

    @Query(value = "SELECT * FROM `couponsys-p2-g2`.coupons where company_id = :companyId and category = :category" , nativeQuery = true)
    List<Coupon> getAllCouponsWithCategory(@Param("companyId") int companyId, @Param("category") int category);

    @Query(value = "SELECT * FROM `couponsys-p2-g2`.coupons where company_id = :companyId and price <=  :price" , nativeQuery = true)
    List<Coupon> getAllCouponsByMaxPrice(@Param("companyId") int companyId, @Param("price") double price);

    @Query(value = "SELECT * FROM `couponsys-p2-g2`.coupons AS coupons INNER JOIN `couponsys-p2-g2`.customers_coupons AS purchase ON coupons.id = purchase.coupons_id WHERE (purchase.customer_id = :customerId)" , nativeQuery = true)
    List<Coupon> getCouponJoinCustomer(@Param("customerId") int customerId);

    @Query(value = "SELECT * FROM `couponsys-p2-g2`.coupons AS coupons INNER JOIN `couponsys-p2-g2`.customers_coupons AS purchase ON coupons.id = purchase.coupons_id WHERE (purchase.customer_id = :customerId) AND (coupons.category = :category)" , nativeQuery = true)
    List<Coupon> getCouponJoinCustomerByCategory(@Param("customerId") int customerId , @Param("category") int category);


}

