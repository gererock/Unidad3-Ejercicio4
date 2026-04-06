package com.programacion4.unidad3ej4.feature.producto.services.interfaces.commons;

import com.programacion4.unidad3ej4.feature.producto.models.Producto;

public interface IProductoFindActiveByIdService {
    
    Producto findById(Long id);
}