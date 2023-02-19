package data_structure.lesson2;

public class Sort {
  String s;
  String t;
  
  // static methodはrubyでいうところのクラスメソッド。インスタンス化せずに直接呼び出せる
  public static String sort(String s) {
    char[] content = s.toCharArray();
    java.util.Arrays.sort(content);
    return new String(content);
  }

  public static boolean permutation(String s, String t) {
    if(s.length() != t.length()){
      return false;
    }
    return sort(s).equals(sort(t));
  }

  // Java実行に必須のメソッド
  public static void main(String[] args) throws Exception {
    boolean result1 = Sort.permutation("hello", "heoll");
    boolean result2 = Sort.permutation("Hello", "heoll");
    boolean result3 = Sort.permutation("hello ", "heoll ");
    System.out.println(result1);
    System.out.println(result2);
    System.out.println(result3);
  }
}
