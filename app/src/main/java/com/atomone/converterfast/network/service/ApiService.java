package com.atomone.converterfast.network.service;

import com.alibaba.fastjson.JSONObject;
import com.atomone.converterfast.data.BaseResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author atomone
 * @date 2017/2/21
 * rest api
 */
public interface ApiService {

    @POST("user/userInfo")
    Observable<BaseResponse> getUserInfo(@Body JSONObject object);

}
