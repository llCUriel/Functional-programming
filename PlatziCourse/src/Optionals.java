import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Optionals {

    public static void main(String[] args) {
        List<String> names = getNames();
        if(names != null){
            // Operar con nombres
        }
    }

    static List<String> getNames(){
        List<String> list = new LinkedList<>();
        return Collections.emptyList();
    }

    static String mostValuablePlayer(){
        return null;
    }

    static int mostExpensiveItem(){
        return -1;
    }
}
