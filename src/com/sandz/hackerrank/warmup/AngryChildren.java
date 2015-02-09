package com.sandz.hackerrank.warmup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// The part of the program involving reading from STDIN and writing to STDOUT has been provided by us.
public class AngryChildren {

    static Integer solve(List<Integer> packets, int numKids) {
        Integer retVal = Integer.MAX_VALUE;
        int size = packets.size();
        int j = size - numKids;
        for (int i = 0; i < j; i++) {
            retVal = Math.min(packets.get(i + numKids - 1) - packets.get(i),
                    retVal);
        }
        return retVal;
    }
    public static void main(String[] args) throws NumberFormatException,
            IOException {
        Scanner in = new Scanner((System.in));
        int numPackets = in.nextInt();
        int numKids = in.nextInt();

        List<Integer> packets = new ArrayList<Integer>();
        for (int i = 0; i < numPackets; i++) {
            packets.add((in.nextInt()));
        }

        in.close();
        Collections.sort(packets);
        Integer unfairness = solve(packets, numKids);

        System.out.println(unfairness);
    }
}
