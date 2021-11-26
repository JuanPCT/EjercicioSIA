/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufps.util.colecciones_seed;

/**
 * Clase que representa un nodo doble
 *
 * @author madarme
 */
class NodoD<T> {

    private T info;
    private NodoD<T> sig;
    private NodoD<T> ant;

     NodoD() {
    }

     NodoD(T info, NodoD<T> sig, NodoD<T> ant) {
        this.info = info;
        this.sig = sig;
        this.ant = ant;
    }

     T getInfo() {
        return info;
    }

     void setInfo(T info) {
        this.info = info;
    }

     NodoD<T> getSig() {
        return sig;
    }

     void setSig(NodoD<T> sig) {
        this.sig = sig;
    }

     NodoD<T> getAnt() {
        return ant;
    }

     void setAnt(NodoD<T> ant) {
        this.ant = ant;
    }

}
