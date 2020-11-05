package com.example.alertlayouting;

import android.content.Intent;
import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class LayoutingActivity extends AppCompatActivity implements View.OnClickListener{
//TODO membuat variabel
    Button btnLogin;
    EditText edtUsername, edtPassword;
    TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layouting);
        // TODO Inisialisasi variabel dengan id yang ada di activity_layouting.xml
        btnLogin = findViewById(R.id.btn_login);
        edtPassword = findViewById(R.id.edt_password);
        edtUsername = findViewById(R.id.edt_username);
        tvRegister = findViewById(R.id.tv_register);
        //TODO handling halaman
        btnLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                // TODO Here to Handling Login
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                // TODO membuat kondisi error bila username dan pass harus diisi lebih dari 6 karakter huruf
                if(username.length() < 6 ){
                    edtUsername.setError("Username Harus Lebih dari 6 karacter");
                } else if (password.length() < 6 ){
                    edtPassword.setError("Password Harus Lebih dari 6 karacter");
            }else{
               // TODO membuat kondisi jika username dan pass sesuai maka akan menuju kepada halaman home
                    Intent intenHome = new Intent(LayoutingActivity.this,HomeActivity.class);
                    intenHome.putExtra("USERNAME", username);
                    startActivityForResult(intenHome, 2);
                    // TODO intenHome adalah variabel untuk handling pindah halaman
                }
                break;
            case R.id.tv_register:
                // Here to Handling register
                break;
        }
    }
// TODO menampilkan TOAST dari HomeActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra("key_logout");
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                //TODO membuat password
                edtPassword.setText("");
                edtUsername.setText("");
            }
        }
    }
}