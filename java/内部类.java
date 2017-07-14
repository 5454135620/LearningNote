
package java内部类和匿名内部类;
/*
 * 类文件被封装进对象
 * d1.class()//获取class文件
 * class文件里有构造函数和一般方法
 * 注意有的功能的复写  比如返回对象字符串值（哈希值）
 * 
 */
/*内部类：
 * 
 * 访问规则：
 * 	1.内部类可以直接访问外部类中的成员，包括私有
 *   之所以可以直接访问外部类中的成员，是因为内部类中持有一个外部类的引用 格式 外部类名。this。
 *  2.外部类想要访问内部类可以直接创建内部对象
 *  
 * 访问格式：
 * 1. 当内部类在外部类的成员位置上时，而且菲私有，可以在外部其他类中直接建立内部类对象
 *  格式：
 *  	外部类名。内部类名  变量 = 外部类对象（）。内部类对象（）；
 *   	Outer.Inner in =new Outer().new Inner();
 *  2.当内部类在 成员位置上 就可以被成员修饰符所修饰
 *     private ：将内部类在外部类中进行封装
 *     static： 内部类就具备static的特性
 *     当内部类被静态修饰后 只能直接访问外部类中的static成员。出现访问局限。 
 *     定义时为共享数据
 *     当内部类中定义了静态成员 该内部类必须是静态
 *     
 *     在外部其他类中如何直接访问静态内部类的非静态成员：：
 *        new Outer.Inner().function(); //function非静态
 *     在外部其他类中，如何直接访问Static内部类的静态成员：
 *        Outer.Inner.function();
 *      
 *      当外部类中的静态方法访问内部类时，内部类也必须是静态的
 *      
 * 3.应用：
 *     当描述事物时，事物内部还有事物，该事物用内部类来描述
 *     因为内部事务在使用外部事物的内容
 *     心脏直接使用身体的其他器官，定义在外 只能创建对象在使用 外部事物的内容
 *     class Body{
 *       private class xinzhang{
 *       //私有 不允许外部随意访问  
 *       
 *       }
 *       public void show()
 *       {//访问方法一般判断一下
 *          new xinzang().
 *       }
 *     }
 *        
 *     
 * */
/*class Outer
{
	int x;
	 class Inner//内部类直接访问方式   如果不被封装
	{//访问x时不用创建外部对象
		int x = 4;
		 void function()
		{ 
			int x = 6;
			System.out.println("内部类"+x);//x=6
			System.out.println("内部类"+this.x);//4
			System.out.println("内部类"+Outer.this.x);//3
			//外部类的引用
		}
	}
	
	static  class Inner2
	{
		void show()
		{
			System.out.println("inner2 show");
		}
	}
	
	void method()
	{
		
		Inner in =new Inner();
		in.function();
	}
	
	public static void method2()
	{
		//Inner.function(); static class  static function()
		new Inner2().show();
	}
}
public class Object类toString {
	public  static void  main (String[] args)
	{
		Outer.Inner in =new Outer().new Inner();
	}

}

*/
//静态 是成员修饰符 只能修饰成员  局部（方法，类）不能修饰
//非静态无对象 不运行
//可以直接访问外部类中的成员 ，因为还持有外部类的引用
// 但是不可以直接访问它们所在局部中的变量 只能访问被final修饰的局部变量
/*
class Outer{
	
	int x = 3;
	void method(final int a)
	{
		final int y = 4;//
		class Inner//局部内部类 
		{
			
			void function()
			{
				//System.out.println(Outer.this.x);
				System.out.println(y);
			}
		}
		new Inner().function();//调用局部内部类方法
	}
}

public class Object类toString {
	public static void main(String[] args)
	{
		new Outer().method(7);//调用局部内部类方法
		new Outer().method(8);
		
		Outer out = new Outer();
		out.method(7);//局部进栈 a=7 之后出栈
		out.method(8);//再进栈出栈 
	}
}
*/
/*
 * 匿名内部类：
 * 1.匿名内部类其实就是内部类的简写格式
 * 2.定义匿名内部类前提：
 *    内部类必须继承一个类或者接口
 * 3.匿名内部类的格式：
 *    new 父类或者接口（）
 *    {
 *    	定义子类的内容
 *    }
 * 4.匿名内部类就是一个匿名子类对象，创建可以加复写内容 也可以同时创建对象
 * 5.匿名内部类方法最好不要超过3个，多的话分装在类中使用
 * 6.使用多态调用各种函数方法 失去意义
 
 * */

abstract class AbsDemo
{//复写抽象方法 体现不同对象的特点
	abstract void show();
}

class Outer
{
	int x = 3;
	/*class Inner extends AbsDemo
	{//内部类继承外部类 复写抽象方法 体现不同对象的特点
		
		void show()
		{
			System.out.println(x);
		}
	}*/
	public void function()
	{
		/*对方法多调用时 匿名内部类的多调用*/
		AbsDemo d = new AbsDemo()//多态
		{//创建对象 还要带内容    是/**/部分的简化写法
			int num = 9;
			void show()
			{
				System.out.println(x);
			}
			void function()
			{
				System.out.println("定义一个函数"+num);
			}
		};
		d.show();
		//错误d.function();  不能调用子类的特有方法 必须向下转型 所以不行
		
		
		
		
		//new Inner().show();
		new AbsDemo()//匿名内部类
		{//创建对象 还要带内容    是/**/部分的简化写法
			
			void show()
			{
				System.out.println(x);
			}
			void function()
			{
				System.out.println("定义一个函数");
			}
		}.show();//。abc();可以调用匿名子类对象的方法
	}
}




/*小练习：*/
interface Inter
{
	void method();//抽象非静态
}

class Test
{
	/*通过匿名内部类表示
	 * static class Inner implements Inter
	{
		public void method()
		{
			System.out.println("method run");
		}
	}
		static Inter function()
		{
			 return new Inner();
		}
		*/
	static Inter function()
	{
		 return new Inter()
		 {
			 public void method()
			 {
				 System.out.println("method run");
			 }
		 };
	}
	
		
}
public class Object类toString {
	
	public static void main(String[] args)
	{
		//Test类中有一个静态的方法function
		//method():function这个方法运算结果是一个对象 而且是一个Inter类型的对象
		//因为Inter类型对象，才能调用method方法
	    Test.function().method();
	    
	    show(new Inter()
		{
		    public void method()
			{
				System.out.println("method show run");
			}
		} );//方法中传入匿名内部类具体写法  注意形式 
	    
	    
	}
    
	public static void show(Inter in)
	{//先定义一个类 创建对象 在调用方法   
		//方法二： 当使用参数类型为接口类型  其方法少于三个  定义一个匿名内部类 传入即可
		in.method();
	}
}
//面试题 没有父类和接口如何实现匿名内部类的应用

class Test2
{
	public static void main(String[] args)
	{
		new Object()//定义子类
		{
			public void function()
			{
				System.out.println("d");
			}
		}.function();
	}
}




