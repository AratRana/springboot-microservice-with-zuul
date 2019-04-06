package com.arat.security.hystrix.utils;

import java.util.List;

public class CompareObjects {
	/**
	    * Compare two input objects. If the objects are equal or are both null,
	    * a <code>true</code> is returned. If one of the objects is null and the
	    * other object has a value, a <code>false</code> is returned. If both
	    * objects have values, but are not equal, a <code>false</code> is returned.
	    */
	   public static final boolean compare(Object iObject1, Object iObject2)
	   {
	      // Check for both nulls
	      if (iObject1 == null && iObject2 == null) return true;

	      // Check if both strings have values
	      if (iObject1 != null && iObject2 != null) return iObject1.equals(iObject2);

	      // One object must be null and the other object has a value - these will
	      // never be equal.
	      return false;
	   }

	   /**
	    * Compare two lists.  If both list objects are null or one is
	    * null and the other has size() of 0, <code>true</code> is returned.
	    * Otherwise, list1.equals(list2) is returned.
	    *
	    * @param list1
	    * @param list2
	    * @return
	    */
	   public static final boolean compareLists(List list1,List list2)
	   {
	      // if both are not null, use List.equals()
	      if (list1!=null && list2!=null ) return list1.equals(list2);

	      // if both are null, return true
	      if (list1==null && list2==null) return true;

	      // if one is null and the other is not size 0, then consider
	      // them not equals
	      if (list1==null && list2!=null && list2.isEmpty()) return true;
	      if (list2==null && list1!=null && list1.isEmpty()) return true;

	      return false;
	   }

}
