// 체욱복
class Cloth {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int member = n-lost.length;
        ArrayList<Integer> lostMember = new ArrayList<>();
        ArrayList<Integer> reserveMember = new ArrayList<>();
        for(int i : lost){
            lostMember.add(i);
        }
        for(int j: reserve){
            reserveMember.add(j);
        }
        //reserveMember 중 lostMember가 있다면 제거
        for(int i=0; i<lostMember.size();i++){
            for(int j=0; j<reserveMember.size();j++) {
                if (lostMember.get(i).equals(reserveMember.get(j))) {
                    lostMember.remove(i);
                    reserveMember.remove(j);

                    member += 1;
                    break;
                }
            }
        }
        //lostMember 중 여분을 받을 수 있는 인원 확인
        for (int lostNum : lostMember) {
            for (Integer reserveNum : reserveMember) {
                if (reserveNum - 1 == lostNum || reserveNum + 1 == lostNum) {
                    reserveMember.remove(reserveNum);
                    member += 1;
                    break;
                }
            }
        }
        answer = member;
        return answer;
    }
}
