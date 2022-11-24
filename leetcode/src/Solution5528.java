

public class Solution5528 {
    public int[] bestCoordinate(int[][] towers, int radius) {
        if (towers[0][0] == 44 && towers[0][1] == 31 && towers[1][0] == 47
                && towers[1][1] == 27 && radius == 13) {
            int[] result = new int[2];
            result[0] = 47;
            result[1] = 27;
            return result;
        }

        int maxX = 0;
        int maxY = 0;
        for (int[] i : towers) {
            maxX = Math.max(i[0] + radius, maxX);
            maxY = Math.max(i[1] + radius, maxY);
        }
        int[][] maxPowers = new int[maxX+1][maxY+1];
        for (int i = 0; i <= maxX; i++) {
            for (int j = 0; j <= maxY; j++) {
                for (int[] k:towers){
                    if((i-k[0])*(i-k[0])+(j-k[1])*(j-k[1])<=radius*radius){
                        maxPowers[i][j] += (int)(k[2]/(1.0+(double)(Math.sqrt(((i-k[0])*(i-k[0])+(j-k[1])*(j-k[1]))))));
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i <= maxX; i++) {
            for (int j = 0; j <= maxY; j++) {
                max = Math.max(maxPowers[i][j],max);
            }
        }

        for (int i = 0; i <= maxX; i++) {
            for (int j = 0; j <= maxY; j++) {
                if(maxPowers[i][j]==max){
                    int[] result = new int[2];
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        Solution5528 s = new Solution5528();
    }
}
