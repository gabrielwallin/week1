package assignments.basics;

import static java.lang.System.*;

/*
 *   Exercising while-loop
 */
public class WhileLoop {

    public static void main(String[] args) {
        new WhileLoop().program();
    }


    void program() {
        // Write your code here
        // Comment out when finished with one and continue with next
        int a = -20;
        while(a <= 3){

            out.print(a);
            a++;
            if(a <= 3){
                out.print(", ");
            }
        }

        out.println();

        int b = 10;
        while(b >= -10){

            out.print(b);
            b--;
            if(b >= -10){
                out.print(", ");
            }
        }

        out.println();

        int c = 5;
        while(c <= 100){

            out.print(c);
            c = c + 5;
            if(c <= 100){
                out.print(", ");
            }
        }

        out.println();

        double d = 0.0;
        while(d <= 9.0){

            out.print((double) Math.round(d*10)/10);
            d = d + 0.3;

            if(d <= 9.0){
                out.print(", ");
            }

        }

        out.println();

        int e = 2;
        while(e <= 256){
            out.print("1/" + e);
            e = e*2;
            if(e <= 256){
                out.print(", ");
            }
        }

        out.println();

        //int
    }



}
