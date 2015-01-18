import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person{
	private int id;
	private String name;
	public Person(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString()
	{
		return id +":"+name;
		
	}
}
class StringLengthComparator implements Comparator<String>
{

	@Override
	public int compare(String s1, String s2) 
	{
		int l=s1.length();
		int l1=s2.length();
		if(l>l1)
		{
			return 1;
		}
		else if(l<l1)
		{
			return -1;
		}
		
		return 0;
	}
	}
class AlphabeticalComparator implements Comparator<String>
{

	@Override
	public int compare(String s1, String s2) 
	{
		return s1.compareTo(s2);
	}
	}
class ReverseAlphabeticalComparator implements Comparator<String>
{

	@Override
	public int compare(String s1, String s2) 
	{
		return s2.compareTo(s1);
	}
	}
public class DemoList
{
	

	public static void main(String[] args) 
	{
		
		List<String> animals=new ArrayList<String>();
		animals.add("chicken");
		animals.add("deer");
		animals.add("ant");
		animals.add("tiger");
		//Collections.sort(animals, new StringLengthComparator());
		//Collections.sort(animals, new AlphabeticalComparator());
		Collections.sort(animals, new ReverseAlphabeticalComparator());
		for(String animal:animals)
		{
			System.out.println(animal);
		}
		List<Integer> number=new ArrayList<Integer>();
		number.add(16);
		number.add(6);
		number.add(26);
		/*Collections.sort(number , new Comparator<Integer>()
				{

					@Override
					public int compare(Integer o1, Integer o2) {
						
						return -o1.compareTo(o2);
					}
			
				}); reverse order*/
		Collections.sort(number , new Comparator<Integer>()
				{

					@Override
					public int compare(Integer o1, Integer o2) {
						
						return o1.compareTo(o2);
					}
			
				});
		for(Integer num:number)
		{
			System.out.println(num);
		}
		List<Person> p=new ArrayList<Person>();
		p.add(new Person(1,"shahid"));
		p.add(new Person(4,"hasan"));
		p.add(new Person(3,"joel"));
		p.add(new Person(2,"kavinannan"));
		
     /* Collections.sort(p, new Comparator<Person>(){

		@Override
		public int compare(Person o1, Person o2) {
			if(o1.getId()>o2.getId())
			{
				return 1;
				
			}
			else if(o1.getId()<o2.getId())
			{
				return -1;
			}
			return 0;
		}
    	  
      });
      for(Person per:p)
      {
    	  System.out.println(per);
      }*/
      Collections.sort(p, new Comparator<Person>(){

  		@Override
  		public int compare(Person o1, Person o2) {
  			return o1.getName().compareTo(o2.getName());
  		}
      	  
        });
        for(Person per:p)
        {
      	  System.out.println(per);
        }
      
	}
	

}
