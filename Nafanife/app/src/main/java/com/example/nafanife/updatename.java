package com.example.nafanife;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class updatename extends AppCompatActivity {
    EditText oldaname,newaname;
    Button updatenamea,exit1;
    abayadatabase adb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatename);
        oldaname=findViewById(R.id.oldabayaname);
        newaname=findViewById(R.id.newabayaname);
        updatenamea=findViewById(R.id.updatenamee);
        adb=new abayadatabase(this);
        updatename1();

        exit1=findViewById(R.id.Exitu);
        exit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(updatename.this, welcomecustomer.class);
                startActivity(intent);
            }
        });
    }
    public void updatename1(){
        updatenamea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oldn = oldaname.getText().toString();
                String newname = newaname.getText().toString();
                boolean updatean = adb.updatename(oldn, newname);
                if (updatean) {
                    Toast.makeText(updatename.this, "Phone number changed", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(updatename.this, welcomecustomer.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(updatename.this, "Phone number not changed", Toast.LENGTH_LONG).show();
                }}
        });
    }}