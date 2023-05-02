package com.example.monross;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {
    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        mBtn = (Button) findViewById(R.id.btnMakePayment);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PaymentActivity.this, "Please wait as you,re being re-directed to paypal.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PaymentActivity.this,MakePaymentActivity.class));

            }
        });

    }
}