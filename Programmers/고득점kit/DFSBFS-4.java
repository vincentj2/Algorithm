package Algorthm.Programmers.고득점kit;

//여행경로
class travelRoute{
    int ticketNum =0;
    int cnt =0;
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1];
        boolean[] used= new boolean[tickets.length];
        Arrays.sort(tickets, (o1, o2) -> {
            if(o1[0].equals(o2[0]))
                return o1[1] .compareTo(o2[1]);
            else
                return o1[0].compareTo(o2[0]);
        });
        System.out.println(Arrays.deepToString(tickets));
        for(int i=0;i<tickets.length;i++){
            String start = tickets[i][0];
            String arrive = tickets[i][1];
            if(start.equals("ICN")){
                used[i]=true;
                answer[0] = start;
                ticketNum =1;
                cnt =1;
                dfs(arrive,tickets,ticketNum, used,answer);
                if(ticketNum == tickets.length) return answer;
                used[i] =false;
                ticketNum --;
                cnt--;
            }
        }
        return answer;
    }
    public void dfs(String start, String[][] tickets, int ticketNum ,boolean[] used,String[] answer){
        if(ticketNum == tickets.length) {
            answer[ticketNum] = start;
            System.out.println("티켓다씀"+Arrays.toString(answer));
            return;
        }
        for(int j=0;j<tickets.length;j++){
            if(tickets[j][0].equals(start) && !used[j]){
                used[j] = true;
                answer[ticketNum]= tickets[j][0];
                System.out.println(Arrays.toString(answer) + "num : "+ticketNum);
                ticketNum +=1;
                cnt+=1;
                dfs(tickets[j][1],tickets,ticketNum,used,answer);
                if(cnt==tickets.length) {
                    System.out.println("다씀");
                    return;
                }else{
                    used[j] = false;
                    ticketNum --;
                    cnt--;
                    System.out.println("남음"+Arrays.toString(answer));
                }
            }
        }

    }
}