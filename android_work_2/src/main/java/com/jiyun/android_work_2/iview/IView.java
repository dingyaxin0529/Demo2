package com.jiyun.android_work_2.iview;

import com.jiyun.android_work_2.bean.Bean;

public interface IView {
    void updateUI(Bean bean);
    void updateError(String result);
}
