package com.example.myapplication;

import android.app.Activity;
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

    EditText edt_numa, edt_numb;
    TextView tv_ketqua;
    Button btn_cong, btn_tru, btn_nhan, btn_chia, btn_ucln, btn_thoat;

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
        edt_numa = findViewById(R.id.edt_numa);
        edt_numb = findViewById(R.id.edt_numb);
        tv_ketqua = findViewById(R.id.tv_ketqua);
        btn_cong = findViewById(R.id.btn_cong);
        btn_tru = findViewById(R.id.btn_tru);
        btn_nhan = findViewById(R.id.btn_nhan);
        btn_chia = findViewById(R.id.btn_chia);
        btn_ucln = findViewById(R.id.btn_ucln);
        btn_thoat = findViewById(R.id.btn_thoat);

        btn_cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!check(edt_numa.getText().toString(), edt_numb.getText().toString()))
                    return;
                float a = Float.parseFloat(edt_numa.getText().toString());
                float b = Float.parseFloat(edt_numb.getText().toString());
                if((a+b) - ((int)a+b) == 0){
                    tv_ketqua.setText((int)(a+b) + "");
                }
                else tv_ketqua.setText(a+b + "");
            }
        });

        btn_tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!check(edt_numa.getText().toString(), edt_numb.getText().toString()))
                    return;
                float a = Float.parseFloat(edt_numa.getText().toString());
                float b = Float.parseFloat(edt_numb.getText().toString());
                if((a+b) - ((int)a+b) == 0){
                    tv_ketqua.setText((int)(a-b) + "");
                }
                else tv_ketqua.setText(a-b + "");
            }
        });

        btn_nhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!check(edt_numa.getText().toString(), edt_numb.getText().toString()))
                    return;
                float a = Float.parseFloat(edt_numa.getText().toString());
                float b = Float.parseFloat(edt_numb.getText().toString());
                if((a+b) - ((int)a+b) == 0){
                    tv_ketqua.setText((int)(a*b) + "");
                }
                else tv_ketqua.setText(a*b + "");
            }
        });

        btn_chia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!check(edt_numa.getText().toString(), edt_numb.getText().toString()))
                    return;
                float a = Float.parseFloat(edt_numa.getText().toString());
                float b = Float.parseFloat(edt_numb.getText().toString());
                if((a+b) - ((int)a+b) == 0){
                    tv_ketqua.setText((int)(a/b) + "");
                }
                else tv_ketqua.setText(a/b + "");
            }
        });

        btn_ucln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!check(edt_numa.getText().toString(), edt_numb.getText().toString()))
                    return;
                int a = (int) Float.parseFloat(edt_numa.getText().toString());
                int b = (int) Float.parseFloat(edt_numb.getText().toString());
                tv_ketqua.setText(gcd(a,b) + "");
            }
        });

        btn_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }

    boolean check(String a, String b){
        if(a.isEmpty() || b.isEmpty()){
            Toast.makeText(this, "Hãy nhập dữ liệu !!!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else return true;
    }

    public int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }
}