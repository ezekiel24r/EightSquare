public class H1 {
    public static int run(String in){
        int result = 0;
        for(int i=0; i<9; i++){
            if(Character.getNumericValue(in.charAt(i)) != i){
                result++;
            }
        }
        return result;
    }
}
