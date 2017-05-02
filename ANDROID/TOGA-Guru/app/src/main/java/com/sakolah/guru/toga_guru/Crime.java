package com.sakolah.guru.criminalintent;

import java.util.UUID;

/**
 * Created by Ilham Zakky on 3/29/2017.
 */

public class Crime {
    private UUID mId;
    private String mTitle;
    public Crime() {
        mId = UUID.randomUUID();
    }
    public UUID getId() {
        return mId;
    }
    public String getTitle() {
        return mTitle;
    }
    public void setTitle(String title) {
        mTitle = title;
    }
}
