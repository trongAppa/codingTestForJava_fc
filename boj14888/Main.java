package boj14888;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14888
public class Main {
    public static void main(String[] args) {
        // 입력
        input();
        // 동작부
        proc(1, num[1]);
        // 출력
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
    }
    
    static StringBuilder sb = new StringBuilder();
    static int n, max, min;
    static int[] num, oper, order;

    // 함수 구현
    static void proc(int k, int value) {
        if(k == n) {
            // 최종값 비교 후 큰 값 넣음
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            // 사칙연산 부호 반복
            for(int i=1; i<=4; i++) {
                if(oper[i] > 0) {
                    oper[i]--;
                    // 재귀함수 처리하여 마지막까지 비교
                    proc(k+1, cal(value, i, num[k+1]));
                    oper[i]++;
                }
            }
        }
    }

    // 계산함수 구현
    static int cal(int a, int o, int b) {
        if(o == 1) {        // +
            return a + b; 
        } else if(o == 2) { // -
            return a - b; 
        } else if(o == 3) { // *
            return a * b; 
        } else { // /
            return a / b; 
        }
    }

    static void input() {
        // 숫자 입력 갯수, 숫자, 사칙연산
        fastSb sc = new fastSb();
        // 숫자 입력 갯수
        n = sc.nextInt();
        // 배열크기 설정
        num = new int[n+1];
        oper = new int[5];
        order = new int[n+1];
        // 숫자 입력
        for(int i=1; i<=n; i++) {
            num[i] = sc.nextInt();
        }
        // 사칙연산 갯수 입력
        for(int i=1; i<=4; i++) {
            oper[i] = sc.nextInt();
        }

        // 최대 최소 -10억~10억
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    static class fastSb {
        BufferedReader br;
        StringTokenizer st;

        public fastSb() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public fastSb(String s) throws FileNotFoundException{
            br = new BufferedReader(new FileReader(new File(s)));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}