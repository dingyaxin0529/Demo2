package com.jiyun.android_work_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jiyun.android_work_1.adapter.Adapter;
import com.jiyun.android_work_1.bean.Bean;
import com.jiyun.android_work_1.utils.MyHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRv;
    private ArrayList<Bean> list;
    private Adapter adapter;

    //丁雅鑫  H1810A
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initMvp();
    }

    private void initMvp() {
        MyHelper.getMyHelper().query();
    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            list.add(new Bean(Long.valueOf(i),R.drawable.cc,"做个恶魔吧"+i));
        }
        MyHelper.getMyHelper().insertAll(list);
    }

    private void initView() {
        mRv = (RecyclerView) findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        list = new ArrayList<>();
        adapter = new Adapter(list, this);
        mRv.setAdapter(adapter);
    }
}
