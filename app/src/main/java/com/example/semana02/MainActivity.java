package com.example.semana02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.semana02.adapter.ProductAdapter;
import com.example.semana02.entity.Product;
import com.example.semana02.service.ServiceProducto;
import com.example.semana02.util.ConnectionRest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //ListView y Adapater
    GridView lstProduct;
    ArrayList<Product> listaProducto = new ArrayList<Product>();
    ProductAdapter productAdapter;

    Button   btnFiltrar;

    //conecta al servicio REST
    ServiceProducto serviceProducto;

    private List<Product> listaTotalProductos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lstProduct = findViewById(R.id.lstProductos);
        productAdapter = new ProductAdapter(this, R.layout.product_item, listaProducto);
        lstProduct.setAdapter(productAdapter);


        //Relaciona las variables con las variables de la GUI
        btnFiltrar = findViewById(R.id.btnFiltrar);

        //Conecta al servicio REST
        serviceProducto = ConnectionRest.getConnecion().create(ServiceProducto.class);


        btnFiltrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargaProductos();
            }
        });

        //Evento
        lstProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product obj = listaProducto.get(position);
                Intent intent = new Intent(MainActivity.this, MainViewDetail.class);
                intent.putExtra("var_product", obj);
                startActivity(intent);
            }
        });


    }

    void cargaProductos(){
        Call<List<Product>> call = serviceProducto.listaproductos();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                   if (response.isSuccessful()){
                       listaTotalProductos = response.body();
                       listaProducto.clear();
                       listaProducto.addAll(listaTotalProductos);
                       productAdapter.notifyDataSetChanged();
                   }
            }
            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });

    }

}