package com.jiyun.android_work_3.persenter;

import com.jiyun.android_work_3.bean.Bean;
import com.jiyun.android_work_3.callback.CallBack;
import com.jiyun.android_work_3.iview.IView;
import com.jiyun.android_work_3.model.Model;
import com.jiyun.android_work_3.model.Modelmpl;

public class PersenterImpl implements Persenter{
    Model model;
    IView iView;

    public PersenterImpl( IView iView) {
        this.model = new Modelmpl();
        this.iView = iView;
    }

    @Override
    public void update() {
        model.updateData(new CallBack() {
            @Override
            public void updateSuccess(Bean bean) {
                iView.updateUI(bean);
            }

            @Override
            public void updateFailed(String result) {
                iView.updateError(result);
            }
        });
    }
}
