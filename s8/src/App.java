public class App {
    public static void main(String[] args) throws Exception {
        Tokenizer t = new Tokenizer(false);
        t.readString("(35*3-12)/4=");
        System.out.println("\nResult: \n" + t.calc.getResult());
    }
}
