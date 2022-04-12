import UnionFind.UnionFindNaive;
import UnionFind.UnionFindFatherHeight;
import UnionFind.UnionFindFatherWeights;
import UnionFind.UnionFindFather;
import UnionFind.UnionFind;

public class App {
    public static void main(String[] args) throws Exception {
        UnionFind uf = new UnionFindFatherWeights(10);

        System.out.println("Before:");
        uf.show();
        uf.union(1, 2);
        uf.union(3, 2);
        uf.union(4, 2);
        uf.union(5, 2);

        System.out.println("After:");
        uf.show();
    }
}

