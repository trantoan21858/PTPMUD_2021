package org.at15.mystories.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.at15.mystories.data.model.NovelModel;
import org.at15.mystories.data.repository.novels.NovelFilter;
import org.at15.mystories.data.repository.novels.NovelsRepository;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel implements NovelsRepository.LoadNovelsCallback{

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

    @Override
    public void onLoadSuccess(List<NovelModel> novels) {
        List<AllSugesstionAdapter.SuggesstionGroup> data = new ArrayList<>();
        data.add(new AllSugesstionAdapter.SuggesstionGroup("Truyện mới", novels));
        data.add(new AllSugesstionAdapter.SuggesstionGroup("Truyện hot", novels));
        data.add(new AllSugesstionAdapter.SuggesstionGroup("Truyện full", novels));
        data.add(new AllSugesstionAdapter.SuggesstionGroup("Truyện mới cập nhật", novels));
        mData.postValue(data);
    }

    public void loadSuggestions() {
        mRepository.getNovels(this, new NovelFilter());
    }
}