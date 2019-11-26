package com.appxcore.agilepro.BaseUtils;

import android.app.Application;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.appxcore.agilepro.BuildConfig;
import com.appxcore.agilepro.Utils.LoadingDialog;
import com.appxcore.agilepro.Utils.SharedPrefUtils;
import com.appxcore.agilepro.Utils.ToastCustom;
import com.appxcore.agilepro.networking.ApiInterface;
import com.appxcore.agilepro.networking.ApiUtils;

import io.reactivex.disposables.CompositeDisposable;

import static android.content.Context.MODE_PRIVATE;

public class BaseViewModel extends AndroidViewModel {

    private ToastCustom toastCustom;
    private ProgressDialog mProgressDialog;
    private int PROGRESS_DIALOG_COUNTER = 0;

    private SharedPreferences spGetter;
    private SharedPreferences.Editor spEdit;


    public BaseViewModel(@NonNull Application application) {
        super(application);

        spGetter = application.getSharedPreferences(SharedPrefUtils.AppPreference,MODE_PRIVATE);
        spEdit = this.spGetter.edit();
    }


    public SharedPreferences spGetter(){
        return spGetter;
    }

    public SharedPreferences.Editor spEditor(){
        return spEdit;
    }


    public CompositeDisposable mCompositeDisposableGetter(){

        return new CompositeDisposable();
    }

    public ApiInterface mApiGetter() {
        return ApiUtils.getAPIServiceRx(getApplication());
    }

    public String getURLForResource (int resourceId) {

        return Uri.parse("android.resource://"+ BuildConfig.APPLICATION_ID+"/" +resourceId).toString();
    }


    public void showLoadingDialog(boolean isCancellable, Context context) {

        if (mProgressDialog == null) {

            mProgressDialog = new ProgressDialog(context);
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


}
