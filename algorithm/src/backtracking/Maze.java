package backtracking;

public class Maze {
    public static void main(String[] args) {
        maze();
    }
    //迷宫回溯问题
    public static void maze() {
        //创建二维数组模拟迷宫
        //使用1表示墙，0表示路
        int[][] map = new int[][]{
                {1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1}
        };
        //输出地图
        System.out.println("迷宫：");
        for (int[] row : map) {
            for (int i : row) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }
        System.out.println("寻路结果：");
        //开始寻路
        setWay(map, 1, 1);
        //输出地图
        for (int[] row : map) {
            for (int i : row) {
                System.out.printf("%d\t", i);
            }
            System.out.println("");
        }

    }

    //传入地图map
    //传入开始位置(i, j)
    //如果能到达右下角(6, 5)，则说明找到通路
    //0表示未走过，1表示墙，2表示可以走的通路，3表示已经走过，但是走不通
    //确定方向策略：下 -> 右 -> 上 -> 左
    //若该点走不通，则回溯
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            //通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) {
                //如果当前点没有走过
                map[i][j] = 2;    //假定该点可以走通
                if (setWay(map, i + 1, j)) {
                    //向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    //向右走
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    //向上走
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    //向左走
                    return true;
                } else {
                    //该点走不通
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //如果map[i][j] != 0
                //可能是1、2、3
                return false;
            }
        }
    }
}
