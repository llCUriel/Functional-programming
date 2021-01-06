package Ejercicio2;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

        Auxiliar<Estudiante> calculaEdad = x -> {
            LocalDate fecNacDate = LocalDate.parse(x.getFecNacimiento(),formatter);
            x.setEdad(Period.between(fecNacDate,LocalDate.now()).getYears());
        };

        Auxiliar<Estudiante> calculaCarrera = x -> {
            String tmpValue = x.getCarrera();
            if (tmpValue == null)
                tmpValue = "Sin especificar";
            x.setCarrera(tmpValue);
        };

        Auxiliar<Estudiante> separaNombreCompleto = x -> {

            String nombreCompleto = x.getNombreCompleto();
            int espacios = obtenerEspacios(nombreCompleto);
            String[] parts = nombreCompleto.split(" ");

            String  nombre = "",
                    apellidoPaterno = "",
                    apellidoMaterno = "";

            if (espacios == 0) {
                nombre = parts[0];
            }  //  Nombre1
            if (espacios == 1) {
                nombre = parts[0];
                apellidoPaterno = parts[1];
            }  //  Nombre1_ApellidoPaterno
            if (espacios == 2) {
                nombre = parts[0];
                apellidoPaterno = parts[1];
                apellidoMaterno = parts[2];
            }  //  Nombre1_ApellidoPaterno_ApellidoMaterno
            if (espacios == 3) {
                nombre = parts[0] +" "+ parts[1];
                apellidoPaterno = parts[2];
                apellidoMaterno = parts[3];
            }  //  Nombre1_Nombre2_ApellidoPaterno_ApellidoMaterno

            x.setNombre(nombre);
            x.setApellidoPaterno(apellidoPaterno);
            x.setApellidoMaterno(apellidoMaterno);
        };



        Estudiante estudiante = new Estudiante("Cesar Uriel Hernandez Castellanos", "05/03/1997", null, x -> {
            calculaEdad.procesaObjeto(x);
            calculaCarrera.procesaObjeto(x);
            separaNombreCompleto.procesaObjeto(x);
        });

        System.out.println(estudiante.toString());

}

    public static int  obtenerEspacios(String s) {
        int espacios = 1;
        String[] _name = s.split(" ");
        espacios = _name.length-1;
        return espacios;
    }
}
