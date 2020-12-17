package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {
    int Order=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void displayOrder(){
        TextView price = (TextView) findViewById(R.id.quantity_text_view);
        price.setText(""+Order);
    }

    public void displayPrice(int number){
        TextView priceText = (TextView) findViewById(R.id.price_text_view);
        priceText.setText("₹ "+number);
    }

    public void IncreaseOrder_1(View view){
        Order++;
        displayOrder();
        displayPrice(Order*10);
    }
    public void DecreaseOrder_1(View view){
        Order--;
        if(Order<0)Order=0;
        displayOrder();
        displayPrice(Order*10);
    }
    public void displayMessage(View view) {
        TextView messageText = (TextView) findViewById(R.id.message);
        if(Order>0)
            messageText.setText("Your order of ₹ "+ Order*10+" has been placed");
        else
            messageText.setText("No order has been placed");
    }
}


