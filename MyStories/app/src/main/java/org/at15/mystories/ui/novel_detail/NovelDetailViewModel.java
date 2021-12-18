package org.at15.mystories.ui.novel_detail;

import androidx.lifecycle.ViewModel;

import org.at15.mystories.data.repository.novels.NovelsRepository;

public class NovelDetailViewModel extends ViewModel {

    private final NovelsRepository mRepository;
    public  NovelDetailViewModel(NovelsRepository repository) {
        this.mRepository = repository;
    }
}