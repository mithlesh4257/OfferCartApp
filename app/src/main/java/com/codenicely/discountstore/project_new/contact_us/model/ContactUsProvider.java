package com.codenicely.discountstore.project_new.contact_us.model;


import com.codenicely.discountstore.project_new.contact_us.ContactUsCallback;

/**
 * Created by meghal on 15/10/16.
 */

public interface ContactUsProvider {


    void requestContactUs(ContactUsCallback contactUsCallback);

    void onDestroy();

}
