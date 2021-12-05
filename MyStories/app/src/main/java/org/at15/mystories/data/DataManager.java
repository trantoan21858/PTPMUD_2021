package org.at15.mystories.data;

import org.at15.mystories.data.repository.categories.CategoryRepository;
import org.at15.mystories.data.repository.categories.CategoryRepositoryImplForTest;

public class DataManager {

    private static DataManager sSingleton;

    private DataManager() {

    }

    public static DataManager get() {
        if (sSingleton == null)
            sSingleton = new DataManager();
        return sSingleton;
    }

    public CategoryRepository getCategoryRepository() {
        return CategoryRepositoryImplForTest.getInstane();
    }
}
