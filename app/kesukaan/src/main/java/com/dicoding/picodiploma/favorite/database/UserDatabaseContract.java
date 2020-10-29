package com.dicoding.picodiploma.favorite.database;

import android.net.Uri;
import android.provider.BaseColumns;


public class UserDatabaseContract {
    public static final String AUTHORITY = "com.dicoding.picodiploma.favorite";
    public static final String SCHEME = "content";
    public static final class DataColumns implements BaseColumns{
        public static final String TABLE_USER = "user";
        public static final String LOGIN = "login";
        public static final String AVATAR = "avatar_url";

        public static final Uri CONTENT_URI = new Uri.Builder().scheme(SCHEME)
                .authority(AUTHORITY)
                .appendPath(TABLE_USER)
                .build();
    }
}