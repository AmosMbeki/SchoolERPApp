package it.com.ke;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Launcher extends AppCompatActivity {

    private EditText myEmail;
    private EditText myPassword;
    private Button myLogin;
    private Button myRegister;
    private String x_email, x_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        myEmail =  findViewById(R.id.myemail);
        myPassword = findViewById(R.id.mypassword);
        myLogin = findViewById(R.id.btn_button);
        myRegister = findViewById(R.id.btn_signup);

        myRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUp = new Intent(Launcher.this, RegisterActivity.class);

                startActivity(signUp);
            }
        });

        myLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkIfBlank();
            }
        });
    }

    private void checkIfBlank() {
        x_email = myEmail.getText().toString();
        x_password = myPassword.getText().toString();

        if(x_email.length() < 6){
            new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("Oops...")
                    .setContentText("Email is wrong!")
                    .show();

            return;
        }

        if(x_password.length() < 6){
            new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("Oops...")
                    .setContentText("Password is wrong!")
                    .show();

            return;
        }
        
        moveToHomePage();
    }

    private void moveToHomePage() {
        Intent next = new Intent(Launcher.this, Home.class);
        startActivity(next);
    }
}