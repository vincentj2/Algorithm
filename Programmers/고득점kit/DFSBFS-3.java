package Algorthm.Programmers.고득점kit;

//단어 변환
class wordChange {
    int answer = 0;
    int cnt = 0;
    int min =51;
    boolean[] visited;

    public int solution(String begin, String target, String[] words) {

        visited = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            visited[i] = false;
        }
        dfs(begin, target, words, visited,cnt);
        if(min == 51) min =0;
        answer = min;
        return answer;
    }

    //dfs
    // target을 찾았을때 까지의 길이를 cnt에 저장하고 작은 값이 나오면 min에 할당한다
    // 다음 노드로 들어가는 것을 cnt 추가하는걸로 확인
    //  visited를 true -> false로 다시 변경하여 부모 노드에서 다시 접근 가능하도록 한다
    public void dfs(String before, String target, String[] words, boolean[] visited, int cnt) {
        if (before.equals(target)){
            if(min>cnt){
                min = cnt;
            }
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && check(before, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, visited, cnt+1);
                visited[i] = false;
            }
        }
    }
    //한글자 다른지 확인
    boolean check(String before, String after){
        int cnt =0;
        for(int i=0; i<before.length();i++){
            if(before.charAt(i) != after.charAt(i)){
                cnt +=1;
            }
        }
        return cnt == 1;
    }
}

