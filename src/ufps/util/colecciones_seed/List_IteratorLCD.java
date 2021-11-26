/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufps.util.colecciones_seed;

import java.util.ListIterator;

/**
 *
 * @author madarme
 */
public class List_IteratorLCD<T> implements ListIterator<T> {

    private NodoD<T> inicio;
    private NodoD<T> cabeza;

    public List_IteratorLCD(NodoD<T> cabeza) {
        this.cabeza = cabeza;
        this.inicio = this.cabeza.getAnt();
    }

    @Override
    public boolean hasPrevious() {
        return this.inicio != this.cabeza;
    }

    @Override
    public T previous() {
        if (this.inicio == this.cabeza) {
            throw new RuntimeException("No hay más datos a recorrer");
        }
        this.inicio = this.inicio.getAnt();
        return this.inicio.getSig().getInfo();
    }

    /**
     * ***
     * NO SE VAN A IMPLEMENTAR, USAMOS ITERATOR
     *
     * @return
     */
    @Override
    public boolean hasNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T next() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int nextIndex() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int previousIndex() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void set(T e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(T e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
