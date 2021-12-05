package org.at15.mystories.data.repository.categories;

import org.at15.mystories.data.model.CategoryModel;
import org.at15.mystories.data.repository.ErrorCallback;

import java.util.List;

public interface CategoryRepository {

    interface LoadCategoryCallback extends ErrorCallback {
        void onLoadSucces(List<CategoryModel> categories);
    }

    void getCategories(LoadCategoryCallback callback);
}
