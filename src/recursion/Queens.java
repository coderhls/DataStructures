package recursion;

/**
 * @className: Queens
 * @author: coderhls
 * @date: 2021/7/11
 * @description: 八皇后问题
 **/
public class Queens {
    // 定义皇后棋子数量
    int max = 8;
    int[] array = new int[max];
    static int count = 0;
    static int judgeCount = 0;
    public static void main(String[] args) {
        Queens queue8 = new Queens();
        queue8.check(0);
        System.out.printf("一共有%d 解法", count);
        System.out.printf("一共判断冲突的次数%d 次", judgeCount); // 1.5w
    }

    //编写一个方法， 放置第 n 个皇后
    //特别注意： check 是 每一次递归时， 进入到 check 中都有 for(int i = 0; i < max; i++)， 因此会有回溯
    private void check(int n) {
        if(n == max) { //n = 8 , 其实 8 个皇后就既然放好
            print();
            return;
        } //依次放入皇后， 并判断是否冲突
        for(int i = 0; i < max; i++) {
            //先把当前这个皇后 n , 放到该行的第 1 列
            array[n] = i;
            //判断当放置第 n 个皇后到 i 列时， 是否冲突
            if(judge(n)) { // 不冲突
                //接着放 n+1 个皇后,即开始递归
                check(n+1); //
            } //如果冲突， 就继续执行 array[n] = i; 即将第 n 个皇后， 放置在本行得 后移的一个位置
        }
    }

    private boolean judge(int n) {
        judgeCount++;
        for(int i = 0; i < n; i++) {
            // 说明
            //1. array[i] == array[n] 表示判断 第 n 个皇后是否和前面的 n-1 个皇后在同一列
            //2. Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示判断第 n 个皇后是否和第 i 皇后是否在同一斜线
            // n = 1 放置第 2 列 1 n = 1 array[1] = 1
            // Math.abs(1-0) == 1 Math.abs(array[n] - array[i]) = Math.abs(1-0) = 1
            //3. 判断是否在同一行, 没有必要， n 每次都在递增
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i]) ) {
                return false;
            }
        }
        return true;
    }

    /**
     * 输出皇后的摆放位置
     */
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
