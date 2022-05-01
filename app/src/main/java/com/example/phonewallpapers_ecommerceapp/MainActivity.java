package com.example.phonewallpapers_ecommerceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* This section is used to call the first fragment (authentication) and display in the fragment item on the screen */
        FragmentManager fragmentManager = getSupportFragmentManager(); // Standard
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); // Standard
        fragmentTransaction.replace(R.id.framelayout_fragment, new LandingFragment()); // frameLayout_fragment = id of the fragment/framelayout item
        // authentication = name of the fragments .java file
        fragmentTransaction.commit(); // Standard
    }

}