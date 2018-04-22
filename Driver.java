/*
Eric Rensel - CS420 - 4/22/2018
This is the Driver class for the EightSquare program. Some comments are left in for
testing purposes.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class Driver {

    /*
        isSolvable() tests input strings to see if they are valid strings and possible to be solved
     */
    private static boolean isSolvable(String in){
        //if the string is not of length 9, then it is not a puzzle
        if(in.length() != 9){
            return false;
        }
        //the next section determines whether the input is just a scrambled puzzle
        ArrayList<Character> test = new ArrayList<>();
        for(int i=0; i<9; i++){
            //test.add((char)(i+48));
            test.add(in.charAt(i));
        }
        Collections.sort(test);
        StringBuilder strTest = new StringBuilder();
        for(int i=0; i<9; i++){
            strTest.append(test.get(i));
        }
        if(!strTest.toString().equals("012345678")){
            return false;
        }
        //this section counts the number of inversions, while skipping zero.
        char [] input = in.toCharArray();
        int inversions = 0;
        for(int i=0; i<9; i++){
            //skip zero
            if(input[i] == '0'){
                continue;
            }
            for(int j=(i+1); j<9; j++){
                //count inversion and don't count zero.
                if((input[j]<input[i]) && (input[j] != '0')){
                    inversions++;
                }
            }
        }
        //System.out.println("Inversions is equal to: " + inversions);
        return (inversions % 2) == 0;
    }



    public static void main(String [] args) throws FileNotFoundException, UnsupportedEncodingException {
        System.out.println("Enter 1 to test an input string, or 2 to test a random puzzle");

        Scanner scan = new Scanner(System.in);

        String choice = scan.nextLine();

        String input = "";

        switch (choice) {
            case "1":
                //User enters input string
                while (true) {
                    System.out.print("Enter input string: ");
                    input = scan.nextLine();
                    input = RenselTools.cleanString(input);
                    if (!isSolvable(input)) {
                        System.out.println("This input is not solvable");
                    } else break;
                }
                System.out.print("\nUse h1 or h2? :");
                choice = scan.nextLine();
                if (choice.contains("h1")) {
                    BoardNode root = new BoardNode(input);
                    StateSpaceH1 space = new StateSpaceH1(root);
                    //root.printBoard();
                    //space.aStarH1();
                    System.out.println("Solution found at depth: " + space.aStar());

                } else if (choice.contains("h2")) {
                    BoardNode root = new BoardNode(input);
                    StateSpaceH2 space = new StateSpaceH2(root);
                    //root.printBoard();
                    //space.aStarH1();
                    System.out.println("Solution found at depth: " + space.aStar());

                } else {
                    System.out.println("Invalid choice");
                }
                break;
            case "2":
                //a solvable string is generated
                ArrayList randIn = new ArrayList<Integer>();
                for (int i = 0; i < 9; i++) {
                    randIn.add(i);
                }
                StringBuilder str;
                do {
                    str = new StringBuilder();
                    Collections.shuffle(randIn);
                    for (int i = 0; i < 9; i++) {
                        str.append(randIn.get(i));
                    }
                    System.out.println("Random string generated = " + str.toString());
                } while (!isSolvable(str.toString()));


                System.out.println("This puzzle is solvable");

                System.out.print("\nUse h1 or h2? :");
                choice = scan.nextLine();

                if (choice.contains("h1")) {
                    BoardNode root = new BoardNode(str.toString());
                    StateSpaceH1 space = new StateSpaceH1(root);
                    //root.printBoard();

                    space.aStar();

                } else if (choice.contains("h2")) {
                    BoardNode root = new BoardNode(str.toString());
                    StateSpaceH2 space = new StateSpaceH2(root);
                    //root.printBoard();

                    space.aStar();

                } else {
                    System.out.println("Invalid choice");
                }

                break;


            case "testh1":
                testH1();
                break;


            case "testh2":
                testH2();

                break;


            default:
                System.out.println("Invalid choice");

        }
    }

    static void testH1() throws FileNotFoundException, UnsupportedEncodingException {

        long timeSum;
        long initTime, totalTime;
        int tempDepth;
        PrintWriter out = new PrintWriter("outputH1100.csv", "UTF-8");
        for(int i=0; i<100;i++) {


            ArrayList in = new ArrayList<Integer>();
            for (int j = 0; j < 9; j++) {
                in.add(j);
            }
            StringBuilder strIn;
            do {
                strIn = new StringBuilder();
                Collections.shuffle(in);
                for (int j = 0; j < 9; j++) {
                    strIn.append(in.get(j));
                }
                //System.out.println("Random string generated = " + strIn.toString());
            } while (!isSolvable(strIn.toString()));

            initTime = System.nanoTime() ;

            //System.out.println("This puzzle is solvable");


            BoardNode root = new BoardNode(strIn.toString());
            StateSpaceH1 space = new StateSpaceH1(root);
            //root.printBoard();

            tempDepth = space.aStar();
            totalTime = (System.nanoTime() ) - initTime;

            out.println(tempDepth + "," + totalTime + "," + space.totalNodes);


        }

        out.close();


    }



        static void testH2() throws FileNotFoundException, UnsupportedEncodingException {

                long timeSum;
                long initTime, totalTime;
                int tempDepth;
                PrintWriter out = new PrintWriter("outputH21000.csv", "UTF-8");
                for(int i=0; i<1000;i++) {


                    ArrayList in = new ArrayList<Integer>();
                    for (int j = 0; j < 9; j++) {
                        in.add(j);
                    }
                    StringBuilder strIn;
                    do {
                        strIn = new StringBuilder();
                        Collections.shuffle(in);
                        for (int j = 0; j < 9; j++) {
                            strIn.append(in.get(j));
                        }
                        //System.out.println("Random string generated = " + strIn.toString());
                    } while (!isSolvable(strIn.toString()));

                    initTime = System.nanoTime() ;


                    //System.out.println("This puzzle is solvable");


                    BoardNode root = new BoardNode(strIn.toString());
                    StateSpaceH2 space = new StateSpaceH2(root);
                    //root.printBoard();

                    tempDepth = space.aStar();
                    totalTime = (System.nanoTime() ) - initTime;

                    out.println(tempDepth + "," + totalTime + "," + space.totalNodes);


                }

                out.close();


        }





        /*File f = new File("src/test.txt");

        Scanner scan = new Scanner(f);


        while(scan.hasNextLine()) {


            String initState = scan.nextLine();
            if (!isSolvable(initState)) {
                System.out.println("Input is not solvable");
                return;
            }

            BoardNode root = new BoardNode(initState);
            StateSpaceH2 space = new StateSpaceH2(root);
            //root.printBoard();
            //space.aStarH1();
            space.aStarH2();
            //space.expandNode(root);

            //System.out.println("Total nodes created: " + space.totalNodes);

        }*/


    }


