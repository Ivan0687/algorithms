package ivan.boiko.algorithms.prometheus;

public class SquareRoot {

    public static void main(String[] args) {
        double a = 3;
        double b = 2.5;
        double c = -0.5;

        //PUT YOUR CODE HERE
        if (a != 0){
            double d = b * b - 4 * a * c;
            if (d >= 0) {
                double x1 = (-b + Math.sqrt(d)) / (2 * a);
                double x2 = (-b - Math.sqrt(d)) / (2 * a);
                System.out.println("x1=" + x1);
                System.out.println("x2=" + x2);
            } else {
                System.out.println("x1=");
                System.out.println("x2=");
            }
        } else if (b!=0){
            System.out.println("x1=" + (c / b));
            System.out.println("x2=" + (c / b));
        } else {
            System.out.println("x1=");
            System.out.println("x2=");
        }
        //PUT YOUR CODE HERE
    }

}
