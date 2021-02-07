package Algorthm.Programmers.kakaoBlind2018;

public class solve {
    public static void main(String[] args)  {
        num6 k = new num6();
        String[] ans =k.solution(6, new int[]{46,33,33,22,31,50}, new int[]{27,56,19,14,14,10});
        System.out.println(Arrays.toString(ans));
    }
}
class num6{
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];

        for(int i=0; i<arr1.length;i++){
            StringBuilder temp= new StringBuilder();
            int[] temp1 = new int[arr1.length];
            int[] temp2 = new int[arr1.length];
            for(int j=0; j<arr1.length; j++){
                temp1[arr1.length-1-j] = arr1[i]%2;
                arr1[i] = arr1[i]/2;

                temp2[arr1.length-1-j] = arr2[i]%2;
                arr2[i]= arr2[i]/2;
            }
            for(int k=0; k<arr1.length;k++){
                if(temp1[k] != 0 || temp2[k] !=0){
                    temp.append("#");
                }else{
                    if(k!=0 || k!=arr1.length-1) {
                        temp.append(" ");
                    }
                }
            }
            String aa =temp.toString();
            answer[i] =aa;
        }
        return answer;
    }
}