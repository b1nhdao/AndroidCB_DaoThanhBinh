package com.example.qlns;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class UpdateNote extends AppCompatActivity {

    dbManager dbManager;
    EditText edt_title ,edt_content, edt_date;
    Button btn_sua, btn_xoa, btn_selectDate;
    Intent intent;
    Note note;
    Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_note);
        getViews();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        intent = getIntent();
        int id = intent.getIntExtra("id", -1);
        Toast.makeText(this, String.valueOf(id), Toast.LENGTH_SHORT).show();
        dbManager = new dbManager(UpdateNote.this);
        dbManager.open();
        note = dbManager.getNoteByID(id);
        edt_title.setText(note.getTitle());
        edt_content.setText(note.getContent());
        edt_date.setText(note.getCreateDate());

        btn_selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(UpdateNote.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        edt_date.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

        btn_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbManager.updateNote(id, edt_title.getText().toString(), edt_date.getText().toString(), edt_content.getText().toString());
                dbManager.close();
                Intent intent1 = new Intent(UpdateNote.this, MainActivity2.class);
                startActivity(intent1);
            }
        });

        btn_xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbManager.deleteNote(id);
                dbManager.close();
                Intent intent2 = new Intent(UpdateNote.this, MainActivity2.class);
                startActivity(intent2);
            }
        });
    }

    private void getViews(){
        edt_title = findViewById(R.id.edt_title);
        edt_content = findViewById(R.id.edt_content);
        edt_date = findViewById(R.id.edt_date);
        btn_sua = findViewById(R.id.btn_sua);
        btn_xoa = findViewById(R.id.btn_xoa);
        btn_selectDate = findViewById(R.id.btn_selectDate);
    }
}