import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        IntBag intBag1 = new IntBag();
        
        int selection = -1;  //Temp value to shut the compiler down
        do {
            System.out.println("1. Create a new empty collection(any previous values are lost!)");
            System.out.println("2. Read a set of positive values into the collection (use zero to indicate all the values have been entered.)");
            System.out.println("3. Print the collection of values.");
            System.out.println("4. Add a value to the collection of values at a specified location");
            System.out.println("5. Remove the value at a specified location from the collection of values");
            System.out.println("6. Remove all instances of a value within the collection");
            System.out.println("7. Quit the program.");
            System.out.println("8. Fibonacci Sequence (Part C)");
            System.out.println("Your selection: ");
            selection = scan.nextInt();

            if (selection > 8 || selection < 1) {
                System.out.println("Invalid selection! Try again: ");
                selection = scan.nextInt();
            } 
            else {
                if(selection == 1){
                    intBag1 = new IntBag();
                    IntBag.setCurrentNoInArray(0);
                }
                else if(selection == 2){
                    int input;
                    do {
                        System.out.println("Add a value: (Press 0 to stop)");
                        input = scan.nextInt();

                        if(input != 0) {
                            intBag1.addValueToEnd(input);
                        }
                        
                    } while (input != 0);
                }
                else if(selection == 3){
                    System.out.println(intBag1.toString());
                }
                else if(selection == 4){
                    System.out.println("What is the value you want to add? : ");
                    int value = scan.nextInt();
                    System.out.println("What is the index for that value? : ");
                    int index = scan.nextInt();
                    intBag1.addValueToSpecificIndex(value, index);
                }
                else if(selection == 5){
                    System.out.println("From which index you want to remove? : ");
                    int value = scan.nextInt();
                    intBag1.removeValue(value);
                    System.out.println("The number is removed from the collection");
                }
                else if(selection == 6){
                    System.out.println("Pick a number which will be deleted from the collection: ");
                    int number = scan.nextInt();
                    intBag1.removeAllInstances(number);
                    System.out.println("The number is removed from the collection");
                }
                else if(selection == 8){
                    System.out.println("For Part C: Fibonacci Values will be shown up to first 40 terms:");
                    intBag1.fibonacciMethod();
                }
            } 
        }
        while (selection != 7);
            System.out.println("The program will be terminated now.");
            scan.close();
    }
}



