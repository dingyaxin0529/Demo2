package com.jiyun.android_work_3.api;

import com.jiyun.android_work_3.bean.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    public String Url="http://gank.io/";
    @GET("api/data/%E7%A6%8F%E5%88%A9/20/1")
    Observable<Bean>getList();
}
