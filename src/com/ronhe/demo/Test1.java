package com.ronhe.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Scanner;
import javax.swing.JOptionPane;
import org.junit.Test;

/**
* auther: rjc
* email:rjc@ronhe.com.cn
* version: 1.0.0
* desc:
*/
public class Test1 {
	
	/**
	 *  题目：企业发放的奖金根据利润提成。
	 *  利润(I)低于或等于10万元时，奖金可提10%；
	 *  利润高于10万元，低于20万元时，低于10万元的部分按10%提成，高于10万元的部分，可可提成7.5%；
	 *  20万到40万之间时，高于20万元的部分，可提成5%；
	 *  40万到60万之间时高于40万元的部分，可提成3%；
	 *  60万到100万之间时，高于60万元的部分，可提成1.5%，高于100万元时，超过100万元的部分按1%提成，
	 *  从键盘输入当月利润I，求应发放奖金总数？  
	 *  1.程序分析：请利用数轴来分界，定位。注意定义时需把奖金定义成长整型。 
	 */
	@Test
	public void test12(){
		
	}
	
	/**
	 * 题目：有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？   
	 * 1.程序分析：可填在百位、十位、个位的数字都是1、2、3、4。组成所有的排列后再去 掉不满足条件的排列。
	 * https://github.com/rjunchao/test.git
	 */
	@Test
	public void test11(){
	    int t=0;
	   //循環
	    for(int i = 1; i <= 4; i++){
	    	for(int j = 1; j <= 4; j++){
	    		for(int k = 1; k <= 4; k++){
	    			if(i != j && i != k && j != k){
	    				t++;
	    				System.out.println(i*100 + j*10 + k);
	    			}
	    		}
	    	}
	    }
	    System.out.println("组合出--->" + t + "个数");
	}
	
	/**
	 * 题目：一球从100米高度自由落下，每次落地后反跳回原高度的一半；
	 * 再落下，求它在   第10次落地时，共经过多少米？第10次反弹多高？ 
	 */
	@Test
	public void test10(){
		double h = 0.0;
		double m = 100;
		for(int i = 0; i < 10; i++){
			h += m;
			m = m/2;
		}
		System.out.println(h);
		System.out.println(m);
	}
	
