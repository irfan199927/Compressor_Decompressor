public class Main{
    public static void main(String[] args) {
        int []arr = {1,2,3,4,5,6};
        boolean ans = StrictlyIncreasing(arr, 0);
        System.out.println( ans);

    }
    public static boolean StrictlyIncreasing(int []arr, int n){
        if(n==arr.length-1){
            return true;
        }
        if(arr[n]>=arr[n+1]){
            return false;
        }
        return StrictlyIncreasing(arr, n+1);
    }
}