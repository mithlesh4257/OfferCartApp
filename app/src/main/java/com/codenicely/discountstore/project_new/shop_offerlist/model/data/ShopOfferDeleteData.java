package com.codenicely.discountstore.project_new.shop_offerlist.model.data;

/**
 * Created by aman on 18/5/17.
 */

public class ShopOfferDeleteData {

    boolean success;
    String message;

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public ShopOfferDeleteData(boolean success, String message) {

        this.success = success;
        this.message = message;
    }
}