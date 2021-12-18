package org.at15.mystories.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryModel {

    @Expose
    @SerializedName("id")
    private String mId;

    @Expose
    @SerializedName("name")
    private String mTitle;

    @Expose
    @SerializedName("description")
    private String mDescription;

    @Expose
    @SerializedName("image_url")
    private String mImageUrl;

    public CategoryModel(String id, String title, String description, String imageUrl) {
        this.mId = id;
        this.mTitle = title;
        this.mDescription = description;
        this.mImageUrl = imageUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getId() {
        return mId;
    }
}
