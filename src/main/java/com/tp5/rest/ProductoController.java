package com.tp5.rest;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProductoController {

    private final ProductoRepository repo;

    public ProductoController(ProductoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    private Iterable<Producto> obtenerProductos() {
        return this.repo.findAll();
    }

    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable Long id) {
        return this.repo.findById(id).orElse(null);
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return this.repo.save(producto);
    }

    /*
    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        return this.repo.save(producto);
    }
    */

    @PutMapping
    public Producto actualizarProducto(@RequestBody Producto producto) {
        return this.repo.save(producto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        this.repo.deleteById(id);
    }

}

