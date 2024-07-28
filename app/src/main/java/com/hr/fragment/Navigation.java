package com.hr.fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;


import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import androidx.navigation.ui.AppBarConfiguration;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.hr.fragment.databinding.ActivityNavigationBinding;
import com.hr.fragment.ui.Homefrag;

public class Navigation extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityNavigationBinding binding;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_navigation);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.ToolBar);

        // Step 1: Set up Toolbar
        setSupportActionBar(toolbar);
        // Step 2: Set up ActionBarDrawerToggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Step 3: Handle Navigation Item Clicks
        navigationView.setNavigationItemSelectedListener(item -> {
                    int id = item.getItemId();
                    if (id == R.id.nav_home) {
                        loadFragment(new Homefrag());
                        Toast.makeText(Navigation.this, "Homeopening", Toast.LENGTH_SHORT).show(); // Show the Toast
                    } else if (id == R.id.nav_gallery) {
                        Toast.makeText(Navigation.this, "Gallery opening", Toast.LENGTH_SHORT).show(); // Show the Toast
                    } else {
                        Toast.makeText(Navigation.this, "Slide opening", Toast.LENGTH_SHORT).show(); // Show the
                    }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, fragment);// Use replace to avoid adding fragments on top of each other

        ft.add(R.id.container,fragment);
        ft.commit();

    }
}