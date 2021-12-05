package org.at15.mystories.ui.category;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import org.at15.mystories.data.repository.categories.CategoryRepository;

public class CategoryViewModelFactory implements ViewModelProvider.Factory {

    private CategoryRepository mRepository;

    public CategoryViewModelFactory(CategoryRepository repository) {
        this.mRepository = repository;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
        if(aClass.isAssignableFrom(CategoryViewModel.class))
            return (T) new CategoryViewModel(mRepository);
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
