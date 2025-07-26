
public class HanoiTower {
    
    public static void main(String[] args) {
        
        System.out.println(countHanoiTower(4, 1, 3));
    }

    public static int countHanoiTower(int n, int start, int end) {
       
        if (n == 1) {
            System.out.println(start + " => " + end);
            return 1;
        }

        int count = 0;
        int mid = 6 - (start + end);

        count += countHanoiTower(n - 1, start, mid);
        System.out.println(start + " => " + end);
        count += 1 + countHanoiTower(n - 1, mid, end);

        return count;
    }
}
