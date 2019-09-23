import java.util.*;

public class SOP {
    public static void main(String[] args) {
        //Vector of Vector
        ArrayList<ArrayList<Integer>> al = new ArrayList<>()
        {{
            for (int i = 0; i < 4; i++) {
                add(new ArrayList<>(Collections.nCopies(5, -1)));
            }
        }};
//        for (int i = 0; i < 4; i++) {
//            al.add(i, new ArrayList<>(Collections.nCopies(5, -1)));
//        }
        System.out.println(al);
        //Vector of Hashmap
        ArrayList<HashMap<Integer, Integer>> a_map = new ArrayList<>();
//        {{
//            for (int i = 0; i < 5; i++) {
//                add(new HashMap<>());
//            }
//        }};
        for (int i = 0; i < 4; i++) {
            a_map.add(new HashMap<>());
        }

        System.out.println(al);
    }
}
