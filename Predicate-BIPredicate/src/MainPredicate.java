import java.util.function.BiPredicate;
import java.util.function.Predicate;

public final class MainPredicate {
    public static void main(String[] args) {

        //TEST
        Predicate<Object> isString = e->e instanceof String;
        var result = usingPredicate(722, isString)? "Es string":"No es string";
        System.out.println(result);

        //AND, OR, NOT
        Predicate<Float> isGretaterThanZero =value -> value > 0;
        Predicate<Float> isLessThan4000 =value -> value == 4000;
        Predicate<Float> orPredicate = Float::isFinite;
        Predicate<Float> notPredicate = Predicate.not(isGretaterThanZero);

        var valide = usingPredicate(133f, isGretaterThanZero,isLessThan4000, orPredicate);
        result = valide ? "Valor aceptado":"Valor Rechazado";
        System.out.println(result);


    }
    private static <T> boolean usingPredicate(T value, Predicate<T>predicate) {
        return predicate.test(value);
    }
    private static <T> boolean usingPredicate(T value, Predicate<T>predicate, Predicate<T>andPredicate, Predicate<T>orPredicate) {
        return predicate.and(andPredicate)
                .or(orPredicate)
                .test(value);
    }
}
