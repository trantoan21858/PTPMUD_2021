package org.at15.mystories.data.model;

public class NovelModel {
    private String mId;
    private String mName;
    private String mIntroduction;
    private String mImageUrl;
    private Author mAuthor;
    private boolean mIsFavorite;
    private boolean mIsInLib;
    private boolean mIsReading;

    public NovelModel(String mId, String mName, String mImageUrl) {
        this.mId = mId;
        this.mName = mName;
        this.mImageUrl = mImageUrl;
    }

    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getImageUrl() {
        return mImageUrl;
    }
}
