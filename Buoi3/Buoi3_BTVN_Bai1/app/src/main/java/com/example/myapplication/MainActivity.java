package com.example.myapplication;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.m100_act_splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.act_splash), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //bai 1
        ArrayList<Integer> color_src = new ArrayList<Integer>();
        color_src.add(R.color.teal_200);
        color_src.add(R.color.teal_700);
        color_src.add(R.color.purple_200);
        color_src.add(R.color.purple_500);
        color_src.add(R.color.purple_700);


        Random random = new Random();
        int i = random.nextInt(color_src.size());
        findViewById(R.id.act_splash).setBackgroundColor(getResources().getColor(color_src.get(i)));
        findViewById(R.id.layout_act_splash).setBackgroundColor(getResources().getColor(color_src.get(i)));
    }
}