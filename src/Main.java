import java.util.Scanner;
public class Main{

    private static double squareRoot(double x)
    {
        int division = 0, multiplication = 0;
        if (x >= 0.4)
        {
            //Division by 4 until x gets closer to 1
            while (x > 1.6)
            {
                x = x/ 4;
                division++;
            }
        }
        else
        {
            //Multiplication by 4 until x gets closer to 1
            while (x < 0.4)
            {
                x = x * 4;
                multiplication++;
            }
        }

        System.out.printf("x= %.6f", x);
        double root = term_calculate(x);
        double sroot = calculate_root(root,division,multiplication);
        return sroot;
    }
    private static double term_calculate(double x)
    {
        double temp_term = 0;
        double first_term = 1;
        int k = 1;
        float term = 1, term1 = 0;
        int flag = 0;
        double value;
        double factorial = 1;
        int N = 0;
        double root = 0;

        while (flag != 1)
        {
            term1 = term;
            factorial = factorial * k;
            //Power series used: Taylor Series for square root : sqrt(x) = 1 + 1/2(x-1) - 1/4(x-1)^2/2! + 3/8(x-1)^3/3! - 15/16(x-1)^4/4! + ..
            term = (float) ((-term1) * (x - 1.0) * (2*k - 3.0) / 2.0);
            temp_term = term / factorial;
            first_term = first_term + temp_term;
            value = Math.abs(temp_term);

            if (value < 0.0000000001)
            {
                root = first_term;
                N = k;
                flag = 1;
            }

            k++;
        }
        System.out.print(",\t n= " + N);
        return root;
    }

    private static double calculate_root(double root, int division, int multiplication)
    {
        for (int i = 1; i <= division; i++)
        {
            root = root + root;
        }
        for (int i = 1; i <= multiplication; i++)
        {
            root = root / 2;
        }
        return root;
    }



    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);;
        while(true)
        {
            System.out.print("Enter a number (0 for exit) :");
            double x = sc.nextDouble();
            if(x == 0)
            {
                break;
            }
            else
            {
                double root = squareRoot(x);
                System.out.printf("\nmy. sqrt(%.6f): %.10f",x,root);
                System.out.printf("\t\tLib. sqrt(%.6f): %.10f\n",x,Math.sqrt(x));

            }
        }
        sc.close();
    }
}