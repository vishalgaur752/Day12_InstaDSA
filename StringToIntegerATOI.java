public class StringToIntegerATOI {
    public static int atoiString(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        boolean negative = false;
        long ans = 0;
        int i = 0;
        if(s.charAt(i) == '-') {
            negative = true;
            i++;
        } else if(s.charAt(i) == '+') {
            i++;
        }
        while(i < s.length()) {
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9') {
                int dig = ch - '0';
                ans = ans * 10 + dig;
                if(negative) {
                    if(-ans < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    if(ans > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                }
            }else {
                break;
            }
            i++;
        }
        return negative ? (int)-ans : (int) ans;
    }

    public static void main(String[] args) {
        String s = "-042";
        System.out.println(atoiString(s));
    }
}
