package com.jiyun.android_work_3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.jiyun.android_work_3.adapter.Adapter;
import com.jiyun.android_work_3.bean.Bean;
import com.jiyun.android_work_3.iview.IView;
import com.jiyun.android_work_3.persenter.PersenterImpl;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IView, Adapter.SetOnClick {
    private RecyclerView mRv;
    private ArrayList<Bean.ResultsBean> list;
    private PersenterImpl persenter;
    private Adapter adapter;
    private static final String TAG = "MainActivity";
    //丁雅鑫 H1810A
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        persenter = new PersenterImpl(this);
        persenter.update();
    }

    private void initView() {
        mRv = (RecyclerView) findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        list = new ArrayList<>();
        adapter = new Adapter(list, this);
        mRv.setAdapter(adapter);
        adapter.OnClick(this);
        mRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    @Override
    public void updateUI(Bean bean) {
        list.addAll(bean.getResults());
        adapter.setList(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void updateError(String result) {
        Log.d(TAG, "updateError: "+result);
    }

    @Override
    public void SetOn(int position, Bean.ResultsBean bean) {
        /*Intent intent = new Intent(MainActivity.this,TuPianActivity.class);
        intent.putExtra("url",bean.getUrl());
        startActivity(intent);*/
        startActivity(new Intent(MainActivity.this,TuPianActivity.class));
        EventBusMassage eventBusMassage = new EventBusMassage();
        eventBusMassage.mResultsBeans = list;
        EventBus.getDefault().postSticky(eventBusMassage);
    }
}
