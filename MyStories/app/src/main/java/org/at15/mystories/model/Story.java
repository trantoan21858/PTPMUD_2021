package org.at15.mystories.model;

import java.util.ArrayList;

public class Story {
    private String mId;
    private String mName;
    private String mIntroduction;
    private String mImageUrl;
    private ArrayList<Chapter> mChapters;
    private Author mAuthor;
    private boolean mIsFavorite;
    private boolean mIsInLib;
    private boolean mIsReading;
}
