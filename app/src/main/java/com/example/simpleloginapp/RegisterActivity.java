
package com.example.simpleloginapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText newUsername, newPassword;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        newUsername = findViewById(R.id.newUsername);
        newPassword = findViewById(R.id.newPassword);
        save = findViewById(R.id.save);

        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        save.setOnClickListener(v -> {
            editor.putString("username", newUsername.getText().toString());
            editor.putString("password", newPassword.getText().toString());
            editor.apply();
            Toast.makeText(this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
