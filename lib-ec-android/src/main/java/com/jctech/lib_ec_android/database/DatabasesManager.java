package com.jctech.lib_ec_android.database;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

/**
 * Created by CHENQIAO on 2017/12/18.
 */

public class DatabasesManager {

    private DaoSession mDaoSession = null;
    private UserProfileDao mDao = null;

    private DatabasesManager() {
    }

    public DatabasesManager init(Context context) {
        initDao(context);
        return this;
    }

    private static final class Holder {
        private static final DatabasesManager INSTANCE = new DatabasesManager();
    }

    public static DatabasesManager getInstance() {
        return Holder.INSTANCE;
    }

    private void initDao(Context context) {
        final ReleaseOpenHelper helper = new ReleaseOpenHelper(context, "fast_ec.db");
        final Database db = helper.getWritableDb();
        mDaoSession = new DaoMaster(db).newSession();
        mDao = mDaoSession.getUserProfileDao();
    }

    public final UserProfileDao getDao() {
        return mDao;
    }
}
