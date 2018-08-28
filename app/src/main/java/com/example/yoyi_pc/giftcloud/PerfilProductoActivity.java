package com.example.yoyi_pc.giftcloud;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PerfilProductoActivity extends AppCompatActivity
{

    static public ActionBar barritaSuperior;
    static public View vista;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_producto);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar3);
        barritaSuperior = getSupportActionBar();
        vista = getSupportActionBar().getCustomView();
        TextView mayo = vista.findViewById(R.id.valorGiftCoins3);
        TextView otro = MainActivity.vista.findViewById(R.id.valorGiftCoins);
        mayo.setText(otro.getText());
        String nombre = getIntent().getStringExtra("nombre");
        String descripcion = getIntent().getStringExtra("descripcion");
        String nombreImagen = getIntent().getStringExtra("nombreImagen");
        String strprecio = getIntent().getStringExtra("strprecio");
        final Integer precio = Integer.parseInt(strprecio);
        TextView textoNombre = findViewById(R.id.nombreProducto);
        TextView textoDescripcion = findViewById(R.id.descripcionProducto);
        TextView textoPrecio = findViewById(R.id.precioProducto);
        textoNombre.setText(nombre);
        textoDescripcion.setText(descripcion);
        textoPrecio.setText(strprecio);
        ImageView imagen = (ImageView) findViewById(R.id.imagenProducto);
        Context context = imagen.getContext();
        int id = context.getResources().getIdentifier(nombreImagen, "drawable", context.getPackageName());
        imagen.setImageResource(id);
        Button botonCanjeo = findViewById(R.id.botonCanjeo);
        botonCanjeo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                final AlertDialog dialogo = builder.create();
                        builder.setMessage("¿Estás seguro que deseas canjear el producto?")
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id)
                            {
                                TextView text = MainActivity.vista.findViewById(R.id.valorGiftCoins);
                                int valor = Integer.parseInt((String) text.getText());
                                if (valor >= precio)
                                {
                                    TextView text2 = TiendaActivity.vista.findViewById(R.id.valorGiftCoins2);
                                    TextView text3 = findViewById(R.id.valorGiftCoins3);
                                    valor -= precio;
                                    String valorString = valor + "";
                                    text.setText(valorString);
                                    text2.setText(valorString);
                                    text3.setText(valorString);
                                    dialogo.setMessage("El producto ha sido canjeado correctamente, y sera despachado prontamente");
                                    dialogo.setTitle("Transacción Completada");
                                    dialogo.show();
                                }
                                else
                                {
                                    dialogo.setMessage("Saldo Insuficiente, Transacción Cancelada");
                                    dialogo.setTitle("Error");
                                    dialogo.show();
                                }
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });
                builder.show();
            }
        });
    }
}
