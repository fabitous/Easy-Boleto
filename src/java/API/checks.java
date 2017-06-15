package API;

public class checks {
    // check numeric
    public static boolean numeric(String digitableLine) {
        boolean isNumeric = true;
        for(int index = 0; index < digitableLine.length(); index++) {
            String number = String.valueOf(digitableLine.charAt(index));
            if("0".equals(number) || 
                    "1".equals(number) || 
                        "2".equals(number) || 
                            "3".equals(number) || 
                                "4".equals(number) || 
                                    "5".equals(number) ||
                                        "6".equals(number) || 
                                            "7".equals(number) || 
                                                "8".equals(number) || 
                                                    "9".equals(number)) {
                    
            } else {
                isNumeric = false;
            }
        }
        return isNumeric;
    }
    // end check numeric
    // function validMod10
    public static boolean validMod10(String digitableLine) {
        boolean valid = true;
        int[] cvMod10 = new int[3];
        cvMod10[0] = 9;
        cvMod10[1] = 20;
        cvMod10[2] = 31;
        int mod10 = 0;
        int facMod10 = 1;
        for(int point = 0; point < digitableLine.length(); point++) {
            int number;
            if(point != cvMod10[0] && point != cvMod10[1] && point != cvMod10[2]) {
                if(facMod10 == 1) {
                    facMod10 = 2;
                } else {
                    facMod10 = 1;
                } 
                number = Integer.parseInt(String.valueOf(digitableLine.charAt(point)));
                number = number*facMod10;
                if(number >= 10) {
                    mod10 = mod10 + number%10;
                    mod10 = mod10 + number/10;
                } else {
                    mod10 = mod10 + number;
                }
            } else {
                mod10 = mod10%10;
                if(mod10 != 0) {
                    mod10 = 10 - mod10;                    
                }
                if(mod10 != Integer.parseInt(String.valueOf(digitableLine.charAt(point)))) {
                    valid = false;
                }
                System.out.print(digitableLine.charAt(point));
                mod10 = 0;                       
            }
        }
        return valid;
    }
    // end function validMod10
}
