public class Main {

    public static void main(String[] args) {
        test(")", false);
        test("(", false);
        test("()", true);
        test("(()", false);
        test("(())", true);
        test("((())", false);
        test("(()()(()(()())()))", true);
        test("(()()(()(()())())))", false);
    }

    private static void test(String str, boolean expected) {
        if(expected == new Ellenorzo(new Verem(str)).helyesE()) {
            System.out.println(String.format(
                    "OK:\t'%s'", str
            ));
        } else {
            System.err.println(String.format(
                    "FAIL:\t'%s'", str
            ));
        }
    }

}