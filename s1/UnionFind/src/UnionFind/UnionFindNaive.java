package UnionFind;

public class UnionFindNaive extends UnionFind{

    private int [] rep;

    public UnionFindNaive (int fieldSize) {
        size = fieldSize;
        rep = new int [size];
        for (int i = 0; i < size; i++) rep[i] = i;
    }

    public int find (int i) {
        return rep[i];
    }

    public void union (int i, int j){
        int repI = rep[i];
        for (int counter = 0; counter < rep.length; counter ++){
            if(rep[counter] == repI) rep[counter] = rep[j];
        }
    }


}