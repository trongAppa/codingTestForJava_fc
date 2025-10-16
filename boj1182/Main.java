package boj1182;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1182
public class Main {
    public static void main(String[] args) {
        // 입력
        input();
        // 동작부
        proc(1, 0);
        if(s == 0) {
            cnt--;
        }
        System.out.println(cnt);
    }
    
    static int n, cnt, s;
    static int[] nums;

    // 함수 구현
    static void proc(int k, int value) {
        if(k == n+1) { // 값 추가
            if(value == s) cnt++;
        } else {
            proc(k+1, value+nums[k]);

            proc(k+1, value);
        }
    }

    static void input() {
        // 숫자 입력
        fastSb sc = new fastSb();
        n = sc.nextInt();
        s = sc.nextInt();
        // 배열크기 설정
        nums = new int[n+1];
        for(int i=1; i<=n; i++) {
            nums[i] = sc.nextInt();
        }
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