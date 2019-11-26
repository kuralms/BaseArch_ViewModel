package com.appxcore.agilepro.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import org.jetbrains.annotations.Nullable;

public class SharedPrefUtils {

    public static final String userName = "userName";

    public static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(AppPreference, Context.MODE_PRIVATE);
    }

    public static void setApiKey(Context context, String apiKey) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(AppToken, apiKey);
        editor.apply();
    }

    public static String getApiKey(Context context) {
        return getSharedPreferences(context).getString(AppToken, "");
    }

    public static String getMemberId(Context context) {
        return getSharedPreferences(context).getString(userId, "");
    }

    public static String AppPreference = "AppPreference";
    public static String SkipLogin = "SkipLogin" ;
    public static String OtpVerify = "OtpVerify";

    public static String AppToken = "AppToken";
    public static String userId = "userId";

    public static String userMobileNumber = "userMobileNumber";

    public static String CHANNEL_ID = "CHANNEL_ID";
    public static int notificationId = 0;



}
