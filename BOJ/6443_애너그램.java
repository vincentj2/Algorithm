import java.util.*;

public class solve {
    static int N;
    static char[] temp;
    static boolean[] isUsed;
    static String[] ans;
    static LinkedHashMap<String,Integer> words;


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        words = new LinkedHashMap<>();
        for(int i=0; i<N; i++) {
            String str = sc.next();

            char[] str_sort = str.toCharArray();
            Arrays.sort(str_sort);
            temp = new char[str.length()];
            isUsed = new boolean[str.length()];

            anagram(str_sort,isUsed,temp,0);
        }
        sc.close();
        ans = words.keySet().toArray(new String[words.size()]);
        for (String s : ans) {
            System.out.println(s);
        }
    }

    static void anagram(char[] str_sort, boolean[] isUsed,char[] temp,int cnt){
        if(cnt == str_sort.length){
            words.put(String.valueOf(temp), 1);
            return;
        }
        for(int i=0; i<str_sort.length;i++){
            if(!isUsed[i]){
                isUsed[i] = true;
                temp[cnt] = str_sort[i];
                anagram(str_sort,isUsed,temp,cnt+1);
                isUsed[i] = false;
            }
        }
    }

}