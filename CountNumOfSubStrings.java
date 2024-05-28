public class CountNumOfSubStrings {
    public static long subStrCount(String s, int k) {
        return atmost(s, k) - atmost(s, k-1);
    }
    public static long atmost(String s, int k) {
        int arr[] = new int[26];
        int dist = 0, left = 0;
        int res = 0;
        for(int i = 0; i<s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            if(arr[s.charAt(i) - 'a'] == 1) dist++;
            while(dist > k) {
                arr[s.charAt(left) - 'a']--;
                if(arr[s.charAt(left) - 'a'] == 0) dist--;
                left++;
            }
            res = res + (i - left+1);
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "aba";
        int k = 2;
        System.out.println(subStrCount(s, k));
    }
}
