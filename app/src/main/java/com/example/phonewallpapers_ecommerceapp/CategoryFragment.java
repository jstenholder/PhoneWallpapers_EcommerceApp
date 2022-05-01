package com.example.phonewallpapers_ecommerceapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


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
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class CategoryFragment extends Fragment {

    private ImageView red, orange, yellow;
    private ImageView green, blue, purple;
    private ImageView pink, black, grey;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register, container, false);

        red = (ImageView) view.findViewById(R.id.red);
        orange = (ImageView) view.findViewById(R.id.orange);
        yellow = (ImageView) view.findViewById(R.id.yellow);
        green = (ImageView) view.findViewById(R.id.green);
        blue = (ImageView) view.findViewById(R.id.blue);
        purple = (ImageView) view.findViewById(R.id.purple);
        pink = (ImageView) view.findViewById(R.id.pink);
        black = (ImageView) view.findViewById(R.id.black);
        grey = (ImageView) view.findViewById(R.id.grey);

        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "red");
                startActivity(intent);
            }
        });

        orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "orange");
                startActivity(intent);
            }
        });

        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "yellow");
                startActivity(intent);
            }
        });

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "green");
                startActivity(intent);
            }
        });

        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "blue");
                startActivity(intent);
            }
        });

        purple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "purple");
                startActivity(intent);
            }
        });

        pink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "pink");
                startActivity(intent);
            }
        });

        black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "black");
                startActivity(intent);
            }
        });

        grey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "grey");
                startActivity(intent);
            }
        });

        return view; // standard
    }
}