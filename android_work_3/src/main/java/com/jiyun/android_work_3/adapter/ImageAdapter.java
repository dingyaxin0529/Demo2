package com.jiyun.android_work_3.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.android_work_3.R;

import java.util.List;

public class ImageAdapter extends PagerAdapter {

    private Context mContext;
    private List<String> mList;

    public ImageAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_image, null);
        String s = mList.get(position);
        ImageView img = inflate.findViewById(R.id.img);
        TextView tv_count = inflate.findViewById(R.id.tv_count);
        Glide.with(mContext).load(s).into(img);
        tv_count.setText("第"+(position+1)+"页/共"+mList.size()+"页");
        container.addView(inflate);
        return inflate;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
