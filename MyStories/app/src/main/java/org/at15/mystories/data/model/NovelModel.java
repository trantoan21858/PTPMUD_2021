package org.at15.mystories.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NovelModel {
    @Expose
    @SerializedName("id")
    private String mId;

    @Expose
    @SerializedName("name")
    private String mName;

    @Expose
    @SerializedName("introduction")
    private String mIntroduction;

    @Expose
    @SerializedName("image_url")
    private String mImageUrl;

    private Author mAuthor;
    private boolean mIsFavorite;
    private boolean mIsInLib;
    private boolean mIsReading;

    private ArrayList<CategoryModel> mCategories = new ArrayList<>();

    public NovelModel(String mId, String mName, String mImageUrl) {
        this.mId = mId;
        this.mName = mName;
        this.mImageUrl = mImageUrl;
    }

    public NovelModel(String mId, String mName, String mImageUrl, ArrayList<CategoryModel> categories) {
        this.mId = mId;
        this.mName = mName;
        this.mImageUrl = mImageUrl;
        this.mCategories = categories;
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
