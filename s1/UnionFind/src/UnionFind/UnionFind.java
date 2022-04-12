package UnionFind;

public abstract class UnionFind {
    public int size;

    public abstract int find (int i);
    public abstract void union (int i, int j);

    public void show() {
        for (int counter = 0; counter < this.size; counter ++){
            System.out.print(counter + ": ");
            for (int inner = 0; inner < this.size; inner ++)
                if(find(inner) == counter) 
                    System.out.print(inner + " ");
            System.out.println();
        }
    }
}
