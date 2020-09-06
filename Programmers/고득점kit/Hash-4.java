
class bestAlbum{
    public static <K, V> K getKey(Map<K, V> map, V value) {
        // 찾을 hashmap 과 주어진 단서 value
        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }
    public int[] solution(String[] genres, int[] plays) {
        boolean[] chk = new boolean[plays.length];

        HashMap<String, Integer> totalList = new HashMap<>();
        for(int i=0;i<genres.length;i++){
            if(totalList.containsKey(genres[i])){
                totalList.put(genres[i],totalList.get(genres[i])+plays[i]);
            }
            else{
                totalList.put(genres[i], plays[i]);
            }
        }

        List<Integer> Rank = new ArrayList<>(totalList.values());
        Rank.sort(Collections.reverseOrder());
        //장르순 결정
        //플레이 횟수,순서 hashmap -> 횟수 정렬 -> 가장큰 횟수 == 장르 순 맞으면 2개까지 answer에 넣고 하나뿐이면 다음으로
        HashMap<Integer,Integer> numRank = new HashMap<>();
        for(int j=0;j<plays.length;j++){
            numRank.put(j,plays[j]);
        }
        List<Integer> playRank = new ArrayList<>(numRank.values());
        playRank.sort(Collections.reverseOrder());
        System.out.println(numRank);

        ArrayList<Integer> answerlist = new ArrayList<>();

        for(Integer genreSum : Rank){
            int num =0;
            for(int k=0; k< playRank.size();k++){
                if(genres[getKey(numRank,playRank.get(k))].equals(getKey(totalList,genreSum)) && num <=2){
                    if(answerlist.size() >1 && (plays[answerlist.get(answerlist.size()-1)] == playRank.get(k)) && (answerlist.get(answerlist.size()-1)>(getKey(numRank,playRank.get(k))))){
                        answerlist.set(answerlist.size()-1,getKey(numRank,playRank.get(k)));
                        System.out.println("ㅇㅇㅇㅇ");
                    }
                }
                if(genres[getKey(numRank,playRank.get(k))].equals(getKey(totalList,genreSum)) && num <2){
                    answerlist.add(getKey(numRank,playRank.get(k)));
                    chk[getKey(numRank,playRank.get(k))] = true;
                    num++;
                }
            }
        }
        int[] answer = new int[answerlist.size()];
        for(int i=0; i<answerlist.size();i++){
            answer[i] = answerlist.get(i);
        }

        return answer;
    }
}