package com.mpiyush3510.admin574.StartUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.mpiyush3510.admin574.Activities.SignIn;
import com.mpiyush3510.admin574.Activities.SignUp;
import com.mpiyush3510.admin574.R;
import com.mpiyush3510.admin574.databinding.ActivityGetStartedBinding;

public class GetStarted extends AppCompatActivity {
ActivityGetStartedBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityGetStartedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Callers();
    }

    private void Callers() {
        binding.SignIn.setOnClickListener(v -> {startActivity(new Intent(this, SignIn.class));});
        binding.SignUp.setOnClickListener(v -> {startActivity(new Intent(this, SignUp.class));});
    }
}