package geometry;

/**
 *
 * Leetcode 223. Rectangle Area
 *
 * Given the coordinates of two rectilinear rectangles in a 2D plane, return the total area covered by the two rectangles.
 *
 * The first rectangle is defined by its bottom-left corner (A, B) and its top-right corner (C, D).
 *
 * The second rectangle is defined by its bottom-left corner (E, F) and its top-right corner (G, H).
 *
 * Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
 * Output: 45
 *
 */
public class RectangleArea
{
    public int area(int x1, int x2, int y1, int y2){
        return (x2 - x1)*(y2-y1);
    }

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = area(A, C, B, D);
        int area2 = area(E, G, F, H);

        int x1 = Math.max(A, E);
        int y1 = Math.max(B, F);

        int x2 = Math.min(C, G);
        int y2 = Math.min(D, H);

        if (x1 < x2 && y1 < y2) {
            return area1 + area2 - area(x2, x1, y2, y1);
        }

        return area1 + area2;
    }


}
