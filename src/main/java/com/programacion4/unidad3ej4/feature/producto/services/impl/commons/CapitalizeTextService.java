package com.programacion4.unidad3ej4.feature.producto.services.impl.commons;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej4.feature.producto.services.interfaces.commons.ICapitalizeTextService;

@Service
public class CapitalizeTextService implements ICapitalizeTextService {

    @Override
    public String capitalize(String text) {
        String normalized = text.trim().toLowerCase();
        return normalized.substring(0, 1).toUpperCase() + normalized.substring(1);
    }
}