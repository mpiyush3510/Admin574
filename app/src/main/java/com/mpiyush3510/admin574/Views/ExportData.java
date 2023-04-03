package com.mpiyush3510.admin574.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.mpiyush3510.admin574.R;
import com.mpiyush3510.admin574.databinding.ActivityExportDataBinding;

public class ExportData extends AppCompatActivity {
ActivityExportDataBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityExportDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ImportDataWantsToView();
    }

    private void ImportDataWantsToView() {
        Bundle bundle=getIntent().getExtras();

        assert bundle != null;
        int img=bundle.getInt("img");

        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        String mail=intent.getStringExtra("mail");
        String phone=intent.getStringExtra("phone");
        String designation=intent.getStringExtra("designation");

        binding.EmpImg.setImageResource(img);
        binding.EmpName.setText(name);
        binding.EmpMail.setText(mail);
        binding.EmpPhoneNo.setText(phone);
        binding.EmpDesignation.setText(designation);
    }
}