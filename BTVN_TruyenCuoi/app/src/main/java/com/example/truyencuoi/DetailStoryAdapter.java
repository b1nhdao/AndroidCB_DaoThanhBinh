package com.example.truyencuoi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class DetailStoryAdapter extends PagerAdapter {
    private ArrayList<Story> listStories;
    private Context mContext;

    public DetailStoryAdapter(ArrayList<Story> listStories, Context mContext) {
        this.listStories =listStories;
        this.mContext = mContext;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.detail_story, container,
                false);
        Story item = listStories.get(position);
        TextView tvName = view.findViewById(R.id.tv_name);
        TextView tvContent = view.findViewById(R.id.tv_content);
        tvName.setTag(item);
        tvName.setText(item.getName());
        tvContent.setText(item.getContent());
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return listStories.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
