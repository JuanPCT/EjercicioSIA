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
    
    private ListaCD<Estudiante> estudiantes;

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

    //Metodo que devuelve los estudiantes aprobados de cada grado
    public String getAprobados(int i){
        String msg="";
        
        msg+="\n----------------------------------------------";
        msg+="\nGrado "+(i)+", Total de estudiantes : "+ this.getEstudiantes().getTamanio();

        for(Estudiante est:this.getEstudiantes()){

            msg+="\n "+est.aprobo();
        }
        
        
        return msg;
    }
    
    
    
}
