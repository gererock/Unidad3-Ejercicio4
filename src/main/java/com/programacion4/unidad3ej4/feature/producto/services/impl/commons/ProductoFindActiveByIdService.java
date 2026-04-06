package com.programacion4.unidad3ej4.feature.producto.services.impl.commons;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej4.config.exceptions.ResourceNotFoundException;
import com.programacion4.unidad3ej4.feature.producto.models.Producto;
import com.programacion4.unidad3ej4.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.commons.IProductoFindActiveByIdService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoFindActiveByIdService implements IProductoFindActiveByIdService {

    private final IProductoRepository productoRepository;

    @Override
    public Producto findById(Long id) {
        return productoRepository.findByIdAndEstaEliminadoFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe un producto con id: " + id));
    }
}