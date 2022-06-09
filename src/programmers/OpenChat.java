package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42888
 */
public class OpenChat {

    public static void main(String[] args) {

        args = new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};

        Map<String, String> userMap = new HashMap();
        ArrayList<String> answerLog = new ArrayList();

        for(String code : args){
            String[] codeArr = code.split(" ");
            String service = codeArr[0];
            String user = codeArr[1];
            String nickName = "";
            if(codeArr.length>2){
                nickName = codeArr[2];
            }

            switch(service) {
                case "Enter":
                    userMap.put(user, nickName);
                    answerLog.add(String.format("%s님이 들어왔습니다.", user));
                    break;
                case "Leave":
                    answerLog.add(String.format("%s님이 나갔습니다.", user));
                    break;
                case "Change":
                    userMap.put(user, nickName);
                    break;
                default: break;
            }
        }

        String[] answer = new String[answerLog.size()];
        int index = 0;
        for(String str : answerLog){
            int userIndex = str.indexOf("님");
            String userId = str.substring(0, userIndex);
            answer[index++] = str.replaceFirst(userId, userMap.get(userId));
        }
        System.out.println(Arrays.toString(answer));
//        return answer;

    }

}
