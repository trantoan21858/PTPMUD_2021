package org.at15.mystories.ui.category;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.at15.mystories.data.model.CategoryModel;
import org.at15.mystories.data.repository.categories.CategoryRepository;

import java.util.List;

public class CategoryViewModel extends ViewModel implements CategoryRepository.LoadCategoryCallback {

    private final MutableLiveData<List<CategoryModel>> mListCategoryLiveData = new MutableLiveData<>();

    private final CategoryRepository mRepository;

    public CategoryViewModel(CategoryRepository repository) {
        this.mRepository = repository;
    }

    public void loadCategories() {
        mRepository.getCategories(this);
    }

    @Override
    public void onLoadError() {

    }

    @Override
    public void onLoadSucces(List<CategoryModel> categories) {
        mListCategoryLiveData.postValue(categories);
    }

    public MutableLiveData<List<CategoryModel>> getCategoryLiveData() {
        return mListCategoryLiveData;
    }
}