package programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/17677
 */
public class NewsClusturing {

    public static void main(String[] args) {
        System.out.println(solution("E=M*C^2", "e=m*c^2"));
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
        if(Double.isNaN(jacquard)) jacquard = 1;
        int result = (int) Math.floor(jacquard * 65536);
        return result;
    }

    public static Set<String> getElementSet(String[] strArr){
        Set<String> strSet = new HashSet<>();
        String str = "";
        int v = 0;
        for(int i=0; i<strArr.length-1; i++){
            v = 1;
            str = strArr[i] + strArr[i+1];
            if(!str.matches("[a-z][a-z]")) continue;
            while (strSet.contains(str+v)){
                v+=1;
            }
            strSet.add(str+v);
        }
        return strSet;
    }
}
