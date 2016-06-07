package ec.edu.com.epn.konwarriosapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ec.edu.com.epn.konwarriosapp.adaptador.CancionAdaptador;
import ec.edu.com.epn.konwarriosapp.adaptador.GeneroAdaptador;
import ec.edu.com.epn.konwarriosapp.sqlite.KonWarriorsAppContract;
import ec.edu.com.epn.konwarriosapp.sqlite.KonWarriorsAppHelper;
import ec.edu.com.epn.konwarriosapp.vo.CancionVO;
import ec.edu.com.epn.konwarriosapp.vo.GeneroVO;

public class Generos extends AppCompatActivity {

    private ListView lvActividades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generos);

        CargarDatosGenero();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setContentView(R.layout.activity_generos);

        CargarDatosGenero();
    }

    public void CargarDatosGenero(){

        //declarar al inicio:-----> private ListView lvActividades;
        lvActividades = (ListView)findViewById(R.id.lvGeneros);

        List<GeneroVO> genero = new ArrayList<GeneroVO>();

        /*AlarmaVO alarma1 = new AlarmaVO("Examen", 6, 00, "PM",false);
        alarmas.add(alarma1);

        AlarmaVO alarma2 = new AlarmaVO("Cine", 1, 00, "PM",true);
        alarmas.add(alarma2);

        AlarmaVO alarma3 = new AlarmaVO("Fútbol", 9, 00, "AM",true);
        alarmas.add(alarma3);/*/

        KonWarriorsAppHelper oh = new KonWarriorsAppHelper(getApplicationContext());
        SQLiteDatabase db = oh.getReadableDatabase();

        String[]columnas = {KonWarriorsAppContract.TablaGeneros.COLUMNA_NOMBRE_GENERO};

        Cursor cur = db.query(KonWarriorsAppContract.TablaGeneros.NOMBRE_TABLA,columnas,null,null,null,null,null);

        while(cur.moveToNext()){
            GeneroVO a = new GeneroVO();

            String nombre = cur.getString(0);
            a.setNombreGenero(nombre);
            genero.add(a);
        }

        GeneroAdaptador adaptador = new GeneroAdaptador(this,genero);

        lvActividades.setAdapter(adaptador);
    }

}
