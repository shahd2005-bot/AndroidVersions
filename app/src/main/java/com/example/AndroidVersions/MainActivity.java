package com.example.AndroidVersions;

import com.example.AndroidVersions.databinding.ActivityMainBinding;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;


    private VersionAdapter adapter;
    private List<AndroidVersion> versionList;

    private boolean isSortedAlpha = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupList();
        setupRecyclerView();
        setupSortButton();
    }

    private void setupList() {
        versionList = new ArrayList<>();
        versionList.add(new AndroidVersion(R.drawable.donut, "Donut", "1.6"));
        versionList.add(new AndroidVersion(R.drawable.eclair, "Éclair", "2.0-2.1"));
        versionList.add(new AndroidVersion(R.drawable.froyo, "Froyo", "2.2-2.2.3"));
        versionList.add(new AndroidVersion(R.drawable.gingerbread, "Gingerbread", "2.3-2.3.7"));
        versionList.add(new AndroidVersion(R.drawable.honeycomb, "Honeycomb", "3.0-3.2.6"));
        versionList.add(new AndroidVersion(R.drawable.icecreamsandwich, "Ice Cream Sandwich", "4.0-4.0.4"));
        versionList.add(new AndroidVersion(R.drawable.jellybean, "Jelly Bean", "4.1-4.3.1"));
        versionList.add(new AndroidVersion(R.drawable.kitkat, "KitKat", "4.4-4.4.4"));
        versionList.add(new AndroidVersion(R.drawable.lollipop, "Lollipop", "5.0-5.1.1"));
        versionList.add(new AndroidVersion(R.drawable.marshmallow, "Marshmallow", "6.0-6.0.1"));
        versionList.add(new AndroidVersion(R.drawable.nougat, "Nougat", "7.0-7.1.2"));
        versionList.add(new AndroidVersion(R.drawable.oreo, "Oreo", "8.0-8.1"));
    }
    private void setupRecyclerView() {
        adapter = new VersionAdapter(versionList);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
    }

    private void setupSortButton() {
        binding.btnSort.setOnClickListener(v -> {
            if (isSortedAlpha) {
                versionList.sort((a, b) -> b.version.compareTo(a.version));
                binding.btnSort.setText("Sort A-Z");
            } else {
                versionList.sort((a, b) -> a.codeName.compareTo(b.codeName));
                binding.btnSort.setText("Sort by Version");
            }
            isSortedAlpha = !isSortedAlpha;
            adapter.notifyDataSetChanged();
        });
    }
}