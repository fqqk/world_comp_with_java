package data_structure.lesson2;

public class CountSameLetters {
  // staticを抜くとインスタンス化する必要が出てくる
  public boolean permutation(String s, String t) {
    if(s.length() != t.length()) return false;
    
    // 使用する最大のメモリ領域→一定領域の確保だからO(1)
    int[] letters = new int[128]; //ASCⅡと仮定
    // 時間計算量はO(s.length() + t.length())
    for (int i = 0; i < s.length(); i++){
      letters[s.charAt(i)]++;
    }

    for (int i = 0; i < t.length(); i++){
      letters[t.charAt(i)]--;
      if(letters[t.charAt(i)] < 0){
        return false;
      }
    }
    return true;
  }
  public static void main(String[] args) throws Exception {
    // インスタンス生成する書き方
    CountSameLetters count_same_letters = new CountSameLetters();
    boolean result1 = count_same_letters.permutation("hello", "heoll");
    boolean result2 = count_same_letters.permutation("Hello", "heoll");
    boolean result3 = count_same_letters.permutation("hello ", "heoll ");
    System.out.println(result1);
    System.out.println(result2);
    System.out.println(result3);
  }
}
