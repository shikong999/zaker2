package com.example.lenovo.wdw.utils;

import com.google.gson.Gson;

import org.xutils.http.app.ResponseParser;
import org.xutils.http.request.UriRequest;

import java.lang.reflect.Type;

/**
 * Created by Wucheng on 2016/4/12.
 */
public class JsonResponseParse implements ResponseParser {


    @Override
    public void checkResponse(UriRequest request) throws Throwable {

    }

    /**
     * 转换
     * @param resultType
     * @param resultClass
     * @param result
     * @return
     * @throws Throwable
     */
    @Override
    public Object parse(Type resultType, Class<?> resultClass, String result) throws Throwable {
        Gson gson=new Gson();
        return gson.fromJson(result,resultClass);
    }
}
