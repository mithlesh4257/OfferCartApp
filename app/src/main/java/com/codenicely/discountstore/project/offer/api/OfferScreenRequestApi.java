package com.codenicely.discountstore.project.offer.api;

import com.codenicely.discountstore.project.helper.Urls;
import com.codenicely.discountstore.project.offer.model.data.OfferScreenList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by aman on 19/10/16.
 */

public interface OfferScreenRequestApi {

    @GET(Urls.REQUEST_OFFER)
    Call<OfferScreenList> getCategoryListData(@Query("access_token") String access_token, @Query("shop_id") int shop_id);
}