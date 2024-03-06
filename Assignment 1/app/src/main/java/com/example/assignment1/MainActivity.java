package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button add, sub, mul, div, mod, per, pow, clear;
    EditText input1, input2;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        output = findViewById(R.id.output);
        add = findViewById(R.id.buttonAdd);
        sub = findViewById(R.id.buttonSub);
        mul = findViewById(R.id.buttonMul);
        div = findViewById(R.id.buttonDiv);
        mod = findViewById(R.id.buttonMod);
        per = findViewById(R.id.buttonPer);
        pow = findViewById(R.id.buttonPow);
        clear = findViewById(R.id.buttonClear);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = input1.getText().toString();
                String s2 = input2.getText().toString();
                try {
                    double a = Double.parseDouble(s1);
                    double b = Double.parseDouble(s2);
                    double sum = a + b;
                    output.setText(String.valueOf(sum)); // Convert sum to String
                }
                catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                }
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = input1.getText().toString();
                String s2 = input2.getText().toString();
                try {
                    double a = Double.parseDouble(s1);
                    double b = Double.parseDouble(s2);
                    double outcome = a - b;
                    output.setText(String.valueOf(outcome));
                }
                catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = input1.getText().toString();
                String s2 = input2.getText().toString();
                try {
                    double a = Double.parseDouble(s1);
                    double b = Double.parseDouble(s2);
                    double product = a * b;
                    output.setText(String.valueOf(product));
                }
                catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                }
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = input1.getText().toString();
                String s2 = input2.getText().toString();

                try {
                    double a = Double.parseDouble(s1);
                    double b = Double.parseDouble(s2);
                    if (b == 0) {
                        Toast.makeText(MainActivity.this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    } else {
                        double result = a / b;
                        output.setText(String.valueOf(result));
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = input1.getText().toString();
                String s2 = input2.getText().toString();
                try {
                    double a = Double.parseDouble(s1);
                    double b = Double.parseDouble(s2);
                    double outcome = a % b;
                    output.setText(String.valueOf(outcome));
                }
                catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                }
            }
        });

        per.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = input1.getText().toString();
                String s2 = input2.getText().toString();
                try {
                    double a = Double.parseDouble(s1);
                    double b = Double.parseDouble(s2);
                    double outcome = (a / b) * 100;
                    output.setText(String.valueOf(outcome));
                }
                catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                }
            }
        });

        pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = input1.getText().toString();
                String s2 = input2.getText().toString();
                try {
                    double a = Double.parseDouble(s1);
                    double b = Double.parseDouble(s2);
                    double sum = Math.pow(a, b);
                    output.setText(String.valueOf(sum));
                }
                catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input1.setText("");
                input2.setText("");
                output.setText("");
            }
        });

    }
}