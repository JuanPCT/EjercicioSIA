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
public class IteratorLCD<T> implements Iterator<T> {

    private NodoD<T> inicio;
    private NodoD<T> cabeza;

    IteratorLCD(NodoD<T> inicio) {
        this.cabeza = inicio;
        this.inicio = this.cabeza.getSig();
    }

    @Override
    public boolean hasNext() {
        return this.inicio != this.cabeza;
    }

    @Override
    public T next() {
        if (this.inicio == this.cabeza) {
            throw new RuntimeException("No hay más datos a recorrer");
        }
        this.inicio = this.inicio.getSig();
        return this.inicio.getAnt().getInfo();

    }

}
