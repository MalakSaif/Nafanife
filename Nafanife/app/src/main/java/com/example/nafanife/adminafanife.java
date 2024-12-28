package com.example.nafanife;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class adminafanife extends AppCompatActivity {
    Button regcust, showcustinf, show, lgn;
    logindatabase ldbb;
    abayadatabase adb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminafanife);
        regcust = findViewById(R.id.registercustomeradd);
        showcustinf = findViewById(R.id.showcustinfo);
        show = findViewById(R.id.showabayaall);
        lgn = findViewById(R.id.logoutn);

        ldbb = new logindatabase(this);
        adb = new abayadatabase(this);

        regcust.setOnClickListener(view -> {
            Intent intent = new Intent(adminafanife.this, registercustomer.class);
            startActivity(intent);
        });

        showcustinf.setOnClickListener(view -> {
            Cursor crss = ldbb.getabayacustaccounts();
            if (crss == null || crss.getCount() == 0) {
                displayinfo("Customer", "Cannot find");
                return;
            }
            StringBuilder strbf1 = new StringBuilder();
            while (crss.moveToNext()) {
                strbf1.append("-\n");
                strbf1.append("Customer name: ").append(crss.getString(0)).append("\n");
                strbf1.append("Customer password: ").append(crss.getString(1)).append("\n");
                strbf1.append("-\n");
            }
            displayinfo("Customer details", strbf1.toString());
            crss.close();
        });

        show.setOnClickListener(view -> {
            Cursor crsss = adb.showabayas();
            if (crsss == null || crsss.getCount() == 0) {
                displayinfo("Abaya", "Cannot find");
                return;
            }
            StringBuilder strbf2 = new StringBuilder();
            while (crsss.moveToNext()) {
                strbf2.append("-\n");
                strbf2.append("Abaya ID: ").append(crsss.getString(0)).append("\n");
                strbf2.append("Total cost of the abaya: ").append(crsss.getString(1)).append("\n");
                strbf2.append("Date: ").append(crsss.getString(2)).append("\n");
                strbf2.append("Phone number: ").append(crsss.getString(3)).append("\n");
                strbf2.append("-\n");
            }
            displayinfo("Abaya information", strbf2.toString());
            crsss.close();
        });

        lgn.setOnClickListener(view -> {
            Intent intent = new Intent(adminafanife.this, loginnafanife.class);
            startActivity(intent);
            finish();
        });
    }

    public void displayinfo(String title, String message) {
        AlertDialog.Builder ad = new AlertDialog.Builder(this);
        ad.setCancelable(true);
        ad.setTitle(title);
        ad.setMessage(message);
        ad.show();
    }
}

