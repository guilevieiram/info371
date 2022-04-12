package UnionFind;

public class UnionFindFatherHeight extends UnionFindFather{

    public int [] height;

    public UnionFindFatherHeight(int fieldSize){
        super(fieldSize);
        height = new int [size];
        for(int i = 0; i < size; i ++) height[i] = 1;
    }

    public void union (int i, int j) {

        int fatherI = find(i);
        int fatherJ = find(j);

        int heightI = height[fatherI];
        int heightJ = height[fatherJ];


        if(heightI > heightJ){
            father[fatherJ] = find(fatherI);
        }
        else {
            father[fatherI] = find(fatherJ);
            if(heightI == heightJ) 
                height[fatherJ]++;
        }
    }
    
}
