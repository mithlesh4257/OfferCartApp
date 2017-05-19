package com.codenicely.discountstore.project_new.payment_shop.model.data;

/**
 * Created by aman on 19/5/17.
 */

public class UpdateShopPaymentData {
    boolean success;
    String message;

    public UpdateShopPaymentData(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
