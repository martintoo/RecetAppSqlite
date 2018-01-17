package martinto.digital.escuela.notepad.com.recetappsqlite.Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import martinto.digital.escuela.notepad.com.recetappsqlite.SQLConstants;

/**
 * Created by martinto on 16/01/18.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final int DB_VERSION=1;

    //1 Crear archivo de constantes

    public DBHelper(Context context){
        //CursorFactory null
        //Version->
        super(context, SQLConstants.DB,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLConstants.SQL_CREATE_TABLE_RECETAS);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQLConstants.SQL_DELETE);
        onCreate(db);
    }
}
