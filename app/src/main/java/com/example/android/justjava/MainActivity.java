package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
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
        calculatePrice();
        displayDetails();
    }
    public void DecreaseQuantity_1(View view){
        Quantity--;
        if(Quantity<0)Quantity=0;
        calculatePrice();
        displayDetails();
    }

    public void displayDetails(){
        TextView priceNum = (TextView) findViewById(R.id.quantity_text_view);
        priceNum.setText("" + Quantity);

        TextView priceText = (TextView) findViewById(R.id.price_text_view);
        priceText.setText("₹ "+price);
    }

    public void calculatePrice(){
        price=Quantity*pricePerCoffee;
    }


    public String createOrderSummary(){
        EditText nameEditText = (EditText) findViewById(R.id.name);
        String name = nameEditText.getText().toString();

        int priceWhippedCreamPerCoffee=4;
        int QuantityWhippedCream=Quantity;

        int priceChocolatePerCoffee=7;
        int QuantityChocolate=Quantity;

        CheckBox WhippedCream = findViewById(R.id.checkbox_whipped_cream);
        boolean hasWhippedCream = WhippedCream.isChecked();
        if(hasWhippedCream){
            price+=(priceWhippedCreamPerCoffee*QuantityWhippedCream);
            displayDetails();
        }

        CheckBox Chocolate = findViewById(R.id.checkbox_chocolate);
        boolean hasChocolate = Chocolate.isChecked();
        if(hasChocolate){
            price+=(priceChocolatePerCoffee*QuantityChocolate);
            displayDetails();
        }


        String message="Name: "+name+
                "\nQuantity: "+Quantity+
                "\nAdd Whipped Cream?"+(hasWhippedCream?"Yes":"No")+
                "\nAdd Chocolate?"+(hasChocolate?"Yes":"No")+
                "\nTotal: ₹ "+price;
        return message;
    }

    public void displayOrder(View view) {
        TextView messageText = (TextView) findViewById(R.id.message);
        if (Quantity > 0) {
            messageText.setText(createOrderSummary()+"\nThank you!");
        } else {
            messageText.setText("No order has been placed");
        }
    }


}


