package offer;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class O_01_二维数组中的查找 {

    public boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }

        int m = array.length-1;
        int n = 0;

        while (m >= 0 && n >= 0 && m < array.length && n < array[0].length) {
            if (array[m][n] == target) {
                return true;
            } else if (array[m][n] < target) {
                n++;
            } else {
                m--;
            }
        }

        return false;
    }
}