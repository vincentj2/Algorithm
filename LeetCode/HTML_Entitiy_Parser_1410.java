public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        String ans =k.solution("and I quote: &quot;...&quot;");
        System.out.println(ans);
    }
}

/*  33ms 40.1MB
    문자열 치환
 */
class Solution {
    public String solution(String text) {
        text = text.replace("&quot;","\"");
        text = text.replace("&apos;","'");
        text = text.replace("&gt;",">");
        text = text.replace("&lt;","<");
        text = text.replace("&frasl;","/");
        //&amp의 경우 &로 변경되어 다른 문자열에 영향를 줄 수 있기 때문에 마지막에 처리한다
        text = text.replace("&amp;","&");
        return text;
    }
}