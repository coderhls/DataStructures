package sparsearray;

/**
 * @className: SparseArray
 * @author: coderhls
 * @date: 2021/7/10
 * @description: 稀疏数组
 **/
public class SparseArray {
    public final static int ROW = 11;
    public final static int COLUMN = 11;

    public static void main(String[] args) {
        int chessArr1[][] = new int[ROW][COLUMN];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        System.out.println("原始数组=====>");
        for (int[] row : chessArr1) {
            for (int i : row) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }

        // 得到稀疏数组的个数
        int sum = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                if (chessArr1[i][j] != 0) sum++;
            }
        }

        int sparseArr[][] = new int[sum + 1][3];
        sparseArr[0][0] = ROW;
        sparseArr[0][1] = COLUMN;
        sparseArr[0][2] = sum;

        int count = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        System.out.println();
        System.out.println("稀疏数组======>");
        for (int[] ints : sparseArr) {
            System.out.printf("%d\t%d\t%d\t\n", ints[0], ints[1], ints[2]);
        }

    }

}
