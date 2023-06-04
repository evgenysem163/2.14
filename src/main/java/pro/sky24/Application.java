package pro.sky24;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        StringList stringList = new StringListImpl();
        stringList.add("test1");
        stringList.add("test2");
        stringList.add("test3");
        stringList.add("test4");
        stringList.add(3, "test6");
        System.out.println(Arrays.toString(stringList.toArray()));
        stringList.remove(1);
        System.out.println(Arrays.toString(stringList.toArray()));
        stringList.clear();
        System.out.println(stringList.size());
    }
}