package UnionFind;
public class UnionFindFatherWeights extends UnionFindFather {

    public int [] weights;

    public UnionFindFatherWeights(int fieldSize){
        super(fieldSize);
        weights = new int [size];
        for(int i = 0; i < size; i++) weights[i] = 1;
    }
    
    public void union (int i, int j) {
        int fatherI = find(i);
        int fatherJ = find(j);

        int weightI = weights[fatherI];
        int weightJ = weights[fatherJ];

        if (weightI > weightJ){
            father[fatherJ] = fatherI;
            weights[fatherI] += weightJ;
        }
        else {
            father[fatherI] = fatherJ;
            weights[fatherJ] += weightI;
        }
    }
}
