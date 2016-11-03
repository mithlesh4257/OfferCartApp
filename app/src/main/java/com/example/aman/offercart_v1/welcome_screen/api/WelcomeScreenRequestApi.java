package com.example.aman.offercart_v1.welcome_screen.api;

import com.example.aman.offercart_v1.helper.Urls;
import com.example.aman.offercart_v1.welcome_screen.models.data.WelcomeScreenData;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by aman on 16/10/16.
 */
public interface WelcomeScreenRequestApi {

    @GET(Urls.REQUEST_Welcome_SCREEN)
    Call<WelcomeScreenData> getWelcomeData();

}
