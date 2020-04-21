package geometry;

import java.text.DecimalFormat;

/**
 * x12 + y12 + 2gx1 + 2fy1 + c = 0 – (1)
 * x22 + y22 + 2gx2 + 2fy2 + c = 0 – (2)
 * x32 + y32 + 2gx3 + 2fy3 + c = 0 – (3)
 *
 * From (1) we get, 2gx1 = -x12 – y12 – 2fy1 – c – (4)
 * From (1) we get, c = -x12 – y12 – 2gx1 – 2fy1 – (5)
 * From (3) we get, 2fy3 = -x32 – y32 – 2gx3 – c – (6)
 *
 * Subtracting eqn (2) from eqn (1) we get,
 * 2g( x1 – x2 ) = ( x22 -x12 ) + ( y22 – y12 ) + 2f( y2 – y1 ) – (A)
 *
 * Now putting eqn (5) in (6) we get,
 * 2fy3 = -x32 – y32 – 2gx3 + x12 + y12 + 2gx1 + 2fy1 – (7)
 *
 * Now putting value of 2g from eqn (A) in (7) we get,
 * 2f = ( ( x12 – x32 )( x1 – x2 ) +( y12 – y32 )( x1 – x2 ) + ( x22 – x12 )( x1 – x3 ) + ( y22 – y12 )( x1 – x3 ) ) / ( y3 – y1 )( x1 – x2 ) – ( y2 – y1 )( x1 – x3 )
 *
 * Similarly we can obtain the values of 2g :
 * 2g = ( ( x12 – x32 )( y1 – x2 ) +( y12 – y32 )( y1 – y2 ) + ( x22 – x12 )( y1 – y3) + ( y22 – y12 )( y1 – y3 ) ) / ( y3 -y1 )( y1 – y2 ) – ( x2 – x1 )( y1 – y3 )
 *
 * Putting 2g and 2f in eqn (5) we get the value of c and know we had the equation of circle as x2 + y2 + 2gx + 2fy + c = 0
 */
public class FindCircleFrom3Points {

    public static void findCircle(int x1, int y1,
                                  int x2, int y2,
                                  int x3, int y3){

        int x12 = x1 - x2;
        int x13 = x1 - x3;

        int y12 = y1 - y2;
        int y13 = y1 - y3;

        int y31 = y3 - y1;
        int y21 = y2 - y1;

        int x31 = x3 - x1;
        int x21 = x2 - x1;

        // x1^2 - x3^2
        int sx13 = (int)(Math.pow(x1, 2) -
                Math.pow(x3, 2));

        // y1^2 - y3^2
        int sy13 = (int)(Math.pow(y1, 2) -
                Math.pow(y3, 2));

        // x2^2 - x1^2
        int sx21 = (int)(Math.pow(x2, 2) -
                Math.pow(x1, 2));

        // y2^2 - y1^2
        int sy21 = (int)(Math.pow(y2, 2) -
                Math.pow(y1, 2));

        int f = ((sx13) * (x12)
                + (sy13) * (x12)
                + (sx21) * (x13)
                + (sy21) * (x13))
                / (2 * ((y31) * (x12) - (y21) * (x13)));
        int g = ((sx13) * (y12)
                + (sy13) * (y12)
                + (sx21) * (y13)
                + (sy21) * (y13))
                / (2 * ((x31) * (y12) - (x21) * (y13)));

        int c = -(int)Math.pow(x1, 2) - (int)Math.pow(y1, 2) -
                2 * g * x1 - 2 * f * y1;

        // eqn of circle be x^2 + y^2 + 2*g*x + 2*f*y + c = 0
        // where centre is (h = -g, k = -f) and radius r
        // as r^2 = h^2 + k^2 - c
        int h = -g;
        int k = -f;
        int sqr_of_r = h * h + k * k - c;

        // r is the radius
        double r = Math.sqrt(sqr_of_r);
        DecimalFormat df = new DecimalFormat("#.#####");
        System.out.println("Centre = (" + h + "," + k + ")");
        System.out.println("Radius = " + df.format(r));
    }


    public static void main(String arg[]) {
        int x1 = 1, y1 = 1;
        int x2 = 2, y2 = 4;
        int x3 = 5, y3 = 3;
        findCircle(x1, y1, x2, y2, x3, y3);
    }
}
