package com.example.buoi2_btvn_bai2;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ImageButton button;

    void initControl(){
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.Button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int rand = 0;
                while (true){
                    rand = random.nextInt(7);
                    if (rand != 0) break;
                }
                textView.setText(rand + "");
                switch (rand){
                    case 1:
                        button.setImageResource(R.drawable.dice1);
                        break;
                    case 2:
                        button.setImageResource(R.drawable.dice2);
                        break;
                    case 3:
                        button.setImageResource(R.drawable.dice3);
                        break;
                    case 4:
                        button.setImageResource(R.drawable.dice4);
                        break;
                    case 5:
                        button.setImageResource(R.drawable.dice5);
                        break;
                    case 6:
                        button.setImageResource(R.drawable.dice6);
                        break;
                }
            }
        });
    }

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
        initControl();
    }
}