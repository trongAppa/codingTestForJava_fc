package boj15651;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/15651
public class Main {
    public static void main(String[] args) {
        // 입력
        input();
        // 동작부
        proc(1);
        // 출력
        System.out.println(sb.toString());
    }
    
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] selected;

    // 함수 구현
    // M만큼 k를 반복했으면 출력
    // M보다 k가 작을 경우 -> k번째 부터 M번째까지 반복
    static void proc(int k) {
        // k가 M+1과 값이 같으면 sb에 해당 값 저장(1로 시작했으니까 +1함)
        if(k == M + 1) {
            // 배열반복
            for(int i=1; i<=M; i++)
            {
                // 배열저장
                sb.append(selected[i]).append(' ');
            }
            // 줄바꿈
            sb.append('\n');
        } else {
            for(int i=1; i<=N; i++) {
                // 해당 배열에 값 저장
                selected[k] = i;
                
                // 재귀시작
                proc(k+1);
                // 배열 초기화
                selected[k] = 0;
            }
        }
    }

    static void input() {
        fastSb sc = new fastSb();
        N = sc.nextInt();
        M = sc.nextInt();
        selected = new int[M+1];
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
