package com.arun.e_softwarica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.arun.e_softwarica.fragment.AddFragment;
import com.arun.e_softwarica.fragment.DisplayFragment;

public class DashBoard extends AppCompatActivity {

    ImageView btndisplay, btnadd, btnweb;
    // LinearLayout linearLayout;
    boolean status = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);

        btndisplay = findViewById(R.id.btndisplay);
        btnadd = findViewById(R.id.btnadd);
        btnweb = findViewById(R.id.btnwebview);
        //    linearLayout = findViewById(R.id.linearLayout);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        DisplayFragment displayFragment = new DisplayFragment();
        fragmentTransaction.replace(R.id.fragmentlayout, displayFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        btndisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                DisplayFragment displayFragment = new DisplayFragment();
                fragmentTransaction.replace(R.id.fragmentlayout, displayFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                AddFragment addFragment = new AddFragment();
                fragmentTransaction.replace(R.id.fragmentlayout, addFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        btnweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoard.this, WebViewActivity.class);
                startActivity(intent);
            }
        });
    }
}

