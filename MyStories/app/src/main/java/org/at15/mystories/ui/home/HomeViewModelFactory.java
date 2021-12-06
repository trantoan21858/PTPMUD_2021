package org.at15.mystories.ui.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import org.at15.mystories.data.repository.novels.NovelsRepository;

public class HomeViewModelFactory implements ViewModelProvider.Factory {
    private final NovelsRepository mRepository;

    public HomeViewModelFactory(NovelsRepository repository) {
        this.mRepository = repository;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
        if (aClass.isAssignableFrom(HomeViewModel.class))
            return (T) new HomeViewModel(mRepository);
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
