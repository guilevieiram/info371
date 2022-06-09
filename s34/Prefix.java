public class Prefix {
    String [] t;

    final static String 
        start = "<START>",
        end = "<END>",
        par = "<PAR>";
    
    Prefix(int n){
        t = new String[n];
        for(int i = 0; i < n; i++) t[i] = start;
    }

    static boolean eq(Prefix p1, Prefix p2){
        boolean tmp = true;
        if(p1.t.length != p2.t.length) return false;

        for (int i = 0; i < p1.t.length; i++){
            if(!p1.t[i].equals(p2.t[i])) tmp = false;
        }
        return tmp;
    }

    public Prefix addShift(String w){
        Prefix p = new Prefix(this.t.length);
        p.t[this.t.length - 1] = w;
        for(int i = 1; i < this.t.length; i ++){
            p.t[i-1] = this.t[i];
        }
        return p;
    }

    public int hash(){
        int h = 0;
        for (int i = 0; i < this.t.length; i++) h = 37*h + this.t[i].hashCode();
        return h;
    }
    public int hashCode(int n){
        int hash = hash();
        if (hash % n == 0) return 0;
        if (hash < 0) return (hash % n) + n;
        return (hash % n);
    }

    public  void print(){
        System.out.print("[");
        for(int i = 0; i < t.length; i++){
            System.out.print(t[i] + ", ");
        }
        System.out.print("]");
    }
    
}
