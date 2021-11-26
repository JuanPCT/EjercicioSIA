/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufps.util.colecciones_seed;

import Negocio.*;
import java.util.Arrays;

/**
 * Nuestra primera estructura : Vector--> de objetos
 *
 * @author madarme
 */
public class Secuencia<T> implements Comparable {

    private T[] numeros;

    public Secuencia() {
    }

    public Secuencia(int cant) {
        if (cant <= 0) {
            throw new RuntimeException("No se puede crear el vector");
        }

        Object temp[] = new Object[cant];
        //middlercasting:
        this.numeros = (T[]) temp;

    }

    /**
     * Adiciona un número en la posición i
     *
     * @param i indice donde se va a ingresar el dato
     * @param numeroNuevo el dato a ingresar
     */
    public void adicionar(int i, T numeroNuevo) {
        this.validar(i);
        this.numeros[i] = numeroNuevo;
    }

    public T getElemento(int i) {

        this.validar(i);
        return this.numeros[i];
    }

    private void validar(int i) {
        if (i < 0 || i >= this.numeros.length) {
            throw new RuntimeException("Índice fuera de rango:" + i);
        }
    }

    /*
        ES REDUNDANTE
    **/
    public void actualizar(int i, T numeroNuevo) {
        this.adicionar(i, numeroNuevo);
    }

    public T[] getNumeros() {
        return numeros;
    }

    public void setNumeros(T[] numeros) {
        this.numeros = numeros;
    }

    @Override
    public String toString() {
        String msg = "";
        /*
            Cuando sólo son recorridos, usamos el foreach
            for(T elemento:coleccion)
                hacer algo con elemento;
         */

        for (T dato : this.numeros) {
            msg += dato + "\t";
        }
        return msg;
    }

    public int length() {
        return this.numeros.length;
    }

    /**
     * Elimina la posición i del vector y REDIMENSIONA EL VECTOR
     *
     * @param i la posición a eliminar
     */
    public void eliminar(int i) {

    }

    /**
     * Ordena el vector por el método de la burbuja funcione la clase T debe
     * tener compareTo
     */
    public void ordenar_Burbuja() {
        T temp = null;
        for (int i = 0; i < this.numeros.length; i++) {
            for (int j = 1; j < (this.numeros.length - i); j++) {
                int c = ((Comparable) (this.numeros[j - 1])).compareTo(this.numeros[j]);
                if (c > 0) {
                    temp = this.numeros[j - 1];
                    this.numeros[j - 1] = this.numeros[j];
                    this.numeros[j] = temp;
                }
            }
        }

    }

    /**
     * Ordena el vector por el método de selección
     */
    public void ordenar_Seleccion() {

    }

    /**
     * Retorna una lista de numeros con la unión de conjuntos de lista original
     * con lista dos.
     *
     * Se debe validar que la listanueva contenga UNICAMENTE LA CANTIDAD DE
     * CELDAS REQUERIDAS
     *
     * Ejemplo: this={3,4,5,6} y dos={3,4} ListaNueva = {3,4,5,6}
     *
     * @param dos una lista de numeros
     * @return una nueva lista con la unión de conjuntos
     */
    public Secuencia getUnion(Secuencia dos) {

        // :)
        return null;
    }

    /**
     * Retorna una lista de numeros con la INTERSECCION de conjuntos de lista
     * original con lista dos.
     *
     * Se debe validar que la listanueva contenga UNICAMENTE LA CANTIDAD DE
     * CELDAS REQUERIDAS
     *
     * Ejemplo: this={3,4,5,6} y dos={3,4} ListaNueva = {3,4}
     *
     * @param dos una lista de numeros
     * @return una nueva lista con la unión de conjuntos
     */
    public Secuencia getInterseccion(Secuencia dos) {

        // :)
        return null;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Arrays.hashCode(this.numeros);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Secuencia other = (Secuencia) obj;

        if (this.numeros.length != other.numeros.length) {
            return false;
        }

        for (int i = 0; i < this.numeros.length; i++) {
            if (this.numeros[i] != other.numeros[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Una lista es mayor a otra si y solo si: 1. Tienen el mismo tamaño 2.
     * Todos los elementos de la lista1 son mayores a los de la lista 2 en orden
     * ( suponga que la lista 1 y 2 se encuentra ordenada)
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
