package com.hr.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    Button Bwork, Bmenu, Bsetting,Bmore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Bmenu = findViewById(R.id.btn_menu);
        Bwork = findViewById(R.id.btn_work);
        Bsetting = findViewById(R.id.btn_setting);
        Bmore=findViewById(R.id.btn_option);

        // Initial fragment load, e.g., load setting fragment by default
        // loadFrag(new settingfrag(), 0);

        Bmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFrag(new menufrag(), 0);
            }
        });

        Bwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFrag(new workfrag(), 1);
            }
        });

        Bsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFrag(new settingfrag(), 2);
            }
        });

        Bmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, Navigation.class);
                startActivity(intent);
            }

    });

    }
    public void loadFrag(Fragment fragment, int flag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if (flag == 0) {
            ft.replace(R.id.container, fragment);  // Use replace to change the fragment
        } else {
            ft.replace(R.id.container, fragment);  // Use replace to change the fragment
        }

        ft.commit();
    }
}
