import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        //Задание 1
        //Написать Predicate, который проверяет, является ли число положительным.
        //То есть, если число положительное, то предикат должен возвращать true, в противном случае false.
        //Реализовать Predicate в двух вариантах:
        //* через анонимный класс
        //* через лямбду.

        Predicate<Integer> positive = new Predicate<>() {

            public boolean test(Integer positive) {
                return positive >= 0; }
        };
        System.out.println(positive.test(25));
        System.out.println(positive.test(-448));
        System.out.println(positive.test(0));
        System.out.println();

        Predicate<Integer> positive1 = i -> i >= 0;
        System.out.println(positive1.test(25));
        System.out.println(positive1.test(-448));
        System.out.println(positive1.test(0 ));
        System.out.println();

        //Задание 2
        //Создать Consumer, который будет принимать на вход имя человека и выводить в консоль его приветствие.
        //Реализовать Consumer в двух вариантах:
        //* через анонимный класс
        //* через лямбду.

        String name = "Анна";
        Consumer<String> greeting = new Consumer<>() {

            public void accept(String name) {
                System.out.println("Добрый день, " + name + "!!!");}
        };
        greeting.accept(name);
        System.out.println();

        Consumer<String> greetingName = t -> System.out.println("Добрый день, " + t + "!!!");
        greetingName.accept("Анна");
        System.out.println();

        //Задание 3
        //Реализовать функциональный интерфейс Function, который принимает на вход вещественное число
        //типа Double, а возвращает его округленный вариант типа Long.
        //Реализовать Function в двух вариантах:
        //* через анонимный класс
        //* через лямбду

        Function<Double, Long> function = new Function<Double, Long>() {

            public Long apply(Double t) {
                return Math.round(t);}
        };
        System.out.println(function.apply(13.2));
        System.out.println();

        Function<Double, Long> function1 = n -> Math.round(n);
        System.out.println(function1.apply(13.2));
        System.out.println();

        //Задание 4
        //Написать Supplier, который будет возвращать случайное число от 0 до 100.
        //Реализовать Supplier в двух вариантах:
        //* через анонимный класс
        //* через лямбду

        Supplier<Integer> supplier = new Supplier<Integer>() {

            public Integer get() {
                return (int) (Math.random() * 100);
            }
        };
        System.out.println(supplier.get());
        System.out.println();

        Supplier<Integer> supplier1 = () -> (int) (Math.random() * 100);
        System.out.println(supplier1.get());
        System.out.println();

        //Задание 5
        //Давайте попрактикуемся в комбинировании функций в более сложные функции. Для примера построим
        //следующую комбинацию. Дан предикат condition и две функции ifTrue и ifFalse.

        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safe = ternaryOperator(condition, ifTrue, ifFalse);
        System.out.println(safe);}

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);

    }

}