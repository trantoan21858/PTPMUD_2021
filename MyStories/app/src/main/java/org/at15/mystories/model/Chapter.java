package org.at15.mystories.model;

public class Chapter {

    private String mId;
    private int mIndex;
    private String mTitle;

    public int getIndex() {
        return mIndex;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getContent() {
        return "mContent";
    }

    public Chapter(String id, int index, String title) {
        this.mId = id;
        this.mIndex = index;
        this.mTitle = title;
    }
}
