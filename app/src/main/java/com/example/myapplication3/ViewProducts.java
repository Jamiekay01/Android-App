package com.example.myapplication3;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.net.URLEncoder;
import java.util.ArrayList;

public class ViewProducts extends AppCompatActivity {

    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    private ArrayList<ProductModal> productModalArrayList;
    private DBHandler dbHandler;
    private ProductRVAdapter productsRVAdapter;
    private RecyclerView productsRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_courses);

        // initializing our all variables.
        productModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewProducts.this);

        // getting our course array
        // list from db handler class.
        productModalArrayList = dbHandler.readProduct();

        Log.d("ViewProducts", productModalArrayList.get(0).returnString());

        Button send
                = findViewById(R.id.send);
        send.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sendMessage(productModalArrayList.get(0).returnString());
                    }
                });

        // on below line passing our array lost to our adapter class.
        productsRVAdapter = new ProductRVAdapter(productModalArrayList, ViewProducts.this);
        productsRV = findViewById(R.id.idRVProducts);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewProducts.this, RecyclerView.VERTICAL, false);
        productsRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        productsRV.setAdapter(productsRVAdapter);
    }

    private void sendMessage(String message)
    {

        // Creating new intent
        PackageManager packageManager = getApplicationContext().getPackageManager();
        Intent intent= new Intent(Intent.ACTION_VIEW);

        try {
            String url = "https://api.whatsapp.com/send?phone=" + "+254746990169" + "&text=" + URLEncoder.encode(message, "UTF-8");
            intent.setPackage("com.whatsapp");
            intent.setData(Uri.parse(url));
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Give your message here
        intent.putExtra(
                Intent.EXTRA_TEXT,
                message);

        // Checking whether Whatsapp
        // is installed or not
        if (intent
                .resolveActivity(
                        getPackageManager())
                == null) {
            Toast.makeText(
                    this,
                    "Please install whatsapp first.",
                    Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        // Starting Whatsapp
        startActivity(intent);
    }

}
