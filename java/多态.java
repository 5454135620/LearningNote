package java08面向对象多态;
/*
 定义：
 事物存在的多种体现形态
函数的多态性
对象的多态性
人 女人 男人
多态自始至终都是子类对象的变化
*/

//1.表现形式:
//父类的引用    指向    自己的子类对象                    F f = new Z();
//父类的引用可以   接受    自己的子类对象          
  /* void fun(Animal F)
   {
	   F.eat();
   }
   public static void main (String[] args)
   {
	   fun(new Z());
   }*/
//2.前提
//类之间有关系，继承 实现     extend
//前提存在覆盖（eat（）） 继承内容有覆盖  体现事物多态性

//3.好处
//提高程序的扩展性   

//4.弊端：
//扩展性 但是只能使用父类的引用访问父类成员

//5.应用:

//6.多态出现在代码中的特点（多态的使用注意事项）：

class Fu
{
	int num=0;
	void fun1()
	{
		System.out.println("Fu fun_1");
	}
	void fun2()
	{
		System.out.println("Fu fun_1");
	}
	static void fun4()
	{
		System.out.println("Fu fun_4");
	}
	

}


class Zi extends Fu
{
	int num=1;
	void fun1()
	{
		System.out.println("Zi fun_1");
	}
	void fun3()
	{
		System.out.println("Zi fun_3");
	}
	static void fun4()
	{
		System.out.println("Zi fun_4");
	}

}


class Operator
{
	void fun(Fu f)
	{
		if(f instanceof Zi)//子类型有限时使用 -关键字
		{
			f.fun1();  
			f.fun2();
			//f.fun3();报错

/* 
			 *   Fu f = new Zi();  //类型提升  向上转型  相对=右
			 *   //只能调用子类父类的共有方法 
			 *   //所以f.fun3();错误  
			 * */
			/*
			 * 多态方法调用子类对象特有属性：
			 * */
		    Zi z = (Zi)f;//类型强转 将父类的引用类型转化为子类类型   向下转型 

z.fun3();
			f.fun4();//类同
		}
		else if(f instanceof Fu)
		{
			f.fun1();  
			f.fun2();
			f.fun4();
		}
		
		/*
		 * 在多态中 成员变量 的特点：
		 * 无论编译和运行 都看引用类变量
		 * 非静态方法区  this.method()  动态绑定
		 * 
		 * 多态中 静态成员函数 的特点：
		 * 无论编译和运行 都看引用类变量：
		 * 静态方法区   Fu.method4()  静态绑定
		 * 
		 * */
	}
}

public class Java多态总结 {
	
	public static void main(String[] args)
	{
		
		/*
		Zi z = new Zi();
		z.fun1();//覆盖
		z.fun2();//继承
		z.fun3();//特有
		z.fun4();//静态方法覆盖  类名调用 之看前面
		
		
		
		Fu f = new Zi();//多态调用方式
	    //成员函数多态调用 运行看右边 编译左边
		//编译时：参阅引用型变量所属的类中是否有调用方法 如果有 编译通过 无编译失败；
		// 运行时：参阅对象所属的类中是否有调用的方法 ；
		// 出现f.fun3()问题
		  
		f.fun1(); //子类对象方法 多态覆盖  
		f.fun2();
		//f.fun3();
		f.fun4();//静态方法覆盖   类名调用 之看前面
		*/
		
		
		/*定义操作类  提高调用效率*/
		Operator A = new Operator();
		//A.fun(new Fu());
		A.fun(new Zi());
			
	}

}


***
package java08面向对象多态;

/*
 * object:是所有对象直接或者间接的父类  定义了所有对象都具备的功能
 * 如果自定义类中有相同方法没有必要重新定义
 * 
 */

class A extends Object
{
	private int num ;
	A(int num)
	{
		this.num = num;
	}
	public boolean equals(Object obj)
	{
		//复写Object类中的equals方法  比较类中特有属性 成员变量
		//此方法适用于类之间的比较  相同类之间的比较才有意义
		if(!(obj instanceof A))
			return false;
		A d = (A) obj;
		return this.num == d.num;	
	}
  
}


/*
 * 网卡和主板的连接 可以通过规程接口 扩展提高电脑功能
 * 
 */

interface PCI
{//接口向上抽取的功能   实现网卡功能的转化   提高程序扩展性
	public void open();
	public void close();
	
}


class MainBoard
{
	public void run()
	{
		System.out.println("启动");
	}
	public void usepci(PCI a)
	{
		if(a!=null)
		{
			a.open();
			a.close();
		}
	}
	
	/*public void useNetcard(NetCard a)
	{
		a.open();
		a.close();
	}*/
}

class NetCard implements PCI
{
	public void open()
	{
		System.out.println("网卡系统打开！");
	}
	public void close()
	{
		System.out.println("网卡系统关闭！");
	}

}

class SoundCard implements PCI
{
	public void open()
	{
		System.out.println("声卡系统打开！");
	}
	public void close()
	{
		System.out.println("声卡系统关闭！");
	}

}

public class Java多态中成员的特点 {
	public static void main(String args[])
	{
		/*MainBoard a = new MainBoard();
		a.run();
		//a.usepci(new NetCard());
		a.usepci(null);//如果直接传入空操作 没有建立对象 就会空指针异常
		a.usepci(new NetCard());
		a.usepci(new SoundCard());
		*/
		A b = new A(4);
		A c = new A(5);
		
		System.out.println(b。equals(c));//?
	}

}




