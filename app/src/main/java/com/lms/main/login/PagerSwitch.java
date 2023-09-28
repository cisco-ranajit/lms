package com.lms.main.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.lms.main.R;
import com.lms.main.dashboard.Dashboard;

public class PagerSwitch extends AppCompatActivity {
    private MaterialButton loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager_switch_layout);
        loginBtn = findViewById(R.id.login);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PagerSwitch.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}