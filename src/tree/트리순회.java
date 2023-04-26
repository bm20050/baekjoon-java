package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 트리순회 {

    public static void preorder(String[] tree, int i) {
        if (tree[i] == null)
            return;
        System.out.print(tree[i]);
        preorder(tree, i * 2);
        preorder(tree, i * 2 + 1);
    }

    public static void inorder(String[] tree, int i) {
        if (tree[i] == null)
            return;

        inorder(tree, i * 2);
        System.out.print(tree[i]);
        inorder(tree, i * 2 + 1);
    }

    public static void postorder(String[] tree, int i) {
        if (tree[i] == null)
            return;

        postorder(tree, i * 2);
        postorder(tree, i * 2 + 1);
        System.out.print(tree[i]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] tree = new String[67108865];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            if (map.get(s1) == null) {
                tree[i] = s1;
                map.put(s1, i);
                String s2 = st.nextToken();
                if (!s2.equals(".")) {
                    tree[i * 2] = s2;
                    map.put(s2, i * 2);
                }
                String s3 = st.nextToken();
                if (!s3.equals(".")) {
                    tree[i * 2 + 1] = s3;
                    map.put(s3, i * 2 + 1);
                }
            } else {
                String s2 = st.nextToken();
                if (!s2.equals(".")) {
                    tree[map.get(s1) * 2] = s2;
                    map.put(s2, map.get(s1) * 2);
                }

                String s3 = st.nextToken();
                if (!s3.equals(".")) {
                    tree[map.get(s1) * 2 + 1] = s3;
                    map.put(s3, map.get(s1) * 2 + 1);
                }
            }
        }

        preorder(tree, 1);
        System.out.println();
        inorder(tree, 1);
        System.out.println();
        postorder(tree, 1);
    }
}
