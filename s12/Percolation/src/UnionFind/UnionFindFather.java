package UnionFind;

public class UnionFindFather extends UnionFind{
    
    public int [] father;

    public void initialize(int fieldSize){
        size = fieldSize;
        father = new int [size];
        for(int i = 0; i < size; i++) father[i] = i;
    }

    public int find (int i){
        while(i != father[i])
            i = father[i];
        return i;
    }

    public void union (int i, int j){
        father[find(j)] = find(i);
    }

}
