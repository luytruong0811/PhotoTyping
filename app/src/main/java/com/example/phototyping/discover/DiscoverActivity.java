package com.example.phototyping.discover;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.phototyping.R;
import com.example.phototyping.discover.BrowseAll.BrowseAllAdapter;
import com.example.phototyping.discover.BrowseAll.BrowseAllViewModel;
import com.example.phototyping.discover.NewFeeds.NewFeedAdapter;
import com.example.phototyping.discover.NewFeeds.NewFeedViewModel;

public class DiscoverActivity extends AppCompatActivity {

    private RecyclerView rvNewFeeds, rvBrowseAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);

        rvNewFeeds = findViewById(R.id.rv_new_feed);
        setRecyclerViewNewFeed();
        rvBrowseAll = findViewById(R.id.rv_browse);
        setRecyclerViewBrowseAll();
    }

    private void setRecyclerViewBrowseAll() {
        rvBrowseAll.setHasFixedSize(true);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rvBrowseAll.setLayoutManager(gridLayoutManager);

        BrowseAllViewModel browseAllViewModel = new ViewModelProvider(this).get(BrowseAllViewModel.class);
        BrowseAllAdapter browseAllAdapter = new BrowseAllAdapter(browseAllViewModel.getBrowseAllsLiveData().getValue());

        browseAllViewModel.getBrowseAllsLiveData().observe(this, browseAlls -> {
            browseAllAdapter.notifyDataSetChanged();
        });

        rvBrowseAll.setAdapter(browseAllAdapter);
    }

    private void setRecyclerViewNewFeed() {
        rvNewFeeds.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvNewFeeds.setLayoutManager(linearLayoutManager);

        NewFeedViewModel newFeedViewModel = new ViewModelProvider(this).get(NewFeedViewModel.class);
        NewFeedAdapter newFeedAdapter = new NewFeedAdapter(newFeedViewModel.getNewFeedsLiveData().getValue());

        newFeedViewModel.getNewFeedsLiveData().observe(this, newFeeds -> {
            newFeedAdapter.notifyDataSetChanged();
        });

        rvNewFeeds.setAdapter(newFeedAdapter);
    }
}