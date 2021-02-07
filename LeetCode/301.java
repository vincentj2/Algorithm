package Algorthm.LeetCode;

import java.util.*;

public class solve {
    public static void main(String[] args)  {
        Solution k = new Solution();
        List<String> ans =k.removeInvalidParentheses(")(");
        System.out.println(ans);
    }
}



class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> answer = Collections.singletonList("");
        removeInvalidParenthesis(s);

        return answer;
    }
    public boolean isParenthesis(char c)
    {
        return ((c == '(') || (c == ')'));
    }

    // method returns true if string contains valid
// parenthesis
    public boolean isValidString(String str)
    {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == '(')
                cnt++;
            else if (str.charAt(i) == ')')
                cnt--;
            if (cnt < 0)
                return false;
        }
        return (cnt == 0);
    }
    public void removeInvalidParenthesis(String str)
    {
        if (str.isEmpty())
            return;

        // visit set to ignore already visited string
        HashSet<String> visit = new HashSet<String>();

        // queue to maintain BFS
        Queue<String> q = new LinkedList<>();
        String temp;
        boolean level = false;

        // pushing given string as
        // starting node into queue
        q.add(str);
        visit.add(str);
        while (!q.isEmpty())
        {
            str = q.peek(); q.remove();
            if (isValidString(str))
            {
                System.out.println(str);

                // If answer is found, make level true
                // so that valid string of only that level
                // are processed.
                level = true;
            }
            if (level)
                continue;
            for (int i = 0; i < str.length(); i++)
            {
                if (!isParenthesis(str.charAt(i)))
                    continue;

                // Removing parenthesis from str and
                // pushing into queue,if not visited already
                temp = str.substring(0, i) + str.substring(i + 1);
                if (!visit.contains(temp))
                {
                    q.add(temp);
                    visit.add(temp);
                }
            }
        }
    }
}