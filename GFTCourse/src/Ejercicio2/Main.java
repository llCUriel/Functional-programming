package Ejercicio2;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        Auxiliar<Estudiante> calculaEdad = x -> {
            String fechaDeNacimiento = x.getFecNacimiento();
            if(fechaDeNacimiento != null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                LocalDate fecNacDate = LocalDate.parse(fechaDeNacimiento, formatter);
                x.setEdad(Period.between(fecNacDate,LocalDate.now()).getYears());
            }
        };
        Auxiliar<Estudiante> calculaCarrera = x -> {
            String tmpValue = x.getCarrera();
            if (tmpValue == null)
                tmpValue = "Sin especificar";
            x.setCarrera(tmpValue);
        };
        Auxiliar<Estudiante> separaNombreCompleto = x -> {

            String nombreCompleto = x.getNombreCompleto();
            String nombre = "", apellidoPaterno = "", apellidoMaterno = "";

            if (nombreCompleto != null) {
                int espacios = obtenerEspacios(nombreCompleto);
                String[] parts = nombreCompleto.split(" ");

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
                    nombre = parts[0] + " " + parts[1];
                    apellidoPaterno = parts[2];
                    apellidoMaterno = parts[3];
                }  //  Nombre1_Nombre2_ApellidoPaterno_ApellidoMaterno

            }
            x.setNombre(nombre);
            x.setApellidoPaterno(apellidoPaterno);
            x.setApellidoMaterno(apellidoMaterno);
        };
        Auxiliar<Estudiante> calculaNombreCompleto = x ->{
            String nombreCompleto = x.getNombreCompleto();
            if (nombreCompleto == null)
                    nombreCompleto = "John Doe";

            x.setNombreCompleto(nombreCompleto);
        };

        Estudiante estudiante = new Estudiante(null, "05/03/1997", null, x -> {
            calculaEdad.procesaObjeto(x);
            calculaCarrera.procesaObjeto(x);
            calculaNombreCompleto.procesaObjeto(x);
            separaNombreCompleto.procesaObjeto(x);
        });

        System.out.println(estudiante.toString());

        // Estudiante{nombreCompleto='John Doe', fecNacimiento='05/03/1997', carrera='Sin especificar', nombre='John', apellidoPaterno='Doe', apellidoMaterno='', edad=23}
    }

    public static int  obtenerEspacios(String s) {
        String[] _name = s.split(" ");
        return _name.length-1;
    }
}
