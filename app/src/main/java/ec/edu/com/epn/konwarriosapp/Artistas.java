package ec.edu.com.epn.konwarriosapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ec.edu.com.epn.konwarriosapp.adaptador.ArtistaAdaptador;
import ec.edu.com.epn.konwarriosapp.sqlite.KonWarriorsAppContract;
import ec.edu.com.epn.konwarriosapp.sqlite.KonWarriorsAppHelper;
import ec.edu.com.epn.konwarriosapp.vo.ArtistaVO;

public class Artistas extends AppCompatActivity {

    private ListView lvActividades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artistas2);

        CargarDatosArtista();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
     }

    @Override
    protected void onRestart() {
        super.onRestart();
        setContentView(R.layout.activity_artistas2);

        CargarDatosArtista();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void CargarDatosArtista(){

        //declarar al inicio:-----> private ListView lvActividades;
        lvActividades = (ListView)findViewById(R.id.lvArtistas);

        List<ArtistaVO> artista = new ArrayList<ArtistaVO>();

        /*AlarmaVO alarma1 = new AlarmaVO("Examen", 6, 00, "PM",false);
        alarmas.add(alarma1);

        AlarmaVO alarma2 = new AlarmaVO("Cine", 1, 00, "PM",true);
        alarmas.add(alarma2);

        AlarmaVO alarma3 = new AlarmaVO("Fútbol", 9, 00, "AM",true);
        alarmas.add(alarma3);/*/

        KonWarriorsAppHelper oh = new KonWarriorsAppHelper(getApplicationContext());
        SQLiteDatabase db = oh.getReadableDatabase();

        String[]columnas = {KonWarriorsAppContract.TablaArtistas.COLUMNA_NOMBRE_ARTISTA,
                KonWarriorsAppContract.TablaArtistas.COLUMNA_GENERO,
                KonWarriorsAppContract.TablaArtistas.COLUMNA_CANCION,
                KonWarriorsAppContract.TablaArtistas.COLUMNA_DESCRIPCION};

        Cursor cur = db.query(KonWarriorsAppContract.TablaArtistas.NOMBRE_TABLA,columnas,null,null,null,null,null);

        while(cur.moveToNext()){
            ArtistaVO a = new ArtistaVO();

            String nombre = cur.getString(0);
            a.setNombreArtista(nombre);
            String genero = cur.getString(1);
            a.setGenero(genero);
            String cancion = cur.getString(2);
            a.setCancion(cancion);
            String descripcion = cur.getString(3);
            a.setGenero(descripcion);
            artista.add(a);
        }

        ArtistaAdaptador adaptador = new  ArtistaAdaptador(this,artista);

        lvActividades.setAdapter(adaptador);
    }

    public void abrirCrearArtista(View view){
        Intent llamadoCrear = new Intent(this, CrearNuevoArtista.class);
        startActivity(llamadoCrear);
    }

}
