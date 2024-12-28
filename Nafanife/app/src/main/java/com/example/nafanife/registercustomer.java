package com.example.nafanife;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class registercustomer extends AppCompatActivity {
    EditText rcname, rcpass;
    Button addc, crnp, gb;
    logindatabase regcust;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registercustomer);

        rcname = findViewById(R.id.namerc);
        rcpass = findViewById(R.id.passwordrc);
        addc = findViewById(R.id.addrc);
        crnp = findViewById(R.id.cnprc);
        gb = findViewById(R.id.gbck);

        regcust = new logindatabase(this);

        crnp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rcname.setText("");
                rcpass.setText("");
            }
        });

        gb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(registercustomer.this, adminafanife.class);
                startActivity(intent);
            }
        });

        addc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String adrc = rcname.getText().toString();
                String adrcp = rcpass.getText().toString();
                boolean insert = regcust.addabayacustomer(adrc, adrcp);
                if (insert) {
                    Toast.makeText(registercustomer.this, "Customer registered", Toast.LENGTH_SHORT).show();
                    Intent login = new Intent(registercustomer.this, loginnafanife.class);
                    startActivity(login);
                } else {
                    Toast.makeText(registercustomer.this, "Customer is already registered", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
