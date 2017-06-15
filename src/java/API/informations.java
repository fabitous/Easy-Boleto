package API;

public class informations {
    // value
    public static String value(String digitableLine) {
        int start = 0;
        for(int index = 0; index < digitableLine.length(); index++) {
            if((Integer.parseInt(String.valueOf(digitableLine.charAt(index))) != 0) ||
                    (start > 6)) {
                index = digitableLine.length();
            } else {
                start++;
            }
        }
        return digitableLine.substring(start, 8) + "," + digitableLine.substring(8);            
    }
    // value con
    public static String valueCon(String digitableLine) {
        int start = 0;
        for(int index = 0; index < digitableLine.length(); index++) {
            if((Integer.parseInt(String.valueOf(digitableLine.charAt(index))) != 0) ||
                    (start > 7)) {
                index = digitableLine.length();
            } else {
                start++;
            }
        }
        return digitableLine.substring(start, 9) + "," + digitableLine.substring(9);            
    }
    // shelf life
    public static String shelflife(String factor) {
        return shelf.life(factor);
    }  
}
