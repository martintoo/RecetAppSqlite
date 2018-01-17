package martinto.digital.escuela.notepad.com.recetappsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import martinto.digital.escuela.notepad.com.recetappsqlite.Helpers.DBHelper;

/**
 * Created by Martinto on 17/01/2018.
 */

public class Data {
    Context context;
    SQLiteDatabase sqLiteDatabase;
    SQLiteOpenHelper sqLiteOpenHelper;

    public Data(Context context) {
        this.context = context;
        //Definimos Base de Datos
        sqLiteOpenHelper=new DBHelper(context);
        //Como abrimos la BD, lectura o escritura
        sqLiteDatabase=sqLiteOpenHelper.getWritableDatabase();
    }

    public void open(){
        sqLiteDatabase=sqLiteOpenHelper.getWritableDatabase();
    }
    public void close(){
        sqLiteOpenHelper.close();
    }
}
