package boj.boj1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static String exp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        exp = bf.readLine();
        Stack<String> stack = new Stack<>();

        String regex = "\\d+|[+\\-*/]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(exp);

        while (matcher.find()) {
            stack.push(matcher.group());
        }

        List<Integer> calculatedNums = new ArrayList<>();
        int num = 0;
        while (!stack.isEmpty()) {
            String p = stack.pop();
            if(!"+".equals(p) && !"-".equals(p)) {
                num += Integer.parseInt(p);
                continue;
            }
            if("-".equals(p)) {
                calculatedNums.add(-num);
                num = 0;
            }
        }

        calculatedNums.add(num);

        int result = 0;
        for (Integer calculatedNum : calculatedNums) {
            result += calculatedNum;
        }

        System.out.println(result);
    }
}
