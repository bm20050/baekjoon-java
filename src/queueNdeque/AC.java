package queueNdeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String[] ss = br.readLine().split("[\\[\\],]");
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < ss.length; j++) {
                if (!ss[j].equals("")) {
                    list.add(Integer.parseInt(ss[j]));
                }
            }
            boolean flag = true;
            boolean error = false;
            for (int k = 0; k < s.length(); k++) {
                if (s.charAt(k) == 'R') {
                    flag = !flag;
                }
                else {
                    if (flag) {
                        if (list.size() != 0)
                            list.remove(0);
                        else
                            error = true;
                    }
                    else {
                        if (list.size() != 0)
                            list.remove(list.size() - 1);
                        else
                            error = true;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            if (error){
                System.out.println("error");
            }

            else {
                sb.append("[");
                if (flag) {
                    for (int x = 0; x < list.size(); x++) {
                        if (x != list.size() - 1)
                            sb.append(list.get(x)).append(",");
                        else
                            sb.append(list.get(x));
                    }
                }
                else {
                    for (int x = list.size() - 1; x >= 0; x--) {
                        if (x != 0)
                            sb.append(list.get(x)).append(",");
                        else
                            sb.append(list.get(x));
                    }
                }

                sb.append("]");
                System.out.println(sb);
            }

        }
    }
}
