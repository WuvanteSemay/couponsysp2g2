package com.jb.couponsysp2g2.services;

import com.jb.couponsysp2g2.beans.Coupon;
import com.jb.couponsysp2g2.exceptions.CouponSystemException;
import com.jb.couponsysp2g2.exceptions.ErrMsg;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl extends ClientService implements CompanyService {




    @Override
    public boolean login(String email, String password) {
        return companyRepository.existsByEmailAndPassword(email,password);
    }

    @Override
    public void addCoupon(Coupon coupon) throws CouponSystemException {
        if (couponRepository.existsByTitleAndCompanyId(coupon.getTitle(),coupon.getCompany().getId())){
            throw new CouponSystemException(ErrMsg.TITLE_COUPON_EXIST);
        }
        couponRepository.save(coupon);
    }

    @Override
    public void updateCoupon(int couponId, Coupon coupon) throws CouponSystemException {
        if (!this.couponRepository.existsById(couponId)) {
            throw new CouponSystemException(ErrMsg.COUPON_ID_NOT_EXIST);
        }else {
            if (this.couponRepository.existsByIdAndCompanyId(couponId,coupon.getCompany().getId())){
                throw new CouponSystemException(ErrMsg.COUPON_ID_AND_COMPANY_ID_EXIST);
            };
        }
        couponRepository.saveAndFlush(coupon);
    }

    @Override
    public void deleteCoupon(int couponId) throws CouponSystemException {
        if (!this.couponRepository.existsById(couponId)) {
            throw new CouponSystemException(ErrMsg.COUPON_ID_NOT_EXIST);
        }
        couponRepository.deleteFromCustomerCoupon(couponId);
        couponRepository.deleteById(couponId);
    }



    @Override
    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }
}
