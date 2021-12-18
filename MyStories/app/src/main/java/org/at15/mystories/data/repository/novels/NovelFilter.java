package org.at15.mystories.data.repository.novels;

public class NovelFilter {
    private String mCategoryId = "";
    private String mAuthorId = "";
    private String mOrderBy = "";
    private int mMinChapter = 0;
    private int mMaxChapter = 1000000;

    static NovelFilter noFilter() {
        return new NovelFilter();
    }

    public NovelFilter() {

    }

    public NovelFilter(
            String categoryId,
            String authorId,
            String orderBy,
            int maxChapter,
            int minChapter
    ) {
        this.mCategoryId = categoryId;
        this.mAuthorId = authorId;
        this.mOrderBy = orderBy;
        this.mMaxChapter = maxChapter;
        this.mMinChapter = minChapter;
    }

    public String getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(String categoryId) {
        this.mCategoryId = categoryId;
    }

    public String getAuthorId() {
        return mAuthorId;
    }

    public void setAuthorId(String authorId) {
        this.mAuthorId = authorId;
    }

    public String getOrderBy() {
        return mOrderBy;
    }

    public void setOrderBy(String orderBy) {
        this.mOrderBy = orderBy;
    }

    public int getMinChapter() {
        return mMinChapter;
    }

    public void setMinChapter(int minChapter) {
        this.mMinChapter = minChapter;
    }

    public int getMaxChapter() {
        return mMaxChapter;
    }

    public void setMaxChapter(int maxChapter) {
        this.mMaxChapter = maxChapter;
    }
}
