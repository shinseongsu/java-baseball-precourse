package baseball.uitl;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RandomUtil {
    public static String create() {
        Set<Integer> result = new HashSet<Integer>();

        while(result.size() != 3) {
            result.add(Randoms.pickNumberInRange(1, 9));
        }
        return setOfString(result);
    }

    public static String setOfString(Set<Integer> set) {
        StringBuilder result = new StringBuilder();
        Iterator<Integer> setIterator = set.iterator();

        while(setIterator.hasNext()) {
            result.append(setIterator.next());
        }
        return result.toString();
    }
}
