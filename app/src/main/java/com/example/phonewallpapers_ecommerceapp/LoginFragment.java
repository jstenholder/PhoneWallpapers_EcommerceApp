package com.example.phonewallpapers_ecommerceapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
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
import android.widget.EditText;
import android.widget.Toast;

import com.example.phonewallpapers_ecommerceapp.model.Users;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class LoginFragment extends Fragment {

    private Button LoginButton;
    private EditText InputPhone, InputPassword;

    private String parentDBName = "users";

    public class authentication extends Fragment {

        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.fragment_login, container, false);

            LoginButton = (Button) view.findViewById(R.id.login_btn);
            InputPhone = (EditText) view.findViewById(R.id.login_phone_input);
            InputPassword = (EditText) view.findViewById(R.id.login_password_input);
            // Creates the button that triggers the change to the next fragment (game)

            LoginButton.setOnClickListener(new View.OnClickListener() { // When the button is clicked, do this...
                @Override
                public void onClick(View view) {

                    LoginUser();
                }
            });

            return view; // standard
        }

    }

    private void LoginUser() {
        String phone = InputPhone.getText().toString();
        String password = InputPassword.getText().toString();

        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(getContext().getApplicationContext(), "Please write your phone number", Toast.LENGTH_SHORT).show();
        }

        else if (TextUtils.isEmpty(password)) {
            Toast.makeText(getContext().getApplicationContext(), "Please write your password", Toast.LENGTH_SHORT).show();
        }

        else {

            AllowAccessToAccount(phone, password);
        }
    }

    private void AllowAccessToAccount(String phone, String password) {

        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();


        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.child(parentDBName).child(phone).exists()) {
                    Users usersData = snapshot.child(parentDBName).child(phone).getValue(Users.class);

                    if (usersData.getPhone().equals(phone)) {
                        if (usersData.getPassword().equals(password)) {


                            Toast.makeText(getContext().getApplicationContext(), "Logged in successfully!", Toast.LENGTH_SHORT).show();

                            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction(); // standard
                            fragmentTransaction.setReorderingAllowed(true);
                            fragmentTransaction.replace(R.id.framelayout_fragment, new CategoryFragment()); // framelayout_fragment = ID of fragment/framelayout on mainactivity.xml
                            fragmentTransaction.commit(); // standard
                        }
                    }

                    else {
                        Toast.makeText(getContext().getApplicationContext(), "Account with this phone nuber does not exist", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getContext().getApplicationContext(), "Please enter a valid number", Toast.LENGTH_SHORT).show();
                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}