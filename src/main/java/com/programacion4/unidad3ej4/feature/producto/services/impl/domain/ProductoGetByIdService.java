package com.programacion4.unidad3ej4.feature.producto.services.impl.domain;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej4.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej4.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej4.feature.producto.models.Producto;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.commons.IProductoFindActiveByIdService;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.domain.IProductoGetByIdService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoGetByIdService implements IProductoGetByIdService {

    private final IProductoFindActiveByIdService productoFindActiveByIdService;

    @Override
    public ProductoResponseDto getById(Long id) {
        Producto producto = productoFindActiveByIdService.findById(id);
        return ProductoMapper.toResponseDto(producto);
    }
}