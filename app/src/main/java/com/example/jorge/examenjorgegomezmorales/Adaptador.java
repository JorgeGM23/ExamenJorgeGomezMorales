package com.example.jorge.examenjorgegomezmorales;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jorge on 12/12/17.
 */

public class Adaptador extends BaseAdapter {

    // CONTEXTO DE LA APLICACION
    Context contexto;
    // LIST DE PRODUCTOS
    List<Producto> listaProductos;


    // CONSTRUCTOR
    public Adaptador(Context contexto, List<Producto> listaProductos) {
        this.contexto = contexto;
        this.listaProductos = listaProductos;
    }

    @Override
    public int getCount() {
        return listaProductos.size();
    }

    @Override
    public Object getItem(int i) {
        return listaProductos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listaProductos.get(i).getIdProducto();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vista = view;
        LayoutInflater inflador = LayoutInflater.from(contexto);
        vista = inflador.inflate(R.layout.item, null);

        ImageView imageView = (ImageView) vista.findViewById(R.id.iv);
        TextView tvNombreProducto = (TextView) vista.findViewById(R.id.tvNombreProducto);
        TextView tvDescripcionProducto = (TextView) vista.findViewById(R.id.tvDescripcionProducto);
        TextView tvPrecioProducto = (TextView) vista.findViewById(R.id.tvPrecioProducto);

        imageView.setImageResource(listaProductos.get(i).getImagen());
        tvNombreProducto.setText(listaProductos.get(i).getNombreProducto().toString());
        tvDescripcionProducto.setText(listaProductos.get(i).getDescripcion().toString());
        double precio = listaProductos.get(i).getPrecio();
        tvPrecioProducto.setText(Double.toString(precio));

        return vista;
    }
}
