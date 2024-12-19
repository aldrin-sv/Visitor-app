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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

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

                if(str1.isEmpty() | str2.isEmpty() | str3.isEmpty() | str4.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"All fields are mandatory !",Toast.LENGTH_LONG).show();
                }
                else
                {
                    callApi();
                }
            }

            private void callApi() {
                String apiUrl="https://log-app-demo-api.onrender.com/addvisitor";
                JSONObject data=new JSONObject();
                try {
                    data.put("firstname",str1);
                    data.put("lastname",str2);
                    data.put("purpose",str3);
                    data.put("whomToMeet",str4);

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                JsonObjectRequest request =new JsonObjectRequest(
                        Request.Method.POST,
                        apiUrl,data,
                        response -> Toast.makeText(getApplicationContext(),"Successfully Added",Toast.LENGTH_LONG).show(),
                        error -> Toast.makeText(getApplicationContext(),"Error Occurred",Toast.LENGTH_LONG).show()
                );

                RequestQueue Queue= Volley.newRequestQueue(getApplicationContext());
                Queue.add(request);

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