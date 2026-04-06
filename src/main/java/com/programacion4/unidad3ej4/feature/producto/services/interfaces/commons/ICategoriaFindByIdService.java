package com.programacion4.unidad3ej4.feature.producto.services.interfaces.commons;

import com.programacion4.unidad3ej4.feature.producto.models.Categoria;

public interface ICategoriaFindByIdService {
    
    Categoria findById(Long id);
}