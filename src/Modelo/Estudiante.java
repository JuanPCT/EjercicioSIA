
package Modelo;

import ufps.util.colecciones_seed.ListaCD;


public class Estudiante {

    private int codigo;
    private String nombre;
    private boolean sexo;
    private ListaCD<Materia> materias;

    public Estudiante() {
        this.materias= new ListaCD<Materia>();
    }

    public Estudiante(int codigo, String nombre, boolean sexo) {
        this();
        this.codigo = codigo;
        this.nombre = nombre;
        this.sexo = sexo;
    }

    
    
    public void addMateria(Materia mat){
        this.materias.insertarInicio(mat);
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }
            
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaCD<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(ListaCD<Materia> materias) {
        this.materias = materias;
    }
    
    public String aprobo(){
        boolean aprobo;
        int promedio=0;
        for(Materia mat:this.materias){
            promedio+=mat.getNotaInt();
        }
        promedio=promedio/this.materias.getTamanio();
        if(promedio>=60)
            return codigo + " - " + nombre + " - Aprobo";
        else
            return codigo + " - " + nombre + " - Reprobo"; 
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre + " - " + materias.getTamanio() + " materias cursadas";
    }
    
    
            
    
}
