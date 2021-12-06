package org.at15.mystories.data.repository.novels;

import org.at15.mystories.data.model.CategoryModel;
import org.at15.mystories.data.model.NovelModel;
import org.at15.mystories.data.repository.ErrorCallback;

import java.util.List;

public interface NovelsRepository {

    interface LoadNovelsCallback extends ErrorCallback {
        void onLoadSuccess(List<NovelModel> novels);
    }

    void getNovels(LoadNovelsCallback callback, NovelFilter filter);
}
