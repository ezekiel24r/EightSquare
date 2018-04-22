import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

public class StateSpaceH2 {
    private PriorityQueue<BoardNode> frontierSet;
    //private ArrayList<BoardNode> frontierSet;
    private HashMap<String, String> exploredSet;
    private boolean solution;
    public int totalNodes;

    StateSpaceH2(BoardNode root){
        frontierSet = new PriorityQueue<>();
        exploredSet = new HashMap<>();
        solution = false;

        addToFrontier(root);
        //frontierSet.add(root);
        totalNodes = 1;
    }

    private void addToFrontier(BoardNode in) {
        if(!exploredSet.isEmpty()) {
            for (int i = 0; i < exploredSet.size(); i++) {
                if (exploredSet.containsKey(in.board)) {
                    return;
                }

            }
        }
        in.h2 = (short)H2.run(in.board);
        if (in.h2 == 0) {
            //System.out.println("solution found at depth: " + in.depth);
            //if(in.depth != 20){
             //   System.out.println("wrong");
            //}
            solution = true;
            //printPath(in);
        }
        frontierSet.add(in);
        totalNodes+=1;
    }


    public int aStar(){
        while (!solution){
            //calcH2();
            expandNodeH2(frontierSet.peek());


        }
        //System.out.println(frontierSet.peek().depth);
        return frontierSet.peek().depth;

    }


    /*private int getMinH1(){
        int minIndex = 0;
        int minH1 = frontierSet.get(0).h2 + frontierSet.get(0).depth;
        for(int i=0; i<frontierSet.size(); i++){
            if((frontierSet.get(i).h2 + frontierSet.get(i).depth) < minH1){
                minH1 = (frontierSet.get(i).h2 + frontierSet.get(i).depth);
                minIndex = i;
            }
        }
        return minIndex;
    }

    private int getMinH2(){
        int minIndex = 0;
        int minH2 = frontierSet.get(0).h2 + frontierSet.get(0).depth;
        for(int i=0; i<frontierSet.size(); i++){
            if((frontierSet.get(i).h2 + frontierSet.get(i).depth) < minH2){
                minH2 = (frontierSet.get(i).h2 + frontierSet.get(i).depth);
                minIndex = i;
            }
        }
        return minIndex;
    }*/



    private void expandNodeH2(BoardNode in){

        //short d = (short)(in.depth + 1);
        String result = "";

        switch(in.zeroPos){
            case 0:

                 result = RenselTools.swap(in.board, 0, 1);
                 addToFrontier(new BoardNode(result, in));

                 result = "";

                 result = RenselTools.swap(in.board, 0, 3);
                 addToFrontier(new BoardNode(result, in));


                break;
            case 1:


                result = RenselTools.swap(in.board, 1, 0);
                addToFrontier(new BoardNode(result, in));

                result = "";

                result = RenselTools.swap(in.board, 1, 2);
                addToFrontier(new BoardNode(result, in));

                result = "";

                result = RenselTools.swap(in.board, 1, 4);
                addToFrontier(new BoardNode(result, in));


                break;
            case 2:
                result = RenselTools.swap(in.board, 2, 1);
                addToFrontier(new BoardNode(result, in));

                result = "";

                result = RenselTools.swap(in.board, 2, 5);
                addToFrontier(new BoardNode(result, in));


                break;
            case 3:
                result = RenselTools.swap(in.board, 3, 0);
                addToFrontier(new BoardNode(result, in));

                result = "";

                result = RenselTools.swap(in.board, 3, 4);
                addToFrontier(new BoardNode(result, in));

                result = "";

                result = RenselTools.swap(in.board, 3, 6);
                addToFrontier(new BoardNode(result, in));


                break;
            case 4:
                result = RenselTools.swap(in.board, 4, 1);
                addToFrontier(new BoardNode(result, in));

                result = "";

                result = RenselTools.swap(in.board, 4, 3);
                addToFrontier(new BoardNode(result, in));

                result = "";

                result = RenselTools.swap(in.board, 4, 5);
                addToFrontier(new BoardNode(result, in));
                result = "";

                result = RenselTools.swap(in.board, 4, 7);
                addToFrontier(new BoardNode(result, in));


                break;
            case 5:
                result = RenselTools.swap(in.board, 5, 2);
                addToFrontier(new BoardNode(result, in));

                result = "";

                result = RenselTools.swap(in.board, 5, 4);
                addToFrontier(new BoardNode(result, in));

                result = "";

                result = RenselTools.swap(in.board, 5, 8);
                addToFrontier(new BoardNode(result, in));


                break;
            case 6:
                result = RenselTools.swap(in.board, 6, 3);
                addToFrontier(new BoardNode(result, in));

                result = "";

                result = RenselTools.swap(in.board, 6, 7);
                addToFrontier(new BoardNode(result, in));


                break;
            case 7:
                result = RenselTools.swap(in.board, 7, 4);
                addToFrontier(new BoardNode(result, in));

                result = "";

                result = RenselTools.swap(in.board, 7, 6);
                addToFrontier(new BoardNode(result, in));

                result = "";

                result = RenselTools.swap(in.board, 7, 8);
                addToFrontier(new BoardNode(result, in));


                break;
            case 8:
                result = RenselTools.swap(in.board, 8, 5);
                addToFrontier(new BoardNode(result, in));

                result = "";

                result = RenselTools.swap(in.board, 8, 7);
                addToFrontier(new BoardNode(result, in));


                break;
        }
        exploredSet.put(in.board, "");
        frontierSet.remove(in);
    }

    private void printPath(BoardNode in){
        Stack<BoardNode> path= new Stack<>();

        while(true){
            path.push(in);
            if(in.parent != null){
                in = in.parent;
            }
            else break;
        }

        while(!path.isEmpty()){
            path.pop().printBoard();
        }
    }
}
