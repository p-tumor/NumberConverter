import java.util.ArrayList;
public class NumberConverter {
    int[] digits;
    int base;
    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i, i + 1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
    }
    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }
    public int[] getDigits() {
        return digits;
    }
    public int convertToDecimal() {
        ArrayList<Integer> digitsInDecimal = new ArrayList<>();
        int exponent = 0;
        for (int i = digits.length - 1; i > -1; i--) {
            int digitInDecimal = digits[i] * (int) Math.pow(base, exponent);
            digitsInDecimal.add(0, digitInDecimal);
            exponent++;
        }
        int sum = 0;
        for (int x : digitsInDecimal) {
            sum += x;
        }
        return sum;
    }
    public String convertToAnyBase(int base) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz=/";
        StringBuilder s = new StringBuilder("(");
        double temp;
        int count = 0;
        for (double toDecimal = convertToDecimal(); toDecimal > 0; toDecimal = (int) temp) {
            count++;
            temp =(toDecimal / base);
            int remainder = (int) ((temp % 1) * base);
            if(remainder > 9){
                int tempInt = Math.abs(9-remainder)-1;
                s.insert(1,chars.charAt(tempInt));
            }else s.insert(1, remainder);
        }
        s.append(")"+base);
        return s.toString();
    }
}