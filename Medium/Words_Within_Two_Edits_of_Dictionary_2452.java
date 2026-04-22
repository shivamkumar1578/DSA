package Medium;

import java.util.ArrayList;
import java.util.List;

public class Words_Within_Two_Edits_of_Dictionary_2452 {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        ArrayList<String> res = new ArrayList<String>();
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < dictionary.length; j++) {
                byte diff = 0;

                for (int k = 0; k < queries[i].length() && diff <= 2; k++)
                    if (queries[i].charAt(k) != dictionary[j].charAt(k))
                        diff++;

                if (diff <= 2) {
                    res.add(queries[i]);
                    break;
                }
            }
        }
        return res;
    }
}
