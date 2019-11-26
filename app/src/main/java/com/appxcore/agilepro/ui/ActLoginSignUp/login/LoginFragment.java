package com.appxcore.agilepro.ui.ActLoginSignUp.login;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appxcore.agilepro.BaseUtils.BaseFragment;
import com.appxcore.agilepro.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends BaseFragment {

    private LoginViewModel mViewModel;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View fragRoot = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this,fragRoot);
        return fragRoot;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);


    }


    @OnClick(R.id.btn_sign_in)
    void onClickSignIn(){

        showLoadingCustom("",true);

    }



}
