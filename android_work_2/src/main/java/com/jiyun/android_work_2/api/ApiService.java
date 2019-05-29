package com.jiyun.android_work_2.api;

import com.jiyun.android_work_2.bean.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    public String Url="http://www.wanandroid.com/";
    @GET("project/list/1/json?cid=294")
    Observable<Bean>getList();
}
