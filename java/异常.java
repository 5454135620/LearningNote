package java异常概述;
/*
 * 异常体系：
 * 异常：程序在运行时出现不正常的情况，把问题封装成对象。
 * 异常由来：问题也是现实生活中一个具体事物，也可以通过java形式进行描述，并封装成对象。
 * 
 * 问题划分：
 * 严重 java通过Error类进行描述  不编写针对性代码处理 数组开辟空间超过物理内存空间
 * 非严重 java通过Exception类进行描述  使用征对性处理方式进行处理  数组下指标越界 空指针异常
 * 
 * 但上述两者都有共性内容。
 * 比如：不正常情况的信息，引发原因等。
 * 
 * Throw
 *   |--Error
 *   |--Exception
 * 
 *  java虚拟机有一个内置的异常处理机制
 *  
 *2.异常处理
 *特殊语句处理：
 *try
 *{
 *  需要被检测的代码；
 *}
 *catch(异常类 变量)
 *{
 *   处理异常的代码；(处理方式)
 *}
 *finally
 *{
 *   一定会执行的语句；
 *}
 *
 *
 *
 * */
class Demo
{//程序提示此处需要异常处理  调用时用try
	int div(int a,int b)throws Exception//功能上通过throws关键字声明功能可能会出现的问题
	{
		return a/b;
	}
}



public class Java05异常概述 {
	
	public static void main(String[] args)throws Exception//依然处理不了抛给虚拟机，默认方式解决，程序结束
	{
		Demo d = new Demo();
		/*try
		{
			int x = d.div(4,0);//new AritchmeticException()
			System.out.println("x="+x);
		}
		catch(Exception e)//异常对象引用 Exception e = new AritchmeticException()
		{//内部类 函数 
			//异常被处理   如果没有异常处理catch 系统抛出异常无人接手 虚拟机开始默认处理机制 导致程序停止 
			System.out.println("/0");	
			System.out.println(e.getMessage());// by zero
			System.out.println(e.toString());// 异常信息异常名称
			e.printStackTrace();//异常名称信息以及异常出现位置
			//其实jvm默认的异常处理机制，就是在调用printStackTrace方法 。 打印异常的堆栈的跟踪信息。
		}
		*/
		int x = d.div(4,0);//new AritchmeticException()
		System.out.println("x="+x);
		System.out.println("over");	
	
	}
//编译正常 运行不对
}
