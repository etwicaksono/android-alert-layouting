package com.example.alertlayouting;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AlertDialog;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;




public class HomeActivity extends AppCompatActivity {
// TODO membuat variabel
    Button btnLogout;
    TextView tvUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnLogout = findViewById(R.id.btn_logout);
        tvUsername =findViewById(R.id.tv_homeusername);
        String usernameText = getIntent().getStringExtra("USERNAME");
        tvUsername.setText(usernameText);

        // TODO Mengirim data ke LayoutActivity dengan menggunakan activityforresult
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(HomeActivity.this);

                //set dialog
                dialog.setTitle("Logout");

                // set pesan dialog
                dialog.setMessage("Klik Yes untuk keluar!")
                        .setIcon(R.drawable.logo)
                        .setCancelable(true) //klik diluar alert maka ke cancel
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                }
                        })
                        // TODO menampilkan toast yang akan di tampilkan di layoutActivity
                        .setPositiveButton("Yes", new
DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent data = new Intent();
                                data.putExtra("key_logout", "Anda Telah Logout, Silahkan login lagi");
                                setResult(Activity.RESULT_OK, data);
                                finish();
                            }
                        });
                dialog.show();
            }
        });
    }
}