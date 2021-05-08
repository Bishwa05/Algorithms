package geometry;

class Point {
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

/**
 *
 * Slope of line segment (p1, p2): σ = (y2 - y1)/(x2 - x1)
 * Slope of line segment (p2, p3): τ = (y3 - y2)/(x3 - x2)
 *
 * If  σ > τ, the orientation is clockwise (right turn)
 *
 * Using above values of σ and τ, we can conclude that,
 * the orientation depends on sign of  below expression:
 *
 * (y2 - y1)*(x3 - x2) - (y3 - y2)*(x2 - x1)
 *
 * Above expression is negative when σ < τ, i.e.,  counterclockwise
 *
 *
 */
public class TwoLineSegmentIntersect
{

    // Whether point q lies on the line segment pr
    public boolean onSegment(Point p, Point q, Point r){
        if(q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x)
        && (q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y))){
            return true;
        }
        return false;
    }

    /**
     * 0 --> p, q, r are colinear
     * 1--> clock wise
     * 2 --> anti clockwise
     */
    public int orientation(Point p1, Point p2, Point p3){
        int val = (p2.y - p1.y) * (p3.x - p2.x) -
            (p2.x -p1.x) *(p3.y - p2.y);


        if(val ==0) return 0;// colinear

        return (val>0)?1:2;
    }

    public boolean doIntersect(Point p1, Point q1, Point p2, Point q2){

        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);

        if(o1 !=0 && o3 != o4) return true;

        // p1, q1 and p2 are colinear and p2 lies on segment
        if(o1 == 0 && onSegment(p1, p2, q1)) return true;

        // p1, q1 and q2 are colinear and p2 lies on segment
        if(o2 == 0 && onSegment(p1, q2, q1)) return true;

        // p2, q2 and p1 are colinear and p1 lies on segment
        if(o1 == 0 && onSegment(p2, p1, q2)) return true;

        // p2, q2 and p2 are colinear and q1 lies on segment
        if(o1 == 0 && onSegment(p2, q1, q2)) return true;

        return false;

    }

}
