package org.at15.mystories.data.remote;

import org.at15.mystories.data.model.CategoryModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NovelApi {

    @GET("categories")
    Call<List<CategoryModel>> getCategories();
}
