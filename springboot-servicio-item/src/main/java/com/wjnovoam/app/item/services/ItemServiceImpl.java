package com.wjnovoam.app.item.services;

import com.wjnovoam.app.item.models.Item;
import com.wjnovoam.app.item.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private RestTemplate clienteRest;

    @Override
    public List<Item> findAll() {
        List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://localhost:8001/api/productos/listar",Producto[].class));
        return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id",id.toString());
        Producto producto = clienteRest.getForObject("http://localhost:8001/api/productos/{id}",Producto.class, pathVariables);

        return new Item(producto, cantidad);
    }
}
