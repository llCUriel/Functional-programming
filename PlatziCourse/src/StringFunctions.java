import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class StringFunctions {
    public static void main(String[] args) {
        UnaryOperator<String> quote = text -> "\""+text+"\"";
        UnaryOperator<String> addMark = text -> text+"!";
        System.out.println(quote.apply("Hola estudiante de platzi"));
        System.out.println(addMark.apply("Hola"));

        BiFunction<Integer,Integer, Integer> multiplicacion = (x,y) -> x*y;
        BinaryOperator<Integer> mult = (x,y) -> x*y;
        BiFunction<String, Integer, String> leftPad = (text,number) -> String.format("%"+number + "s",text);
        System.out.println(leftPad.apply("Java",5));
        //List<BiFunction<String,Integer,String>> formateadores

    }
}
