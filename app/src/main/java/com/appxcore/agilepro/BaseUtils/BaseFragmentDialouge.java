package com.appxcore.agilepro.BaseUtils;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.appxcore.agilepro.R;
import com.appxcore.agilepro.Utils.SharedPrefUtils;
import com.appxcore.agilepro.Utils.ToastCustom;
import com.appxcore.agilepro.networking.ApiInterface;
import com.appxcore.agilepro.networking.ApiUtils;

import io.reactivex.disposables.CompositeDisposable;

public class BaseFragmentDialouge extends DialogFragment {

    private ToastCustom toastCustom;
    private ProgressDialog mProgressDialog;
    private int PROGRESS_DIALOG_COUNTER = 0;

    private SharedPreferences spGetter;
    private SharedPreferences.Editor spEdit;



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spGetter = this.getActivity().getSharedPreferences(SharedPrefUtils.AppPreference, Context.MODE_PRIVATE);
        spEdit = this.spGetter.edit();
    }

    public SharedPreferences spGetter(){
        return spGetter;
    }

    public SharedPreferences.Editor spEditor(){
        return spEdit;
    }


    public CompositeDisposable mCompositeDisposable;
    public CompositeDisposable mCompositeDisposableGetter(){

        return new CompositeDisposable();
    }

    private ApiInterface mApiInterface;
    public ApiInterface mApiGetter() {
        mApiInterface = ApiUtils.getAPIServiceRx(getActivity());
        return mApiInterface;
    }

    public void showAlert(String message, boolean dismissible){

        final Dialog dialog = new Dialog(getActivity(), R.style.Theme_Dialog);
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

    }

    public Activity getViewContext() {
        return getActivity();
    }


    public void showToast(String message) {
        if (message != null) {
            Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
        } else {
            //Toast.makeText(this, getString(R.string.some_error), Toast.LENGTH_SHORT).show();
        }
    }


    public void showToastCustom(String title, SpannableString message, int gravity){
        toastCustom = new ToastCustom(getActivity());
        SpannableString ss =  new SpannableString(message);
        toastCustom.ShowToast(title,ss,gravity);
    }

    public void hideSoftKeyboard() {

        if (getActivity().getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity()
                    .getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),
                    0);
        }

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    public void showLoadingDialog(boolean iScancellable) {

        if (mProgressDialog == null) {

            mProgressDialog = new ProgressDialog(getActivity());
            mProgressDialog.setMessage("Please wait...");
            if(!iScancellable){
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
