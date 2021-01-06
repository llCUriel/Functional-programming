package Ejercicio2;

public class Estudiante {
    private String nombreCompleto;
    private String fecNacimiento;
    private String carrera;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int edad;
    private Auxiliar<Estudiante> aux;

    public Estudiante(String nombre, String fecNacimiento, String carrera) {
        super();
        this.nombreCompleto=nombre;
        this.fecNacimiento=fecNacimiento;
        this.carrera=carrera;
    }

    public Estudiante(String nombre, String fecNacimiento, String carrera, Auxiliar<Estudiante> aux) {
        super();
        this.nombreCompleto=nombre;
        this.fecNacimiento=fecNacimiento;
        this.carrera=carrera;
        this.aux=aux;
        aux.ejecutarAccion(this);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecNacimiento() {
        return fecNacimiento;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setFecNacimiento(String fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", fecNacimiento='" + fecNacimiento + '\'' +
                ", carrera='" + carrera + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", edad=" + edad +
                '}';
    }
}