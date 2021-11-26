/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Modelo.Estudiante;
import Modelo.Grado;
import Modelo.Materia;
import ufps.util.varios.ArchivoLeerURL;

/**
 *
 * @author madar
 */
public class SIA {
    
    private Grado[] grados= new Grado[6];

    public SIA() {
    }

    public SIA(String url) {
        crearGrados();
        crearEstudiantes(url);
        
    }
    
    private void crearGrados(){
        for (int i = 0; i < this.grados.length; i++) {
            this.grados[i] = new Grado();
        }
    }
    
    private void crearEstudiantes(String url){
        
        ArchivoLeerURL archivo = new ArchivoLeerURL(url);
        //Leer el archivo: 
        Object datos[] = archivo.leerArchivo();
        //i=1 , por que la cabecera NO se procesa
        //codigos;nombre de estudiante;email;semestre
        String datoMaterias = datos[0].toString();
        String datos2[] = datoMaterias.split(",");
        String nombresMaterias[] = new String[9];
        for (int i = 4; i < datos.length; i++) {
            nombresMaterias[i-4]=datos2[i];
        }
        
        for (int i = 1; i < datos.length; i++) {
            String datoEstudiante = datos[i].toString();
            String datosestudiantes[] = datoEstudiante.split(",");
            int codigo = Integer.parseInt(datos2[0]);
            String nombre = datos2[1];
            boolean sexo = Boolean.parseBoolean(datos2[2]);
            short grado = Short.parseShort(datos2[3]);
            
            //creo un objeto estudiante con los datos obtenidos del csv
            Estudiante estudiante=new Estudiante(codigo, nombre, sexo);
            
            //Guardo los nombres de las materias matematica,sociales,ingles,educación_física,artes,ciencias,lenguaje,fisica,quimica
            for (int j = 0; j < nombresMaterias.length; j++) {
                if(!datos2[j+4].equals("-")){
                    Materia materia = new Materia(nombresMaterias[i],datos2[j+4].charAt(0));
                    estudiante.addMateria(materia);
                } 
                
            }
            
            //Resto para coincidir con el índice del vector
            grado--;
            
            //Donde insertar ese estudiante?
            this.grados[grado].addEstudiante(estudiante);
            //System.out.println(fila.toString());
        }
        
    }
    
}
