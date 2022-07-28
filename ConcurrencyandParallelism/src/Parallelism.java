public class Parallelism  {

    public static void processTax(String user){
    System.out.println("Taxes for user: "+user);
    }
    public static void heavyCalculations(Double amount){
        Math.sqrt(amount);
    System.out.println("Tax amount equals to: "+amount+" "+ Thread.currentThread().getName());
    }

  public static void main(String[] args) {
    new Thread(new Runnable() {

        @Override
        public void run() {
            processTax("Juan "+ Thread.currentThread().getName());
        }
    }).start();
      new Thread(new Runnable() {

          @Override
          public void run() {
              processTax("Jose Luis "+ Thread.currentThread().getName());
          }
      }).start();

      heavyCalculations(27489.75);
  }
}
