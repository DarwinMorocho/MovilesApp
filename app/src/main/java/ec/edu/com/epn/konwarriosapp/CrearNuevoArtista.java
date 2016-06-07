package ec.edu.com.epn.konwarriosapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ToggleButton;

import ec.edu.com.epn.konwarriosapp.sqlite.KonWarriorsAppContract;
import ec.edu.com.epn.konwarriosapp.sqlite.KonWarriorsAppHelper;

public class CrearNuevoArtista extends AppCompatActivity {

    private Spinner cmbGenero;
    private Spinner cmbCancion;
    private EditText txtNombreArtista;
    private EditText txtDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_nuevo_artista);

        cmbGenero=(Spinner)findViewById(R.id.cmbGenero);
        cmbCancion=(Spinner)findViewById(R.id.cmbCanciones);
        txtNombreArtista=(EditText)findViewById(R.id.ETNombreArtista);
        txtDescripcion=(EditText)findViewById(R.id.ETDescripcionArtista);


        String[]generos={"Heavy Metal","Thrash Metal","Power Metal", "Hard Rock", "Rock", "Glam Metal", "Heavy Rock"};

        ArrayAdapter<String> adatadorGenerosAux = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, generos);

        cmbGenero.setAdapter(adatadorGenerosAux);

        String[]canciones={"Sucesor","Aguanta","Pretendo", "Aves de Acero", "Punkistein", "Cancerbero", "Atahualpa Rock"};

        ArrayAdapter<String> adatadorCancionesAux = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, canciones);

        cmbCancion.setAdapter(adatadorCancionesAux);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setContentView(R.layout.activity_crear_nuevo_artista);
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
}
