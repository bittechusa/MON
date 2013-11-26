package com.bit.test;

import com.bit.example1.ConstructorExample;
import com.bit.example1.Inherit1;

public class Prodhan extends Inherit1
{

	public static void main(String[] args) 
	{

		//constructor example method call
		
		ConstructorExample ce1 = new ConstructorExample();
		System.out.println(ce1.add(100));
		
		ConstructorExample ce2 = new ConstructorExample(100);
		System.out.println(ce2.add(100));
		
		ConstructorExample ce3 = new ConstructorExample(100,"Constructor Changed this value");
		System.out.println(ce3.add(103));
		
		ce3.another(200);
		
		login();
		
		

	}

}
