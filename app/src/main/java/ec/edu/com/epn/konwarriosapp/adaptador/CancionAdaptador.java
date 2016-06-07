package ec.edu.com.epn.konwarriosapp.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import ec.edu.com.epn.konwarriosapp.R;
import ec.edu.com.epn.konwarriosapp.vo.ArtistaVO;
import ec.edu.com.epn.konwarriosapp.vo.CancionVO;

/**
 * Created by CHUCHO on 6/6/2016.
 */
public class CancionAdaptador extends ArrayAdapter {

    List<CancionVO> listaCancion;

    public CancionAdaptador(Context context, List<CancionVO> objects){
        super(context,0,objects);
        listaCancion=objects;
    }

    @Override
    public View getView(int posicion, View view, ViewGroup padre){
        if(view == null){
            LayoutInflater inflador = LayoutInflater.from(getContext());
            view=inflador.inflate(R.layout.item_cancion,null);
        }

        TextView tituloCancion=(TextView)view.findViewById(R.id.lblTituloCancion);
        TextView album=(TextView)view.findViewById(R.id.lblAlbum);
        TextView anio=(TextView)view.findViewById(R.id.lblAnio);

        CancionVO cancion= (CancionVO)listaCancion.get(posicion);

        tituloCancion.setText(cancion.getNombreCancion());

        String albumStr = "Álbum : "+cancion.getAlbum();
        album.setText(albumStr);

        String anioStr = "Año : "+cancion.getAnio();
        anio.setText(anioStr);

        return view;
    }

}
