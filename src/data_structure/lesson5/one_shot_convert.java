package data_structure.lesson5;

public class one_shot_convert {
  public static boolean isConvertible(String words, String converted_words) {
    boolean isEqual = false;
    // 2文字以上の文字数差がある場合は判定終了
    isEqual = checkWordsLength(words, converted_words);

    // 変換前の文字数 < 期待文字数の場合はinsert処理を行う
    if(words.length() < converted_words.length()){
      System.out.println(insertWord(words, converted_words));
    }
    return isEqual;
  }

  public static String insertWord(String words, String converted_words){
    // 変換前の文字列の数 < 変換後の文字列の数の場合に呼ばれる
    StringBuilder sb = new StringBuilder();
    char[] beforeChars = words.toCharArray();
    char[] afterChars = converted_words.toCharArray();
    int leftSearchCount = 0;
    int rightSearchCount = 0;
    int leftIndex = 0;
    int rightIndex = 0;
    // beforeの先頭から探索する場合とafterの後ろから探索する場合の2パターンの探索を考える
    // beforeの先頭から
    for(int i = 0; i < words.length(); i++){
      if(beforeChars[i] != afterChars[i]){
        leftSearchCount ++;
        leftIndex = i;
      }
    }
    for(int j = converted_words.length() - 1; j > 0; j --){
      if(beforeChars[j-1] != afterChars[j]){
        rightSearchCount ++;
        rightIndex = j;
      }
    }
    if(leftSearchCount == 0 && rightSearchCount == 1){
      // 1番後ろに追加
      sb.append(words);
      sb.insert(sb.length(), afterChars[rightIndex]);
    } else if (leftSearchCount == words.length() && rightSearchCount == 0){
         // 1番前に追加
         sb.append(words);
         sb.insert(0, afterChars[0]);
    } else if (leftSearchCount < words.length() && rightSearchCount < converted_words.length()){
      if(leftIndex == rightIndex){
        sb.append(words);
        sb.insert(leftIndex, afterChars[leftIndex]);
      }
    } else {
      sb.append("none");
    }
    return sb.toString();
  }

  // public static String deleteWord(String str){
  //   // 変換前の文字列の数 > 変換後の文字列の数の場合に呼ばれる 
  // }

  // public static String replaceWord(String str){
  //   // 変換前の文字列の数 = 変換後の文字列の数の場合に呼ばれる
  // }

  public static boolean checkWordsLength(String words, String converted_words){
        // 全ての処理を実行し、それでも操作後の文字列が一致しない場合はfalseを返す
        int wordsLength = Math.abs(words.length());
        int convertedWordsLength = Math.abs(converted_words.length());
        // 2文字以上の文字数差がある場合は判定終了
        if(Math.abs(wordsLength - convertedWordsLength) > 1) return false;
        return true;
  }

  // // 対象文字列に操作を行うインデックスの場所を返却する
  // public static int searchTargetIndex(String words, String converted_words){
  //   char[] beforeChars = words.toCharArray();
  //   char[] afterChars = converted_words.toCharArray();
  //   // countが1以上であればありえない数字1000を返却する
  //   int count = 0;
  //   // 操作によって繰り返し回数が異なる
  //   // TODO: メソッドとして共通化すべきかどうか
  //   // まず共通化するまえにべたで書いてしまう。
  //   for()
  // }

  public static void main(String[] args) throws Exception {
    System.out.println(one_shot_convert.insertWord("bc", "bca"));
  }
}
