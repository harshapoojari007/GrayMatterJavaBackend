package com.grayMatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.*;
public class DemoOnGenerics<T>{
public  T add(T a,T b)
{
       if (a instanceof Integer) {
           Integer sum = (Integer) a + (Integer) b;
           return (T) sum;
       } else if (a instanceof Double) {
           Double sum = (Double) a + (Double) b;
           return (T) sum;
       } else if (a instanceof String) {
           String concat = (String) a + (String) b;
           return (T) concat;
       } else {
           throw new IllegalArgumentException("Unsupported type");
       }
}

public static <T> void printDetails(Collection<T> coll){
for(T t:coll)
{
System.out.println(t);	
}
}
public static void main(String []args)
{
	DemoOnGenerics<Integer> d=new DemoOnGenerics<Integer>();
	System.out.println(d.add(1,2));
	DemoOnGenerics<String> d1=new DemoOnGenerics<String>();
	System.out.println(d1.add("har","sha"));
	
   List<String> al=Arrays.asList("Harsha","Poojari","Nagoor") ;
   printDetails(al);
   
   List<Integer> alI=Arrays.asList(1,2,34,56,78) ;
   printDetails(alI);
  

}
}

