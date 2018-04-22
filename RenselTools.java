/*
Eric Rensel - CS420 - 4/22/2018
 */
public class RenselTools {
    public static String swap(String in, int pos1, int pos2){
        StringBuilder str = new StringBuilder(in);
        str.setCharAt(pos1,in.charAt(pos2));
        str.setCharAt(pos2,in.charAt(pos1));
        return str.toString();
    }

    public static String cleanString(String in){
        StringBuilder str = new StringBuilder();
        for(int i=0; i<in.length(); i++){
            if(in.charAt(i) != ' '){
                str.append(in.charAt(i));
            }
        }
        return str.toString();
    }


}
