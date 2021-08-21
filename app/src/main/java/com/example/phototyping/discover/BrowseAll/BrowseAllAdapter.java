package com.example.phototyping.discover.BrowseAll;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phototyping.R;
import com.example.phototyping.discover.NewFeeds.NewFeedAdapter;

import java.util.List;

public class BrowseAllAdapter extends RecyclerView.Adapter<BrowseAllAdapter.BrowseAllViewHolder> {

    private List<BrowseAll> browseAlls;

    public BrowseAllAdapter(List<BrowseAll> browseAlls) {
        this.browseAlls = browseAlls;
    }

    @NonNull
    @Override
    public BrowseAllViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_browse, parent,false);
        return new BrowseAllViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrowseAllViewHolder holder, int position) {
        BrowseAll browseAll = browseAlls.get(position);
        holder.ivBrowse.setImageResource(browseAll.getImageBrowse());
    }

    @Override
    public int getItemCount() {
        if(browseAlls != null) {
            return browseAlls.size();
        }
        return 0;
    }

    public class BrowseAllViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivBrowse;
        public BrowseAllViewHolder(@NonNull View itemView) {
            super(itemView);
            ivBrowse = itemView.findViewById(R.id.iv_browse);
        }
    }
}
