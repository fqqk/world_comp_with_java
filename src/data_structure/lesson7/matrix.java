package data_structure.lesson7;

public class matrix {
  // 計算量はO(n^2)
  public static boolean rotate(int[][] matrix) {
    // 単位行列かどうかのチェック
    if (matrix.length == 0 || matrix.length != matrix[0].length) return false;
    int n = matrix.length;
    for (int layer = 0; layer < n / 2; layer ++) {
      int first = layer;
      int last = n - 1 - layer;

      for (int i = first; i < last; i ++) {
        int offset = i - 1;
        int top = matrix[first][i]; // 上端の値を保存
        //左橋→上端
        matrix[first][i] = matrix[last - offset][first];
        //下端→左端
        matrix[last - offset][first] = matrix[last][last - offset];
        //右端→下端
        matrix[last][last - offset] = matrix[i][last];
        //上端→右端
        matrix[i][last] = top;  //右端 ← 保存された上端の値

      }
    }
    return true;
  }
  public static void main(String[] args) throws Exception {
    // javaでmatrix自体を生成するのが大変そう
  }
}