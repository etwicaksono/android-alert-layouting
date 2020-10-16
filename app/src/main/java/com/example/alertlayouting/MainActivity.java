package com.example.alertlayouting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
Button btnToast, btnAlert, btnLayouting; // variabel button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inisialisasi dari variabel ke id layout
        setContentView(R.layout.activity_main);
                setContentView(R.layout.activity_main);
        btnToast = (Button) findViewById(R.id.btntoast);
        btnAlert = (Button) findViewById(R.id.btnalert);
        btnLayouting = (Button) findViewById(R.id.btnlayouting);

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Ini Toast",
                        Toast.LENGTH_LONG).show();
            }
        });
        btnAlert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()== R.id.btnalert){
            Intent intenalert = new Intent(this,AlertActivity.class);
            startActivity(intenalert);
        }else if(v.getId()== R.id.btntoast){

        }
    }
}