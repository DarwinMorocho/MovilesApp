package ec.edu.com.epn.konwarriosapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import ec.edu.com.epn.konwarriosapp.sqlite.KonWarriorsAppContract;
import ec.edu.com.epn.konwarriosapp.sqlite.KonWarriorsAppHelper;

public class CrearNuevaCancion extends AppCompatActivity {

    private EditText txtNombreCancion;
    private EditText txtAlbum;
    private EditText numAnio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_nueva_cancion);

        crearNuevaCancionMetodo();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setContentView(R.layout.activity_crear_nueva_cancion);

        crearNuevaCancionMetodo();
    }

    public void crearNuevaCancionMetodo(){
        txtNombreCancion=(EditText)findViewById(R.id.ETNombreCancion);
        txtAlbum=(EditText)findViewById(R.id.ETAlbum);
        numAnio=(EditText)findViewById(R.id.ETAnio);
    }

    public void guardarCancion(View view){
        KonWarriorsAppHelper op = new KonWarriorsAppHelper(getApplicationContext());
        SQLiteDatabase db = op.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(KonWarriorsAppContract.TablaCanciones.COLUMNA_NOMBRE_CANCION, txtNombreCancion.getText().toString());
        valores.put(KonWarriorsAppContract.TablaCanciones.COLUMNA_ALBUM, txtAlbum.getText().toString());
        valores.put(KonWarriorsAppContract.TablaCanciones.COLUMNA_ANIO, Integer.parseInt(numAnio.getText().toString()));

        db.insert(KonWarriorsAppContract.TablaCanciones.NOMBRE_TABLA_CANCIONES, null, valores);
        db.close();

        Intent llamadoCanciones = new Intent(this, Canciones.class);
        startActivity(llamadoCanciones);
    }

}
