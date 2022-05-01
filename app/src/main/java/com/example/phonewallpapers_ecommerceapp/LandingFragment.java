package com.example.phonewallpapers_ecommerceapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class LandingFragment extends Fragment {

    private Button joinNowButton, loginButton;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_landing, container, false);

        joinNowButton = (Button) view.findViewById(R.id.main_join_now_btn);
        loginButton = (Button) view.findViewById(R.id.main_login_btn);

        joinNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* Used to call the next fragment (game) */

                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction(); // standard
                fragmentTransaction.setReorderingAllowed(true);
                fragmentTransaction.replace(R.id.framelayout_fragment, new RegisterFragment()); // framelayout_fragment = ID of fragment/framelayout on mainactivity.xml
                fragmentTransaction.commit(); // standard
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() { // When the button is clicked, do this...
            @Override
            public void onClick(View view) {

                /* Used to call the next fragment (game) */
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction(); // standard
                fragmentTransaction.setReorderingAllowed(true);
                fragmentTransaction.replace(R.id.framelayout_fragment, new LoginFragment()); // framelayout_fragment = ID of fragment/framelayout on mainactivity.xml
                fragmentTransaction.commit(); // standard
            }
        });

        return view; // standard
    }

}