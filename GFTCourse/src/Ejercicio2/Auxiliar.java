package Ejercicio2;

public interface Auxiliar<T> {
    default T procesaObjeto(T observado){
        this.ejecutarAccion(observado);
        return observado;
    }

    void ejecutarAccion(T observado);
}
