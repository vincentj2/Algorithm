package Algorthm.Programmers.고득점kit;

// 가장 큰 수
class Maxnum{
    public String solution(int[] numbers) {
        String answer = "";

        String[] arr = new String[numbers.length];
        for(int i=0; i<arr.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return (str2+str1).compareTo(str1+str2);
            }
        });
        System.out.println(Arrays.toString(arr));
        return (arr[0].equals("0")) ? arr[0] : String.join("",arr);
    }
}