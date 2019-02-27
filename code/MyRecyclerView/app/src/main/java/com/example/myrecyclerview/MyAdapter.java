package com.example.myrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Class:       MyAdapter
 * Description: MyAdapter
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyItemViewHolder> {

    private List<String> monthsList;

    public MyAdapter(List<String> monthsList) {
        this.monthsList = monthsList;
    }

    @NonNull
    @Override
    public MyItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item, parent, false);

        return new MyItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyItemViewHolder holder, int position) {
        holder.monthNameTextView.setText(monthsList.get(position));
    }

    @Override
    public int getItemCount() {
        return monthsList.size();
    }

    /**
     * Add a month
     */
    void addMonth() {
        int lastIndex = monthsList.size();
        monthsList.add("+ Month "+ lastIndex);
        notifyItemInserted(lastIndex);
    }

    /**
     * Holder class to hold reference from row_item.xml
     */
    class MyItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView monthNameTextView;

        MyItemViewHolder(@NonNull View itemView) {
            super(itemView);
            monthNameTextView = itemView.findViewById(R.id.monthNameTextView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            int adapterPosition = getAdapterPosition();
            String word = monthsList.get(adapterPosition);
            monthsList.set(adapterPosition, "Clicked " + word);
            notifyDataSetChanged();
        }
    }
}
