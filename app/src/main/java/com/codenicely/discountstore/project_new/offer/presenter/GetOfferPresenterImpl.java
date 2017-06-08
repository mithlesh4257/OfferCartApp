package com.codenicely.discountstore.project_new.offer.presenter;

import com.codenicely.discountstore.project_new.offer.OnGetOffer;
import com.codenicely.discountstore.project_new.offer.model.GetOffer_Provider;
import com.codenicely.discountstore.project_new.offer.model.data.OfferData;
import com.codenicely.discountstore.project_new.offer.view.GetOfferView;

/**
 * Created by meghal on 2/11/16.
 */

public class GetOfferPresenterImpl implements GetOfferPresenter {

    private GetOfferView getOfferView;
    private GetOffer_Provider buyOfferProvider;

    public GetOfferPresenterImpl(GetOfferView getOfferView, GetOffer_Provider buyOfferProvider) {
        this.getOfferView = getOfferView;
        this.buyOfferProvider = buyOfferProvider;
    }

    @Override
    public void getOffer(int offer_id, String access_token) {

        getOfferView.showLoadingDialog(true);
        buyOfferProvider.getOffer(offer_id, access_token, new OnGetOffer() {
            @Override
            public void onSuccess(OfferData getOfferData) {

                getOfferView.showLoadingDialog(false);
                if (getOfferData.isSuccess()) {
                //    getOfferView.showSnackMessage(buyOfferData.getMessage());
                    getOfferView.onOfferget(getOfferData);
                } else {
                  //  getOfferView.showSnackMessage(buyOfferData.getMessage());
                    getOfferView.onOfferget(getOfferData);

                }
            }

            @Override
            public void onFailure() {

                getOfferView.showLoadingDialog(false);
                getOfferView.showSnackMessage("Unable to connect to server ! Please check your Internet Connection.");
            }
        });

    }
}
