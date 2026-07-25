
// String ko revese karna hai 


public class main {
    public static void main(String[] args) {
        
        String s = "ShobhiT";

        // ispe focus karna

        char[] arr = s.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        while(left < right) {
            
            // swap character

            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
            

        }
        
        // isko bhi dekh lena

        String result = new String(arr);

        System.out.println(result);
    }
}
