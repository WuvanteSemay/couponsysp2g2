package com.jb.couponsysp2g2.exceptions;

public class CouponSystemException extends Exception {
    public CouponSystemException(ErrMsg errMsg) {
        super(errMsg.getDesc());
    }
}
