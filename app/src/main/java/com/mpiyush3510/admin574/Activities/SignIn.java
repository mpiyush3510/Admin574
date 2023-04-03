package com.mpiyush3510.admin574.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.mpiyush3510.admin574.MainActivity;
import com.mpiyush3510.admin574.Views.EmployeeInfo;
import com.mpiyush3510.admin574.databinding.ActivitySignInBinding;
import java.util.Objects;

public class SignIn extends AppCompatActivity {
ActivitySignInBinding binding;
MaterialAlertDialogBuilder materialAlertDialogBuilder;
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Callers();
    }

    private void Callers() {
        binding.SignIn.setOnClickListener(v -> {
            intent=new Intent(SignIn.this, EmployeeInfo.class);
           // if (isValidate()){
                startActivity(intent);
            //}
        });
        binding.ForgotPassword.setOnClickListener(v -> {CustomAlertDialog();});
    }

    private void CustomAlertDialog(){
        materialAlertDialogBuilder= new MaterialAlertDialogBuilder(this)
                .setTitle("Admin Information")
                .setMessage("This Option is under development, we'll released with next Future Update 😁")
                .setPositiveButton("Thank You !", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        materialAlertDialogBuilder.create().show();
        showToast("You can't be perform operation");
    }
    private boolean isValidate() {
        if(Objects.requireNonNull(binding.EmailOrPhone.getText()).toString().isEmpty()){
            showToast("Please Kindly Enter Uid");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(binding.EmailOrPhone.getText().toString()).matches() && !Patterns.PHONE.matcher(binding.EmailOrPhone.getText().toString()).matches()) {
            showToast("Enter Valid Uid");
            return false;
        } else if (Objects.requireNonNull(binding.Password.getText()).toString().isEmpty()) {
            showToast("Password Can't be Empty ");
            return false;
        } else if (binding.Password.getText().toString().length()<6) {
            showToast("Password length should be 6 character");
            return false;
        }
        return true;
    }

    private void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}