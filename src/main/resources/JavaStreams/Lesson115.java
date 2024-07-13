package main.resources.JavaStreams;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Lesson115 {


    // @Test
    public void regular() {


        ArrayList<String> names = new ArrayList<String>();
        names.add("Abhijeet");
        names.add("Don");
        names.add("Arnold");
        names.add("Adam");
        names.add("Ram");
        int count = 0;

        for (int i = 0; i < names.size(); i++) {

            String actualName = names.get(i);
            if (actualName.startsWith("A")) {
                count++;
            }

            System.out.println(count);
        }


    }

    public void streamFilter() {

        ArrayList<String> names = new ArrayList<String>();
        names.add("Abhijeet");
        names.add("Don");
        names.add("Arnold");
        names.add("Adam");
        names.add("Ram");

        Long c = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(c);


        Long d = Stream.of("Abhijeet", "Don", "Arnold", "Adam", "Ram").filter(s ->
                {
                    s.startsWith("A");
                    return true;
                }
        ).count();


        System.out.println(d);

        // print all the names in the ArrayList

        // 1: Without limit
        //names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.print(s));

        // 2: With limit
        names.stream().filter(s -> s.length() > 4).limit(1).forEach(System.out::print);
    }


    @Test
    public void streamMap() {

        ArrayList<String> names = new ArrayList<String>();;

        // print names which have last letter as "a" in Uppercase


        /* Stream.of("Abhijeet", "Don", "Alekhya", "Arnold", "Adam", "Rama")
                .filter(s -> s.endsWith("a"))
                .map(m -> m.toUpperCase()).forEach(System.out::println); */

        // print names which have first letter as "a" in Uppercase and sorted

        List<String> names1 = Arrays.asList("Abhijeet", "Don", "Alekhya", "Arnold", "Adam", "Rama");
        names1.stream().filter(s -> s.startsWith("A")).sorted().map(m -> m.toUpperCase()).forEach(System.out::println);

        // merging two streams
        Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
        newStream.sorted().forEach(System.out::println);

    }


}
