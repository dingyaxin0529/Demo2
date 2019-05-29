package com.jiyun.android_work_3.iview;

import com.jiyun.android_work_3.bean.Bean;

public interface IView {
    void updateUI(Bean bean);
    void updateError(String result);
}
