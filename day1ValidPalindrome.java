public class day1ValidPalindrome {
    public static void main(String[] args) {
        
        String s = "A man, a plan, a canal: Panama";

        int left = 0;
        int right = s.length() - 1;
        boolean R = true;

        while (left < right) {
            
            // Step A: Left side se kachra (spaces/symbols) skip karo
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Step B: Right side se kachra (spaces/symbols) skip karo
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Step C: Lowercase me convert karke compare karo
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                R = false;
                break;
            }

            left++;
            right--;
        }

        System.out.println(R);
    }
}




/// for Leet Code 

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Left pointer: Non-alphanumeric character ko skip karo
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Right pointer: Non-alphanumeric character ko skip karo
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare after converting to lowercase
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
