package com.example.barangaycomplaints;

import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barangaycomplaints.databinding.LayoutItemBinding;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private List<Complaint> complaintList;

    private OnClickListener onClickListener;

    public ItemAdapter(List<Complaint> complaintList) {
        this.complaintList = complaintList;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutItemBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ItemViewHolder holder, int position) {
        Complaint complaint = complaintList.get(position);
        holder.binding.tvSubject.setText(complaint.getSubject());
        holder.binding.tvUsername.setText(complaint.getUser().getUsername());

    }

    @Override
    public int  getItemCount() {
        return complaintList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        private final LayoutItemBinding binding;
        public ItemViewHolder(LayoutItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
