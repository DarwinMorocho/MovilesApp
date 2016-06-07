package ec.edu.com.epn.konwarriosapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import ec.edu.com.epn.konwarriosapp.sqlite.KonWarriorsAppContract;
import ec.edu.com.epn.konwarriosapp.sqlite.KonWarriorsAppHelper;

public class CrearGenero extends AppCompatActivity {

    private EditText txtGenero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_genero);

        crearNuevoGeneroMetodo();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setContentView(R.layout.activity_crear_genero);

        crearNuevoGeneroMetodo();
    }

    public void crearNuevoGeneroMetodo(){
        txtGenero=(EditText)findViewById(R.id.ETNombreGenero);
    }

    public void guardarGenero(View view){
        KonWarriorsAppHelper op = new KonWarriorsAppHelper(getApplicationContext());
        SQLiteDatabase db = op.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(KonWarriorsAppContract.TablaGeneros.COLUMNA_NOMBRE_GENERO, txtGenero.getText().toString());

        db.insert(KonWarriorsAppContract.TablaGeneros.NOMBRE_TABLA, null, valores);
        db.close();

        Intent llamadoGeneros = new Intent(this, Generos.class);
        startActivity(llamadoGeneros);
    }
}
