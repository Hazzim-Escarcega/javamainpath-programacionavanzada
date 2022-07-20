import functional.MyFunctionalInterface;

public class App {

    public static void doSomethingTraditional(){
        var tux = new Tux();
        System.out.println(tux.doSomething("Holaaaaaaaa"));
    }
    public static void doSomethingClassy(){
        //Clase anonima
        var duke = new MyFunctionalInterface() {
            @Override
            public String doSomething(String param) {
                return "Hola soy duke y recibi "+param;
            }
        };
        System.out.println(duke.doSomething("Clase anonima"));
    }

    public static void doSomethingFunctional(){
        //funcion anonima
        MyFunctionalInterface clippy = ((String param) -> {
           return "Hola soy clippy y recibi: "+ param;
        });

        System.out.println(clippy.doSomething("Functional param"));
    }

    public static void main(String[] args) {
        var instanciaTux = new Tux();
        //POO
        //System.out.println(instanciaTux.doSomething("Este es un paramtro"));

        doSomethingTraditional();
        doSomethingClassy();
        doSomethingFunctional();

    }
}
