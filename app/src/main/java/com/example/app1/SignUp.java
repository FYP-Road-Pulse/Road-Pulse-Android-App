package com.example.app1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    EditText txtfName, txtEmail, txtPass, txtConpass;
    Button btn_reg;
    ProgressBar proBar;

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().hide(); // hide the title bar

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setTitle("Sign Up");
        txtfName = (EditText)findViewById(R.id.fulname);
        txtEmail = (EditText)findViewById(R.id.email);
        txtPass = (EditText)findViewById(R.id.pass);
        txtConpass = (EditText)findViewById(R.id.conpass);
        btn_reg = (Button)findViewById(R.id.button);
        proBar = (ProgressBar)findViewById(R.id.progressBar);

        firebaseAuth = FirebaseAuth.getInstance();

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmail.getText().toString().trim();
                String password = txtPass.getText().toString().trim();
                String confirmPassword = txtConpass.getText().toString().trim();
                String fullName = txtfName.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(SignUp.this, "Please enter your Email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Toast.makeText(SignUp.this, "Please enter your Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(confirmPassword)){
                    Toast.makeText(SignUp.this, "Please confirm your Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(SignUp.this, "Please enter your Name", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(password.length()<6){
                    Toast.makeText(SignUp.this, "Password is too short.It must be of 8 digits.", Toast.LENGTH_SHORT).show();
                }

                proBar.setVisibility(View.VISIBLE);

                if (password.equals(confirmPassword)){

                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    proBar.setVisibility(View.GONE);

                                    if (task.isSuccessful()) {

                                        startActivity(new Intent(getApplicationContext(),LogIn.class));
                                        Toast.makeText(SignUp.this, "Registration Successfull", Toast.LENGTH_SHORT).show();

                                    } else {

                                        Toast.makeText(SignUp.this, "Authentication Failed", Toast.LENGTH_SHORT).show();

                                    }

                                    // ...
                                }
                            });

                }

            }

        });



    }

}