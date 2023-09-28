package com.lms.main.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.lms.main.R;
import com.lms.main.dashboardItems.Home;
import com.lms.main.dashboardItems.Notification;
import com.lms.main.dashboardItems.RequestService;
import com.lms.main.dashboardItems.profile;

public class Dashboard extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;
    final int home = R.id.home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_layout);
        fragmentManager = getSupportFragmentManager();
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if(id == R.id.home){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new Home()).commit();
                    return true;
                }
                if(id == R.id.register){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new RequestService()).commit();
                    return true;
                }
                if (id == R.id.profile){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new profile()).commit();
                    return true;
                }if (id == R.id.notification){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new Notification()).commit();
                    return true;
                }
                return false;
            }
        });
    }
}
