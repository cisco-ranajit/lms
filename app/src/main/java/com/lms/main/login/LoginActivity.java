package com.lms.main.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.lms.main.R;
import com.lms.main.dashboard.Dashboard;

public class LoginActivity extends AppCompatActivity {
    private MaterialButton m_login;
    private TextInputEditText m_username, m_password;
    private FirebaseAuth mAuth;
    private TextView m_singUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        m_username = findViewById(R.id.username);
        m_password = findViewById(R.id.password);
        m_singUp = findViewById(R.id.signupText);
        m_login = findViewById(R.id.login);
        mAuth = FirebaseAuth.getInstance();
        
        m_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuthentication();
            }
        });

        m_singUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
    private void mAuthentication(){
        String userName, userPassword;
        userName = m_username.getText().toString();
        userPassword = m_password.getText().toString();
        //validations for input email and password
        if(TextUtils.isEmpty(userName)){
            Toast.makeText(getApplicationContext(),"Please enter username",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(userPassword)){
            Toast.makeText(getApplicationContext(),"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Login successful!!",Toast.LENGTH_LONG).show();
                    // intent to home activity
                    Intent intent = new Intent(LoginActivity.this, Dashboard.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Login unsuccessful!!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}