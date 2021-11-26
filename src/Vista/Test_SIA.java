package Vista;
import Negocio.SIA;
import ufps.util.varios.*;
import ufps.util.colecciones_seed.*;
/**
 * Write a description of class Test_SIA here.
 * 
 * @author marco adarme
 * @version 1.0
 */
public class Test_SIA
{
   
    public static void main(String args[])
    {
        String url="https://gitlab.com/pruebas_madarme/persistencia/ed_c/sia/-/raw/main/sia-grupoC.csv";
        
        SIA sia = new SIA(url);
        
        System.out.println(sia.toString());
        System.out.println(sia.getAprobados(1));
        System.out.println(sia.getAprobados(2));
        System.out.println(sia.getAprobados(3));
        System.out.println(sia.getAprobados(4));
        System.out.println(sia.getAprobados(5));
        System.out.println(sia.getAprobados(6));
        
    }
    

    
}
