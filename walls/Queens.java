package walls;

public class Queens {
    public static int[][] q = new int[8][8];
    
    public static void main(String[] args) {
        init();
        showBoard();
        stabalizeQueens(0);
        System.out.println();
        showBoard();
    }
    
    private static void showBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.printf("%d ", q[i][j]);
            }
            System.out.println();
        }
        
    }

    public static void init() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                q[i][j] = 0;
            }
        }
    }
    
    public static boolean stabalizeQueens(int n) {
        if (n == 8) return true;
        
        for (int i = 0; i < 8; i++) {
            if (valid(n,i)) {
                q[n][i] = 1;
                boolean found = stabalizeQueens(n+1);
                if (found) break;
                q[n][i] = 0;
            }
        }
        return true;
    }

    private static boolean valid(int n, int m) {
        for (int i = 0; i < 8; i++) {
            if (i != m && q[n][i] == 1) return false;
            if (i != n && q[i][m] == 1) return false;
        }
        int s = n >= m ? m : n;
        int e = n >= m ? 8-n : 8-m;
        for ()
        return true;
    }
}
