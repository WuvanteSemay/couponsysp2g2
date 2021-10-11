package com.jb.couponsysp2g2.exceptions;

public enum ErrMsg {

    COMPANY_EMAIL_EXIST ("email is already exist"),
    COMPANY_NAME_EXIST("name is already exist"),
    COMPANY_ID_NOT_EXIST("Can't Update  - CompanyId Not Exist"),
    COMPANY_ID_AND_NAME_EXIST("Can't Update  - CompanyId And Name already Exist"),
    CUSTOMER_EMAIL_EXIST ("Can't add  - Customer With This Email already Exist, Enter Different Email"),
    CUSTOMER_ID_EXIST("Can't Update  - CustomerId already Exist"),
    TITLE_COUPON_EXIST("Can't add  - Company With This Title already Exist, Enter Different Title"),
    COUPON_ID_NOT_EXIST("Can't Update  - CouponId Not Exist"),
    COUPON_ID_AND_COMPANY_ID_EXIST("Can't Update  - Coupon With This CouponId and CompanyId already Exist"),
    MAX_PURCHASE_COUPON("Can't Purchase  - Limited sale"),
    OUT_OF_STOCK("Can't Purchase  - Sorry, Out of Stock"),
    EXPIRED_COUPON("Can't Purchase - EXPIRED_COUPON");


    private String desc;

    ErrMsg(String desc){
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
