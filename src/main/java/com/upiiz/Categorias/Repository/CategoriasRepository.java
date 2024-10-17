package com.upiiz.Categorias.Repository;

import com.upiiz.Categorias.Models.Categorias;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CategoriasRepository {
    // Almancenar en un listado las categorias: salvar, listar, eliminar, actualizar
    // Generar de manera unica el id para cada categoria
    private List<Categorias> categorias  = new ArrayList<>(); // Evitar el null pointer exception
    private AtomicLong id = new AtomicLong(); // Para incrementar automaticamente el id

    // Agregamos la categoria al listado y la regresamos - POST
    public Categorias guardar(Categorias categoria) {
        categoria.setId(id.incrementAndGet());
        categorias.add(categoria);
        return categoria;
    }

    //GET - Todas las categorias
    public List<Categorias> getCategorias() {
        return categorias;
    }

    // GET solo una categoria
    public Categorias getCategoriaPorId(Long id) {
        //Funcional
        return categorias.stream().filter(categoria -> categoria.getId().equals(id)).findFirst().orElse(null);
    }

    //DELETE
    public void eliminar(Long id) {
        categorias.removeIf(categoria -> categoria.getId().equals(id));
    }

    //PUT
    public Categorias actualizar(Categorias categoria) {
        eliminar(categoria.getId());
        categorias.add(categoria);
        return categoria;
    }
}
