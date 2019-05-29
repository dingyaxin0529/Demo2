package com.jiyun.android_work_3.callback;

import com.jiyun.android_work_3.bean.Bean;

public interface CallBack {
    void updateSuccess(Bean bean);
    void updateFailed(String result);
}
