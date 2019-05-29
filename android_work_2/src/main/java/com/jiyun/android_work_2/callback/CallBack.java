package com.jiyun.android_work_2.callback;

import com.jiyun.android_work_2.bean.Bean;

public interface CallBack {
    void updateSuccess(Bean bean);
    void updateFailed(String result);
}
