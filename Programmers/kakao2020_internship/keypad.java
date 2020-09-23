public class solve {
    public static void main(String[] args)  {
        num6 k = new num6();
        String ans =k.solution(new int[] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},"right");
        System.out.println(ans);
    }
}
//2020카카오 인턴십 - 키패드 누르기
//좌표평면으로 생각하기
class num6{
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int left =10;
        int right = 12;
        for(int i :numbers){
            if(i ==1 || i ==4 || i ==7){
                answer.append("L");
                left = i;
            }
            else if(i == 3|| i==6 || i==9){
                answer.append("R");
                right =i;
            }else {
                int distanceLeft = getDistance(left,i);
                int distanceRight = getDistance(right,i);
                if(distanceLeft == distanceRight){
                    answer.append(hand.equals("right")? "R" : "L");
                    if(hand.equals("right")) right =i;
                    else left =i;
                }
                else {
                    answer.append(distanceLeft > distanceRight ? "R" : "L");
                    if (distanceLeft > distanceRight) right = i;
                    else left = i;
                }
            }
        }
        return answer.toString();
    }

    public int getDistance(int position , int number){
        int distance =0;
        if(position ==0) position = 11;
        if(number ==0) number =11;

        int positionX = (position-1)/3;
        int positionY = (position-1)%3;
        int numberX = (number-1)/3;
        int numberY = (number-1)%3;

        distance = Math.abs(positionX-numberX) + Math.abs(positionY-numberY);
        return  distance;
    }
}