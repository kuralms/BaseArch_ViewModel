package com.appxcore.agilepro.BaseUtils;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.appxcore.agilepro.BuildConfig;
import com.appxcore.agilepro.R;
import com.appxcore.agilepro.Utils.LoadingDialog;
import com.appxcore.agilepro.Utils.SharedPrefUtils;
import com.appxcore.agilepro.Utils.ToastCustom;
import com.appxcore.agilepro.networking.ApiInterface;
import com.appxcore.agilepro.networking.ApiUtils;

import io.reactivex.disposables.CompositeDisposable;


import static android.content.Context.MODE_PRIVATE;


public class BaseFragment extends Fragment {

    private ToastCustom toastCustom;
    private ProgressDialog mProgressDialog;
    private int PROGRESS_DIALOG_COUNTER = 0;

    private SharedPreferences spGetter;
    private SharedPreferences.Editor spEdit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

      return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        spGetter = this.getActivity().getSharedPreferences(SharedPrefUtils.AppPreference,MODE_PRIVATE);
        spEdit = this.spGetter.edit();
    }

    public SharedPreferences spGetter(){
        return spGetter;
    }

    public SharedPreferences.Editor spEditor(){
        return spEdit;
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

    public  CompositeDisposable mCompositeDisposableGetter(){

        return new CompositeDisposable();
    }

    public ApiInterface mApiGetter() {
        return ApiUtils.getAPIServiceRx(getActivity());
    }

    public String getURLForResource (int resourceId) {

        return Uri.parse("android.resource://"+ BuildConfig.APPLICATION_ID+"/" +resourceId).toString();
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



    public void showLoadingCustom(String title, Boolean isCancelable) {

        LoadingDialog fragment = (LoadingDialog) getActivity().getSupportFragmentManager().findFragmentByTag(LoadingDialog.FRAGMENT_TAG);
        if (fragment == null) {
            fragment = new LoadingDialog();
            fragment.setCancelable(false);
            getActivity().getSupportFragmentManager().beginTransaction()
                    .add(fragment, LoadingDialog.FRAGMENT_TAG)
                    .commitAllowingStateLoss();

            // fragment.show(getSupportFragmentManager().beginTransaction(), LoadingDialogFragment.FRAGMENT_TAG);
        }
    }

    public void hideLoadingCustom() {
        LoadingDialog fragment = (LoadingDialog) getActivity().getSupportFragmentManager().findFragmentByTag(LoadingDialog.FRAGMENT_TAG);
        if (fragment != null) {
            // fragment.dismissAllowingStateLoss();
            getActivity().getSupportFragmentManager().beginTransaction().remove(fragment).commitAllowingStateLoss();
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