	/**
	 * 一个数如果恰好等于它的因子之和，这个数就称为 "完数 "。
	 * 例如6=1＋2＋3.编程   找出1000以内的所有完数。
	 * @throws IOException 
	 */
	@Test
	public void test9() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("输入判断完数的数：");
		String numStr = br.readLine();
		int num = new BigDecimal(numStr).intValue();
		if(isPerfectNumber(num)){
			System.out.println(num + " 是完数");
		}else{
			System.out.println(num + " 不是完数");
		}
	}
	
	/**
	 * 判断是否是完数
	 * @param number
	 * @return
	 */
	public static boolean isPerfectNumber(int number){
		int sum = 1;
		System.out.println(sum);
		for(int i = 2; i <= number/2; i++){
			if(number % i ==0){
				System.out.println(i);
				sum = sum + i;
			}
		}
		System.out.println();
		if(sum == number){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。
	 * 例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制
	 * @throws IOException 
	 */
	@Test
	public void test8() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("请输入数字：");
		String nStr = br.readLine();
		int n = new BigDecimal(nStr).intValue();
		int sum = n;
		int t = n;
		System.out.println(t);
		for(int i = 0; i < n-1; i++){//
			t = t*10 + n;
			System.out.println(t);
			sum  = sum + t;
		}
		System.out.println(sum);
		
		
	} 
	
	/**
	 * 输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。   
	 * 1.程序分析：利用while语句,条件为输入的字符不为 '\n '
	 */
	@Test
	public void test7(){
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入字符，除\\n外:");
		String text = scan.next();
		int countc = 0;
		int counte = 0;
		if(text != null && !text.equals("")){
			//匹配正则表达式
			String che = "[\u4e00-\u9fa5]";//中文字符
			String ee = "[a-zA-Z]";//匹配字符的
			char[] chars = text.toCharArray();
			for(int i = 0; i < chars.length; i++){
				String c = String.valueOf(chars[i]);
				if(c.matches(che)){
					countc++;
				}
				if(c.matches(ee)){
					counte++;
				}
			}
		}
		System.out.println("中文字符个数：" + countc);
		System.out.println("英文字符个数：" + counte);
	}
	/**
	 * 最大公约数和最下公倍数
	 */
	@Test
	public void test6(){
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入a:");
		int a = scan.nextInt();
		System.out.print("请输入b:");
		int b = scan.nextInt();
		System.out.println("a和b的最大公约数：" + commonDivisor(a,b));
		System.out.println("a和b的最小公倍数：" + lcm(a,b));
	}
	
	/**
	 * 求最大公约数
	 * 辗转相除法
	 * @param a
	 * @param b
	 * @return
	 */
	public static int commonDivisor(int a, int b){
		//保持a是的大数
		if(a < b){//a = 3, b = 4
			b = a + b;//7
			//a = 3  b=7;
			a = b - a;//a = 4 ,b = 7
			b = b - a;//a = 4 ,b = 7-4 =3
		}
		while(true){
			if(a % b == 0){
				//a整除b，b就是最大公约数
				return b;
			}else{
				//a不能整除b
				int c = a % b;
				a = b;
				b = c;
			}
		}
	}
	
	public static int lcm(int a, int b){
		return (a*b)/commonDivisor(a, b);
	}
	
	/**
	 * 题目：利用条件运算符的嵌套来完成此题：
	 * 学习成绩> =90分的同学用A表示，
	 * 60-89分之间的用B表示，
	 * 60分以下的用C表示。   
	 * 1.程序分析：(a> b)?a:b这是条件运算符的基本例子。
	 */
	@Test
	public void test5(){
		int num = 0;
		try {
			//显示一个输入提示框
			String numStr = JOptionPane.showInputDialog("请输入成绩："); 
			num = Integer.parseInt(numStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String grade = (num >=90)?"A":((num < 60)?grade="C":"B");
		System.out.println(grade);
	}
	/**
	 * ：将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。   
	 * 程序分析：对n进行分解质因数，应先找到一个最小的质数k，然后按下述步骤完成：   
	 * (1)如果这个质数恰等于n，则说明分解质因数的过程已经结束，打印出即可。   
	 * (2)如果n <> k，但n能被k整除，则应打印出k的值，并用n除以k的商,作为新的正整数你,重复执行第一步。   
	 * (3)如果n不能被k整除，则用k+1作为k的值,重复执行第一步。
	 */
	@Test
	public void test4(){
		int number = 90;
		resolve(number);
	}
	/**
	 * 解析合数
	 * @param number
	 */
	public static void resolve(int number){
		for(int i = 2; i < number/2; i++){
			if(number % i == 0){
				//这里输出的是素数
				System.out.print(i+"*");
				resolve(number/i);
			}
		}
		System.out.println(number);
		System.exit(0);
	}

	/**
	 * 打印出所有的 "水仙花数 "，
	 * 所谓 "水仙花数 "是指一个三位数，其各位数字立方和等于该数本身。
	 * 例如：153是一个 "水仙花数 "，因为153=1的三次方＋5的三次方＋3的三次方。   
	 * 1.程序分析：利用for循环控制100-999个数，每个数分解出个位，十位，百位
	 */
	@Test
	public void test3(){
		for(int i = 100; i <1000; i ++){
			if(isDaffodil(i)){
				System.out.println("该" + i + "是水仙花");
			}
		}
	}
	
	/**
	 * 判断是否是水仙花数
	 * @param number
	 * @return
	 */
	public static boolean isDaffodil(int number){
		//478
		int h = (int)number/100; //4
		//478%100 78/10 7
		int d = (int) ((number % 100)/10);
		//478% 10 =8
		int u = (int) ((number % 10));
		if((h*h*h + d*d*d + u*u*u) == number){
			System.out.println(h + ", " + d + ", " + u);
			return true;
		}
		return false;
		
	}
	
	/**
	 * 素数
	 * 即：只能把自己和1整数的数
	 */
	@Test
	public void test2(){
		for(int i = 101; i <= 200; i++){
			if(isPrimeNumber(i)){
				System.out.println(i + "-->不是素数");
			}else{
				System.out.println(i + "-->是素数");
			}
		}
	}
	
	/**
	 * 判断素数
	 * @param number
	 * @return
	 */
	public static boolean isPrimeNumber(int number){
		
		for(int i = 2; i < number/2; i++){
			if(number % i ==0){
				return true;
			}
		}
		return false;
		
		/*boolean result = false;
		for(int i = 2; i < number;i++){
			if(number%i == 0){
				 result = true;
				 break;
			}
		}
		return result;*/
	}
	
	/**
	 * 测试斐波拉函数，
	 * 题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第四个月后每个月又生一对兔子，
	 * 假如兔子都不死，问每个月的兔子总数为多少？   
	 * 1.程序分析：   兔子的规律为数列1,1,2,3,5,8,13,21....  
	 */
	@Test
	public void test1() {
		//算20个月的数量
		for(int i = 1; i <= 20; i++){
			System.out.println("第" +(i) + "个月的兔子数量：" + f(i));
		}
		//System.out.println(f(4));
	}
	
	private static int f(int x){
		//前面两个月，等于1
		if(x == 1 || x == 2){
			return 1;
		}else{
			//第x个月的数量等于前面两个月的数量和
			return f(x-1) + f(x-2);
		}
	}
	

}
