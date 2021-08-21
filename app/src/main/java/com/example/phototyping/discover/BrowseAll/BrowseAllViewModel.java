package com.example.phototyping.discover.BrowseAll;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.phototyping.R;
import com.example.phototyping.discover.NewFeeds.NewFeed;

import java.util.ArrayList;
import java.util.List;

public class BrowseAllViewModel extends ViewModel {
    private MutableLiveData<List<BrowseAll>> mutableLiveData;

    public BrowseAllViewModel() {
        mutableLiveData = new MutableLiveData<>();
        List<BrowseAll> browseAlls = new ArrayList<>();
        browseAlls.add(new BrowseAll(R.drawable.browse_1));
        browseAlls.add(new BrowseAll(R.drawable.browse_2));
        browseAlls.add(new BrowseAll(R.drawable.browse_3));
        browseAlls.add(new BrowseAll(R.drawable.browse_4));
        browseAlls.add(new BrowseAll(R.drawable.browse_5));
        browseAlls.add(new BrowseAll(R.drawable.browse_6));
        browseAlls.add(new BrowseAll(R.drawable.browse_7));
        browseAlls.add(new BrowseAll(R.drawable.browse_8));
        browseAlls.add(new BrowseAll(R.drawable.browse_9));
        browseAlls.add(new BrowseAll(R.drawable.browse_10));
        mutableLiveData.setValue(browseAlls);
    }

    public LiveData<List<BrowseAll>> getBrowseAllsLiveData() {
        return mutableLiveData;
    }
}
