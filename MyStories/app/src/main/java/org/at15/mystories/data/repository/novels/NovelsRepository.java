package org.at15.mystories.data.repository.novels;

import org.at15.mystories.data.model.NovelModel;
import org.at15.mystories.data.repository.ErrorCallback;

import java.util.List;
import java.util.Map;

public interface NovelsRepository {

    //lấy danh sách truyện
    interface LoadNovelsCallback extends ErrorCallback {
        void onLoadSuccess(List<NovelModel> novels);
    }

    void getNovels(LoadNovelsCallback callback, NovelFilter filter);

    //Lấy danh sách ở trang chủ
    interface SuggestNovelHomepage extends ErrorCallback {
        void onLoadSuccess(Map<String, List<NovelModel>> suggest);
    }

    void getSuggestNovelsHomepage(SuggestNovelHomepage callback);

    //lấy thông tin chi tiết truyện
    interface LoadDetailCallback extends  ErrorCallback {
        void onLoadSucces(NovelModel detail);
    }

    void getNovelDetail(String novelId, LoadDetailCallback callback);
}
