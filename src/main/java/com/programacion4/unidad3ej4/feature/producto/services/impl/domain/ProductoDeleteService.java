package com.programacion4.unidad3ej4.feature.producto.services.impl.domain;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej4.feature.producto.models.Producto;
import com.programacion4.unidad3ej4.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.commons.IProductoFindActiveByIdService;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.domain.IProductoDeleteService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoDeleteService implements IProductoDeleteService {

    private final IProductoFindActiveByIdService productoFindActiveByIdService;
    private final IProductoRepository productoRepository;

    @Override
    public void delete(Long id) {
        Producto producto = productoFindActiveByIdService.findById(id);
        producto.setEstaEliminado(true);
        productoRepository.save(producto);
    }
}