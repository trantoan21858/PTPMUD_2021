package org.at15.mystories.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.at15.mystories.data.model.NovelModel;
import org.at15.mystories.data.repository.novels.NovelFilter;
import org.at15.mystories.data.repository.novels.NovelsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HomeViewModel extends ViewModel implements NovelsRepository.SuggestNovelHomepage{

    public MutableLiveData<List<AllSugesstionAdapter.SuggesstionGroup>> getData() {
        return mData;
    }

    private final MutableLiveData<List<AllSugesstionAdapter.SuggesstionGroup>> mData
            = new MutableLiveData<List<AllSugesstionAdapter.SuggesstionGroup>>();

    private final NovelsRepository mRepository;

    public HomeViewModel(NovelsRepository repository) {
        this.mRepository = repository;
    }

    @Override
    public void onLoadError() {

    }

    public void loadSuggestions() {
        mRepository.getSuggestNovelsHomepage(this);
    }

    @Override
    public void onLoadSuccess(Map<String, List<NovelModel>> suggest) {
        List<AllSugesstionAdapter.SuggesstionGroup> data = new ArrayList<>();
        for(String key : suggest.keySet()) {
            data.add(new AllSugesstionAdapter.SuggesstionGroup(key, suggest.get(key)));
        }
        mData.postValue(data);
    }
}