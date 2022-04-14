public class PercolationEx7 {
    public static int size = 100;
    public static int length = size * size;
    public static boolean[] grid = new boolean[length];

    public static int top = length;
    public static int bottom = length + 1;

    public static void main(String[] args) {

        // getting SIGKILL errors probably because of the tests expecting eclipse;
        // change name of the class before submitting
        int n = Integer.parseInt(args[0]);

        long timeStart = System.currentTimeMillis();
        double average = monteCarlo(n);
        long timeFinish = System.currentTimeMillis();

        System.out.println(
            "Average: " + average + " on time (ms): " + (timeFinish - timeStart)
        );
    }

    public static void init(){
        for(int i = 0; i < length; i++){
            grid[i] = false;
        }
    }

    public static void print(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(grid[i * size + j]) System.out.print("*");
                else System.out.print("_");
            }
            System.out.println();
        }
    }

    public static boolean isPercolation(int n){
        return isNaivePercolation(n);
    }

    public static double percolation(){
        boolean isPerc;
        int shadowPosition;
        do{
            shadowPosition = randomShadow();
            isPerc= isPercolation(shadowPosition);
        }while(!isPerc);
        return whitesPercentages();
    }

    public static double monteCarlo(int n){
        double percolationSumScore = 0;
        for(int i = 0; i < n; i++){
            init();
            percolationSumScore += percolation();
        }
        return percolationSumScore / n;
    }

    public static int randomShadow(){
        int position;
        double random;
        do{
            random = Math.random();
            position = (int)(random*length);
        } while(grid[position]);
        grid[position] = true;
        return position;
    }

    public static boolean isNaivePercolation(int n){
        boolean[] seen = new boolean[length];

        for(int i = 0; i < length; i++) seen[i] = false;
        boolean up = detectPath(seen, n, true);

        for(int i = 0; i < length; i++) seen[i] = false;
        boolean down = detectPath(seen, n, false);

        return up && down;
    }

    public static boolean detectPath (boolean[] seen, int n, boolean up){
        // check if is white
        if(!grid[n]) return false;
        // check if seen
        if(seen[n]) return false;
        // set seen
        seen[n] = true;
        // base cases
        if (isOnTop(n) && up) return true;
        if (isOnBottom(n) && !up) return true;

        // check horizontals
        if(!isOnLeft(n)) 
            if (detectPath(seen, left(n), up)) return true;
        if(!isOnRight(n))
            if(detectPath(seen, right(n), up)) return true;
        // check up
        if(!isOnTop(n))
            if(detectPath(seen, top(n), up)) return true;
        // check down
        if(!isOnBottom(n))
            if(detectPath(seen, bottom(n), up)) return true;
        return false;
    }

    // auxiliary functions
    private static boolean isOnLeft(int n){
        return n%size == 0;
    }
    private static boolean isOnRight(int n){
        return n%size == size - 1;
    }
    private static boolean isOnTop(int n){
        return n < size;
    }
    private static boolean isOnBottom(int n){
        return n >= (size - 1) * size;
    }
    private static int left(int n){
        return n - 1;
    } 
    private static int right(int n){
        return n + 1;
    } 
    private static int top(int n){
        return n - size;
    } 
    private static int bottom(int n){
        return n + size;
    } 

    private static double whitesPercentages(){
        int whitesCounter = 0;
        for (int i = 0; i < length; i++){
            if (grid[i]) whitesCounter ++;
        }
        return (double)whitesCounter / length;
    }
}
