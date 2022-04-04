package Optionals;

import org.checkerframework.checker.nullness.Opt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        //Examples
        // 1 - Optional.of - Creating Optional
        Optional<Integer> number = Optional.of(5);
        System.out.println(number.get());

        // 2 - Optional isPresent or isEmpty - check value before call

        Optional<Integer> number1 = Optional.empty();

        if (number.isPresent()) {
            System.out.println(number.get());
        } else {
            System.out.println("Value is not present.");
        }

        // 3 - Optional.ofNullable - maybe value is null. If we give null to Optional.of(), we will get a nullPointerException,
        //but in case we give null to Optional.ofNullable, Optional will be empty.

        Optional<Integer> number2 = Optional.ofNullable(null);
        System.out.println(number2.isEmpty());

        // 4 - orElse and orElseGet and orElseThrow (allows to mechanically throw an exception)

        Optional<Integer> number3 = Optional.empty();
        System.out.println(number3.orElse(10));
        System.out.println(number3.orElseGet(() -> 100));
        //System.out.println(number3.orElseThrow(IllegalStateException::new));

        // 5 - Optional Map

        var integerValue = Optional.<Integer>empty();
        integerValue = Optional.of(45);

        System.out.println(integerValue.map(i -> i + " Lines").get());
        System.out.println(integerValue.map(i -> i + " Lines").orElse("No Line"));

        // 6 - Filter

        var filterValue = Optional.<Integer>empty();
        filterValue = Optional.of(40);

        System.out.println(filterValue.filter(i -> i == 2).orElse(10));

        // 7 - Optional ifPresent

        var ifPresent = Optional.<Integer>empty();
        ifPresent = Optional.of(45);

        ifPresent.ifPresent(i -> System.out.println(i));
        ifPresent.ifPresentOrElse(
                i -> System.out.println(i),
                () -> System.out.println("No Value"));

        // 8 - Optional NonNullReturn


        // NullPointerException
        /*Person person = getPerson(3);
        System.out.println(person.getName());*/

        Optional<Person> person = getPersonOptiona(5);
        //System.out.println(person.get().getName());
        person.ifPresentOrElse(
                p -> System.out.println(p.getName()),
                        () -> System.out.println("Is not present")
                );
    }

    public static Person getPerson(int id) {
        Person person = null;

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Vahe", 22));
        personList.add(new Person("Poxos", 50));

        if (id >= 0 && id <= personList.size()) {
            person = personList.get(id);
        }
        return person;
    }

    public static Optional<Person> getPersonOptiona(int id) {
        Optional<Person> person = Optional.empty();

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Vahe", 22));
        personList.add(new Person("Poxos", 50));

        if (id >= 0 && id <= personList.size()) {
            person = Optional.of(personList.get(id));
        }
        return person;
        // or we can return Optional.ofNullable(person) instead of changing all lines to Optional.
    }
}

