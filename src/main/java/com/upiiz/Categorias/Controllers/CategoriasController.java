package com.upiiz.Categorias.Controllers;


import com.upiiz.Categorias.Models.Categorias;
import com.upiiz.Categorias.Services.CategoriasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriasController {
    //Requiero "inyectar una dependencia" del servicio
    CategoriasService categoriasService;

    //Crear el constructor
    public CategoriasController(CategoriasService categoriasService){
        this.categoriasService = categoriasService;
    }

    //GET - todas las categorias
    @GetMapping
    public ResponseEntity<List<Categorias>> getCategorias(){
        return ResponseEntity.ok(categoriasService.getallCategorias());
    }

    //GET - solo una categoria por ID
    @GetMapping("/{id}")
    public ResponseEntity<Categorias> getCategoriaPorId(@PathVariable Long id){
        return ResponseEntity.ok(categoriasService.getCategoriaPorId(id));
    }

    //POST - Crear una categoria
    @PostMapping
    public ResponseEntity<Categorias> crearCategoria(@RequestBody Categorias categoria){
        //return ResponseEntity.ok(categoriasService.crearCategoria(categoria));

        Categorias nuevaCategoria = categoriasService.crearCategoria(categoria);
        // Devuelve HTTP 201 Created con el objeto creado como JSON
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCategoria);
    }

    //PUT - Actualizar una categoria
    @PutMapping("/{id}")
    public ResponseEntity<Categorias> actualizarCategoria(@RequestBody Categorias categoria, @PathVariable Long id){
        categoria.setId(id);
        return ResponseEntity.ok(categoriasService.actualizarCategoria(categoria));
    }

    // DELETE - eliminar una categoria por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id){
        categoriasService.eliminarCategoria(id);
        return ResponseEntity.noContent().build(); // Devuelve HTTP 204 No Content
    }
}
