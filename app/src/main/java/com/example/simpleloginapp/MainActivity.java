
package com.example.simpleloginapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);

        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        login.setOnClickListener(v -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();
            String savedUser = prefs.getString("username", "");
            String savedPass = prefs.getString("password", "");

            if(user.equals(savedUser) && pass.equals(savedPass)){
                startActivity(new Intent(this, HomeActivity.class));
            } else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        });

        register.setOnClickListener(v -> {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}
