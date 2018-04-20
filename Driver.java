import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.util.*;

public class Driver {

    private static boolean isSolvable(String in){

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



    public static void main(String [] args) throws FileNotFoundException {


        ArrayList randIn = new ArrayList<Integer>();
        for(int i = 0; i<9; i++){
            randIn.add(i);
        }
        StringBuilder str;
        do {
            str = new StringBuilder();
            Collections.shuffle(randIn);
            for(int i = 0; i < 9; i++){
                str.append(randIn.get(i));
            }
        }while(!isSolvable(str.toString()));


        System.out.println(str.toString());




        BoardNode root = new BoardNode(str.toString());
        StateSpace space = new StateSpace(root);
        //root.printBoard();
        //space.aStarH1();
        space.aStarH2();
        //space.expandNode(root);

        System.out.println("Total nodes created: " + space.totalNodes);






        /*File f = new File("src/test.txt");

        Scanner scan = new Scanner(f);


        while(scan.hasNextLine()) {


            String initState = scan.nextLine();
            if (!isSolvable(initState)) {
                System.out.println("Input is not solvable");
                return;
            }

            BoardNode root = new BoardNode(initState);
            StateSpace space = new StateSpace(root);
            //root.printBoard();
            //space.aStarH1();
            space.aStarH2();
            //space.expandNode(root);

            //System.out.println("Total nodes created: " + space.totalNodes);

        }*/


    }


}
