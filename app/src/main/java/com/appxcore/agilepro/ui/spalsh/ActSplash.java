package com.appxcore.agilepro.ui.spalsh;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.appxcore.agilepro.BaseUtils.BaseActivity;
import com.appxcore.agilepro.Utils.SharedPrefUtils;
import com.appxcore.agilepro.ui.ActLoginSignUp.LoginActivity;


public class ActSplash extends BaseActivity {
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 500;  // mSeconds
    Intent i;
    Boolean LoggedInUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if(spGetter().getBoolean(SharedPrefUtils.OtpVerify,false)){

            i = new Intent(ActSplash.this, LoginActivity.class);

        }else {

            i = new Intent(ActSplash.this, LoginActivity.class);

        }


       Intent2Activity();


    }


    private void Intent2Activity() {



        new Handler().postDelayed(new Runnable() {
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                startActivity(i);
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }


   }