import java.util.ArrayList;
import java.util.HashMap;

public class StateSpace {
    private ArrayList<BoardNode> frontierSet;
    private HashMap<String, String> exploredSet;
    private boolean solution;

    StateSpace(BoardNode root){
        frontierSet = new ArrayList<>();
        exploredSet = new HashMap<>();
        solution = false;

        frontierSet.add(root);
    }

    private void addToFrontier(BoardNode in) {
        if(!exploredSet.isEmpty()) {
            for (int i = 0; i < exploredSet.size(); i++) {
                if (exploredSet.containsKey(in.board)) {
                    return;
                }

            }
        }
        frontierSet.add(in);
    }

    public void aStarH1(){
        while (!solution){
            calcH1();
            expandNode(frontierSet.get(getMinH1()));
        }
    }

    public void aStarH2(){
        while (!solution){
            calcH2();
            expandNode(frontierSet.get(getMinH2()));


        }
    }


    private int getMinH1(){
        int minIndex = 0;
        int minH1 = frontierSet.get(0).h1 + frontierSet.get(0).depth;
        for(int i=0; i<frontierSet.size(); i++){
            if((frontierSet.get(i).h1 + frontierSet.get(i).depth) < minH1){
                minH1 = (frontierSet.get(i).h1 + frontierSet.get(i).depth);
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
    }

    private void calcH1(){
        for (BoardNode node : frontierSet) {
            if (node.h1 == -1) {
                node.h1 = (short) H1.run(node.board);
            }
            if (node.h1 == 0) {
                System.out.println("solution!");
                solution = true;
            }
        }
    }

    private void calcH2(){
        for (BoardNode node : frontierSet) {
            if (node.h2 == -1) {
                node.h2 = (short) H2.run(node.board);
            }
            if (node.h2 == 0) {
                System.out.println("solution!");
                solution = true;
            }
        }
    }


    private void expandNode(BoardNode in){

        short d = (short)(in.depth + 1);
        String result = "";

        switch(in.zeroPos){
            case 0:

                 result = RenselTools.swap(in.board, 0, 1);
                 addToFrontier(new BoardNode(result,d));

                 result = "";

                 result = RenselTools.swap(in.board, 0, 3);
                 addToFrontier(new BoardNode(result,d));

                break;
            case 1:


                result = RenselTools.swap(in.board, 1, 0);
                addToFrontier(new BoardNode(result,d));

                result = "";

                result = RenselTools.swap(in.board, 1, 2);
                addToFrontier(new BoardNode(result,d));

                result = "";

                result = RenselTools.swap(in.board, 1, 4);
                addToFrontier(new BoardNode(result,d));


                break;
            case 2:
                result = RenselTools.swap(in.board, 2, 1);
                addToFrontier(new BoardNode(result,d));

                result = "";

                result = RenselTools.swap(in.board, 2, 5);
                addToFrontier(new BoardNode(result,d));

                break;
            case 3:
                result = RenselTools.swap(in.board, 3, 0);
                addToFrontier(new BoardNode(result,d));

                result = "";

                result = RenselTools.swap(in.board, 3, 4);
                addToFrontier(new BoardNode(result,d));

                result = "";

                result = RenselTools.swap(in.board, 3, 6);
                addToFrontier(new BoardNode(result,d));

                break;
            case 4:
                result = RenselTools.swap(in.board, 4, 1);
                addToFrontier(new BoardNode(result,d));

                result = "";

                result = RenselTools.swap(in.board, 4, 3);
                addToFrontier(new BoardNode(result,d));

                result = "";

                result = RenselTools.swap(in.board, 4, 5);
                addToFrontier(new BoardNode(result,d));
                result = "";

                result = RenselTools.swap(in.board, 4, 7);
                addToFrontier(new BoardNode(result,d));

                break;
            case 5:
                result = RenselTools.swap(in.board, 5, 2);
                addToFrontier(new BoardNode(result,d));

                result = "";

                result = RenselTools.swap(in.board, 5, 4);
                addToFrontier(new BoardNode(result,d));

                result = "";

                result = RenselTools.swap(in.board, 5, 8);
                addToFrontier(new BoardNode(result,d));

                break;
            case 6:
                result = RenselTools.swap(in.board, 6, 3);
                addToFrontier(new BoardNode(result,d));

                result = "";

                result = RenselTools.swap(in.board, 6, 7);
                addToFrontier(new BoardNode(result,d));

                break;
            case 7:
                result = RenselTools.swap(in.board, 7, 4);
                addToFrontier(new BoardNode(result,d));

                result = "";

                result = RenselTools.swap(in.board, 7, 6);
                addToFrontier(new BoardNode(result,d));

                result = "";

                result = RenselTools.swap(in.board, 7, 8);
                addToFrontier(new BoardNode(result,d));
                break;
            case 8:
                result = RenselTools.swap(in.board, 8, 5);
                addToFrontier(new BoardNode(result,d));

                result = "";

                result = RenselTools.swap(in.board, 8, 7);
                addToFrontier(new BoardNode(result,d));
                break;
        }
        exploredSet.put(in.board, "");
        frontierSet.remove(in);
    }
}
