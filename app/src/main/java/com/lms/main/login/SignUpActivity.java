package com.lms.main.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.lms.main.R;
import com.lms.main.dashboard.Dashboard;

public class SignUpActivity extends AppCompatActivity {
    private MaterialButton m_signup;
    private TextInputEditText m_email, m_password, m_cnfpassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_layout);

        m_email = findViewById(R.id.email);
        m_password = findViewById(R.id.password);
        m_cnfpassword = findViewById(R.id.cnfpassword);
        m_signup = findViewById(R.id.signup);
        mAuth = FirebaseAuth.getInstance();
        m_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_Authentication();
            }
        });
    }

    private void m_Authentication() {
        String email, password, cnfpassword;
        //getting data from text editor
        email = m_email.getText().toString();
        password = m_password.getText().toString();
        cnfpassword = m_cnfpassword.getText().toString();

        //validations for input email and password
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Please enter password", Toast.LENGTH_LONG).show();
            return;
        }

        //checking if the password and confirm password is equal or not
        if(!password.equals(cnfpassword)) {
            Toast.makeText(getApplicationContext(), "Please check both having same password", Toast.LENGTH_LONG).show();
        }
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "you have registered successfully.", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SignUpActivity.this, PagerSwitch.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "Fail to register user..", Toast.LENGTH_LONG).show();
                }
            }
        });








    }
}