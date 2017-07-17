package java异常概述;
/*
 * 1.异常体系：
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
 *函数上声明异常 
 *便于提高安全性，让调用处进行处理。不处理编译失败。
 *
 *3.对多异常的处理：
 *  ①声明异常时，建议声明具体，这样可以处理具体
 *  ②声明几个异常，对应几个catch。如果多个catch块中的异常出现继承关系，父类异常catch块出现在最下面
 *
 *建议进行catch处理时 一定要在catch中定义具体处理方式 （用硬盘文件记录 异常日志）
 *
 *4.自定义异常：
 *  项目会出现特有问题，这些问题并未被java描述分装对象 。所以对这些特有的问题可以按照java的对问题封装的思想。
 *  将特有的问题进行自定义。
 *  
 *  程序中除数是负数也视为是错误无法运算
 *  当函数内部出现throw抛出异常对象，就必须对应处理或者在函数上声明让调用者处理
 *  
 *  自定义异常应该定义异常信息：
 *  所以子类只要在构造时，将异常信息传给父类通过super语句，那就可以通过getmassage方法获取信息
 *  
 *  必须是自定义类继承Exception
 *  
 *  继承Exception原因：
 *  异常体系特点：异常类和异常对象都被抛出
 *  他们都具备可抛性，Throwable体系中独有特点
 *  
 *  只有这个体系中的成员才能被这样操作
 *  class Person extends Exception
 *  {
 *  }
 *  
 *  
 *5.throw 和  throws
 *位置：一个函数内/一个函数上
 *内容：异常对象/异常类,隔开
 *
 *
 *6.RuntimeException面试
 *  Exception中的一个特殊的子类异常，运行时异常。
 *  如果在函数内容抛出该异常，函数上可以不用声明，编译一样通过
 *  函数上如果声明该异常，调用者可以不进行处理，编译一样通过。
 *
 *   之所以不用在函数声明，是因为不需要让调用者处理。
 *   当该异常发生，希望程序停止。因为在运行时，出现了无法继续运算的情况，希望停止程序后，对代码进行修正。
 *   空指针异常是他的子类
 *   
 *   自定义异常时，异常发生无法继续运算 就继承RuntimeException
 *   
 *   异常分类：
 *   1.编译时被检测的异常
 *   2.编译时不被检测的异常（运行时异常，RuntimeException以及其子类
 *   
 ** */
class FuShuException extends Exception//继承
{
	/*private String msg;
	FuShuException(String msg)
	{
		this.msg = msg;	
	}
	public String getMessage()
	{
		return msg;
	}*/
	FuShuException(String msg,int value)
	{
		super(msg);
		this.value = value;
	}
	public int getValue()
	{
		return value;
	}
	
	/*空载
	FuShuException()
	{
		super();
	}*/

}
class Demo
{//程序提示此处需要异常处理  调用时用try
	int div(int a,int b)throws FuShuException,ArithmeticException,ArrayIndexOutOfBoundsException//功能上通过throws关键字声明功能可能会出现的问题
	{
		if(b<0)
			throw new FuShuException("出现情况为负数的现象",b);//手动抛出异常
		int[] arr = new int[a];
		
		System.out.println(arr[4]);//脚标越界 处理 
		return a/b;
	}
}



public class Java05异常概述 {
	
	public static void main(String[] args)//throws Exception//依然处理不了抛给虚拟机，默认方式解决，程序结束
	{
		Demo d = new Demo();
		try
		{
			int x = d.div(4,0);//new AritchmeticException()
			System.out.println("x="+x);
		}
		/*catch( Exception e)异常对象引用 Exception e = new AritchmeticException()
		{//内部类 函数 
			//异常被处理   如果没有异常处理catch 系统抛出异常无人接手 虚拟机开始默认处理机制 导致程序停止 
			System.out.println("/0");	
			System.out.println(e.getMessage());// by zero
			System.out.println(e.toString());// 异常信息异常名称
			e.printStackTrace();//异常名称信息以及异常出现位置
			//其实jvm默认的异常处理机制，就是在调用printStackTrace方法 。 打印异常的堆栈的跟踪信息。
		}*/
		/*多异常*/
		catch( ArithmeticException e)//异常对象引用 Exception e = new AritchmeticException()
		{//catch有针对性的异常 Exception没有针对性
			System.out.println(e.toString());// 异常信息异常名称
			System.out.println("/0");
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println(e.toString());// 异常信息异常名称
			System.out.println("脚标越界");
		}
		catch( FuShuException e)
		{
			System.out.println(e.toString());// 异常信息异常名称
			System.out.println("出现负数:"+e.getValue());
		}
		
		
		
		/*
		int x = d.div(4,0);//new AritchmeticException()
		System.out.println("x="+x);
		System.out.println("over");	
	*/
	}
//编译正常 运行不对
}
