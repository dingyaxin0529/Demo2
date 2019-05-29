package com.jiyun.android_work_3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jiyun.android_work_3.adapter.ImageAdapter;
import com.jiyun.android_work_3.bean.Bean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class TuPianActivity extends AppCompatActivity {

    private ViewPager mVp;
    private ArrayList<String> mList;
    private ImageAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tu_pian);
        initView();
        EventBus.getDefault().register(this);
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mList = new ArrayList<>();
        mAdapter = new ImageAdapter(this, mList);
        mVp.setAdapter(mAdapter);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void OnEventBusMassage(EventBusMassage eventBusMassage) {
        List<Bean.ResultsBean> resultsBeans = eventBusMassage.mResultsBeans;
        for (int i = 0; i < resultsBeans.size(); i++) {
            Bean.ResultsBean resultsBean = resultsBeans.get(i);

            String url = resultsBean.getUrl();
            mList.add(url);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

   /* private void initView() {
        mIv1 = (ImageView) findViewById(R.id.iv1);
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        Glide.with(this).load(url).into(mIv1);
    }*/
}
