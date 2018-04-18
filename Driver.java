public class Driver {

    private static boolean isSolvable(String in){

        char [] input = in.toCharArray();
        int inversions = 0;
        for(int i=0; i<9; i++){
            for(int j=(i+1); j<9; j++){
                if((input[j]<input[i]) && (input[i] != 0)){
                    inversions++;
                }
            }
        }
        return (inversions % 2) == 0;
    }



    public static void main(String [] args){
        String initState = "158634072";
        if(!isSolvable(initState)){
            System.out.println("Input is not solvable");
            return;
        }

        BoardNode root = new BoardNode(initState);
        StateSpace space = new StateSpace(root);
        //root.printBoard();
        //space.aStarH1();
        space.aStarH2();
        //space.expandNode(root);

        System.out.println("Total nodes created: " + space.totalNodes);
    }


}
