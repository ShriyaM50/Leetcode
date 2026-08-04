class Solution {
    public boolean isPalindrome(String s) {

        StringBuilder clean = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                clean.append(Character.toLowerCase(ch));
            }
        }

        String original = clean.toString();

        String reversed = new StringBuilder(original).reverse().toString();

        return original.equals(reversed);
    }
}