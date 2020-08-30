// K번째 수
class KNUM {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int length=0;
        int idx =0;

        for(int i=0;i<commands.length;i++){

            int start = commands[i][0]-1;
            int end = commands[i][1]-1;
            idx = commands[i][2]-1;
            if(start == end){
                answer[i] = array[start];
            }
            else {
                length = commands[i][1] - commands[i][0] + 1;
                int[] subarray = new int[length];

                for (int j = 0; j < length; j++) {
                    subarray[j] = array[start];
                    start++;
                }
                Arrays.sort(subarray);
                System.out.println(Arrays.toString(subarray));
                answer[i] = subarray[idx];
            }
        }
        return answer;
    }
}