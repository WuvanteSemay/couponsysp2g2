package com.jb.couponsysp2g2.services;

import com.jb.couponsysp2g2.beans.Coupon;
import com.jb.couponsysp2g2.exceptions.CouponSystemException;

import java.util.List;

public interface CompanyService {

    void addCoupon (Coupon coupon) throws CouponSystemException;
    void updateCoupon (int couponId , Coupon coupon) throws CouponSystemException;
    void deleteCoupon (int couponId) throws CouponSystemException;
//    List<Coupon> getAllCouponsWithCompanies(int companyId);
    List <Coupon> getAllCoupons();


}
