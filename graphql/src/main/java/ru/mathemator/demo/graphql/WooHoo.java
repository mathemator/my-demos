package ru.mathemator.demo.graphql;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WooHoo {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        StringBuilder sb = new StringBuilder();
        generate(n, n, sb);
    }

    static void generate(int left, int right, StringBuilder sb) {
        if (left > right) return;

        if (left == 0 && right == 0) {
            System.out.println(sb.toString());
            return;
        }

        if (left > 0) {
            sb.append('(');
            generate(left - 1, right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right > 0) {
            sb.append(')');
            generate(left, right - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}