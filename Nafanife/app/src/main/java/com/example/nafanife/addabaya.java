package com.example.nafanife;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class addabaya extends AppCompatActivity {
    EditText abayac, abayaq, totalcq;
    EditText abayaid, date11, abayatc, cphno, abname;
    CheckBox abayacheck;
    Button totalcalcab, addab, clrall;

    private abayacalculation a1calc;

    abayadatabase adb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addabaya);

        abayacheck = findViewById(R.id.abayacheck1);
        abayac = findViewById(R.id.abayacostt);
        abayaq = findViewById(R.id.abayaquantityy);

        a1calc = new abayacalculation();

        totalcq = findViewById(R.id.tltabcost);
        totalcalcab = findViewById(R.id.calcabayatotal);
        totalcalcab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a1 = abayac.getText().toString();
                String q1 = abayaq.getText().toString();

                Double a11 = Double.parseDouble(a1);
                Double q11 = Double.parseDouble(q1);

                Double abcalcc = a1calc.abayacalc(a11, q11);

                totalcq.setText("" + abcalcc);
                totalcq.setVisibility(View.VISIBLE);
            }
        });

        addab = findViewById(R.id.addaby);
        abayaid = findViewById(R.id.idabaya);
        abayatc = findViewById(R.id.tltabcost);
        date11 = findViewById(R.id.datee);
        cphno = findViewById(R.id.phnocust);
        abname = findViewById(R.id.nameabaya);

        clrall = findViewById(R.id.clrall1);
        clrall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abayaq.setText("");
                abayaid.setText("");
                date11.setText("");
                cphno.setText("");
                abayac.setText("");
                totalcq.setText("");
                abayatc.setText("");
                abname.setText("");

            }
        });

        adb = new abayadatabase(this);
        addabayas1();
    }

    public void addabayas1() {
        addab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String aid = abayaid.getText().toString();
                String abcost = totalcq.getText().toString();
                String dt = date11.getText().toString();
                String cph = cphno.getText().toString();

                boolean insert = adb.addabayas1(aid, abcost, dt, cph);
                if (insert) {
                    Toast.makeText(addabaya.this, "Abaya added", Toast.LENGTH_SHORT).show();
                    Intent login = new Intent(addabaya.this, welcomecustomer.class);
                    startActivity(login);
                } else {
                    Toast.makeText(addabaya.this, "Abaya not added", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}