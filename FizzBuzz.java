import java.util.InputMismatchException;
import java.util.Scanner;

public class FizzBuzz {

    private int smallestMultiple;
    private int biggerMultiple;

    public FizzBuzz(int smallestMultiple, int biggerMultiple) {
        this.smallestMultiple = smallestMultiple;
        this.biggerMultiple = biggerMultiple;
    }


    public int getBiggerMultiple() {
        return biggerMultiple;
    }

    public void setBiggerMultiple(int biggerMultiple) {
        this.biggerMultiple = biggerMultiple;
    }

    public int getSmallestMultiple() {
        return smallestMultiple;
    }

    public void setSmallestMultiple(int smallestMultiple) {
        this.smallestMultiple = smallestMultiple;
    }


    public void fizzbuzz(int n) {
//        both multiples are saved here and ready for use
        int smallestMultiple = getSmallestMultiple();
        int biggerMultiple = getBiggerMultiple();

        try {
//        for loop to go through from 1 to number given
            for (int i = 1; i < n + 1; i++) {


//            if less than smallest value then it is automatically has a mod of 0
//            and cannot be a mod less than the value being modded
                if (i >= smallestMultiple) {

                    if (i % smallestMultiple == 0 && i % biggerMultiple == 0) {
                        System.out.println("FIZZBUZZ" + " " + "Both");
                    } else if (i % smallestMultiple == 0) {
                        System.out.println("FIZZ " + i + " is " + smallestMultiple);
                    } else if (i % biggerMultiple == 0) {
                        System.out.println("BUZZ " + i + " is " + +biggerMultiple);
                    } else {
                        System.out.println("Neither" + " " + i);
                    }

// if the value is less than the smallest multiple then it is automatically not a multiple and just printed out
                } else {
                    System.out.println("Neither" + " " + i);
                }


            }
        } catch (ArithmeticException error) {
            System.out.println("The number you entered does not make sense");
        } catch (Exception error) {
            System.out.println("Nothing makes sense anymore!");
        }
    }


    public void inputMismatch() {

    }

    public static void main(String[] args) {

        //        variables that will be needed are declared
        Scanner input = new Scanner(System.in);

        int firstNumber = 0;
        int secondNumber = 0;
        int userResponse = 0;

//        used for error catching to get users response again during an error
        boolean flag = true;

        System.out.println("______________");
        System.out.println("FIZZBUZZ GAME!");
        System.out.println("______________");

        while (flag) {
            try {
                System.out.println("Enter first number: ");
                firstNumber = input.nextInt();

                System.out.println("Enter second number: ");
                secondNumber = input.nextInt();
                flag = false;
            } catch (InputMismatchException error) {
//                pops out the last thing stuck in scanner to use new input
                input.next();
                System.out.println("Please enter a number");
            }
        }


        System.out.println(" ");

        System.out.println("The program will tell you from 1 to your number how many are multiples of only " + firstNumber + " and " + secondNumber);

        System.out.println(" ");

        System.out.println("Rules: ");
        System.out.println("Multiples of only " + firstNumber + " is FIZZ");
        System.out.println("multiple of only " + secondNumber + " is BUZZ");
        System.out.println("multiple of both is FIZZBUZZ");
        System.out.println("multiple of neither just shows the number");
        System.out.println("Number entered must be positive");

        System.out.println("________________________________________");


        System.out.println("");

        flag = true;

        while (flag) {
            try {
                System.out.println("Enter your number and let the game begin:");
                userResponse = input.nextInt();
                flag = false;

            } catch (InputMismatchException error) {
//                pops out the last thing stuck in scanner to use new input
                input.next();
                System.out.println("Please enter a number");
            }
        }


//        creates a FizzBuzz object and initializes the constructor
//        sets both value
        FizzBuzz game = new FizzBuzz(firstNumber, secondNumber);

//        calls the fizzbuzz game after both values have been set
        game.fizzbuzz(userResponse);
    }


}
