package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText nameEt;
    EditText ageEt;
    TextView nameTv;
    TextView ageTv;
    Button showBtn;
    Button saveBtn;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEt=findViewById(R.id.et1);
        ageEt=findViewById(R.id.et2);
        nameTv=findViewById(R.id.tv1);
        ageTv=findViewById(R.id.tv2);
        saveBtn=findViewById(R.id.btn1);
        showBtn=findViewById(R.id.btn2);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=nameEt.getText().toString();
                int age=Integer.parseInt(ageEt.getText().toString());
                sharedPreferences=MainActivity.this.getSharedPreferences("nameAge",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("name",name);
                editor.putInt("age",age);
                editor.commit();

            }
        });
        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=sharedPreferences.getString("name","error!");
                int age=sharedPreferences.getInt("age",0);
                nameTv.setText(name);
                ageTv.setText(String.valueOf(age));

            }
        });
    }
}