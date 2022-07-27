package com.ssafy.study.Test1;

public class Test3 {

	public static void main(String[] args) {
		int t = 10000;
		int p = 2530;
		int g = t-p;
		System.out.printf("투입금액 : %d원\n",t);
		System.out.printf("상품금액 : %d원\n",p);
		System.out.printf("거스름돈 : %d원\n",g);
		System.out.println("------------------------------");
		
		int d[] = {1000,500,100,50,10};
		int fin[] = new int[d.length];
		for(int i = 0 ; i<5;i++) {
			int t1= g/d[i];
			int t2 = g%d[i];
			fin[i] = t1;
			g=t2;
		}
		
		for(int i = 0 ; i<5;i++) {
			System.out.printf("%d원 : %d장\n",d[i],fin[i]);
		}
	}

}
