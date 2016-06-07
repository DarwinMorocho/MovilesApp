package ec.edu.com.epn.konwarriosapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

import ec.edu.com.epn.konwarriosapp.adaptador.CancionAdaptador;
import ec.edu.com.epn.konwarriosapp.sqlite.KonWarriorsAppContract;
import ec.edu.com.epn.konwarriosapp.sqlite.KonWarriorsAppHelper;
import ec.edu.com.epn.konwarriosapp.vo.CancionVO;

public class CrearNuevoArtista extends AppCompatActivity {

    private Spinner cmbGenero;
    private Spinner cmbCancion;
    private EditText txtNombreArtista;
    private EditText txtDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_nuevo_artista);

        crearNuevoArtistaMetodo();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setContentView(R.layout.activity_crear_nuevo_artista);

        crearNuevoArtistaMetodo();
    }

    public void crearNuevoArtistaMetodo(){
        cmbGenero=(Spinner)findViewById(R.id.cmbGenero);
        cmbCancion=(Spinner)findViewById(R.id.cmbCanciones);
        txtNombreArtista=(EditText)findViewById(R.id.ETNombreArtista);
        txtDescripcion=(EditText)findViewById(R.id.ETDescripcionArtista);


        //String[]generos={"Heavy Metal","Thrash Metal","Power Metal", "Hard Rock", "Rock", "Glam Metal", "Heavy Rock"};

        //ArrayAdapter<String> adatadorGenerosAux = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, generos);

        KonWarriorsAppHelper oh = new KonWarriorsAppHelper(getApplicationContext());
        SQLiteDatabase db = oh.getReadableDatabase();

        //COMBO GENEROS
        String[]columnasG = {KonWarriorsAppContract.TablaGeneros.COLUMNA_NOMBRE_GENERO};

        Cursor curG = db.query(KonWarriorsAppContract.TablaGeneros.NOMBRE_TABLA,columnasG,null,null,null,null,null);

        ArrayList<String> generos = new ArrayList<String>();
        while(curG.moveToNext()){
            generos.add(curG.getString(0));
        }
        ArrayAdapter<String> adatadorGenerosAux = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, generos);
        cmbGenero.setAdapter(adatadorGenerosAux);

        //COMBO CANCIONES
        String[]columnasC = {KonWarriorsAppContract.TablaCanciones.COLUMNA_NOMBRE_CANCION};

        Cursor curC = db.query(KonWarriorsAppContract.TablaCanciones.NOMBRE_TABLA_CANCIONES,columnasC,null,null,null,null,null);

        ArrayList<String> canciones = new ArrayList<String>();
        while(curC.moveToNext()){
            canciones.add(curC.getString(0));
        }
        ArrayAdapter<String> adatadorCancionesAux = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, canciones);
        cmbCancion.setAdapter(adatadorCancionesAux);
    }

    public void guardarArtista(View view){
        KonWarriorsAppHelper op = new KonWarriorsAppHelper(getApplicationContext());
        SQLiteDatabase db = op.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(KonWarriorsAppContract.TablaArtistas.COLUMNA_NOMBRE_ARTISTA, txtNombreArtista.getText().toString());
        valores.put(KonWarriorsAppContract.TablaArtistas.COLUMNA_GENERO, cmbGenero.getSelectedItem().toString());
        valores.put(KonWarriorsAppContract.TablaArtistas.COLUMNA_CANCION, cmbCancion.getSelectedItem().toString());
        valores.put(KonWarriorsAppContract.TablaArtistas.COLUMNA_DESCRIPCION, txtDescripcion.getText().toString());

        db.insert(KonWarriorsAppContract.TablaArtistas.NOMBRE_TABLA, null, valores);
        db.close();

        Intent llamadoArtistas = new Intent(this, Artistas.class);
        startActivity(llamadoArtistas);
    }

    public void abrirCrearCancionNueva(View view){
        Intent llamadoCrear = new Intent(this, CrearNuevaCancion.class);
        startActivity(llamadoCrear);
    }

    public void abrirCrearGenero(View view){
        Intent llamadoCrear = new Intent(this, CrearGenero.class);
        startActivity(llamadoCrear);
    }
}
