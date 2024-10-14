package com.example.truyencuoi;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String topicName;
    ArrayList<Story> listStories;
    Story story;
    StoryAdapter storyAdapter;
    DetailStoryAdapter detailStoryAdapter;
    RecyclerView recycleview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setContentView(R.layout.activity_main);
        showFragment(new InitiateFragment());
    }


    public void gotoInitiateScreen() {

    }

    public void backtoInitiateScreen(){
        gotoInitiateScreen();
    }

    private void showFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.main, fragment, null).commit();
    }

    public void gotoTopicScreen() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main, new
                ItemTopicFragment(), null).commit();
    }

    public void backtoTopicScreen() {
        gotoTopicScreen();
    }

    public void gotoStoryScreen(String tag) {
        this.topicName = tag;
        StoryFragment frg = new StoryFragment();
        frg.setTopicName(topicName);
        showFragment(frg);
    }

    public void gotoStoryScreen(ArrayList<Story> listStories, Story tag) {

    }

    public void gotoDetailStoryScreen(ArrayList<Story> listStory, Story story) {
        DetailStoryFragment frg = new DetailStoryFragment();
        frg.setData(topicName, listStory, story);
        showFragment(frg);
    }

}