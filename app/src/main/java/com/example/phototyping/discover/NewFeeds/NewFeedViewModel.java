package com.example.phototyping.discover.NewFeeds;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.phototyping.R;

import java.util.ArrayList;
import java.util.List;

public class NewFeedViewModel extends ViewModel {
    private MutableLiveData<List<NewFeed>> mutableLiveData;

    public NewFeedViewModel() {
        mutableLiveData = new MutableLiveData<>();
        List<NewFeed> newFeeds = new ArrayList<>();
        newFeeds.add(new NewFeed(R.drawable.image_new_feed_1, R.drawable.avt_1, "Ridhwan Nordin", "ridzjcob"));
        newFeeds.add(new NewFeed(R.drawable.image_new_feed_2, R.drawable.avt_2, "Clem Onojeghuo", "clemono2"));
        newFeeds.add(new NewFeed(R.drawable.image_new_feed_3, R.drawable.avt_3, "Jon Tyson", "jontyson"));
        newFeeds.add(new NewFeed(R.drawable.image_new_feed_4, R.drawable.avt_4, "Simon Zhu", "smnzhu"));
        mutableLiveData.setValue(newFeeds);
    }

    public LiveData<List<NewFeed>> getNewFeedsLiveData() {
        return mutableLiveData;
    }
}
