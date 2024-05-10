package com.tp5.rest;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProductoController {

    private final ProductoRepository repo;

    public ProductoController(ProductoRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/productos")
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

    @PostMapping("/nuevos")
    public void crearProductos(@RequestBody Iterable<Producto> productos) {
        this.repo.saveAll(productos);
    }

    @PutMapping
    public Producto actualizarProducto(@RequestBody Producto producto) {
        return this.repo.save(producto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        this.repo.deleteById(id);
    }

}

