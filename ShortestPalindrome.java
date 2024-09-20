
//https://leetcode.com/problems/shortest-palindrome/

public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        String rev = new StringBuilder(s).reverse().toString();
        String concat = s + "#" + rev;
        int[] Z = computeZ(concat);

        // BASICALLY WHAT PART OF REVERSE STRING IS ALSO PREFIX OF ORIGINAL
        // IF THE CONDITION SATISFIES YOU WILL HAVE TO ADD ALL THE REMAINING CHARACTERS UNTIL END OF REVERSE
        // BECAUSE OF THE ADD IN FRONT CONDITION
        int maxPalindromeLength = 0;
        for (int i = s.length() + 1; i < concat.length(); i++) {
            if (Z[i] == concat.length() - i) {
                maxPalindromeLength = Z[i];
                break;
            }
        }
        String suffixToAdd = rev.substring(0, s.length() - maxPalindromeLength);
        return suffixToAdd + s;
    }
    private int[] computeZ(String str) {
        int n = str.length();
        int[] Z = new int[n];
        int L = 0, R = 0;

        for (int i = 1; i < n; i++) {
            if (i < R) {
                Z[i] = Math.min(R - i , Z[i - L]);
            }
            while (i + Z[i] < n && str.charAt(Z[i]) == str.charAt(i + Z[i])) {
                Z[i]++;
            }
            if (i + Z[i]> R) {
                L = i;
                R = i + Z[i];
            }
        }

        return Z;
    }
}
