package com.example.simpleCalc;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.simpleCalc.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static ActivityMainBinding binding;

    double result = 0;
    String operation = "";
    int textColor = Color.BLACK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding =
                ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        if (savedInstanceState != null) {

            binding.num1.setText(
                    savedInstanceState.getString("num1"));

            binding.num2.setText(
                    savedInstanceState.getString("num2"));

            binding.txtResult.setText(
                    savedInstanceState.getString("result"));

            textColor =
                    savedInstanceState.getInt("color");

            binding.txtResult.setTextColor(
                    textColor);

            operation =
                    savedInstanceState.getString(
                            "operation");
        }

        binding.btnAdd.setOnClickListener(v ->
                        calculate("+"));

        binding.btnSub
                .setOnClickListener(v ->
                        calculate("-"));

        binding.btnMul
                .setOnClickListener(v ->
                        calculate("*"));

        binding.btnDiv
                .setOnClickListener(v ->
                        calculate("/"));

        binding.txtResult
                .setOnClickListener(v -> {

                    Intent intent =
                            new Intent(
                                    MainActivity.this,
                                    activity_result.class);

                    intent.putExtra(
                            "num1",
                            binding.num1.getText()
                                    .toString());

                    intent.putExtra(
                            "num2",
                            binding.num2.getText()
                                    .toString());

                    intent.putExtra(
                            "result",
                            binding.txtResult
                                    .getText()
                                    .toString());

                    intent.putExtra(
                            "operation",
                            operation);

                    startActivity(intent);
                });
    }

    private void calculate(String op) {

        String first =
                binding.num1.getText()
                        .toString();

        String second =
                binding.num2.getText()
                        .toString();

        if (first.isEmpty()
                || second.isEmpty()) {

            binding.txtResult
                    .setText(
                            "Enter Numbers");

            return;
        }

        double n1 =
                Double.parseDouble(first);

        double n2 =
                Double.parseDouble(second);

        switch (op) {

            case "+":
                result = n1 + n2;
                operation = "Addition";
                textColor = Color.GREEN;
                break;

            case "-":
                result = n1 - n2;
                operation = "Subtraction";
                textColor = Color.RED;
                break;

            case "*":
                result = n1 * n2;
                operation = "Multiplication";
                textColor = Color.YELLOW;
                break;

            case "/":
                result = n1 / n2;
                operation = "Division";
                textColor = Color.BLUE;
                break;
        }

        binding.txtResult.setText(
                String.valueOf(result));

        binding.txtResult
                .setTextColor(textColor);
    }

    @Override
    protected void onSaveInstanceState(
            Bundle outState) {

        super.onSaveInstanceState(
                outState);

        outState.putString(
                "num1",
                binding.num1.getText()
                        .toString());

        outState.putString(
                "num2",
                binding.num2.getText()
                        .toString());

        outState.putString(
                "result",
                binding.txtResult
                        .getText()
                        .toString());

        outState.putString(
                "operation",
                operation);

        outState.putInt(
                "color",
                textColor);
    }
}