package com.atomone.converterfast.network.retrofit;


import com.atomone.converterfast.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 *
 * @author atomone
 * @date 2017/2/21
 * Singleton
 */
public class OkHttpHelper {

    private static final OkHttpHelper ourInstance = new OkHttpHelper();
    private OkHttpClient INSTANCE;

    private OkHttpHelper() {
    }

    public static OkHttpHelper getInstance() {
        return ourInstance;
    }

    //  Default HttpClient
    public OkHttpClient getDefaultHttpClient() {
        if (INSTANCE == null) {
            INSTANCE = getHttpClientBuilder().build();
        }
        return INSTANCE;
    }


    private OkHttpClient.Builder getHttpClientBuilder() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            if (!builder.interceptors().contains(interceptor)) {
                builder.addInterceptor(interceptor);
            }
        }
        return builder;
    }
}
