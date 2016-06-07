package ec.edu.com.epn.konwarriosapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Generos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generos2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarG);
        setSupportActionBar(toolbar);
    }

    public void abrirCrearGenero(View view){
        Intent llamadoCrear = new Intent(this, CrearNuevoGenero.class);
        startActivity(llamadoCrear);
    }

}
