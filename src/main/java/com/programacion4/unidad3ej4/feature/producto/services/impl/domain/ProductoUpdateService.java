package com.programacion4.unidad3ej4.feature.producto.services.impl.domain;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej4.feature.producto.dtos.request.ProductoUpdateRequestDto;
import com.programacion4.unidad3ej4.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej4.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej4.feature.producto.models.Categoria;
import com.programacion4.unidad3ej4.feature.producto.models.Producto;
import com.programacion4.unidad3ej4.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.commons.ICapitalizeTextService;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.commons.ICategoriaFindByIdService;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.commons.IProductoFindActiveByIdService;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.domain.IProductoUpdateService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ProductoUpdateService implements IProductoUpdateService {

    private final IProductoFindActiveByIdService productoFindActiveByIdService;
    private final ICategoriaFindByIdService categoriaFindByIdService;
    private final ICapitalizeTextService capitalizeTextService;
    private final IProductoRepository productoRepository;

    @Override
    public ProductoResponseDto update(Long id, ProductoUpdateRequestDto dto) {
        Producto producto = productoFindActiveByIdService.findById(id);
        Categoria categoria = categoriaFindByIdService.findById(dto.getCategoriaId());

        producto.setNombre(capitalizeTextService.capitalize(dto.getNombre()));
        producto.setCodigo(dto.getCodigo());
        producto.setDescripcion(capitalizeTextService.capitalize(dto.getDescripcion()));
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        producto.setCategoria(categoria);

        Producto productoActualizado = productoRepository.save(producto);

        return ProductoMapper.toResponseDto(productoActualizado);
    }
}