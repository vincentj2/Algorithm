//방금그곡
class thatSong{

    public String solution(String m, String[] musicinfos) {
        String answer ="(None)";
        m = ChangeCd(m);
        int maxTime =0 ;
        for (String info : musicinfos) {
            String[] detailInfo = info.split(",");
            String start = detailInfo[0];
            String end = detailInfo[1];
            String name = detailInfo[2];
            String melody = detailInfo[3];
            melody = ChangeCd(melody);

            int startTime = 60 * Integer.parseInt(start.substring(0, 2)) + Integer.parseInt(start.substring(3, 5));
            int endTime = 60 * Integer.parseInt(end.substring(0, 2)) + Integer.parseInt(end.substring(3, 5));
            int time = endTime - startTime;

            if (maxTime < time) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < time; j++) {
                    int idx = j % (melody.length());
                    sb.append(melody.charAt(idx));
                }
                String fullMelody = sb.toString();
                if (fullMelody.contains(m)) {
                    maxTime = time;
                    answer = name;
                }
            }
        }
        return answer;
    }

    public String ChangeCd(String m ){
        m = m.replaceAll("C#","c");
        m = m.replaceAll("D#","d");
        m = m.replaceAll("F#","f");
        m = m.replaceAll("G#","g");
        m = m.replaceAll("A#","a");
        return m;
    }
}