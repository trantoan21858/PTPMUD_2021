package org.at15.mystories.data;

import org.at15.mystories.data.repository.categories.CategoryRepository;
import org.at15.mystories.data.repository.categories.CategoryRepositoryImplForTest;
import org.at15.mystories.data.repository.novels.NovelsRepository;
import org.at15.mystories.data.repository.novels.NovelsRepositoryImpl;
import org.at15.mystories.data.repository.novels.NovelsRepositoryImplForTest;

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

    public NovelsRepository getNovelsRepository() {
        return NovelsRepositoryImplForTest.getInstane();
    }
}
