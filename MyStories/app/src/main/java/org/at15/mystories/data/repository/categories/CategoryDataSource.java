package org.at15.mystories.data.repository.categories;

public interface CategoryDataSource {
    void getCategories(CategoryRepository.LoadCategoryCallback callback);
}
