package ec.edu.com.epn.konwarriosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CrearNuevaCancion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_nueva_cancion);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setContentView(R.layout.activity_crear_nueva_cancion);
    }

    public void abrirCrearCancion(View view){
        Intent llamadoCrear = new Intent(this, CrearNuevaCancion.class);
        startActivity(llamadoCrear);
    }

}
