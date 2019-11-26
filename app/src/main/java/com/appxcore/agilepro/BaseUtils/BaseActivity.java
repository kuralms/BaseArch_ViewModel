package com.appxcore.agilepro.BaseUtils;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.appxcore.agilepro.BuildConfig;
import com.appxcore.agilepro.R;
import com.appxcore.agilepro.Utils.SharedPrefUtils;
import com.appxcore.agilepro.Utils.ToastCustom;
import com.appxcore.agilepro.networking.ApiInterface;
import com.appxcore.agilepro.networking.ApiUtils;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import io.reactivex.disposables.CompositeDisposable;


public class BaseActivity extends AppCompatActivity {

    ToastCustom toastCustom;
    ProgressDialog mProgressDialog;
    private int PROGRESS_DIALOG_COUNTER = 0;


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    SharedPreferences spGetter;
    SharedPreferences.Editor spEdit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        spGetter = getSharedPreferences(SharedPrefUtils.AppPreference,MODE_PRIVATE);
        spEdit = spGetter.edit();


    }

    public SharedPreferences spGetter(){
        return spGetter;
    }

    public SharedPreferences.Editor spEditor(){
        return spEdit;
    }


    public void showAlert(String message, boolean dismissible){

        final Dialog dialog = new Dialog(this, R.style.Theme_Dialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if(!dismissible){
            dialog.setCancelable(false);}
        dialog.setContentView(R.layout.dialouge_alert_base);

        TextView text = (TextView) dialog.findViewById(R.id.tv_alert_dialogue_message);
        text.setText(message);

        Button dialogButton = (Button) dialog.findViewById(R.id.btn_alert_dialogue_ok);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

        hideSoftKeyboard();
        hideLoadingDialog();

    }




    public CompositeDisposable mCompositeDisposableGetter(){
               return new CompositeDisposable();
    }


    public ApiInterface mApiGetter() {
        ApiInterface mApiInterface;
        mApiInterface = ApiUtils.getAPIServiceRx(getApplicationContext());
        return mApiInterface;
    }

    public String getURLForResource (int resourceId) {

        return Uri.parse("android.resource://"+ BuildConfig.APPLICATION_ID+"/" +resourceId).toString();
    }


    public Activity getViewContext() {
        return BaseActivity.this;
    }





    public void showToast(String message) {
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        } else {
            //Toast.makeText(this, getString(R.string.some_error), Toast.LENGTH_SHORT).show();
        }
    }


    public void showToastCustom(String title, SpannableString message, int gravity){
        toastCustom = new ToastCustom(this);
        SpannableString ss =  new SpannableString(message);
        toastCustom.ShowToast(title,ss,gravity);
    }

    public void hideSoftKeyboard() {

        if (this.getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) this
                    .getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(),
                    0);
        }

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    public void showLoadingDialog(boolean isCancellable) {

        if (mProgressDialog == null) {

            mProgressDialog = new ProgressDialog(BaseActivity.this);
            mProgressDialog.setMessage("Please wait...");
            if(!isCancellable){
            mProgressDialog.setCancelable(false);
            mProgressDialog.setIndeterminate(true);}
            try{
                mProgressDialog.show();
            } catch (Exception e){
                e.printStackTrace();
            }
            PROGRESS_DIALOG_COUNTER++;

        } else {
            PROGRESS_DIALOG_COUNTER++;
            try{
                mProgressDialog.show();
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        hideSoftKeyboard();

    }


    public void hideLoadingDialog() {

        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            PROGRESS_DIALOG_COUNTER--;
            if (PROGRESS_DIALOG_COUNTER == 0){
                try {
                    mProgressDialog.cancel();
                } catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mProgressDialog != null && mProgressDialog.isShowing()){
            try {
                mProgressDialog.cancel();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
