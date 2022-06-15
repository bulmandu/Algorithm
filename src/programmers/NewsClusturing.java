package programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/17677
 */
public class NewsClusturing {

    public static void main(String[] args) {
        System.out.println(solution("aa1+aa2", "AAAA12"));
    }

    public static int solution(String str1, String str2){
        String[] str1Arr = str1.toLowerCase().split("");
        String[] str2Arr = str2.toLowerCase().split("");

        Set<String> str1Set = getElementSet(str1Arr);
        Set<String> str2Set = getElementSet(str2Arr);

        Set<String> totalSet = new HashSet<>();
        totalSet.addAll(str1Set);
        totalSet.addAll(str2Set);

        str1Set.retainAll(str2Set);

        double jacquard = (str1Set.size()*1.0)/totalSet.size();

        int result = (int) Math.round(jacquard * 65536);
        return result;
    }

    public static Set<String> getElementSet(String[] strArr){
        Set<String> strSet = new HashSet<>();
        String temp = "";
        for(int i=0; i<strArr.length-1; i++){
            temp = strArr[i] + strArr[i+1];
            if(!temp.matches("[a-z][a-z]")) continue;
            strSet.add(temp);
        }
        return strSet;
    }
}
