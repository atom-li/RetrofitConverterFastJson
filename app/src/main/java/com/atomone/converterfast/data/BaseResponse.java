package com.atomone.converterfast.data;

import android.text.TextUtils;

/**
 * Created by Developer on 2017/9/29.
 * {"code":200,"msg":"","stat":"OK"}
 */

public class BaseResponse {

    private String msg;
    private String code;
    private String stat;
    private String data;
    private String errorCode;

    public BaseResponse() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    //  判断接口是否成功
    public boolean isSuccessful() {
        return TextUtils.equals("OK", getStat());
    }
}
