import java.util.function.BiPredicate;

public class BIPredicate {
    public static void main(String[] args) {
        BiPredicate<Integer, Integer> isGreater = BIPredicate::isGreater;
        System.out.println("Es mayor el primer numero?: "+ isGreater.negate().test(5,4));
    }
    public static boolean isGreater(Integer greater, Integer less) {
        return greater>less;
    }

}
