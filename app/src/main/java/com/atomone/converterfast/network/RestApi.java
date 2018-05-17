package com.atomone.converterfast.network;


import com.atomone.converterfast.network.retrofit.RetrofitHelper;
import com.atomone.converterfast.network.service.ApiService;


/**
 * @author atomone
 * @date 2017/2/21
 * rest api center
 */
public class RestApi {

    private static final RestApi ourInstance = new RestApi();
    private ApiService apiService = null;
    private RestApi() {

    }

    public static RestApi getInstance() {
        return ourInstance;
    }

    public ApiService getApiService() {
        if (apiService == null) {
            apiService = RetrofitHelper.getRetrofitAuth2()
                    .create(ApiService.class);
        }
        return apiService;
    }

}
