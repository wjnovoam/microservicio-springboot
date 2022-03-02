package com.wjnovoam.app.productos.controllers;

import com.wjnovoam.app.productos.entity.Producto;
import com.wjnovoam.app.productos.services.IProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private IProductosService iProductosService;

    @GetMapping("/listar")
    public List<Producto> listar(){
        return iProductosService.findAll();
    }

    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable Long id){
        return iProductosService.findById(id);
    }
}
