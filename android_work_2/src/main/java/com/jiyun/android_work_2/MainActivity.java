package com.jiyun.android_work_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.jiyun.android_work_2.adapter.Adapter;
import com.jiyun.android_work_2.bean.Bean;
import com.jiyun.android_work_2.iview.IView;
import com.jiyun.android_work_2.persenter.PersenterImpl;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IView {
    private RecyclerView mRv;
    private ArrayList<Bean.DataBean.DatasBean> list;
    private Adapter adapter;
    private PersenterImpl persenter;
    private static final String TAG = "MainActivity";
    //丁雅鑫  H1810A
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
    }

    @Override
    public void updateUI(Bean bean) {
        list.addAll(bean.getData().getDatas());
        adapter.setList(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void updateError(String result) {
        Log.d(TAG, "updateError: "+result);
    }
}
