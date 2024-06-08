package com.example.semana7.service;

import com.example.semana7.entity.Categoria;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceCategoriaLibro {

    @GET("servicio/util/listaCategoriaDeLibro")
    public Call<List<Categoria>> listaTodos();

}
