package com.codenicely.discountstore.project_new.payment_shop.api;

import com.codenicely.discountstore.project_new.helper.Urls;
import com.codenicely.discountstore.project_new.payment.model.data.UpdatePaymentStatusData;
import com.codenicely.discountstore.project_new.payment_shop.model.data.UpdateShopPaymentData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by aman on 19/5/17.
 */

public interface PaymentUpdateApi {

    @FormUrlEncoded
    @POST(Urls.SUB_URL_UPDATE_SHOP_PAYMENT)
    Call<UpdateShopPaymentData> updateShopPaymentStatusDataCall(@Field("access_token") String access_token, @Field("transaction_id") String transaction_id);




}