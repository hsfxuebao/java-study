package offer;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class O_65_矩阵中的路径 {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(rows == 0 ||cols == 0){
            return false;
        }
        if(str.length == 0){
            return true;
        }
        boolean hasPath = false;
        boolean[] flag = new boolean[matrix.length];
        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                if(matrix[i * cols + j] == str[0]){
                    hasPath = core(matrix,i,j,rows,cols,str,flag,0);
                }
                if(hasPath){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean core(char[] arr,int i,int j,int rows,int cols,char[] str,boolean[] flag,int index){
        if(i < 0 ||j < 0 || i >= rows || j >= cols ||arr[i*cols+j] != str[index] || flag[i*cols+j]){
            return false;
        }
        if(index == str.length-1){
            return true;
        }
        flag[i*cols+j] = true;
        boolean f = core(arr,i+1,j,rows,cols,str,flag,index+1)||
                core(arr,i,j+1,rows,cols,str,flag,index+1)||
                core(arr,i-1,j,rows,cols,str,flag,index+1)||
                core(arr,i,j-1,rows,cols,str,flag,index+1);
        flag[i*cols+j] = false;
        return f;
    }
}