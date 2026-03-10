package com.example.barangaycomplaints;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.barangaycomplaints.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ItemAdapter itemAdapter;
    private List<Complaint> complaintList;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        complaintList = StoreComplaint.getInstance().getComplaintList();
        itemAdapter = new ItemAdapter(complaintList);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(itemAdapter);

        binding.fabAdd.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ComplaintActivity.class);
            startActivity(intent);
        });

        itemAdapter.setOnClickListener(position -> {
            // View mode
            Intent intent = new Intent(MainActivity.this, ComplaintActivity.class);
            intent.putExtra("POSITION", position);
            intent.putExtra("MODE", "VIEW");
            startActivity(intent);
        });

        itemAdapter.setOnEditClickListener(position -> {
            // Edit mode
            Intent intent = new Intent(MainActivity.this, ComplaintActivity.class);
            intent.putExtra("POSITION", position);
            intent.putExtra("MODE", "EDIT");
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        itemAdapter.notifyDataSetChanged();
    }
}