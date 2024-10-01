package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edt_f, edt_c;
    Button btn_1, btn_2, btn_clear;

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
        edt_f = findViewById(R.id.edt_f);
        edt_c = findViewById(R.id.edt_c);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_clear  = findViewById(R.id.btn_clear);

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkEmpty(edt_f.getText().toString(), edt_c.getText().toString())){
                    Toast.makeText(MainActivity.this, "Hãy nhập dữ liệu !!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Float f = Float.valueOf(edt_f.getText().toString());
                Float c = (f - 32) * (float)5/9;
                edt_c.setText(c + "");
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkEmpty(edt_f.getText().toString(), edt_c.getText().toString())){
                    Toast.makeText(MainActivity.this, "Hãy nhập dữ liệu !!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Float c = Float.valueOf(edt_c.getText().toString());
                Float f = c * (float)9/5 + 32;
                edt_f.setText(f + "");
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt_c.setText("");
                edt_f.setText("");
            }
        });
    }
    boolean checkEmpty(String a, String b){
        if(a.isEmpty() && b.isEmpty())
            return false;
        else
            return true;
    }
}