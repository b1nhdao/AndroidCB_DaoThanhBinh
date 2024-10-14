package com.example.truyencuoi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.net.ssl.HandshakeCompletedEvent;

public class InitiateFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        initViews();
        return inflater.inflate(R.layout.fragment_initiate, container, false);
    }

    private void initViews(){
        new Handler().postDelayed(this::gotoTopicScreen, 1000);
    }

    private void gotoTopicScreen(){
        ((MainActivity)getActivity()).gotoTopicScreen();
    }
}