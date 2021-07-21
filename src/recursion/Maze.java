package recursion;

/**
 * @className: maze
 * @author: coderhls
 * @date: 2021/7/11
 * @description: 递归之迷宫问题
 **/
public class Maze {
    public static void main(String[] args) {
        // 构建二维数组模拟迷宫
        int[][] maze = new int[8][7];
        // 1为墙
        for (int i = 0; i < 7; i++) {
            maze[0][i] = 1;
            maze[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            maze[i][0] = 1;
            maze[i][6] = 1;
        }
        maze[3][1] = 1;
        maze[3][2] = 1;
        // 输出地图
        System.out.println("初始地图");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }

        getWay(maze, 1, 1);
        System.out.println("小球路径");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 使用递归回溯来给小球找路
     * 0：没走过
     * 1：墙
     * 2：通路可以走
     * 3：已经走过，但是走不通
     * @param maze 迷宫地图
     * @param i 出发点横坐标
     * @param j 出发点纵坐标
     * @return true：找到路；false：没找到路
     */
    public static boolean getWay(int[][] maze, int i, int j) {
        if (maze[6][5] == 2) {
            return true;
        } else {
            if (maze[i][j] == 0) {
                // 当前坐标还没走过
                // 按照策略 下→右→上→左走
                maze[i][j] = 2;
                // 向右走
                if (getWay(maze, i + 1, j)) {
                    return true;
                } else if (getWay(maze, i, j + 1)) {
                    return true;
                } else if (getWay(maze, i - 1, j)) {
                    return true;
                } else if (getWay(maze, i, j - 1)) {
                    return true;
                } else {
                    // 走不通
                    maze[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
