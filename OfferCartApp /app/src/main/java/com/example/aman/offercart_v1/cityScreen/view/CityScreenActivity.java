package com.example.aman.offercart_v1.city.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.aman.offercart_v1.R;

import butterknife.BindView;

/**
 * Created by aman on 15/10/16.
 */
public class CityScreenActivity extends Activity
{

    @BindView(R.id.Text)
    TextView Text;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cityscreen);

        Text.setText("City1");

    }




}

