package Ejercicio1;

import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        Integer a= 5, b = 10, c =  9102019, d = 9102018, e = 2442;

        System.out.println(isLessThan(a,b));        // true   5 < 10
        System.out.println(isGreaterThan(a,b));     // false  5 > 10
        System.out.println(isGreaterThan(b,a));     // true   10 > 5
        System.out.println(isDivisorOf(a,b));       // true   5       is a divisor of 10?
        System.out.println(isDivisorOf(b,a));       // false  10      is a divisor of 5?
        System.out.println(isMultipleOf(a,b));      // false  5       is a multiple of 10?
        System.out.println(isMultipleOf(b,a));      // true   10      is a multiple of 5?
        System.out.println(isPalindromicNumber(c)); // true   9102019 is a palindromic number?
        System.out.println(isPalindromicNumber(d)); // false  9102018 is a palindromic number?
        System.out.println(isPalindromicNumber(e)); // true   2442    is a palindromic number?

    }

    public static boolean isLessThan(int a, int b){
        NumberComparator c = (int x, int y) -> x < y;
        return c.compare(a,b);
    }

    public static boolean isGreaterThan(int a, int b){
        NumberComparator c = (int x, int y) ->  x > y;
        return c.compare(a,b);
    }

    public static boolean isDivisorOf(int a, int b){
        NumberComparator c = (int x, int y) ->  y % x == 0;
        return c.compare(a,b);
    }

    public static boolean isMultipleOf(int number, int multiple){
        NumberComparator c = (int x, int y) -> x % y == 0;
        return c.compare(number,multiple);
    }

    public static boolean isPalindromicNumber(int a){
        Predicate<Integer> c = x -> {
            String tmpValue = Integer.toString(x);
            String reverseString = new StringBuilder(tmpValue).reverse().toString();
            return reverseString.equals(tmpValue) ;
        };
        return c.test(a);
    }
}
