package org.at15.mystories.ui.list_novels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import org.at15.mystories.data.repository.novels.NovelsRepository;

public class ListNovelViewModelFactory implements ViewModelProvider.Factory {

    private final NovelsRepository mRepository;

    public ListNovelViewModelFactory(NovelsRepository repository) {
        this.mRepository = repository;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
        if(aClass.isAssignableFrom(ListNovelViewModel.class))
            return (T) new ListNovelViewModel(mRepository);
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
