package arrayAndLinkedListProject;

import java.util.ArrayList;
import java.util.LinkedList;

public class A 
{
	ArrayList<Integer> al=new ArrayList<Integer>();
	LinkedList<Integer> ll=new LinkedList<Integer>();
	void m1()
	{
		//al.add(6);
		//al.add(5);
		//al.add(9);
		//al.add(10);
		//al.remove(0);
		
		//al.add(1, 11);
		//al.add(2, 12);
		//al.add(3, 8);
		long start=System.currentTimeMillis();

         for(int i=1;i<100000;i++)
		{
			//al.add(i);for this it takes less time
        	// al.add(0 ,i);it takes more time

		}
		long end =System.currentTimeMillis();
		System.out.println(end-start);
		long start1=System.currentTimeMillis();

        for(int i=1;i<100000;i++)
		{
			//ll.add(i);for this it takes more time
        	//it take less timell.add(0, i);
		}
		long end1 =System.currentTimeMillis();
		System.out.println(end1-start1);
		
	}

}
