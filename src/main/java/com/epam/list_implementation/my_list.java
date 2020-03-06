package com.epam.list_implementation;
import java.util.*;
class LNode<T>
{
	T val;
	LNode<T> next;
	LNode(T b)
	{
		val=b;
		next=null;
	}
	void set(T ele)
	{
		val=ele;
	}
}
class MyArrayList<T> extends AbstractList<T>
{
    private LNode<T> a;
    private LNode<T> next_to_add;
    MyArrayList(T[] array)
    {
    	a=new LNode(array[0]);
    	LNode<T> temp=a;
        for(int i=1;i<array.length;i++)
        	{
        	System.out.print("So ");
        	temp.next=new LNode(array[i]);
        	System.out.print("No ");
        	//if(i!=array.length-1)
        	temp=temp.next;
        	//System.out.print(a.next+" ");
        	}
        next_to_add=temp;
    }
    public T get(int index)
    {
    	LNode<T> temp=a;
    	int c=0;
    	while(c!=index-1)
    	{
    		temp=temp.next;c++;
    	}
    	return (T)temp.val;
    }
    public T set(int index, T element)
    {
    	LNode<T> temp=a;
    	int c=0;
    	while(c!=index-1 && temp!=null)
    	{
    		temp=temp.next;
    		c++;
    	}
        temp.set(element);
        return element;
    }
public boolean add(T ele)
{
	next_to_add.next=new LNode<T>(ele);
	next_to_add=next_to_add.next;;
	//next_to_add=next_to_add.next;
	return true;
}
    public int size()
    {
    	LNode<T> temp=a;
    	int c=0;
    	while(temp!=null)
    	{
    		temp=temp.next;
    		c++;
    	}
        return c;
    }
    public void print_list()
    {
    	LNode<T> temp=a;
    	while(temp!=null)
    	{
    		System.out.print(temp.val+" ");
    		temp=temp.next;
    	}	
    	System.out.println();
    }
   public boolean remove(Object ele)
   {
	   LNode<T> temp=a;
	   LNode<T> prev=null;
	   if(a.val.equals(ele))
	   {
		   a=a.next;
		   return true;
	   }
	   while(temp!=null)
	   {
		   if(temp.val.equals(ele))
		   {
			   prev.next=temp.next;
			   break;
		   }
		   prev=temp;
		   temp=temp.next;
	   }
	   if(temp!=null)
	   return false;
	   return true;
   }
}
public class my_list
{
public static void main(String[] args)
{
	Scanner sc=new Scanner(System.in);
	Integer arr[];
	System.out.println("Enter no. eles to be initialized");
	int n=sc.nextInt();
	arr=new Integer[n];
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();
	MyArrayList<Integer> a1=new MyArrayList<Integer>(arr);
	System.out.print(a1.size());
	a1.print_list();
	a1.set(2,67);
	a1.print_list();
	a1.add(9);
	a1.print_list();
	a1.remove((Integer)67);
	a1.print_list();
	sc.close();	
}
}
