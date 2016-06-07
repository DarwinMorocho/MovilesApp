package ec.edu.com.epn.konwarriosapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Buscar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setContentView(R.layout.activity_buscar);
    }
}
