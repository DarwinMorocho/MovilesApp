package ec.edu.com.epn.konwarriosapp.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import ec.edu.com.epn.konwarriosapp.R;
import ec.edu.com.epn.konwarriosapp.vo.CancionVO;
import ec.edu.com.epn.konwarriosapp.vo.GeneroVO;

/**
 * Created by CHUCHO on 6/6/2016.
 */
public class GeneroAdaptador extends ArrayAdapter {

    List<GeneroVO> listaGenero;

    public GeneroAdaptador(Context context, List<GeneroVO> objects){
        super(context,0,objects);
        listaGenero=objects;
    }

    @Override
    public View getView(int posicion, View view, ViewGroup padre){
        if(view == null){
            LayoutInflater inflador = LayoutInflater.from(getContext());
            view=inflador.inflate(R.layout.item_genero,null);
        }

        TextView tituloGenero=(TextView)view.findViewById(R.id.lblTituloGenero);

        GeneroVO genero= (GeneroVO)listaGenero.get(posicion);

        tituloGenero.setText(genero.getNombreGenero());

        return view;
    }

}