package com.example.barangaycomplaints;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class ForgotPasswordActivity extends AppCompatActivity {

    private ImageButton btnBack;
    private TextInputEditText etEmailPhone;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forgot_password);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnBack = findViewById(R.id.btnBack);
        etEmailPhone = findViewById(R.id.etEmailPhone);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnBack.setOnClickListener(v -> finish());

        btnSubmit.setOnClickListener(v -> {
            String input = etEmailPhone.getText().toString().trim();
            if (input.isEmpty()) {
                Toast.makeText(ForgotPasswordActivity.this, "Please enter your Email or Phone #", Toast.LENGTH_SHORT).show();
            } else {
                // Show message as requested
                Toast.makeText(ForgotPasswordActivity.this, "check your email please", Toast.LENGTH_SHORT).show();
                
                // Continue to resetting password
                Intent intent = new Intent(ForgotPasswordActivity.this, ResetPasswordActivity.class);
                startActivity(intent);
                finish(); // Optional: close forgot password screen
            }
        });
    }
}