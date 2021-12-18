package org.at15.mystories.data.repository.categories;

import org.at15.mystories.data.model.CategoryModel;
import org.at15.mystories.data.remote.NovelApi;
import org.at15.mystories.data.remote.NovelService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryRemoteDataSource implements CategoryDataSource {

    private final NovelApi mApi;

    private static CategoryRemoteDataSource sSingleton;

    public static CategoryRemoteDataSource getInstane() {
        if(sSingleton == null)
            sSingleton = new CategoryRemoteDataSource(NovelService.getInstance().getApi());
        return sSingleton;
    }

    private CategoryRemoteDataSource(NovelApi api) {
        this.mApi = api;
    }

    @Override
    public void getCategories(CategoryRepository.LoadCategoryCallback callback) {
        mApi.getCategories().enqueue(new Callback<List<CategoryModel>>() {
            @Override
            public void onResponse(Call<List<CategoryModel>> call, Response<List<CategoryModel>> response) {
                List<CategoryModel> categories = response.body() != null ? response.body() : null;
                if(categories != null && !categories.isEmpty()) {
                    callback.onLoadSucces(categories);
                } else {
                    callback.onLoadError();
                }
            }

            @Override
            public void onFailure(Call<List<CategoryModel>> call, Throwable t) {
                callback.onLoadError();
            }
        });
    }
}
