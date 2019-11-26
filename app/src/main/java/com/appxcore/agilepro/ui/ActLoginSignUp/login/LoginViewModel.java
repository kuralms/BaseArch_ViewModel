package com.appxcore.agilepro.ui.ActLoginSignUp.login;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.appxcore.agilepro.BaseUtils.BaseViewModel;
import com.appxcore.agilepro.BaseUtils.Spacex.SpacexLatest;
import com.appxcore.agilepro.BaseUtils.baseObj;

import java.util.List;

public class LoginViewModel extends BaseViewModel {


    public LoginViewModel(@NonNull Application application) {
        super(application);
    }


    private MutableLiveData<List<SpacexLatest>> mDataList;

    //we will call this method to get the data
    public LiveData<List<SpacexLatest>> getLatestList() {

        if (mDataList == null) {
            mDataList = new MutableLiveData<List<SpacexLatest>>();
            //we will load it asynchronously from server in this method
            loadListData();
        }

        //finally we will return the list
        return mDataList;

    }

    private void loadListData() {




    }


}
