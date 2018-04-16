public class RenselTools {
    public static String swap(String in, int pos1, int pos2){
        String result = "";
        StringBuilder str = new StringBuilder(in);
        str.setCharAt(pos1,in.charAt(pos2));
        str.setCharAt(pos2,in.charAt(pos1));
        return str.toString();
    }


}
