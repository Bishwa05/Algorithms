package tree.other;
class Node {

    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
public class QuadTree {

    public Node construct(int[][] grid) {
        return constructTree(grid, 0, 0, grid.length);
    }

    private Node constructTree(int[][] grid, int x, int y, int length) {
        if(isLeaf(grid, x, y, length)) return new Node(grid[x][y]==1, true);

        Node topLeft = constructTree(grid, x, y, length/2);
        Node topRight = constructTree(grid, x, y+ length/2, length/2);
        Node bottomLeft = constructTree(grid, x + length/2, y, length/2);
        Node bottomRight = constructTree(grid, x + length/2, y + length/2, length/2);
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    private boolean isLeaf(int[][] grid, int x, int y, int length) {
        int current = grid[x][y];
        for(int row = x; row<x+length; row++) {
            for (int col = y; col<y+length; col++) {
                if (current != grid[row][col]) return false;
            }
        }
        return true;
    }
}
