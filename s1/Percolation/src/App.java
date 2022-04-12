import UnionFind.UnionFindNaive;
import UnionFind.UnionFindFatherHeight;
import UnionFind.UnionFindFatherWeights;
import UnionFind.UnionFindFather;
import PercolationBoard.PercolationBoard;
import UnionFind.UnionFind;

public class App {
    public static void main(String[] args) throws Exception {
        PercolationBoard pb = new PercolationBoard(10, new UnionFindNaive());
        pb.showBoard();
        pb.colorPlace();
        pb.showBoard();
    }
}

