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

    EditText edt_height, edt_weight, edt_bmi, edt_diagnose;
    Button btn_tinh;

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
        edt_height = findViewById(R.id.edt_height);
        edt_weight = findViewById(R.id.edt_weight);
        edt_bmi = findViewById(R.id.edt_bmi);
        edt_diagnose = findViewById(R.id.edt_diagnose);
        btn_tinh = findViewById(R.id.btn_tinh);

        btn_tinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkEmpty(edt_height.getText().toString(), edt_weight.getText().toString())){
                    Toast.makeText(MainActivity.this, "Nhập lại dữ liệu !!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                float height = Float.parseFloat(edt_height.getText().toString());
                float weight = Float.parseFloat(edt_weight.getText().toString());
                float BMI = (float) (weight / Math.pow(height, 2));
                edt_bmi.setText(BMI + "");
                edt_diagnose.setText(getDiagnose(BMI));
            }
        });
    }
    boolean checkEmpty(String a, String b){
        if(a.isEmpty() || b.isEmpty() || Integer.parseInt(a) == 0 || Integer.parseInt(b) == 0)
            return false;
        else
            return true;

    }

    String getDiagnose(float BMI){
        if(BMI < 18)
            return "Bạn gầy";
        else if (BMI <= 24.9) {
            return "Bạn bình thường";
        }
        else if (BMI <= 29.9) {
            return "Bạn béo phì độ 1";
        }
        else if (BMI<= 34.9) {
            return  "Bạn béo phì độ 2";
        }
        else
            return "Bạn béo phì độ 3";
    }

}