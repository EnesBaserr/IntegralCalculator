
package question;

import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
	// Main method is for you to test your code
	// You will not get any points here
	public static void main(String[] args) {
		
		Polynomial poly = new Polynomial("-7x^4+5x-10+3x^2+6x^3");
        poly.setDeltaX(0.0001);
        System.out.println(poly.computeIntegral(4,7));
        poly.setDeltaX(0.000001);
        System.out.println(poly.computeIntegral(4,7));


        Polynomial xx = new Polynomial("x^2");
        xx.setDeltaX(0.0001);
        System.out.println(xx.computeIntegral(2, 8));
        Polynomial p1 = new Polynomial("x^4+2x^2-5-3x");
        Polynomial p2 = new Polynomial("-x^4+2x^2-5-3x");
        Polynomial p3 = new Polynomial("-5x^4+2x^2-5-3x");
        Polynomial p4 = new Polynomial("-10x^4+2x^2-5-3x");
        Polynomial p5 = new Polynomial("6x^4+2x^2-5-3x");
        Polynomial p6 = new Polynomial("-x+x^2-5-3x^3");
        Polynomial p7 = new Polynomial("5x+2x^2+5-x^3");
        Polynomial p8 = new Polynomial("3x^2-4x^4-8");


        System.out.println(p1.computeIntegral(2,8));
        System.out.println(p2.computeIntegral(2,8));
        System.out.println(p3.computeIntegral(2,8));
        System.out.println(p4.computeIntegral(2,8));
        System.out.println(p5.computeIntegral(2,8));
        System.out.println(p6.computeIntegral(2,8));
        System.out.println(p7.computeIntegral(2,8));
        System.out.println(p8.computeIntegral(2,8));
	}

}

