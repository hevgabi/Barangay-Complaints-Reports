package com.example.barangaycomplaints;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barangaycomplaints.databinding.LayoutItemBinding;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private List<Complaint> complaintList;
    private OnClickListener onClickListener;
    private OnEditClickListener onEditClickListener;

    public ItemAdapter(List<Complaint> complaintList) {
        this.complaintList = complaintList;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void setOnEditClickListener(OnEditClickListener onEditClickListener) {
        this.onEditClickListener = onEditClickListener;
    }

    public interface OnClickListener {
        void OnClick(int position);
    }

    public interface OnEditClickListener {
        void OnEditClick(int position);
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ItemViewHolder holder, int position) {
        Complaint complaint = complaintList.get(position);
        holder.binding.tvSubject.setText(complaint.getSubject());
        holder.binding.tvUsername.setText(String.valueOf(complaint.getUserId()));
        holder.binding.tvComplId.setText("ID: " + complaint.getComplaintId());
        
        holder.binding.mbView.setOnClickListener(v -> {
            if (onClickListener != null) {
                onClickListener.OnClick(position);
            }
        });

        holder.binding.mbEdit.setOnClickListener(v -> {
            if (onEditClickListener != null) {
                onEditClickListener.OnEditClick(position);
            }
        });

        if (complaint.isResolved()) {
            holder.binding.textView.setText("Resolved");
        } else {
            holder.binding.textView.setText("Pending");
        }
    }

    @Override
    public int getItemCount() {
        return complaintList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        final LayoutItemBinding binding;
        public ItemViewHolder(LayoutItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}