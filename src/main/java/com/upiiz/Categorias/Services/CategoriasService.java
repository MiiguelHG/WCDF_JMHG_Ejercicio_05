package com.upiiz.Categorias.Services;

import com.upiiz.Categorias.Models.Categorias;
import com.upiiz.Categorias.Repository.CategoriasRepository;
import org.springframework.stereotype.Service;

import java.util.List;


//Se crea una knstancia de esta clase
@Service
public class CategoriasService {
    //Requerimos REPO (Datos - Listado) - Categorias
    //Requiero inyectar el repositorio
    CategoriasRepository categoriasRepository;

    //Constructor - Cuando crear la instanica le pasa el repositorio
    public CategoriasService(CategoriasRepository categoriasRepository){
        this.categoriasRepository = categoriasRepository;
    }

    //GET - Todas las categorias
    public List<Categorias> getallCategorias(){
        return categoriasRepository.getCategorias();
    }

    //GET - Categoria por id
    public Categorias getCategoriaPorId(Long id){
        return categoriasRepository.getCategoriaPorId(id);
    }

    //POST - Crear categoria
    public Categorias crearCategoria(Categorias categoria){
        return categoriasRepository.guardar(categoria);
    }

    //PUT - Actualizar categoria
    public Categorias actualizarCategoria(Categorias categoria){
        return categoriasRepository.actualizar(categoria);
    }

    //DELETE - eliminar categoria
    public void eliminarCategoria(Long id){
        categoriasRepository.eliminar(id);
    }
}
