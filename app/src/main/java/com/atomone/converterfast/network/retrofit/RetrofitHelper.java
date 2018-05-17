package com.atomone.converterfast.network.retrofit;



import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

/**
 *
 * @author atomone
 * @date 2017/2/21
 * Singleton
 */
public class RetrofitHelper {

    //    private static final String API_BASE_URL = "http://192.168.1.70:8080/cpkdemo/rest/remoteApi/";
    private static final String API_BASE_URL = "http://192.168.1.137:9011/cpkdemo/rest/remoteApi/";
//    private static final String API_BASE_URL = "http://1.202.165.174:9011/cpkdemo/rest/remoteApi/";

    private static Retrofit mRetrofitAuth2 = null;
    private static Retrofit.Builder mBuilderAuth2 = new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(FastJsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

    private RetrofitHelper() {
    }

    public static Retrofit getRetrofitAuth2() {
        if (mRetrofitAuth2 == null) {
            mBuilderAuth2.client(OkHttpHelper.getInstance().getDefaultHttpClient());
            mRetrofitAuth2 = mBuilderAuth2.build();
        }
        return mRetrofitAuth2;
    }

}
