package com.wjnovoam.app.item.clients;

import com.wjnovoam.app.item.models.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "servicio-productos", url = "localhost:8001/api/productos") //con esta anotacion se declara que esta interfaz es un cliente feing
public interface ProductoClienteRest {

    @GetMapping("/listar")
    List<Producto> listar();

    @GetMapping("/ver/{id}")
    Producto detalle(@PathVariable Long id);
}
