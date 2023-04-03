package com.mpiyush3510.admin574.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.mpiyush3510.admin574.MainActivity;
import com.mpiyush3510.admin574.R;
import com.mpiyush3510.admin574.databinding.ActivitySignUpBinding;

import java.util.Objects;

public class SignUp extends AppCompatActivity {
ActivitySignUpBinding binding;
MaterialDatePicker<Long> materialDatePicker;
Intent intent;
ArrayAdapter<String> arrayAdapter;
String[] City={
        "Ahmedabad","Amreli","Anand","Bharuch","Bhuj","Botad","Dahod","Deesa","Gandhidham","Gandhinagar","Godhra",
        "Gondal","Jamnagar","Jetpur","Junagadh","Kalol","Mehsana","Morbi","Nadiad","Navsari","PalanPur","Patan",
        "Porbandar","Rajkot","Surat","Surendranagar","Vadodara","Valsad","Vapi","Veraval"
};

String[] Designation={
        "Chief Operation Officer(Coo)","Chief Executive Officer(Ceo)","Director","Chief Compliance Officer","President",
        "Chief Financial Officer","Chief Technology Officer","Vice-President","Human Resource Director","Employee","Watchmen",
        "Administrator"
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Callers();
    }

    private void Callers() {
        binding.SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(SignUp.this, MainActivity.class);
                if(isValidate()){
                    startActivity(intent);
                }
            }
        });
        binding.BirthdateImg.setOnClickListener(v -> {
            CustomDatePicker();
            materialDatePicker.show(getSupportFragmentManager(),"Material Date Picker");
            materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
                @Override
                public void onPositiveButtonClick(Long selection) {
                    binding.Birthdate.setText(materialDatePicker.getHeaderText());
                }
            });
        });
        mySpinnerData();
    }

    private boolean isValidate() {
        if(Objects.requireNonNull(binding.FirstName.getText()).toString().isEmpty()){
            showToast("Enter First Name");
            return false;
        } else if (Objects.requireNonNull(binding.LastName.getText()).toString().isEmpty()) {
            showToast("Please enter Last name");
            return false;
        } else if (Objects.requireNonNull(binding.Birthdate.getText()).toString().isEmpty()) {
            showToast("Enter Your Birthdate");
            return false;
        } else if (Objects.requireNonNull(binding.Email.getText()).toString().isEmpty()) {
            showToast("Email can't be Empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(binding.Email.getText().toString()).matches()) {
            showToast("Enter Valid Email");
            return false;
        } else if (Objects.requireNonNull(binding.PhoneNo.getText()).toString().isEmpty()) {
            showToast("Enter your Phone No");
            return false;
        } else if (binding.PhoneNo.getText().toString().length()<10){
            showToast("Enter Valid Phone No");
            return false;
        } else if (binding.City.getText().toString().isEmpty()) {
            showToast("Please Select Your City");
            return false;
        } else if (!binding.Male.isChecked() && !binding.Female.isChecked() && !binding.Other.isChecked()) {
            showToast("Choose Your Gender");
            return false;
        } else if (binding.Designation.getText().toString().isEmpty()){
            showToast("Select Your Designation");
            return false;
        } else if (!binding.TermsCondition.isChecked()) {
            showToast("Accept Terms And Condition");
            return false;
        }
        return true;
    }
    private void mySpinnerData(){
        arrayAdapter= new ArrayAdapter<String>(this,R.layout.autocomplete_spinner,City);
        binding.City.setAdapter(arrayAdapter);

        arrayAdapter= new ArrayAdapter<String>(this,R.layout.autocomplete_spinner,Designation);
        binding.Designation.setAdapter(arrayAdapter);
    }

    private void CustomDatePicker(){
        materialDatePicker= MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select Your Birthdate")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build();
    }
    private void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}