package com.programacion4.unidad3ej4.feature.producto.services.impl.commons;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej4.config.exceptions.ResourceNotFoundException;
import com.programacion4.unidad3ej4.feature.producto.models.Categoria;
import com.programacion4.unidad3ej4.feature.producto.repositories.ICategoriaRepository;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.commons.ICategoriaFindByIdService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoriaFindByIdService implements ICategoriaFindByIdService {

    private final ICategoriaRepository categoriaRepository;

    @Override
    public Categoria findById(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe una categoría con id: " + id));
    }
}