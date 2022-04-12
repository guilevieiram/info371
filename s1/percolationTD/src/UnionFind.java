public class UnionFind {
    public static int [] equiv;
    public static int [] height;

    public static void main (String[] args){
        init(9);
        show();
        union(2, 5);
        show();
        union(5, 6);
        show();
        union(6, 2);
        show();
        find(5);
    }

    // auxiliary show method for debugging
    public static void show(){
        for(int i = 0; i < equiv.length; i++){
            System.out.print(i + ": ");
            for(int j = 0; j < equiv.length; j++){
                if(equiv[j] == i)
                    System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public static void init(int len){
        equiv = new int [len];
        height = new int [len];
        for(int i = 0; i < len; i++){
            equiv[i] = i;
            height[i] = 1;
        }
    }
    public static int find(int x){
        // return naiveFind(x);
        // return fastFind(x);
        return logFind(x);
    }
    public static int union(int x, int y){
        // return naiveUnion(x, y);
        // return fastUnion(x, y);
        return logUnion(x, y);
    }
    public static int naiveFind(int x){
        return equiv[x];
    }
    public static int fastFind(int x){
        while(x != equiv[x])
            x = equiv[x];
        return x;
    }
    public static int logFind(int x){
        while(x != equiv[x]){
            equiv[x] = equiv[x];
            x = equiv[x];
        }
        return x;

    }
    public static int naiveUnion(int x, int y){
        int equivX = equiv[x];
        int equivY = equiv[y];
        for(int i = 0; i < equiv.length; i++){
            if(equiv[i] == equivX) equiv[i] = equivY;
        }
        return equivY;
    }
    public static int fastUnion(int x, int y){
        if(!(find(x) == find(y)))
            equiv[find(x)] = equiv[y];
        return equiv[y];
    }
    public static int logUnion(int x, int y){
        if(!(find(x) == find(y))){
            int heightX = height[find(x)];
            int heightY = height[find(y)];

            if(heightX > heightY){
                equiv[find(x)] = equiv[y];
                height[find(y)] = heightX;
                return equiv[y];
            }
            else {
                equiv[find(y)] = equiv[x];
                height[find(x)] = heightY;
                return equiv[x];
            }
        }
        return equiv[y];
    }
}
