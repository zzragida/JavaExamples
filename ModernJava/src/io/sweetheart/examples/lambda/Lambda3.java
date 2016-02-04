package io.sweetheart.examples.lambda;

import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda3 {
    @FunctionalInterface
    interface Foo {
        void foo();
    }

    public static void main(String[] args) throws Exception {
        // Predicates
        Predicate<String> predicate = (s) -> s.length() > 0;

        predicate.test("foo");
        predicate.negate().test("foo");

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        // Functions
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        backToString.apply("123");

        // Suppliers
        Supplier<Person> personSupplier = Person::new;
        personSupplier.get();

        // Comsumers
        Consumer<Person> greeter = (p) -> System.out.println("Hello " + p.firstName);
        greeter.accept(new Person("Luke", "Skywalker"));

        // Comparators
        Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);
        Person p1 = new Person("Jone", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        comparator.compare(p1, p2);
        comparator.reversed().compare(p1, p2);

        // Runnables
        Runnable runnable = () -> System.out.println(UUID.randomUUID());
        runnable.run();

        // Callables
        Callable<UUID> callable = UUID::randomUUID;
        callable.call();
    }
}
