package com.programacion4.unidad3ej4.feature.producto.services.impl.domain;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej4.config.exceptions.ConflictException;
import com.programacion4.unidad3ej4.feature.producto.dtos.request.ProductoCreateRequestDto;
import com.programacion4.unidad3ej4.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej4.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej4.feature.producto.models.Categoria;
import com.programacion4.unidad3ej4.feature.producto.models.Producto;
import com.programacion4.unidad3ej4.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.commons.ICapitalizeTextService;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.commons.ICategoriaFindByIdService;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.commons.IProductoExistByNameService;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.domain.IProductoCreateService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoCreateService implements IProductoCreateService {

    private final IProductoExistByNameService productoExistByNameService;
    private final ICategoriaFindByIdService categoriaFindByIdService;
    private final ICapitalizeTextService capitalizeTextService;
    private final IProductoRepository productoRepository;

    @Override
    public ProductoResponseDto create(ProductoCreateRequestDto dto) {

        String nombreFormateado = capitalizeTextService.capitalize(dto.getNombre());
        String descripcionFormateada = capitalizeTextService.capitalize(dto.getDescripcion());

        if (productoExistByNameService.existByName(nombreFormateado)) {
            throw new ConflictException("El nombre del producto ya existe");
        }

        Categoria categoria = categoriaFindByIdService.findById(dto.getCategoriaId());

        Producto productoAGuardar = ProductoMapper.toEntity(dto, categoria);
        productoAGuardar.setNombre(nombreFormateado);
        productoAGuardar.setDescripcion(descripcionFormateada);
        productoAGuardar.setEstaEliminado(false);

        Producto productoGuardado = productoRepository.save(productoAGuardar);

        return ProductoMapper.toResponseDto(productoGuardado);
    }
}