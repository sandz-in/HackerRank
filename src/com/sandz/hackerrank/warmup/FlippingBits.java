package com.sandz.hackerrank.warmup;

import java.util.Scanner;

public class FlippingBits
{
	static void solve(long[] a)
	{
		long x = 4294967295l;
		for (int i = 0; i < a.length; i++)
		{
			System.out.println(x - a[i]);
		}
	}
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine().trim());
		long a[] = new long[testCases];
		for (int i = 0; i < testCases; i++)
		{
			a[i] = Long.parseLong(in.nextLine());
		}

		solve(a);

	}
}
