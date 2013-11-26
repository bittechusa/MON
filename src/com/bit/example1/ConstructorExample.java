package com.bit.example1;

public class ConstructorExample 
{
	int a = 5;
	
	String status = "normal";
	
	public int add(int b)
	{
		return a+b;
	}
	
	public void another(int b)
	{
		System.out.println(a+b);
		System.out.println(status);
	}
	
	public ConstructorExample()
	{
		
	}
	
	public ConstructorExample(int x)
	{
		a=x;
	}
	
	public ConstructorExample(int x, int y)
	{
		a=x+y;
	}
	
	public ConstructorExample(int x, String st)
	{
		a=x*100;
		status = st;
	}
	
	

}
