package com.example.nafanife;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class deleteabaya extends AppCompatActivity {
    Button deleteb,exitb;
    EditText abayaname;
    abayadatabase adb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleteabaya);

        exitb=findViewById(R.id.Exitd);
        exitb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(deleteabaya.this, welcomecustomer.class);
                startActivity(intent);
            }
        });
        abayaname=findViewById(R.id.abayanamedelete);
        deleteb=findViewById(R.id.deleteabaya);

        adb=new abayadatabase(this);
        deleteOrder(); }
    public void deleteOrder(){
        deleteb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String aname1=abayaname.getText().toString();
                Integer delete1=adb.deleteabayas(aname1);
                if(delete1>0) {
                    Toast.makeText(deleteabaya.this, "Abaya is deleted", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(deleteabaya.this, welcomecustomer.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(deleteabaya.this,"Abaya is not deleted",Toast.LENGTH_SHORT).show();
                }}
        });
    }
}