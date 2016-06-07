package ec.edu.com.epn.konwarriosapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

        /*GeneroVO genero1 = new GeneroVO("Heavy Metal");
        genero.add(genero1);

        GeneroVO genero2 = new GeneroVO("Thrash Metal");
        genero.add(genero2);

        GeneroVO genero3 = new GeneroVO("Power Metal");
        genero.add(genero3);

        GeneroVO genero4 = new GeneroVO("Rock");
        genero.add(genero4);

        GeneroVO genero5 = new GeneroVO("Hard Rock");
        genero.add(genero5);

        GeneroVO genero6 = new GeneroVO("Heavy Rock");
        genero.add(genero6);

        GeneroVO genero7 = new GeneroVO("Glam Metal");
        genero.add(genero7);*/

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

    public void abrirCrearGenero(View view){
        Intent llamadoCrear = new Intent(this, CrearGenero.class);
        startActivity(llamadoCrear);
    }

}
