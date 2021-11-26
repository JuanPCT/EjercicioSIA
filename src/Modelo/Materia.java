
package Modelo;


public class Materia {

    private String nombre;
    private char nota;

    public Materia(String nombre, char nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getNota() {
        return nota;
    }

    public void setNota(char nota) {
        this.nota = nota;
    }
    
    
    
}
