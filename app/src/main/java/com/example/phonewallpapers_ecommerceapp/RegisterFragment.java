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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class RegisterFragment extends Fragment {

    private Button CreateAccountButton;
    private EditText InputName, InputPhone, InputPassword;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register, container, false);

        CreateAccountButton = (Button) view.findViewById(R.id.register_btn);
        InputName = (EditText) view.findViewById(R.id.register_name_input);
        InputPhone = (EditText) view.findViewById(R.id.register_phone_input);
        InputPassword = (EditText) view.findViewById(R.id.register_password_input);
        // Creates the button that triggers the change to the next fragment (game)

        CreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateAccount();
            }
        });

        return view; // standard
    }

    private void CreateAccount() {
        String name = InputName.getText().toString();
        String phone = InputPhone.getText().toString();
        String password = InputPassword.getText().toString();

        if (TextUtils.isEmpty(name)) {
            Toast.makeText(getContext().getApplicationContext(), "Please write your name", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(phone)) {
            Toast.makeText(getContext().getApplicationContext(), "Please write your phone number", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(getContext().getApplicationContext(), "Please write your password", Toast.LENGTH_SHORT).show();
        } else {

            ValidatePhone(name, phone, password);
        }
    }

    private void ValidatePhone(String name, String phone, String password) {
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (!(snapshot.child("users").child(phone).exists())) {
                    HashMap<String, Object> userdataMap = new HashMap<>();
                    userdataMap.put("phone", phone);
                    userdataMap.put("password", password);
                    userdataMap.put("name", name);

                    RootRef.child("users").child(phone).updateChildren(userdataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getContext().getApplicationContext(), "Congratulations! Your account has been created!", Toast.LENGTH_SHORT).show();

                                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction(); // standard
                                fragmentTransaction.setReorderingAllowed(true);
                                fragmentTransaction.replace(R.id.framelayout_fragment, new LoginFragment()); // framelayout_fragment = ID of fragment/framelayout on mainactivity.xml
                                fragmentTransaction.commit(); // standard

                            }

                            else {
                                Toast.makeText(getContext().getApplicationContext(), "Network Error. Please try again", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

                else {
                    Toast.makeText(getContext().getApplicationContext(), "This phone number already exists", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getContext().getApplicationContext(), "Please try again using another phone number", Toast.LENGTH_SHORT).show();

                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction(); // standard
                    fragmentTransaction.replace(R.id.framelayout_fragment, new LandingFragment()); // framelayout_fragment = ID of fragment/framelayout on mainactivity.xml
                    fragmentTransaction.commit(); // standard
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}



