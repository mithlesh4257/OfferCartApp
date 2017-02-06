package com.codenicely.discountstore.project_new.wallet.presenter;

import com.codenicely.discountstore.project_new.wallet.model.WalletProvider;
import com.codenicely.discountstore.project_new.wallet.model.data.WalletData;
import com.codenicely.discountstore.project_new.wallet.view.OnWalletInfoReceived;
import com.codenicely.discountstore.project_new.wallet.view.WalletInterface;

/**
 * Created by iket on 20/10/16.
 */
public class WalletPresenterImpl implements WalletPresenter {
    private WalletInterface walletInterface;
    private WalletProvider walletProvider;

    public WalletPresenterImpl(WalletInterface walletInterface, WalletProvider walletProvider) {
        this.walletInterface = walletInterface;
        this.walletProvider = walletProvider;
    }

    @Override
    public void getWallet(String access_token) {
        walletInterface.showProgressbar(true);
        walletProvider.getWalletInfo(access_token, new OnWalletInfoReceived() {
            @Override
            public void onFailure() {
                walletInterface.showProgressbar(false);
                walletInterface.showMessage("Failed..Try again");
            }

            @Override
            public void onSuccess(WalletData walletData) {
                if (walletData.isSuccess()) {
                    walletInterface.showProgressbar(false);
                    walletInterface.walletReceived(walletData);
                    walletInterface.showMessage(walletData.getMessage());
                } else {
                    walletInterface.showProgressbar(false);
                    walletInterface.showMessage(walletData.getMessage());
                }
            }
        });


    }
}
