package com.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etUsername, etPassword;
    private Button btnRegister, btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword= findViewById(R.id.etPassword);
        btnRegister= findViewById(R.id.btnRegister);
        btnLogin= findViewById(R.id.btnLogin);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUp();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUser();
            }
        });
    }
    private void SignUp(){
        SharedPreferences sharedPreferences= getSharedPreferences("User", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("Username", etUsername.getText().toString());
        editor.putString("Password", etPassword.getText().toString());
        editor.commit();

        Toast.makeText(this, "Successfully Registered", Toast.LENGTH_SHORT).show();

    }

    private void  checkUser() {
        SharedPreferences sharedPreferences = getSharedPreferences("User", MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");
        if (username.equals(etUsername.getText().toString()) &&
                password.equals(etPassword.getText().toString())) {
            Toast.makeText(this, "Successfull", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Either username or password is incorrest", Toast.LENGTH_SHORT).show();

        }

    }

}
