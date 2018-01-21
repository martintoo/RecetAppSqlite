package martinto.digital.escuela.notepad.com.recetappsqlite;

/**
 * Created by martinto on 16/01/18.
 */

public class SQLConstants {
    //DB
    public static final String DB="bdrecetas.db";
    //TABLES
    public static final String TABLE_RECETAS="recetas";
    //COLUMNS
    public static final String COLUMN_ID="id";
    public static final String COLUMN_NOMBRE="nombre";
    public static final String COLUMN_PERSONAS="personas";
    public static final String COLUMN_DESCRIPCION="descripcion";
    public static final String COLUMN_PREPARACION="preparacion";
    public static final String COLUMN_IMAGEN="imagen";
    public static final String COLUMN_FAV="fav";
    //QUERYS
    public static final String SQL_CREATE_TABLE_RECETAS=
            "CREATE TABLE " + TABLE_RECETAS + "(" +
                    COLUMN_ID + " TEXT PRIMARY KEY," +
                    COLUMN_NOMBRE + " TEXT,"+
                    COLUMN_PERSONAS + " INT,"+
                    COLUMN_DESCRIPCION + " TEXT,"+
                    COLUMN_PREPARACION + " TEXT,"+
                    COLUMN_IMAGEN + " TEXT,"+
                    COLUMN_FAV+ " INT"+");";

    public static final String WHERE_CLAUSE_NOMBRE="nombre=?";

    public static final String SQL_DELETE=
            "DROP TABLE "+ TABLE_RECETAS;

    public static final String[] ALL_COLUMNS={
                COLUMN_ID,COLUMN_NOMBRE,COLUMN_PERSONAS,COLUMN_DESCRIPCION,COLUMN_PREPARACION,
                COLUMN_IMAGEN,COLUMN_FAV
    };

    public static final String WHERE_CLAUSES_FAV="fav=?";
    public static final String WHERE_CLAUSES_PERSONAS="personas=?";

}
