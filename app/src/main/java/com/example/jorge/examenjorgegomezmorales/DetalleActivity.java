package com.example.jorge.examenjorgegomezmorales;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetalleActivity extends AppCompatActivity {

    ImageView imageView;
    ImageButton back;
    ImageButton forward;
    TextView tvProducto;
    TextView tvPrecio;
    TextView tvCodigo;
    TextView tvDescripcion;
    int[] fotos;

    int puntero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        imageView = (ImageView) findViewById(R.id.ivDetalle);
        back = (ImageButton) findViewById(R.id.back);
        forward = (ImageButton) findViewById(R.id.forward);
        tvProducto = (TextView) findViewById(R.id.tvNombreProductoDetalle);
        tvPrecio = (TextView) findViewById(R.id.tvPrecioDetalle);
        tvCodigo = (TextView) findViewById(R.id.tvCodigoDetalle);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcionDetalle);

        back.setBackgroundResource(R.drawable.back);
        forward.setBackgroundResource(R.drawable.forward);

        Producto prod = (Producto) getIntent().getExtras().getSerializable("objeto");

        fotos = prod.getGaleriaImagenes();

        tvProducto.setText(prod.getNombreProducto().toString());
        tvPrecio.setText(Double.toString(prod.getPrecio()) + "€");
        tvCodigo.setText("Codigo de producto: " + prod.getIdProducto());
        tvDescripcion.setText(prod.getDescripcion());

        imageView.setImageResource(prod.getImagen());

        puntero = 0;
    }

    public void irSiguiente(View view) {
        puntero++;
        if (puntero == fotos.length) {
            puntero = 0;
            imageView.setImageResource(fotos[puntero]);
        }
        else {
            imageView.setImageResource(fotos[puntero]);
        }
    }

    public void irAnterior(View view) {
        if (puntero == 0) {
            puntero = fotos.length - 1;
            imageView.setImageResource(fotos[puntero]);
        }
        else {
            puntero--;
            imageView.setImageResource(fotos[puntero]);
        }
    }


}
