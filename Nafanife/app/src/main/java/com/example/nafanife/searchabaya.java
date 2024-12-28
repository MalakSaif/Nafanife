package com.example.nafanife;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class searchabaya extends AppCompatActivity {
    Button searchb,exitss;
    EditText abayaname;
    abayadatabase adb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchabaya);
        exitss=findViewById(R.id.Exits);
        exitss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(searchabaya.this, welcomecustomer.class);
                startActivity(intent);
            }
        });
        adb=new abayadatabase(this);
        abayaname=findViewById(R.id.abayanamesearch);
        searchb=findViewById(R.id.searchabaya);

        showabayainfo();
    }
    public void showabayoinformation(String title,String mes) {
        AlertDialog.Builder ad = new AlertDialog.Builder(this);
        ad.setCancelable(true);
        ad.setTitle(title);
        ad.setMessage(mes);
        ad.show();
    }
    public void showabayainfo(){
        searchb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameabayaa=abayaname.getText().toString();
                Cursor crs=adb.showabayainfo(nameabayaa);
                if(crs.getCount()==0) {
                    showabayoinformation("Abaya","cannot find");
                    return;
                }
                StringBuffer strbf=new StringBuffer();
                while(crs.moveToNext()) {
                    strbf.append("-"+"\n");
                    strbf.append("Abaya ID: "+crs.getString(0)+"\n");
                    strbf.append("Total cost of the abayas: "+crs.getString(1)+"\n");
                    strbf.append("Date: "+crs.getString(2)+"\n");
                    strbf.append("Phone.no: "+crs.getString(3)+"\n");
                    strbf.append("-"+"\n");
                }
                showabayoinformation("Abaya information",strbf.toString());
            }
        });
    }
}