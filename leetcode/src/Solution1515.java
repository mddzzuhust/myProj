

public class Solution1515 {
    public double getMinDistSum(int[][] positions) {
        double eps = 1e-7;

        double xLeft = 0.0, xRight = 100.0;
        while (xRight - xLeft > eps) {
            double xFirst = (xLeft + xLeft + xRight) / 3;

            double xSecond = (xLeft + xRight + xRight) / 3;

            if (checkOptimal(xFirst,positions,eps)<checkOptimal(xSecond,positions,eps)){
                xRight = xSecond;
            }else {
                xLeft = xFirst;
            }
        }
        return checkOptimal(xLeft,positions,eps);
    }

    public double getDist(double xc, double yc, int[][] positions) {
        double ans = 0;
        for (int[] pos : positions) {
            ans += Math.sqrt((pos[0] - xc) * (pos[0] - xc) + (pos[1] - yc) * (pos[1] - yc));
        }
        return ans;
    }

    public double checkOptimal(double xc, int[][] positions, double eps) {
        double yLeft = 0.0, yRight = 100.0;
        while (yRight - yLeft > eps) {
            double yFirst = (yLeft + yLeft + yRight) / 3;

            double ySecond = (yLeft + yRight + yRight) / 3;
            if (getDist(xc, yFirst, positions) < getDist(xc, ySecond, positions)) {
                yRight = ySecond;
            } else {
                yLeft = yFirst;
            }
        }
        return getDist(xc, yLeft, positions);
    }

}
