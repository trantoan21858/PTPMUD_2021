package org.at15.mystories.data.model;

public class CategoryModel {

    private String mTitle;
    private String mDescription;
    private String mImageUrl;

    public CategoryModel(String title, String description, String imageUrl) {
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
}
