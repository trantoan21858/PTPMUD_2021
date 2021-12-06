package org.at15.mystories.ui.list_novels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.at15.mystories.data.model.NovelModel;
import org.at15.mystories.data.repository.novels.NovelFilter;
import org.at15.mystories.data.repository.novels.NovelsRepository;

import java.util.List;

public class ListNovelViewModel extends ViewModel implements NovelsRepository.LoadNovelsCallback {

    private final MutableLiveData<List<NovelModel>> mListData
            = new MutableLiveData<List<NovelModel>>();

    private final NovelsRepository mRepository;

    public ListNovelViewModel(NovelsRepository repository) {
        this.mRepository = repository;
    }

    public void loadNovels(){
        mRepository.getNovels(this, new NovelFilter());
    }

    @Override
    public void onLoadError() {

    }

    @Override
    public void onLoadSuccess(List<NovelModel> novels) {
        mListData.postValue(novels);
    }

    public MutableLiveData<List<NovelModel>> getNovelListData() {
        return mListData;
    }
}