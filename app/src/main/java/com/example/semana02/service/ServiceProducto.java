package com.example.semana02.service;

import com.example.semana02.entity.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceProducto {

    @GET("products")
    public abstract Call<List<Product>> listaproductos();

}
