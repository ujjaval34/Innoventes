package com.ujjaval.innoventes_task.data;

import android.provider.BaseColumns;

/**
 * Bookmark contract.
 * This class is used to define how the favorites table in the SQL local storage will look like.
 */
public class BookmarkContract {

    /**
     * The properties of the favorites table defined.
     */
    public static final class BookmarkEntry implements BaseColumns {
        public static final String TABLE_NAME = "bookmark";
        public static final String COLUMN_MOVIE_ID = "movieId";
        public static final String COLUMN_POSTER_PATH = "posterPath";
        public static final String COLUMN_TIMESTAMP = "timestamp";
    }

}
