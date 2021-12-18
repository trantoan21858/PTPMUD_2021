package org.at15.mystories.ui.novel_detail;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import org.at15.mystories.data.repository.novels.NovelsRepository;

public class NovelDetailViewModelFactory implements ViewModelProvider.Factory{

    private final NovelsRepository mRepository;

    public NovelDetailViewModelFactory(NovelsRepository repository) {
        this.mRepository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
        if(aClass.isAssignableFrom(NovelDetailViewModel.class))
            return (T) new NovelDetailViewModel(mRepository);
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
