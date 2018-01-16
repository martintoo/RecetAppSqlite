package martinto.digital.escuela.notepad.com.recetappsqlite.Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by martinto on 16/01/18.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final int DB_VERSION=1;

    //1 Crear archivo de constantes

    public DBHelper(Context context){
        //CursorFactory null
        //Version->
        super(context,SQLConstants.DB,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
