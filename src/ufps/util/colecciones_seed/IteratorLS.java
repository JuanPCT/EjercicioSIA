/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufps.util.colecciones_seed;

import java.util.Iterator;

/**
 *
 * @author madar
 */
public class IteratorLS<T> implements Iterator<T> {

    private Nodo<T> inicio;

    IteratorLS(Nodo<T> inicio) {
        this.inicio = inicio;
    }

    @Override
    public boolean hasNext() {
        return this.inicio != null;
    }

    @Override
    public T next() {
        if (this.inicio == null) {
            throw new RuntimeException("No hay más datos a recorrer");
        }
        T dato = this.inicio.getInfo();
        this.inicio = this.inicio.getSig();
        return dato;

    }

}
