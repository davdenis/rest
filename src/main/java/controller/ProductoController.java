package controller;

import model.Producto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductoController {

    private Producto producto = new Producto();
    private List<Producto> productos = new ArrayList<>();

    @GetMapping
    private List<Producto> obtenerProductos() {
        return productos;
    }

    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable Long id) {
        return producto;
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return producto;
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        return producto;
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {

    }

}

