package ec.edu.com.epn.konwarriosapp.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

import ec.edu.com.epn.konwarriosapp.R;
import ec.edu.com.epn.konwarriosapp.vo.ArtistaVO;

/**
 * Created by CHUCHO on 6/6/2016.
 */
public class ArtistaAdaptador extends ArrayAdapter {

    List<ArtistaVO> listaArtista;

    public ArtistaAdaptador(Context context, List<ArtistaVO> objects){
        super(context,0,objects);
        listaArtista=objects;
    }

    @Override
    public View getView(int posicion, View view, ViewGroup padre){
        if(view == null){
            LayoutInflater inflador = LayoutInflater.from(getContext());
            view=inflador.inflate(R.layout.item_artista,null);
        }

        TextView tituloArtista=(TextView)view.findViewById(R.id.lblTituloArtista);
        TextView genero=(TextView)view.findViewById(R.id.lblGenero);
        TextView cancion=(TextView)view.findViewById(R.id.lblCancion);
        TextView descripcion=(TextView)view.findViewById(R.id.lblDescripcion);

        ArtistaVO artista= (ArtistaVO)listaArtista.get(posicion);

        tituloArtista.setText(artista.getNombreArtista());

        String generoStr = "Género : "+artista.getGenero()+"";
        genero.setText(generoStr);

        String cancionStr = "Canción Representativa : "+artista.getCancion();
        cancion.setText(cancionStr);

        String descripcionStr = "Descripción : "+artista.getDescripcionBanda();
        descripcion.setText(descripcionStr);

        return view;
    }

}
