package com.example.semana02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.semana02.R;
import com.example.semana02.entity.Product;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product>  {

    private Context context;
    private  List<Product> objects;
    public ProductAdapter(@NonNull Context context, int resource, @NonNull List<Product> objects) {
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.product_item, parent, false);

        Product objProducts = objects.get(position);

        //Relacionar los elementos de la interfaz con los de la Entidad

        TextView txtProducto = row.findViewById(R.id.idItemProductTitle);
        txtProducto.setText(objProducts.getTitle());

        ImageView imgFoto = row.findViewById(R.id.idItemProductImage);
        Glide.with(context).load(objProducts.getImage()).into(imgFoto);

        TextView txtPrice = row.findViewById(R.id.idItemProductPrice);
        txtPrice.setText("Price : S/. " + objProducts.getPrice());

        return row;
    }
}
