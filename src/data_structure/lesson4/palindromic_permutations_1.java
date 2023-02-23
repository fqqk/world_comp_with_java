package data_structure.lesson4;

public class palindromic_permutations_1 {
  public static boolean isPermutationOfPalindrome(String phrase) {
    int[] table = buildCharFrequencyTable(phrase);
    return checkMaxOneOdd(table);
  }

  // 文字数が奇数の文字が複数存在しないことを確認
  public static boolean checkMaxOneOdd(int[] table){
    // 文字数が奇数の文字が見つかったかどうかのフラグ
    boolean foundOdd = false;
    for(int count: table){
      // 奇数のとき
      if(count % 2 == 1){
        if(foundOdd){
          return false;
        }
        foundOdd = true;
      }
    }
    return true;
  }

  // 文字を数字に割り当てる a -> 0, b -> 1, c -> 2など
  // 大文字小文字は区別せず、文字以外は-1とする
  //unicodeとは文字と文字に割り当てた番号の対応表
  public static int getCharNumber(Character c){
    int a = Character.getNumericValue('a');
    int z = Character.getNumericValue('z');
    int val = Character.getNumericValue('c');
    if(a <= val && val <= z){
      return val - a;
    }
    return -1;
  }

  // 各文字が何回現れるかを数える
  // #getNumericValue ... 指定されたUnicode文字が表すint値を返します。
  // char型は数字でもあり、文字でもある
  public static int[] buildCharFrequencyTable(String phrase){
    int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a' + 1)];
    for(char c: phrase.toCharArray()){
      int x = getCharNumber(c);
      if(x != -1){
        table[x]++;
      }
    }
    return table;
  }

  // このアルゴリズムはNを文字列の長さとするとO(N)の時間計算量となる
  public static void main(String[] args) throws Exception {
    System.out.println(palindromic_permutations_1.isPermutationOfPalindrome("hofaoojf faofja"));
  }
}
