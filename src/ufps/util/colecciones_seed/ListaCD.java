/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufps.util.colecciones_seed;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * Clase que modela una lista circular doblemente enlazada con nodo cabecera
 * (centinela)
 *
 * @author madarme
 */
public class ListaCD<T> implements Iterable<T> {

    private NodoD<T> cabecera;
    private int tamanio;

    public ListaCD() {
        this.cabecera = new NodoD();
        //Esto es redundante, sólo es por concepto:
        this.cabecera.setInfo(null);
        this.cabecera.setSig(cabecera);
        this.cabecera.setAnt(cabecera);
    }

    public void insertarInicio(T info) {
        this.cabecera.setSig(new NodoD(info, this.cabecera.getSig(), this.cabecera));
        this.cabecera.getSig().getSig().setAnt(this.cabecera.getSig());
        this.tamanio++;
    }

    public void insertarFin(T info) {
        this.cabecera.setAnt(new NodoD(info, this.cabecera, this.cabecera.getAnt()));
        this.cabecera.getAnt().getAnt().setSig(this.cabecera.getAnt());
        this.tamanio++;
    }

    public int getTamanio() {
        return tamanio;
    }

    @Override
    public String toString() {
        String msg = "Cab->";
        //referenciación: NodoD<T> inicio=this.cabeza
        for (NodoD<T> inicio = this.cabecera.getSig(); inicio != this.cabecera; inicio = inicio.getSig()) {
            //inicio.getInfo()--> es T (String, Persona, Monomio...)
            msg += inicio.getInfo().toString() + "<->";
        }
        return msg + "Cab";
    }

    private void validarIndice(int i) {
        if (this.esVacia() || i < 0 || i >= this.getTamanio()) {
            throw new RuntimeException("No es posible encontrar la dirección del nodo");
        }

    }

    public T get(int i) {
        try {
            return this.getPos(i).getInfo();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void set(int i, T info) {
        try {
            this.getPos(i).setInfo(info);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public boolean esVacia() {
        return this.cabecera == this.cabecera.getSig() && this.cabecera == this.cabecera.getAnt();
    }

    private NodoD<T> getPos(int i) {
        this.validarIndice(i);
        //pos es un objeto , i es un entero
        int con = 0;
        NodoD<T> pos;
        for (pos = this.cabecera.getSig(); con < i; pos = pos.getSig()) {
            con++;
        }
        return pos;
    }

    /**
     * Método inserta un dato antes del nodo de posición "i", SI Y SOLO SI, el
     * dato no existe en la lista. Ejemplo: L=<3,7,1,78> ,
     * L.insertarAntes(2,1)-->"Error existe 1" Ejemplo: L=<3,7,1,78> ,
     * L.insertarAntes(5,10)-->"Error índice fuera de rango" Ejemplo:
     * L=<3,7,1,78> , L.insertarAntes(2,10)-->L=<3,7,10,1,78>
     *
     * @param i índice del nodo donde se irá a producir la inserción
     * @param info el elemento a insertar
     */
    public void insertarAntes(int i, T info) {
        // :)
    }

    public void insertarOrdenado(T info) {
        if (this.esVacia()) {
            this.insertarInicio(info);
        } else {
            NodoD<T> x = this.cabecera;
            NodoD<T> y = x;
            x = x.getSig();
            while (x != this.cabecera) {
                Comparable comparador = (Comparable) info;
                int rta = comparador.compareTo(x.getInfo());
                if (rta < 0) {
                    break;
                }
                y = x;
                x = x.getSig();
            }
            if (x == this.cabecera.getSig()) {
                this.insertarInicio(info);
            } else {
                y.setSig(new NodoD(info, x, y));
                x.setAnt(y.getSig());
                this.tamanio++;
            }
        }
    }

    public T eliminar(int i) {
        this.validarIndice(i);
        NodoD<T> a;
        if (i == 0) {
            a = this.cabecera.getSig();
            this.cabecera.setSig(a.getSig());
            this.cabecera.getSig().setAnt(this.cabecera);
        } else {
            a = getPos(i);
            a.getAnt().setSig(a.getSig());
            a.getSig().setAnt(a.getAnt());

        }
        a.setSig(a);
        a.setAnt(a);
        this.tamanio--;
        return a.getInfo();
    }

    /**
     * Concatena dos listas. La lista que se pasa como parámetro es borrada, los
     * nodos de la segunda lista pasan a la primera. NO SE PUEDEN CREAR NODOS.
     *
     * Ejemplo: Caso1: L1=<> y L2=<> --> nada. Caso2: L1=<1,2,3> y L2=<> -->
     * nada. L1=<> y Caso3: L2=<1,2,3> --> L1=<1,2,3> y L2=<>
     * Caso4: L1=<4,5> y L2=<1,2,3> --> L1=<4,5,1,2,3> y L2=<>
     *
     * @param L una lista circular doble enlazada.
     */
    public void concatenar(ListaCD<T> L) {
        if (L.esVacia()) {
            throw new RuntimeException("No es posible realizar concatenación");
        }

        NodoD pos = this.cabecera.getAnt();//this.getPos(tamanio-1);
        pos.setSig(L.cabecera.getSig());
        L.cabecera.getSig().setAnt(pos);
        NodoD<T> pos2 = L.cabecera.getAnt();//L.getPos(tamanio - 1);
        this.cabecera.setSig(pos2);
        pos2.setAnt(this.cabecera);
        L.cabecera.setSig(L.cabecera);
        L.cabecera.setAnt(L.cabecera);
        this.tamanio += L.tamanio;
        L.tamanio = 0;

    }

    /**
     * Concatena L después de la posición "pos". Ejemplo: L=<1,2,3,4> y
     * L2=<9,0,7> --> L.concat(L2,2)--> L=<1,2,3,9,0,7,4> y L2=<>
     *
     *   MÉTODO REALIZADO POR EL COMPAÑERO ANDERSON EFRAÍN QUINTERO MADARIAGA
     * @param L lista a concatener
     * @param pos posición donde se va a insertar la lista.
     */
    public void concatenar(ListaCD<T> L, int pos) {
        if (L.esVacia() || this.esVacia()) {
            throw new RuntimeException("No es posible realizar concatenación, "
                    + (this.esVacia()
                    ? "Lista 1 vacía"
                    : (L.esVacia() ? "Lista 2 vacía" : "Ambas listas vacías")));
        }
        NodoD<T> a = this.getPos(pos);
        NodoD<T> b = a.getSig();
        NodoD<T> c = L.cabecera.getAnt();
        a.setSig(L.cabecera.getSig());
        L.cabecera.getSig().setAnt(a);

        b.setAnt(c);
        c.setSig(b);

        L.cabecera.setSig(L.cabecera);
        L.cabecera.setAnt(L.cabecera);
        this.tamanio += L.tamanio;
        L.tamanio = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorLCD<>(this.cabecera);
    }

    public ListIterator<T> list_iterator() {
        return new List_IteratorLCD<>(this.cabecera);
    }

}
