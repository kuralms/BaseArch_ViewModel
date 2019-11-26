package com.appxcore.agilepro.ui.ActLoginSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.appxcore.agilepro.R;
import com.appxcore.agilepro.ui.ActLoginSignUp.login.LoginFragment;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, LoginFragment.newInstance())
                    .commitNow();
        }
    }
}
