package data_structure.lesson5;

public class one_edit {
  public static boolean oneEditAway(String first, String second){

    // 文字数が同じ場合は置き換え処理
    if(first.length() == second.length()){
      return oneEditReplace(first, second);
    // 文字数差が(+-)1の場合は挿入処理。削除は挿入の逆処理
    } else if (first.length() + 1 == second.length()) {
      return oneEditInsert(first, second);
    } else if (first.length() - 1 == second.length()) {
      return oneEditInsert(second, first);
    }
    return false;
  }

  public static boolean oneEditReplace(String s1, String s2) {
    // 違い発見フラグ
    int foundDiffCount = 0;
    for (int i = 0; i < s1.length(); i ++) {
      // s1のi文字目とs2のi文字目が異なる場合
      if (s1.charAt(i) != s2.charAt(i)) {
        // 合計2文字異なっていたらfalseが返却される
        foundDiffCount++;
        if(foundDiffCount >= 2) {
          return false;
        }
      }
    }
    return true;
  }

  //文字をs1に挿入してs2にできるかどうかを確認する
  public static boolean oneEditInsert(String s1, String s2) {
    int index1 = 0;
    int index2 = 0;
    while (index2 < s2.length() && index1 < s1.length()) {
      if (s1.charAt(index1) != s2.charAt(index2)) {
        if(index1 != index2) {
          return false;
        }
        index2 ++;
      } else {
        index1 ++;
        index2 ++;
      }
    }
    return true;
  }

  public static void main(String[] args) throws Exception {
    System.out.println(one_edit.oneEditAway("abcd", "abcdf"));
  }
}
