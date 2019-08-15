package com.example.appsvikavp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MyProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_my);

        if (getSupportActionBar() != null ){
            getSupportActionBar().setTitle("MY PROFILE");
        }
    }

}
