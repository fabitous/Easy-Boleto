package API;

public class barcod {
    // do bar
    public static String doBar(String digitableLine) {
        return digitableLine.substring(0,3) +
                    digitableLine.charAt(3) +
                    digitableLine.charAt(32) +
                    digitableLine.substring(33,37) +
                    digitableLine.substring(37) +
                    digitableLine.substring(4, 9) +
                    digitableLine.substring(10, 20) +
                    digitableLine.substring(21, 31);
    }
    // do bar concenssionaria
    public static String doBarCon(String digitableLine) {
        return digitableLine.substring(0,11) +
                    digitableLine.substring(12,23) +
                    digitableLine.substring(24, 35) +
                    digitableLine.substring(36, 47);
    } 
}
