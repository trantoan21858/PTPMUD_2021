package org.at15.mystories.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NovelService {

    private static final String URL = "http://192.168.85.106/";

    private final NovelApi mApi;

    private static NovelService sSingleton;

    private NovelService() {
        Retrofit mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URL)
                .build();

        mApi = mRetrofit.create(NovelApi.class);
    }

    public static NovelService getInstance() {
        if (sSingleton == null) {
            synchronized (NovelService.class) {
                if (sSingleton == null) {
                    sSingleton = new NovelService();
                }
            }
        }
        return sSingleton;
    }

    public NovelApi getApi() {
        return mApi;
    }

}
