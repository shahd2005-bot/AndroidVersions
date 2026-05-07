package com.example.HelloToastEnhancement;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.HelloToastEnhancement.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    public static ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(mainBinding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mainBinding.showCount.setText("0");
        mainBinding.buttonZero.setBackgroundColor(
                ContextCompat.getColor(this, android.R.color.darker_gray)
        );
    }

    public void showToast(View view) {
        Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT).show();
    }


    public void showCount(View view) {
        count++;
        mainBinding.showCount.setText(String.valueOf(count));


        if (count % 2 == 0) {
            mainBinding.buttonCount.setBackgroundColor(
                    ContextCompat.getColor(this, android.R.color.holo_blue_light)
            );
        } else {
            mainBinding.buttonCount.setBackgroundColor(
                    ContextCompat.getColor(this, android.R.color.holo_green_light)
            );
        }


        mainBinding.buttonZero.setBackgroundColor(
                ContextCompat.getColor(this, android.R.color.holo_orange_light)
        );
    }


    public void showZero(View view) {
        count = 0;
        mainBinding.showCount.setText("0");


        mainBinding.buttonZero.setBackgroundColor(
                ContextCompat.getColor(this, android.R.color.darker_gray)
        );


        mainBinding.buttonCount.setBackgroundColor(
                ContextCompat.getColor(this, android.R.color.holo_green_light)
        );
    }
}