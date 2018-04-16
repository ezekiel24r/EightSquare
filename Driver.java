public class Driver {

    public static boolean isSolvable(String in){

        char [] input = in.toCharArray();
        int inversions = 0;
        for(int i=0; i<9; i++){
            for(int j=(i+1); j<9; j++){
                if(input[j]<input[i]){
                    inversions++;
                }
            }
        }
        if((inversions % 2) == 0){
            return true;
        }
        else
            return false;
    }



    public static void main(String [] args){
        String initState = "018652374";
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

        System.out.println("hi");
    }


}
