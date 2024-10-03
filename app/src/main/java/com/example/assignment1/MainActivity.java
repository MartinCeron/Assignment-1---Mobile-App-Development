package com.example.assignment1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText mortAmountInput, intRateInput, repaymentTimeInput;
    Button calculateBtn;
    TextView emiResult;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mortAmountInput = findViewById(R.id.mortAmount);
        intRateInput = findViewById(R.id.intRate);
        repaymentTimeInput = findViewById(R.id.repaymentTime);
        calculateBtn = findViewById(R.id.calcBtn);
        emiResult = findViewById(R.id.calcResult);

        // OnClickListener for the button
        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Getting user inputs
                double mortgageAmount = Double.parseDouble(mortAmountInput.getText().toString());
                double interestRate = Double.parseDouble(intRateInput.getText().toString());
                int repaymentPeriod = Integer.parseInt(repaymentTimeInput.getText().toString());

                // Calculate EMI
                double emi = calculateEMI(mortgageAmount, interestRate, repaymentPeriod);

                // Displaying the result in the TextView
                emiResult.setText(String.format("Monthly Payment: $%.2f", emi));
            }
        });
    }

    // Method to calculate EMI
    public double calculateEMI(double principalAmount, double interestRate, int repaymentMonths) {
        // EMI formula
        return (principalAmount * interestRate * Math.pow(1 + interestRate, repaymentMonths)) /
                (Math.pow(1 + interestRate, repaymentMonths) - 1);
    }
}