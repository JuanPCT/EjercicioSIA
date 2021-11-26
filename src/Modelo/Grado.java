/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import ufps.util.colecciones_seed.ListaCD;

/**
 *
 * @author madar
 */
public class Grado {
    
    ListaCD<Estudiante> estudiantes;

    public Grado() {
        estudiantes=new ListaCD<Estudiante>();
    }
    
    public void addEstudiante(Estudiante est){
        this.estudiantes.insertarInicio(est);
    }

    public ListaCD<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ListaCD<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
    
    
}
