package com.sandz.hackerrank.warmup;

import java.io.IOException;
import java.util.Scanner;

public class AcmIcpcTeam {

    public static void main(String[] args) throws NumberFormatException,
            IOException {

        Scanner in = new Scanner((System.in));
        int noOfParticipants = in.nextInt();
        in.nextLine();
        String[] skills = new String[noOfParticipants];
        for (int i = 0; i < noOfParticipants; i++) {
            skills[i] = in.next();
        }
        in.close();
        // Long start = System.currentTimeMillis();

        solve(skills);
        // Long end = System.currentTimeMillis();
        // System.out.println((end - start));
    }

    private static void solve(String[] skills) {
        int maxSkills = 0;
        int count = 0;
        for (int i = 0; i < skills.length; i++) {
            String skillA = skills[i];
            for (int j = i + 1; j < skills.length; j++) {
                int retVal = 0;
                String skillB = skills[j];
                for (int y = 0; y < skillB.length(); y++) {
                    if (skillA.charAt(y) == '1' || skillB.charAt(y) == '1') {
                        retVal++;
                    }
                }
                if (retVal > maxSkills) {
                    count = 1;
                    maxSkills = retVal;
                } else if (retVal == maxSkills) {
                    count++;
                }
            }
        }
        System.out.println(maxSkills);
        System.out.println(count);
    }

}
