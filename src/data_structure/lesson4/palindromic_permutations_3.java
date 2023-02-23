package data_structure.lesson4;

public class palindromic_permutations_3 {
  public static boolean isPermutationOfPalindrome(String phrase) {
    int bitVector = createBitVector(phrase);
    return bitVector == 0 || checkExactlyOneBitSet(bitVector);
  }

  // 文字列に対するビットベクトルを生成する
  // 各文字の文字番号iについてiビット目を切り替える
  public static int createBitVector(String phrase){
    int bitVector = 0;
    for(char c : phrase.toCharArray()){
      int x = getCharNumber(c);
      bitVector = toggle(bitVector, x);
    }
    return bitVector;
  }

  public static int toggle(int bitVector, int index){
    if(index < 0) return bitVector;

    int mask = 1 << index;
    if((bitVector & mask) == 0){
      bitVector |= mask;
    } else {
      bitVector &= -mask;
    }
    return bitVector;
  }

  public static boolean checkExactlyOneBitSet(int bitVector){
    return (bitVector & (bitVector - 1)) == 0;
  }
}
