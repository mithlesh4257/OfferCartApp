package com.codenicely.discountstore.project_new.wallet.model;

import com.codenicely.discountstore.project_new.helper.Urls;
import com.codenicely.discountstore.project_new.wallet.api.WalletApi;
import com.codenicely.discountstore.project_new.wallet.model.data.WalletData;
import com.codenicely.discountstore.project_new.wallet.view.OnWalletInfoReceived;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by iket on 20/10/16.
 */
public class RetrofitWalletProvider implements WalletProvider {

    private WalletApi walletApi;

    public RetrofitWalletProvider() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        walletApi = retrofit.create(WalletApi.class);
    }

    @Override
    public void getWalletInfo(String access_token, final OnWalletInfoReceived onWalletInfoReceived) {

        Call<WalletData> call = walletApi.getWallet(access_token);
        call.enqueue(new Callback<WalletData>() {
            @Override
            public void onResponse(Call<WalletData> call, Response<WalletData> response) {

                onWalletInfoReceived.onSuccess(response.body());

            }

            @Override
            public void onFailure(Call<WalletData> call, Throwable t)
            {

                t.printStackTrace();
                onWalletInfoReceived.onFailure();

            }
        });
    }
}