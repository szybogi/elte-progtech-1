public class Main {

    public static void main(String[] args) {

        Verem verem = new Verem("()()");

        Ellenorzo ellenorzo = new Ellenorzo(verem);

        if (ellenorzo.helyesE()) {
            System.out.println("Helyes!");
        } else {
            System.out.println("Helytelen!");
        }
    }

}