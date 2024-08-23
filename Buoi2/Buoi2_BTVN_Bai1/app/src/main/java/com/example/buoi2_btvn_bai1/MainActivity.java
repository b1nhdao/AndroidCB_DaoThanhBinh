package com.example.buoi2_btvn_bai1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tv_result;
    EditText edt_num1, edt_num2;
    Button btn_plus, btn_sub, btn_multi, btn_division, btn_idk;

    private void innitContorl(){
        tv_result = findViewById(R.id.tv_result);
        edt_num1 = findViewById(R.id.edt_num1);
        edt_num2 = findViewById(R.id.edt_num2);
        btn_plus = findViewById(R.id.btn_plus);
        btn_sub = findViewById(R.id.btn_sub);
        btn_multi = findViewById(R.id.btn_multi);
        btn_division = findViewById(R.id.btn_division);
        btn_idk = findViewById(R.id.btn_idk);

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float num1, num2;
                num1 = Float.parseFloat(edt_num1.getText().toString());
                num2 = Float.parseFloat(edt_num2.getText().toString());
                tv_result.setText(num1 + num2 + "");
            }
        });

        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float num1, num2;
                num1 = Float.parseFloat(edt_num1.getText().toString());
                num2 = Float.parseFloat(edt_num2.getText().toString());
                tv_result.setText(num1 - num2 + "");
            }
        });

        btn_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float num1, num2;
                num1 = Float.parseFloat(edt_num1.getText().toString());
                num2 = Float.parseFloat(edt_num2.getText().toString());
                tv_result.setText(num1 * num2 + "");
            }
        });

        btn_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float num1, num2;
                num1 = Float.parseFloat(edt_num1.getText().toString());
                num2 = Float.parseFloat(edt_num2.getText().toString());
                tv_result.setText(num1 / num2 + "");
            }
        });

        btn_idk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float num1, num2;
                num1 = Float.parseFloat(edt_num1.getText().toString());
                num2 = Float.parseFloat(edt_num2.getText().toString());
                tv_result.setText(num1 % num2 + "");
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
        innitContorl();
    }
}