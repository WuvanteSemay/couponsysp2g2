package com.jb.couponsysp2g2.job;

import com.jb.couponsysp2g2.repos.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DailyRemoval {

    private final CouponRepository couponRepository;

    @Scheduled(fixedRate = 1000*60*60*24)
    public void yala(){
//        couponRepository.expiredCoupon
    }

}
