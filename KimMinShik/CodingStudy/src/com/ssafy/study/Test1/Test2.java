package com.ssafy.study.Test1;


public class Test2 {

	public static void main(String[] args) {
		int[] su= { 45, 80, 68, 19, 34, 55, 27, 60, 27, 18 };
		double avg=0;
		for(int i = 0 ; i < su.length;i++) {
			avg+=su[i];
		}
		avg/=su.length;
		double mx = 0;
		int fin = 0 ;
		for(int i = 0 ; i < su.length;i++) {
			if(mx<Math.abs(su[i]-avg)) {
				fin = su[i];
				mx = Math.abs(su[i]-avg);
			}
		}
		System.out.printf("%.1f %d",avg,fin);
		
	}

}
