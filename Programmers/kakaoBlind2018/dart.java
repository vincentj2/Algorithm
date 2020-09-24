public class solve {
    public static void main(String[] args)  {
        num6 k = new num6();
        int ans =k.solution("1S*2T*3S");
        System.out.println(ans);
    }
}

class num6{
    public int solution(String dartResult) {
        int answer = 0;
        int [] point = new int[3];
        int idx = 0;

        String temp = "";

        for(int i=0 ; i<dartResult.length() ; i++) {
            char c = dartResult.charAt(i);

            if(c >= '0' && c <= '9') {
                temp += String.valueOf(c);
            } else if(c == 'S' || c == 'D'|| c == 'T'){
                int p = Integer.parseInt(temp);

                if(c == 'S') p = (int) Math.pow(p, 1);
                else if(c == 'D') p = (int) Math.pow(p, 2);
                else if(c == 'T') p = (int) Math.pow(p, 3);

                point[idx++] = p;
                temp = "";
            } else {
                if(c == '#') {
                    point[idx-1] *= -1;
                } else {
                    point[idx-1] *= 2;
                    if(idx-2 >= 0) point[idx-2] *= 2;
                }
            }

        }

        for(int val : point) {
            answer += val;
        }

        return answer;
    }
}