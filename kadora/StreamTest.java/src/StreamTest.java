import java.util.List;
import  java.util.Arrays;


public class StreamTest{
    public static void main(String[] args){
        List<String> list = Arrays.asList("banana","peach","pineapple");
        list.stream()
            .filter(s -> s.length() >= 6)
            .map(s -> s.toUpperCase())
            .forEach(s -> System.out.println(s));
    }
}
