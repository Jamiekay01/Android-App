package com.example.myapplication3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText productNameEdt, buyingPriceEdt, sellingPriceEdt, productCategoryEdt;
    private Button addProductBtn, readProductBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing all our variables.
        productNameEdt = findViewById(R.id.idEdtCourseName);
        buyingPriceEdt = findViewById(R.id.idEdtBuyingPrice);
        sellingPriceEdt = findViewById(R.id.idEdtSellingPrice);
        productCategoryEdt = findViewById(R.id.idEdtProductCategory);
        addProductBtn = findViewById(R.id.idBtnAddProduct);
        readProductBtn = findViewById(R.id.idBtnReadProducts);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(MainActivity.this);

        // below line is to add on click listener for our add course button.
        addProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String productName = productNameEdt.getText().toString();
                String buyingPrice = buyingPriceEdt.getText().toString();
                String sellingPrice = sellingPriceEdt.getText().toString();
                String productCategory = productCategoryEdt.getText().toString();

                // validating if the text fields are empty or not.
                if (productName.isEmpty() && buyingPrice.isEmpty() && sellingPrice.isEmpty() && productCategory.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // product to sqlite data and pass all our values to it.
                dbHandler.addNewProduct(productName, sellingPrice, productCategory, buyingPrice);

                // after adding the data we are displaying a toast message.
                Toast.makeText(MainActivity.this, "Product has been added.", Toast.LENGTH_SHORT).show();
                productNameEdt.setText("");
                sellingPriceEdt.setText("");
                buyingPriceEdt.setText("");
                productCategoryEdt.setText("");
            }
        });

        readProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(MainActivity.this, ViewProducts.class);
                startActivity(i);
            }
        });
    }
}
