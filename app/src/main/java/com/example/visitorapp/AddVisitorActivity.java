package com.example.visitorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddVisitorActivity extends AppCompatActivity {
    EditText et1,et2,et3,et4;
    Button bt1,bt2;
    String str1,str2,str3,str4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_visitor);
        et1=(EditText) findViewById(R.id.t1);
        et2=(EditText) findViewById(R.id.t2);
        et3=(EditText) findViewById(R.id.t3);
        et4=(EditText) findViewById(R.id.t4);

        bt1=(Button) findViewById(R.id.b1);
        bt2=(Button) findViewById(R.id.b2);


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str1=et1.getText().toString();
                str1=et1.getText().toString();
                str2=et2.getText().toString();
                str3=et3.getText().toString();
                str4=et4.getText().toString();

            }
        });



        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj =new Intent(getApplicationContext(), MainActivity.class);
                startActivity(obj);
            }
        });
    }
}