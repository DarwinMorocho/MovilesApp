package ec.edu.com.epn.konwarriosapp.sqlite;

import android.provider.BaseColumns;

/**
 * Created by CHUCHO on 6/6/2016.
 */
public class KonWarriorsAppContract {

    public static abstract class TablaArtistas implements BaseColumns {

        public static final String NOMBRE_TABLA="ARTISTAS";
        public static final String COLUMNA_NOMBRE_ARTISTA="NOMBREARTISTA";
        public static final String COLUMNA_GENERO="GENERO";
        public static final String COLUMNA_CANCION="CANCION";
        public static final String COLUMNA_DESCRIPCION="DESCRIPCION";
    }

    public static final String TEXT_TYPE = " TEXT";
    public static final String INTEGER_TYPE=" INTEGER";
    public static final String COMMA_SEP=",";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " +
                    TablaArtistas.NOMBRE_TABLA +" (" +
                    TablaArtistas._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT "+ COMMA_SEP +
                    TablaArtistas.COLUMNA_NOMBRE_ARTISTA + TEXT_TYPE + COMMA_SEP +
                    TablaArtistas.COLUMNA_GENERO + TEXT_TYPE + COMMA_SEP +
                    TablaArtistas.COLUMNA_CANCION + TEXT_TYPE + COMMA_SEP +
                    TablaArtistas.COLUMNA_DESCRIPCION + TEXT_TYPE +
                    " )";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TablaArtistas.NOMBRE_TABLA;

    public static abstract class TablaCanciones implements BaseColumns {

        public static final String NOMBRE_TABLA_CANCIONES="CANCIONES";
        public static final String COLUMNA_NOMBRE_CANCION="NOMBRECANCION";
        public static final String COLUMNA_ALBUM="ALBUM";
        public static final String COLUMNA_ANIO="ANIO";
    }

    public static final String SQL_CREATE_ENTRIES_CANCION =
            "CREATE TABLE " +
                    TablaCanciones.NOMBRE_TABLA_CANCIONES +" (" +
                    TablaCanciones._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT "+ COMMA_SEP +
                    TablaCanciones.COLUMNA_NOMBRE_CANCION + TEXT_TYPE + COMMA_SEP +
                    TablaCanciones.COLUMNA_ALBUM + TEXT_TYPE + COMMA_SEP +
                    TablaCanciones.COLUMNA_ANIO + INTEGER_TYPE +
                    " )";

    public static final String SQL_DELETE_ENTRIES_CANCION =
            "DROP TABLE IF EXISTS " + TablaCanciones.NOMBRE_TABLA_CANCIONES;

    public static abstract class TablaGeneros implements BaseColumns {

        public static final String NOMBRE_TABLA="GENERO";
        public static final String COLUMNA_NOMBRE_GENERO="NOMBREGENERO";
    }

    public static final String SQL_CREATE_ENTRIES_GENERO =
            "CREATE TABLE " +
                    TablaGeneros.NOMBRE_TABLA +" (" +
                    TablaGeneros._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT "+ COMMA_SEP +
                    TablaGeneros.COLUMNA_NOMBRE_GENERO+ TEXT_TYPE +
                    " )";

    public static final String SQL_DELETE_ENTRIES_GENERO =
            "DROP TABLE IF EXISTS " + TablaGeneros.NOMBRE_TABLA;
}
