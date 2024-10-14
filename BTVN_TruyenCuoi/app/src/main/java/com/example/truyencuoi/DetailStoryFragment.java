package com.example.truyencuoi;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class DetailStoryFragment extends Fragment {

    private Context mContext;
    private ArrayList<Story> listStories;
    private String topicName;
    private Story currentStory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View rootView = inflater.inflate(R.layout.detail_story, container, false);
        initViews(rootView);
        return rootView;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }
    private void initViews(View v) {
        v.findViewById(R.id.iv_back).setVisibility(View.VISIBLE);
        v.findViewById(R.id.iv_back).setOnClickListener(v1 -> gotoStoryScreen());
        ((TextView) v.findViewById(R.id.tv_name)).setText(topicName);
        ViewPager vp = v.findViewById(R.id.vp_story);
        DetailStoryAdapter adapter = new DetailStoryAdapter(listStories, mContext);
        vp.setAdapter(adapter);
        vp.setCurrentItem(listStories.indexOf(currentStory), true);
    }

    private void gotoStoryScreen() {
        ((MainActivity) getActivity()).gotoStoryScreen(topicName);
    }
    public void setData(String topicName, ArrayList<Story> listStory, Story
            currentStory) {
        this.currentStory = currentStory;
        this.topicName = topicName;
        this.listStories = listStory;
    }

}