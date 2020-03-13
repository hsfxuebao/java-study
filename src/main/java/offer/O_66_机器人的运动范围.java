package offer;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class O_66_机器人的运动范围 {

    int count = 0;
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[] flag = new boolean[rows*cols];
        movingCount(threshold,0,0,rows,cols,flag);
        return count;
    }

    private void movingCount(int k,int i,int j,int rows,int cols,boolean[] flag){
        if(i < 0 || j < 0 || i >= rows || j >=cols || sum(i) + sum(j) > k ||flag[i*cols+j]){
            return ;
        }
        flag[i*cols+j] = true;
        count++;
        movingCount(k,i+1,j,rows,cols,flag);
        movingCount(k,i-1,j,rows,cols,flag);
        movingCount(k,i,j+1,rows,cols,flag);
        movingCount(k,i,j-1,rows,cols,flag);
    }

    private int sum(int i){
        int res = 0;
        do{
            res += (i % 10);
        }while( (i /= 10) > 0);
        return res;
    }


}