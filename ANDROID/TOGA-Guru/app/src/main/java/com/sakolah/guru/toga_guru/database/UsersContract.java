package com.sakolah.guru.toga_guru.database;

import android.provider.BaseColumns;

public class UsersContract {

    public static final class WaitlistEntry implements BaseColumns {
        public static final String TABLE_NAME = "users";
        public static final String ID_PROFILE= "id_profile";
        public static final String NOMOR_INDUK = "nomor_induk";
        public static final String EMAIL = "email";
        public static final String NAME= "name";
        public static final String GENDER= "gender";
        public static final String SCHOOL= "school";
        public static final String BADGES= "badges";
        public static final String IMAGE= "image";
    }

}
