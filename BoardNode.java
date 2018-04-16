public class BoardNode {
    String board;
    short zeroPos;
    short depth;
    short h1;
    short h2;

    BoardNode(String input){
        board = input;
        depth = 0;
        h1 = -1;
        h2 = -1;
        zeroPos = findZero();
    }

    BoardNode(String input, short d){
        board = input;
        depth = d;
        h1 = -1;
        h2 = -1;
        zeroPos = findZero();
    }



    public void printBoard(){
        for(short i=0; i<9; ){
            System.out.print(board.charAt(i) + ", " );
            i++;
            if(i%3 == 0){
                System.out.println();
            }
        }
        System.out.println("Zero is at position " + zeroPos);
    }

    private short findZero(){
        for(short i=0; i<9; i++){
            if(Character.getNumericValue(board.charAt(i)) == 0){
                return i;
            }
        }
        return -1;
    }
}
