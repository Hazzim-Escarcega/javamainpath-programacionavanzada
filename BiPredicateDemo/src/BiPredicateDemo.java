import java.util.function.BiPredicate;

public class BiPredicateDemo{

  public static void main(String[] args) {
    //Using lambda function
    BiPredicate<String, String> biPredicate = (s1, s2) -> s1.equals(s2);
    //Test cases
    System.out.println(biPredicate.test("Test", "Test"));
    System.out.println(biPredicate.test("test", "Test"));
  }


}
