package boj9663;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/9663
public class Main {
    public static void main(String[] args) {
        // 입력
        input();
        // 동작부
        proc(1);
        System.out.println(a);
    }
    
    static int n, a;
    static int[] col;

    // 함수 구현
    static void proc(int k) {
        if(k == n+1) { // 값 추가
            a++;
        } else {
            for(int i=1; i<=n; i++) {
                boolean p = true;
                // 검사
                for(int j=1; j<=k-1; j++) {
                    if(attckCheck(k, i, j, col[j])) {
                        p = false;
                        break;
                    }
                }

                if(p) {
                    col[k] = i;
                    proc(k+1);
                    col[k] = 0;
                }
            }
        }
    }

    static boolean attckCheck(int r1, int c1, int r2, int c2) {
        if(c1 == c2) {
            return true;
        }

        if(r1 - c1 == r2 - c2) {
            return true;
        }

        if(r1 + c1 == r2 + c2) {
            return true;
        }

        return false;
    }

    static void input() {
        // 숫자 입력
        fastSb sc = new fastSb();
        n = sc.nextInt();
        // 배열크기 설정
        col = new int[n+1];
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