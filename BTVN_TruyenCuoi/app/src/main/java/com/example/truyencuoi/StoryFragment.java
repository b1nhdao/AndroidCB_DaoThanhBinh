package com.example.truyencuoi;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class StoryFragment extends Fragment {

    private Context mContext;
    private ArrayList<Story> listStory;
    private String topicName;
    private Story currentStory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_story, container, false);
        initViews(rootView);
        return rootView;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }



    private void initViews(View v) {
        v.findViewById(R.id.iv_back).setVisibility(View.VISIBLE);
        v.findViewById(R.id.iv_back).setOnClickListener(v1 -> backtoTopicScreen());
        ((TextView)v.findViewById(R.id.tv_name)).setText(topicName);
        RecyclerView rv = v.findViewById(R.id.rv_story);
        ArrayList<Story> listStory = readStory();
        StoryAdapter adapter = new StoryAdapter(listStory,mContext);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(mContext));
    }

    private ArrayList<Story> readStory() {
        ArrayList<Story> listStory = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(mContext.getAssets().open("story/"+topicName+".txt"), "UTF-8"));
            String mLine = "";
            do {
                String title = reader.readLine();
                if (title == null) break;
                String content = "";
                do {
                    mLine = reader.readLine();
                    content += mLine + "\n";
                } while (!mLine.contains("','0');"));
                content = content.replace("','0');","");
                Story storyEntity = new Story(topicName, title, content);
                listStory.add(storyEntity);
            } while (mLine != null);
        } catch (IOException e) {
        }
        return listStory;
    }
    public void setTopicName(String topicName){
        this.topicName = topicName;
    }
    private void backtoTopicScreen() {
        ((MainActivity) getActivity()).backtoTopicScreen();
    }
}