import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Sintaxis {
    public static void main(String[] args) {
        List<String> cursos = NombresUtils.getList("Java","Functional");
        cursos.forEach(curso -> System.out.println(curso));
        //BiFunction<Integer,Integer,Integer> s = (x,y) -> x*y;
        useZero(()->2);
        usePredicate(text -> text.isEmpty());
        useBifunction((x,y) -> x*y);

        useBifunction((x,y)->{
            System.out.println("X:" +x + ", Y:"+y);
            return x-y;
        });
        useNothing(()->{
            System.out.println("Hello world");
        });

        useBifunction((Integer x, Integer y) -> x*y);
    }

    static void useZero(ZeroArguments zeroArguments){

    }

    static void usePredicate(Predicate<String> predicado){

    }

    static void useBifunction(BiFunction<Integer,Integer,Integer> operacion){

    }

    static void useNothing(nothing n){

    }

    @FunctionalInterface
    interface ZeroArguments{
        int get();
    }

    @FunctionalInterface
    interface nothing{
        void nothing();
    }
}
