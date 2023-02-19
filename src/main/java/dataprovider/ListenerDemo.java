package dataprovider;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class ListenerDemo implements ITestListener
{
	
	public void OnTestSuccess(ITestResult result)
	{
		System.out.println(" Test Passed  "+result.getMethod().getMethodName());
	}
	public void OnTestFailure(ITestResult result)
	{
		System.out.println("Test Failed  "+result.getMethod().getMethodName());
		System.out.println("Exception Thrown By this Method" +result.getThrowable().getMessage());
	}
	
	}

