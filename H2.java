public class H2 {

    static String [] key = {
            "012123234",
            "101212323",
            "210321432",
            "123012123",
            "212101212",
            "321210321",
            "234123012",
            "323212101",
            "432321210"
    };

    public static int run(String in){
        int num = 0;
        int distance = 0;
        int total = 0;


        for(int i=0; i<9; i++){
            /*
            grab number at this position in the string,
            and then use the index of the respective "string key" to
            determine how far the number is from its correct position
            */
            num = Character.getNumericValue(in.charAt(i));
            distance = Character.getNumericValue(key[i].charAt(num));
            total+=distance;
        }
        return total;
    }
}
