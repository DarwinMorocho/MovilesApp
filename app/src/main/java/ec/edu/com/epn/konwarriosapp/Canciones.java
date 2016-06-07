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
import ec.edu.com.epn.konwarriosapp.adaptador.CancionAdaptador;
import ec.edu.com.epn.konwarriosapp.sqlite.KonWarriorsAppContract;
import ec.edu.com.epn.konwarriosapp.sqlite.KonWarriorsAppHelper;
import ec.edu.com.epn.konwarriosapp.vo.ArtistaVO;
import ec.edu.com.epn.konwarriosapp.vo.CancionVO;

public class Canciones extends AppCompatActivity {

    private ListView lvActividades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canciones2);

        CargarDatosCancion();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarC);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setContentView(R.layout.activity_canciones2);

        CargarDatosCancion();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarC);
        setSupportActionBar(toolbar);
    }

    public void CargarDatosCancion(){

        //declarar al inicio:-----> private ListView lvActividades;
        lvActividades = (ListView)findViewById(R.id.lvCanciones);

        List<CancionVO> cancion = new ArrayList<CancionVO>();

        /*AlarmaVO alarma1 = new AlarmaVO("Examen", 6, 00, "PM",false);
        alarmas.add(alarma1);

        AlarmaVO alarma2 = new AlarmaVO("Cine", 1, 00, "PM",true);
        alarmas.add(alarma2);

        AlarmaVO alarma3 = new AlarmaVO("Fútbol", 9, 00, "AM",true);
        alarmas.add(alarma3);/*/

        KonWarriorsAppHelper oh = new KonWarriorsAppHelper(getApplicationContext());
        SQLiteDatabase db = oh.getReadableDatabase();

        String[]columnas = {KonWarriorsAppContract.TablaCanciones.COLUMNA_NOMBRE_CANCION,
                KonWarriorsAppContract.TablaCanciones.COLUMNA_ALBUM,
                KonWarriorsAppContract.TablaCanciones.COLUMNA_ANIO};

        Cursor cur = db.query(KonWarriorsAppContract.TablaCanciones.NOMBRE_TABLA_CANCIONES,columnas,null,null,null,null,null);

        while(cur.moveToNext()){
            CancionVO a = new CancionVO();

            String nombre = cur.getString(0);
            a.setNombreCancion(nombre);
            String album = cur.getString(1);
            a.setAlbum(album);
            int anio = cur.getInt(2);
            a.setAnio(anio);
            cancion.add(a);
        }

        CancionAdaptador adaptador = new  CancionAdaptador(this,cancion);

        lvActividades.setAdapter(adaptador);
    }


}
