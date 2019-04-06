//=========================================================================================================
//			Copyright <1995-2017> JDA Software Group, Inc. All rights reserved.
//			LICENSE OF THIS PROGRAM IS ONLY ENTITLED TO ACCESS THE CONFIGURATION(S) SPECIFIED IN ITS
//			SOFTWARE LICENSE AGREEMENT WITH arat.  ACCESS OF ANY OTHER CONFIGURATION IS A DIRECT VIOLATION
//			OF THE TERMS OF THE SOFTWARE LICENSE AGREEMENT, AND JDA RETAINS ALL ITS LEGAL RIGHTS TO ENFORCE
//			SUCH AGREEMENT.
//			This product may be protected by one or more United States and foreign patents.
//			For information on patents, see https://www.arat.com/legal/patents.
//=========================================================================================================

package com.arat.security.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * The Assert class is a utility class that contains static methods to
 * test assertions and throw exceptions if those assertions fail.
 *
 * @author Robert Mitchell, Michael Hooks
 * @version $Revision: 1.3 $
 */

public class Assert
{
    // intializing logger
    private static final Logger logger = LoggerFactory.getLogger(Assert.class);
   // *************************************************************************
   // ***************************** CREATORS **********************************
   // *************************************************************************
   
   /**
    * No public constructor because this is a utility class.
    */
   private Assert()
   {
      // do nothing
   }

   /**
    * Checks the assertion and throws an IllegalArgumentException is the
    * assertion is not true.
    *
    * @param iAssertion the assertion to check.
    * @param iFailureMsg
    * @exception IllegalArgumentException
    *                   thrown if <code>iAssertion</code> is not
    *                   <code>true</code>.
    */
   public static void arg(boolean iAssertion, String iFailureMsg)
   {
      if (!iAssertion)
      {
          IllegalArgumentException exp = new IllegalArgumentException(iFailureMsg);
          logger.error("assertion is false", exp);
          throw exp;
      }
   }

    /**
     * Gathers the current thread's stack trace and searches it to determine if
     * any junit classes are present. If non are present, it is assumed that the
     * Assert was called from production code and a RuntimeException is thrown.
     *
     * So this method can be used in unit test-only methods which are in
     * production classes to make sure applications do not inadvertantly
     * call them.
     */
    public static void calledFromJUnit() {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();

        boolean foundJunit = false;
        for (StackTraceElement ele : stack) {
            if (ele.toString().contains("junit")) {
                foundJunit = true;
                break;
            }
        }

        if (!foundJunit) {
            RuntimeException re = new RuntimeException("Method must only be called from within a junit context");
            logger.error("Error ", re);
            throw re;
        }
    }

    /**
    * throws an <CODE>IllegalArgumentException</CODE> if <CODE>iArg</CODE>
    * is <CODE>null</CODE>.
    *
    * @param iArg       argument to check for <CODE>null</CODE>.
    * @param iArgName   the name of the argument to check for <CODE>null</CODE>.
    * @exception IllegalArgumentException
    *                   thrown if <code>iArg</code> is <code>null</code>.
    */
   public static void notNull(Object iArg, String iArgName)
   {
      if (iArg == null)
      {
         String msg = "The " + iArgName + " argument must not be null";
          logger.error(msg);
         throw new IllegalArgumentException(msg);
      }
   }

   /**
    * throws an <CODE>IllegalArgumentException</CODE> if <CODE>iArg</CODE>
    * is <CODE>null</CODE> or empty.
    *
    * @param iArg       argument to check for <CODE>null</CODE> or empty.
    * @param iArgName   the name of the argument to check for <CODE>null</CODE>.
    * @exception IllegalArgumentException
    *                   thrown if <code>iArg</code> is <code>null</code> or empty.
    */
   public static void notNullOrEmpty(String iArg, String iArgName)
   {
      if (iArg == null)
      {
         String msg = "The " + iArgName + " argument must not be null";
          logger.error( msg);
         throw new IllegalArgumentException(msg);
      }
      else if (iArg.trim().length() == 0 == true)
      {
         String msg = "The " + iArgName + " argument must not be empty";
          logger.error(msg);
         throw new IllegalArgumentException(msg);
      }
   }

   /**
    * throws an <CODE>IllegalArgumentException</CODE> if <CODE>iArg</CODE>
    * is <CODE>null</CODE> or empty.
    *
    * @param iArg       argument to check for <CODE>null</CODE> or empty.
    * @param iArgName   the name of the argument to check for <CODE>null</CODE>.
    * @exception IllegalArgumentException
    *                   thrown if <code>iArg</code> is <code>null</code> or empty.
    */
   public static void notNullOrEmpty(Collection iArg, String iArgName)
   {
      if (iArg == null)
      {
         String msg = "The " + iArgName + " argument must not be null";
          logger.error(msg);
         throw new IllegalArgumentException(msg);
      }
      else if (iArg.isEmpty())
      {
         String msg = "The " + iArgName + " argument must not be empty";
          logger.error(msg);
         throw new IllegalArgumentException(msg);
      }
   }

   /**
    * throws an <CODE>IllegalArgumentException</CODE> if <CODE>iArg</CODE>
    * is <CODE>not a positive number</CODE>.
    *
    * @param iArg       argument to check for a <CODE>positive number</CODE>.
    * @param iArgName   the name of the argument to check for a <CODE>positive number</CODE>.
    * @exception IllegalArgumentException
    *                   thrown if <code>iArg</code> is <code>not a positive number</code>.
    */
   public static void posNum(long iArg, String iArgName)
   {
      if (iArg < 0)
      {
         String msg = "The " + iArgName + " argument must be a positive number";
          logger.error(msg);
         throw new IllegalArgumentException(msg);
      }
   }
}

// $Log: Assert.java,v $
// Revision 1.3  2012/01/11 15:08:41  bsimon
// Added Assert.calledFromUnitTest to make sure the code is only called from unit test drivers
//
// Revision 1.2  2010/07/04 20:52:30  bsimon
// Refactorings by IDeaJ - mostly performance related.
//
// Revision 1.1  2003/03/18 14:24:34  everett
// Initial Version - Moved from Webservices, ViewPointWeb or WebServicesUI modules.
//
// Revision 1.4  2003/02/14 21:11:52  aanders
// Added tracing to each assert method
// ust before throwing IllegalArgumentException.
//
// Revision 1.3  2002/01/09 14:39:46  aanders
// Added notNullOrEmpty(Collection iArg, String iArg) method.
//
// Revision 1.2  2001/12/10 15:07:20  aanders
// new method: posNum
//
// Revision 1.1  2001/02/28 19:33:30  mhooks
// Initial version
//
// Revision 1.1  2001/02/26 16:38:21  mhooks
// Initial version
//
//
