package com.example.nafanife;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class loginnafanife extends AppCompatActivity {
    EditText acustname, acustpass;
    Button signin1;
    logindatabase loginadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginnafanife);

        acustname = findViewById(R.id.namelogin);
        acustpass = findViewById(R.id.passwordlogin);
        signin1 = findViewById(R.id.signinlogin);

        loginadd = new logindatabase(this);

        signin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String acustid1 = acustname.getText().toString().trim();
                String acustpass1 = acustpass.getText().toString().trim();
                if (acustid1.equals("mallak") && acustpass1.equals("mallak")) {
                    Intent intent = new Intent(loginnafanife.this, adminafanife.class);
                    startActivity(intent);
                } else {
                    try {
                        String nfa = loginadd.getcustpassword(acustid1);
                        if (acustpass1.equals(nfa)) {
                            Toast.makeText(loginnafanife.this, "Welcome to Nafanife", Toast.LENGTH_SHORT).show();
                            acustname.setText("");
                            acustpass.setText("");
                            Intent intent = new Intent(loginnafanife.this, welcomecustomer.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(loginnafanife.this, "Type name and password again", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(loginnafanife.this, "Cannot login: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
