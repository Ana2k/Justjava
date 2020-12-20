package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    int Quantity=0,price=0,pricePerCoffee=10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void IncreaseQuantity_1(View view){
        Quantity++;
        calculatePrice(Quantity,pricePerCoffee);
        displayDetails(Quantity,price);
    }
    public void DecreaseQuantity_1(View view){
        Quantity--;
        if(Quantity<0)Quantity=0;
        calculatePrice(Quantity,pricePerCoffee);
        displayDetails(Quantity,price);
    }
    public void displayDetails(int number,int price) {
        TextView priceNum = (TextView) findViewById(R.id.quantity_text_view);
        priceNum.setText("" + Quantity);

        TextView priceText = (TextView) findViewById(R.id.price_text_view);
        priceText.setText("₹ "+price);
    }


    public int calculatePrice(int Quantity,int pricePerCoffee){
        price=Quantity*pricePerCoffee;
        return price;
    }


    public String createOrderSummary(){

        int price=calculatePrice(Quantity,10);
        String name = "Anushka";

        CheckBox WhippedCream = findViewById(R.id.checkbox_whipped_cream);
        boolean CheckBoxWhippedCream = WhippedCream.isChecked();

        Log.v("CheckBox Activity:","Whipped Cream is"+CheckBoxWhippedCream);

        String message="Name: "+name+
                "\nQuantity: "+Quantity+
                "\nAdd Whipped Cream?"+CheckBoxWhippedCream+
                "\nTotal: "+price+"\n";
        return message;
    }

    public void displayOrder(View view) {
        TextView messageText = (TextView) findViewById(R.id.message);
        if (Quantity > 0) {
            messageText.setText(createOrderSummary()+"Thank you!");
        } else {
            messageText.setText("No order has been placed");
        }
    }


}


