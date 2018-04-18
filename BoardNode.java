public class BoardNode implements Comparable<BoardNode> {
    String board;
    short zeroPos;
    short depth;
    short h1;
    short h2;
    BoardNode parent;

    BoardNode(String input){
        board = input;
        depth = 0;
        h1 = -1;
        h2 = -1;
        zeroPos = findZero();
    }

    BoardNode(String input, BoardNode p){
        board = input;
        depth = (short)(p.depth+1);
        h1 = -1;
        h2 = -1;
        zeroPos = findZero();
        parent = p;
    }

    public int compareTo(BoardNode in){
        if((in.depth + in.h2) > (this.depth + this.h2 )){
            return -1;
        }
        else if((in.depth + in.h2) < (this.depth + this.h2)){
            return 1;
        }
        else return 0;
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
