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

        Set<String> str1Set = getElementSet(str1);
        Set<String> str2Set = getElementSet(str2);

        Set<String> totalSet = new HashSet<>();
        totalSet.addAll(str1Set);
        totalSet.addAll(str2Set);

        str1Set.retainAll(str2Set);

        double jacquard = (str1Set.size()*1.0)/totalSet.size();
        if(Double.isNaN(jacquard)) jacquard = 1;
        int result = (int) Math.floor(jacquard * 65536);
        return result;
    }

    public static Set<String> getElementSet(String str){
        String[] strArr = str.toLowerCase().split("");
        Set<String> strSet = new HashSet<>();
        String temp = "";
        int v = 0;
        for(int i=0; i<strArr.length-1; i++){
            v = 1;
            temp = strArr[i] + strArr[i+1];
            if(!temp.matches("[a-z][a-z]")) continue;
            while (strSet.contains(temp+v)){
                v+=1;
            }
            strSet.add(temp+v);
        }
        return strSet;
    }
}
