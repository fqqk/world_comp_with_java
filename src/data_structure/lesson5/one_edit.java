package data_structure.lesson5;

public class one_edit {
  public static boolean oneEditAway(String first, String second){
    if(first.length() == second.length()){
      return oneEditReplace(first, second);
    } else if (first.length() + 1 == second.length()) {
      return oneEditInsert(first, second);
    } else if (first.length() - 1 == second.length()) {
      return oneEditInsert(second, first);
    }
    return false;
  }

  public static boolean oneEditReplace(String s1, String s2) {
    boolean foundDifference = false;
    for (int i = 0; i < s1.length(); i ++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        if(foundDifference) {
          return false;
        }

        foundDifference = true;
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
    System.out.println(one_edit.oneEditAway("abcd", "abcd"));
  }
}
