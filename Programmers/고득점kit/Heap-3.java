package Algorthm.Programmers.고득점kit;

// 이중우선순위큐
class doublePriority{
    public int[] solution(String[] operations) {
        int[] answer = {};
        ArrayList<Integer> array = new ArrayList<>();

        for(String operation : operations){
            if(operation.equals("D 1")){
                if(array.isEmpty()) continue;
                Collections.sort(array);
                array.remove(array.size()-1);
            }else if(operation.equals("D -1")){
                if(array.isEmpty()) continue;
                Collections.sort(array);
                array.remove(0);
            }else {
                array.add(Integer.valueOf(operation.substring(2)));
            }
        }
        Collections.sort(array);
        if(array.isEmpty()){
            answer = new int[]{0, 0};
        }
        else{
            answer = new int[]{array.get(array.size() - 1),array.get(0)};
        }
        return answer;
    }
}