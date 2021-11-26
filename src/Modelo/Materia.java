
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
    
    public int getNotaInt(){
        switch (nota) {
            case 'E':
                return 100;
            case 'B':
                return 80;
            case 'A':
                return 60;
            case 'D':
                return 30;
            default:
                throw new AssertionError();
            
        }
    }

    public char getNota() {
        return nota;
    }

    public void setNota(char nota) {
        this.nota = nota;
    }
    
    
    
}
