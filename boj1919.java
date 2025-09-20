import java.util.Scanner;

public class boj1919 {
    public static int[] getAlphaCnt(String str) {
        int[] cnt = new int[26];

        for(int i=0; i<str.length(); i++) {
            cnt[str.charAt(i) - 'a']++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        // 해당 구조를 함수로 변경 가능
        /*
        int[] cntA = new int[26];
        int[] cntB = new int[26];

        for(int i=0; i<a.length(); i++) {
            cntA[a.charAt(i) - 'a']++;
        }

        for(int i=0; i<b.length(); i++) {
            cntB[b.charAt(i) - 'a']++;
        } */

        int[] cntA = getAlphaCnt(a);
        int[] cntB = getAlphaCnt(b);

        int ans = 0;

        for(int i=0; i<26; i++) {
            // 절대값으로 변경
            ans += Math.abs(cntA[i] - cntB[i]);

            /*if(cntA[i] < cntB[i]) {
                ans += cntB[i] - cntA[i];
            } else if(cntB[i] < cntA[i]) {
                ans += cntA[i] - cntB[i];
            }*/
        }

        System.out.println(ans);
    }
}
