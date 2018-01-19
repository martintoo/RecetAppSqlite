package martinto.digital.escuela.notepad.com.recetappsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import martinto.digital.escuela.notepad.com.recetappsqlite.Helpers.DBHelper;
import martinto.digital.escuela.notepad.com.recetappsqlite.POJOS.Receta;

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

    public void insertReceta(Receta receta){
        ContentValues contentValues=receta.toValues();
        sqLiteDatabase.insert(SQLConstants.TABLE_RECETAS,null,contentValues);
    }

    public long getItemsCount(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase,SQLConstants.TABLE_RECETAS);
    }

    public void insertarRecetas(List<Receta> listaRecetas){
        long items=getItemsCount();
        if(items==0){
            for(Receta receta:listaRecetas){
                try {
                    insertReceta(receta);
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public List<Receta> getAll(){
        List<Receta> recetas=new ArrayList<>();
        //consulta
        Cursor cursor=sqLiteDatabase.query(SQLConstants.TABLE_RECETAS,SQLConstants.ALL_COLUMNS,
                null,null,null,null,null);
        while (cursor.moveToNext()){
            Receta receta=new Receta();
            receta.setId(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_ID)));
            receta.setNombre(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_NOMBRE)));
            receta.setPersonas(cursor.getInt(cursor.getColumnIndex(SQLConstants.COLUMN_PERSONAS)));
            receta.setDescripcion(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_DESCRIPCION)));
            receta.setPreparacion(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_PREPARACION)));
            receta.setImage(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_IMAGEN)));
            receta.setFav(cursor.getInt(cursor.getColumnIndex(SQLConstants.COLUMN_FAV)));
            recetas.add(receta);
        }
        return recetas;
    }

    public void deleteItem(String nombre){
        String[] whereArgs=new String[]{String.valueOf(nombre)};
        sqLiteDatabase.delete(SQLConstants.TABLE_RECETAS,SQLConstants.WHERE_CLAUSE_NOMBRE,whereArgs);

    }
}
