/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufps.util.colecciones_seed;

import java.util.Iterator;

/**
 * Clase que modela una lista simple enlazada genérica
 *
 * @author madarme
 */
public class ListaS<T> implements Iterable<T>{

    private Nodo<T> cabeza = null; //Es redundante--> por aclaración
    private int tamanio;

    public ListaS() {
    }

    public int getTamanio() {
        return tamanio;
    }

    public void insertarInicio(T info) {
        Nodo<T> nuevo = new Nodo(info, this.cabeza); //Creación (new)
        this.cabeza = nuevo;
        this.tamanio++;

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

    public void insertarFin(T info) {
        /*
        En términos generales el adicionar el fin:
        Buscar el último elemento
        El siguiente del último “es el nuevo” y “el siguiente
        del nuevo es null” 
        Aumentar cardinalidad

         */

        if (this.esVacia()) {
            this.insertarInicio(info);
        } else {
            Nodo<T> ultimo = this.getPos(tamanio - 1);
            ultimo.setSig(new Nodo(info, null));
            this.tamanio++;
        }
    }

    private void validarIndice(int i) {
        if (this.esVacia() || i < 0 || i >= this.getTamanio()) {
            throw new RuntimeException("No es posible encontrar la dirección del nodo");
        }

    }

    private Nodo<T> getPos(int i) {
        this.validarIndice(i);
        //pos es un objeto , i es un entero
        int con = 0;
        Nodo<T> pos;
        for (pos = this.cabeza; con < i; pos = pos.getSig()) {
            con++;
        }
        return pos;
    }

    public void borrarTodo() {
        this.tamanio = 0;
        this.cabeza = null;
    }

    @Override
    public String toString() {
        String msg = "Cabeza->";
        //referenciación: Nodo<T> inicio=this.cabeza
        for (Nodo<T> inicio = this.cabeza; inicio != null; inicio = inicio.getSig()) {
            //inicio.getInfo()--> es T (String, Persona, Monomio...)
            msg += inicio.getInfo().toString() + "->";
        }
        return msg + "null";
    }

    public boolean esVacia() {
        return this.cabeza == null; //this.tamanio==0
    }

    public T[] toArray() {
        if (this.esVacia()) {
            throw new RuntimeException("No se puede crear convertir la lista a un vector, por que está es vacía");
        }
        Object temp[] = new Object[this.tamanio];

        int i = 0;
        for (Nodo<T> inicio = this.cabeza; inicio != null; inicio = inicio.getSig()) {
            temp[i] = inicio.getInfo();
            i++;
        }
        return (T[]) (temp);
    }

    public Object[] toArray2() {
        if (this.esVacia()) {
            throw new RuntimeException("No se puede crear convertir la lista a un vector, por que está es vacía");
        }
        Object temp[] = new Object[this.tamanio];

        int i = 0;
        for (Nodo<T> inicio = this.cabeza; inicio != null; inicio = inicio.getSig()) {
            temp[i] = inicio.getInfo();
            i++;
        }
        return (temp);
    }

    /**
     * Verifica que un elemento exista en la lista simple
     *
     * @param elemento un objeto a buscar en la lista
     * @return true si el elemento existe, false en caso contrario
     */
    //https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/List.html#contains(java.lang.Object)
    public boolean contains(T elemento) {
        if (this.esVacia() || elemento == null) {
            throw new RuntimeException("No se puede buscar  por que está es vacía lista o elemento es null");
        }
        for (Nodo<T> inicio = this.cabeza; inicio != null; inicio = inicio.getSig()) {
            if (inicio.getInfo().equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public T remove(int indice_elemento_borrar) {

        Nodo<T> borrar = this.cabeza;
        if (indice_elemento_borrar == 0 && !this.esVacia()) {
            this.cabeza = this.cabeza.getSig();
        } else {
            Nodo<T> ant_borrar = this.getPos(indice_elemento_borrar - 1);
            borrar = ant_borrar.getSig();
            ant_borrar.setSig(borrar.getSig());
        }
        this.tamanio--;
        borrar.setSig(null);
        return borrar.getInfo();
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorLS(this.cabeza);
    }

}
