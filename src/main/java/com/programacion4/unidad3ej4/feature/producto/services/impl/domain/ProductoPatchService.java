package com.programacion4.unidad3ej4.feature.producto.services.impl.domain;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej4.feature.producto.dtos.request.ProductoPatchRequestDto;
import com.programacion4.unidad3ej4.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej4.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej4.feature.producto.models.Producto;
import com.programacion4.unidad3ej4.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.commons.ICategoriaFindByIdService;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.commons.IProductoFindActiveByIdService;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.domain.IProductoPatchService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoPatchService implements IProductoPatchService {

    private final IProductoFindActiveByIdService productoFindActiveByIdService;
    private final ICategoriaFindByIdService categoriaFindByIdService;
    private final IProductoRepository productoRepository;

    @Override
    public ProductoResponseDto patch(Long id, ProductoPatchRequestDto dto) {
        Producto producto = productoFindActiveByIdService.findById(id);

        if (dto.getPrecio() != null) {
            producto.setPrecio(dto.getPrecio());
        }

        if (dto.getStock() != null) {
            producto.setStock(dto.getStock());
        }

        if (dto.getCategoriaId() != null) {
            producto.setCategoria(categoriaFindByIdService.findById(dto.getCategoriaId()));
        }

        Producto productoActualizado = productoRepository.save(producto);

        return ProductoMapper.toResponseDto(productoActualizado);
    }
}