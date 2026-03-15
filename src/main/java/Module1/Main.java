package Module1;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args){
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Ваня");
        ImmutableClass immutableClass = new ImmutableClass(1, "Ваня", map);
        System.out.println("Запись до: " + immutableClass);
        map.put(2, "Петя");
        System.out.println("Запись после: " + immutableClass);

        Map<Integer, String> retrievedMap = immutableClass.getMap();
        retrievedMap.put(3, "попытка изменить");
        System.out.println("Запись после изменения геттера: " + immutableClass);
    }
}