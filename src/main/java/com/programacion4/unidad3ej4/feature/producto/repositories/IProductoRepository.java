package com.programacion4.unidad3ej4.feature.producto.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.programacion4.unidad3ej4.feature.producto.models.Producto;

@Repository
public interface IProductoRepository extends CrudRepository<Producto, Long> {

    boolean existsByNombreAndEstaEliminadoFalse(String nombre);

    List<Producto> findAllByEstaEliminadoFalse();

    Optional<Producto> findByIdAndEstaEliminadoFalse(Long id);
}