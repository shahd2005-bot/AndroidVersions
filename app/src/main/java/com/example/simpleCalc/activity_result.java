package com.example.simpleCalc;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.simpleCalc.databinding.ActivityResultBinding;

public class activity_result extends AppCompatActivity {

    public static ActivityResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String num1 = getIntent().getStringExtra("num1");
        String num2 = getIntent().getStringExtra("num2");
        String result = getIntent().getStringExtra("result");
        String operation = getIntent().getStringExtra("operation");

        binding.resultInfo.setText(
                "First Number: " + num1 +
                        "\nSecond Number: " + num2 +
                        "\nOperation: " + operation +
                        "\nResult: " + result
        );
    }
}