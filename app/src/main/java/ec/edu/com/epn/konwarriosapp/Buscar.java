package ec.edu.com.epn.konwarriosapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ec.edu.com.epn.konwarriosapp.adaptador.ArtistaAdaptador;
import ec.edu.com.epn.konwarriosapp.sqlite.KonWarriorsAppContract;
import ec.edu.com.epn.konwarriosapp.sqlite.KonWarriorsAppHelper;
import ec.edu.com.epn.konwarriosapp.vo.ArtistaVO;

public class Buscar extends AppCompatActivity {

    private ListView lvActividades;
    private EditText txtBuscar;
    private Button btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setContentView(R.layout.activity_buscar);
    }

    public void buscarArtista(View v){

        //declarar al inicio:-----> private ListView lvActividades;
        lvActividades = (ListView)findViewById(R.id.lvArtistas);
        txtBuscar = (EditText) findViewById(R.id.ETBuscar);
        //btnBuscar =  findViewById(R.id.ETBuscar);

        List<ArtistaVO> artista = new ArrayList<ArtistaVO>();

        KonWarriorsAppHelper oh = new KonWarriorsAppHelper(getApplicationContext());
        SQLiteDatabase db = oh.getReadableDatabase();

        String[]columnas = {KonWarriorsAppContract.TablaArtistas.COLUMNA_NOMBRE_ARTISTA,
                KonWarriorsAppContract.TablaArtistas.COLUMNA_GENERO,
                KonWarriorsAppContract.TablaArtistas.COLUMNA_CANCION,
                KonWarriorsAppContract.TablaArtistas.COLUMNA_DESCRIPCION};

        //Cursor cur = db.query(KonWarriorsAppContract.TablaArtistas.NOMBRE_TABLA,columnas,null,null,null,null,null);
        Cursor cur = db.rawQuery(" SELECT * FROM "+KonWarriorsAppContract.TablaArtistas.NOMBRE_TABLA
                                    +" WHERE "+KonWarriorsAppContract.TablaArtistas.COLUMNA_NOMBRE_ARTISTA+" = '"+
                                    txtBuscar.getText().toString()+"'",null);

        while(cur.moveToNext()){
            ArtistaVO a = new ArtistaVO();

            String nombre = cur.getString(0);
            a.setNombreArtista(nombre);
            String genero = cur.getString(1);
            a.setGenero(genero);
            String cancion = cur.getString(2);
            a.setCancion(cancion);
            String descripcion = cur.getString(3);
            a.setDescripcionBanda(descripcion);
            artista.add(a);
        }

        ArtistaAdaptador adaptador = new  ArtistaAdaptador(this,artista);
        lvActividades.setAdapter(adaptador);
    }
}
