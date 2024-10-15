package com.example.truyencuoi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.viewHoldler> {
    ArrayList<Story> listStories;
    Context mContext;

    public StoryAdapter(ArrayList<Story> listStories, Context mContext) {
        this.listStories = listStories;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public viewHoldler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_story, parent, false);
        return new viewHoldler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHoldler holder, int position) {
        Story story = listStories.get(position);
        holder.tv_name.setTag(story);
        holder.tv_name.setText(story.getName());
    }

    @Override
    public int getItemCount() {
        return listStories.size();
    }

    public class viewHoldler extends RecyclerView.ViewHolder {
        TextView tv_name;
        public viewHoldler(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((MainActivity)mContext).gotoDetailStoryScreen(listStories, (Story)tv_name.getTag());
                }
            });
        }
    }
}
