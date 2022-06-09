public class ex1 {
    public static void main (String[] args){
        e3();
    }

    public static void e1(){
        System.out.println(factorial(20));
    }
    public static void e2(){
        double d = 0;
        // d = 1 + 1/2 + 1/3;
        d = 1 + (double)1/2 + (double)1/3;
        System.out.println(d);
    }
    public static void e3(){
        int r1 = 2 + 2;
        System.out.println(r1);
        double r2 = Math.PI + Math.E;
        System.out.println(r2);
    }

    public static long factorial(int n){
        // int result = 1;
        long result = 1;
        for(int i = 1; i <= n; i++){
            result *= i;
        }
        return result;
    }
    
}
