package com.example.phototyping.discover.NewFeeds;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phototyping.R;

import java.util.List;

public class NewFeedAdapter extends RecyclerView.Adapter<NewFeedAdapter.NewFeedViewHolder> {

    private List<NewFeed> newFeeds;
    private ItemClickListener itemClickListener;

    public NewFeedAdapter(List<NewFeed> newFeeds) {
        this.newFeeds = newFeeds;
    }

    @NonNull
    @Override
    public NewFeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_new_feed, parent,false);
        return new NewFeedViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull NewFeedViewHolder holder, int position) {
        NewFeed newFeed = newFeeds.get(position);
        holder.ivNewFeed.setImageResource(newFeed.getImage());
        holder.ivAvt.setImageResource(newFeed.getAvt());
        holder.tvName.setText(newFeed.getName());
        holder.tvEmail.setText("@"+newFeed.getEmail());
    }

    @Override
    public int getItemCount() {
        if(newFeeds != null) {
            return newFeeds.size();
        }
        return 0;
    }

    public class NewFeedViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivNewFeed, ivAvt;
        private TextView tvName, tvEmail;
        public NewFeedViewHolder(@NonNull View itemView) {
            super(itemView);

            ivNewFeed = itemView.findViewById(R.id.iv_new_feed);
            ivAvt = itemView.findViewById(R.id.iv_avt);
            tvName = itemView.findViewById(R.id.tv_name);
            tvEmail= itemView.findViewById(R.id.tv_email);
        }
    }

    public interface ItemClickListener {
        void getDataItemClick(NewFeed newFeed);
    }
}
