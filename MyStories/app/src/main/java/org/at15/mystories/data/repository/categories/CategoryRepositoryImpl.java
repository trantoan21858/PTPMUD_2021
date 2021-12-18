package org.at15.mystories.data.repository.categories;

public class CategoryRepositoryImpl implements CategoryRepository{

    private static CategoryRepositoryImpl sSingleton;

    public static CategoryRepositoryImpl getInstane() {
        if(sSingleton == null)
            sSingleton = new CategoryRepositoryImpl();
        return sSingleton;
    }

    private CategoryRepositoryImpl() {

    }

    @Override
    public void getCategories(LoadCategoryCallback callback) {
        CategoryRemoteDataSource.getInstane().getCategories(callback);
    }
}
