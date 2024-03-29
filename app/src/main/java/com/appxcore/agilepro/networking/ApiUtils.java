package com.appxcore.agilepro.networking;

import android.content.Context;

import com.appxcore.agilepro.BuildConfig;



/**
 * Created by kural on 10/10/17.
 */

public class ApiUtils {


        private ApiUtils() {}

        private static final String BASE_URL = BuildConfig.URL;

        public static ApiInterface getAPIService() {

            return RetroFitClient.getClient(BASE_URL).create(ApiInterface.class);
        }

        public static ApiInterface getAPIServiceRx(Context context) {

            return RetroFitBuilderReactive.getRxClient(BASE_URL,context)
                    .create(ApiInterface.class);
        }

}
