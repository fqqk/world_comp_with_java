import data_structure.Sort;

public class App {
    public static void main(String[] args) throws Exception {
        boolean result = Sort.permutation("hello", "heoll");
        String sort_result = Sort.sort("faafjal");
        System.out.println(result);
        System.out.println(sort_result);
    }
}