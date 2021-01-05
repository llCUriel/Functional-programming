import java.util.function.Function;

public class MathOperations2 {
    public static void main(String[] args) {
        Function<Integer, Integer> multiplyBy3 = x -> {
            System.out.println("Multiplicando "+x+" por 3");
            return x*3;
        };
        Function<Integer,Integer> add1MultiplyBy3 =
                multiplyBy3.compose(y->{
                    System.out.println("Le agregaré 1 a :"+y);
                    return y+1;
                });

        Function<Integer,Integer> andSquare = add1MultiplyBy3.andThen(x->{
            System.out.println("Estoy elevando al cuadrado "+x);
            return x*x;
        });
        System.out.println(andSquare.apply(3));
    }
}
