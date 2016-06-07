package ec.edu.com.epn.konwarriosapp.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by CHUCHO on 6/6/2016.
 */
public class KonWarriorsAppHelper extends SQLiteOpenHelper {

    public static final int version = 1;
    private static final String base_datos = "konWarriorControl.db";

    public KonWarriorsAppHelper(Context context) {
        super(context, base_datos, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(KonWarriorsAppContract.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if (newVersion > oldVersion) {
            db.execSQL(KonWarriorsAppContract.SQL_DELETE_ENTRIES);
            db.execSQL(KonWarriorsAppContract.SQL_CREATE_ENTRIES);
        }

    }
}

