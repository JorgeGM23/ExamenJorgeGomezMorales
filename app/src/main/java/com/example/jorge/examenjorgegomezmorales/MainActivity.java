package com.example.jorge.examenjorgegomezmorales;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Producto> productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listViewMain);
        productos = new ArrayList<>();

        // CREO LOS OBJETOS Y LOS METO EN EL ARRAYLIST
        int[] fotosP1 = new int[] {R.drawable.galeria_tv1, R.drawable.galeria_tv2, R.drawable.galeria_tv3};
        Producto p1 = new Producto(1, "Televisor LG F21-40",R.drawable.televisor_lg , 399,  "Televisor imagen 4K de 40 pulgadas 400Mhz",fotosP1);

        int[] fotosP2 = new int[] {R.drawable.galeria_microcadena1, R.drawable.galeria_microcadena2, R.drawable.galeria_microcadena3};
        Producto p2 = new Producto(2, "Microcadena Sony HT-100sd",R.drawable.minicadena_sony , 199, "Cadena musical conexión USB y iPod 40W", fotosP2);

        int[] fotosP3 = new int[] {R.drawable.galeria_plancha1, R.drawable.galeria_plancha2, R.drawable.galeria_plancha3};
        Producto p3 = new Producto(3, "Plancha Rowenta Soft FX-1",R.drawable.plancha_rowenta ,90, "Plancha profesional 7 funciones de planchado 1800W", fotosP3);

        int[] fotosP4 = new int[] {R.drawable.galeria_portatil1, R.drawable.galeria_portatil2, R.drawable.galeria_portatil3, R.drawable.galeria_portatil4};
        Producto p4 = new Producto (4, "Ordenador Portatil Acer R235",R.drawable.portatil_acer , 589.90, "Ordenador Portatil Acer I5, 8GB, SSD240GB",fotosP4);

        productos.add(p1); productos.add(p2); productos.add(p3); productos.add(p4);

        // INSTANCIO EL ADAPTADOR Y LO APLICO AL LIST VIEW
        Adaptador miAdaptador = new Adaptador(getApplicationContext(), productos);

        listView.setAdapter(miAdaptador);


        // AL PULSAR EN UN ITEM, PASO AL SIGUIENTE ACTIVITY (DetalleActivity)
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Producto obj = (Producto) adapterView.getItemAtPosition(i);

                // PASO EL OBJETO PULSADO
                Intent paso = new Intent(getApplicationContext(), DetalleActivity.class);
                paso.putExtra("objeto", (Serializable)obj);
                startActivity(paso);
            }
        });
    }
}
