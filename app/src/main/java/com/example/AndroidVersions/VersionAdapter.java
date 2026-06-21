package com.example.AndroidVersions;
import com.example.AndroidVersions.databinding.
ItemAndroidVersionBinding;
import com.google.android.material.snackbar.Snackbar;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


public class VersionAdapter extends RecyclerView.Adapter<VersionAdapter.VersionViewHolder> {

    private List<AndroidVersion> versionList;

    public VersionAdapter(List<AndroidVersion> versionList) {

        this.versionList = versionList;

    }

    @NonNull
    @Override
    public VersionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        
ItemAndroidVersionBinding binding = 
ItemAndroidVersionBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new VersionViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull VersionViewHolder holder, int position) {
        AndroidVersion currentVersion = versionList.get(position);

        holder.binding.txtCodeName.setText(currentVersion.codeName);
        holder.binding.txtVersion.setText(currentVersion.version);
        holder.binding.imgLogo.setImageResource(currentVersion.imageResId);

        if (position % 2 == 0) {
            holder.binding.cardView.setBackgroundColor(Color.parseColor("#F5F5F5"));
        } else {
            holder.binding.cardView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }

        holder.binding.getRoot().setOnClickListener(v -> {
            String message = "You selected: " + currentVersion.codeName + " (" + currentVersion.version + ")";
            Snackbar.make(v, message, Snackbar.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return versionList.size();
    }

    public static class VersionViewHolder extends RecyclerView.ViewHolder {
        
ItemAndroidVersionBinding binding;
        public VersionViewHolder (
ItemAndroidVersionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}