package data_structure.lesson6;

public class string_compress {
  public static String compress(String str) {
    char[] compressed_str = new char[str.length()] ;
    int cons_num = 1;
    System.out.println(cons_num);
    for (int i = 1; i < str.length(); i++) {
      if (str.charAt(i - 1) == str.charAt(i)) {
        cons_num ++;
        System.out.println(cons_num);
      } else {
        if (cons_num == 1) {
          compressed_str[i - cons_num] = str.charAt(i - cons_num);
          compressed_str[i + 1 - cons_num] = 3;
          // compressed_str[i + 1 - cons_num] = (char)cons_num;
        } else {
          compressed_str[i - cons_num] = str.charAt(i - cons_num);
          compressed_str[i + 1 - cons_num] = 3;
          System.out.printf("cons_num::", cons_num);
          // System.out.printf("i + 1 - cons_num", i + 1 - cons_num);
          // compressed_str[i + 1 - cons_num] = (char)cons_num;
          cons_num = 1;
        }
      }
    }

    if (compressed_str.toString().length() < str.length()) {
      return String.valueOf(compressed_str);
    }
    return str;
  }

  // 模範解答1
  // pを元の文字列サイズ、kを連続する文字列群の数とすれば実行時間はO(p + k^2)
  // 文字列の連結にはO(n^2)の計算時間を要するのでじっさいはかなり遅い
  public static String compressBad(String str) {
    String compressedString = "";
    int countConsecutive = 0;
    for (int i = 0; i < str.length(); i ++) {
      countConsecutive ++;

      // 次の文字が現在の文字と異なる場合、この文字を結果に追加する
      if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
        compressedString += "" + str.charAt(i) + countConsecutive;
        countConsecutive = 0;
      }
    }
    return compressedString.length() < str.length() ? compressedString : str;
  }

  // StringBuilderを用いた改善案
  // StringBuilderは繋げたい文字列を一時的に溜めておいて、終わったら文字列全体のStringを作れる
  public static String compress_strbuld(String str) {
    StringBuilder compressed = new StringBuilder();
    int countConsecutive = 0;
    for (int i = 0; i < str.length(); i ++) {
      countConsecutive ++;

      // 次の文字が現在の文字と異なる場合、この文字を結果に追加する
      if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
        compressed.append(str.charAt(i));
        compressed.append(countConsecutive);
        countConsecutive = 0;
      }
    }
    return compressed.length() < str.length() ? compressed.toString() : str;
  }

  // 圧縮前後で文字の長さを比較
  public static void main(String[] args) throws Exception {
    // System.out.println(string_compress.compress("aaaaabbbbccccaaaaaa"));
    System.out.println(string_compress.compressBad("aaaaabbbbccccaaaaaa"));
    System.out.println(string_compress.compress_strbuld("aaaaabbbbccccaaaaaa"));
  }
}
