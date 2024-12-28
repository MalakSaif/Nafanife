package com.example.nafanife;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class welcomecustomer extends AppCompatActivity {
    Button adabaya, dlabaya, utnm, srabaya, lgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomecustomer);
        adabaya = findViewById(R.id.addabayas);
        adabaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(welcomecustomer.this, addabaya.class);
                startActivity(intent);
            }
        });
        dlabaya = findViewById(R.id.deldabaya);
        dlabaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(welcomecustomer.this, deleteabaya.class);
                startActivity(intent);
            }
        });
        utnm = findViewById(R.id.updname);
        utnm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(welcomecustomer.this, updatename.class);
                startActivity(intent);
            }
        });
        srabaya = findViewById(R.id.srcabaya);
        srabaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(welcomecustomer.this, searchabaya.class);
                startActivity(intent);
            }
        });
        lgot = findViewById(R.id.logoutnf);
        lgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(welcomecustomer.this, loginnafanife.class);
                startActivity(intent);
            }
        });
    }}
