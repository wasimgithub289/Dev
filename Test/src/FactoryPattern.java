public class FactoryPattern 
{
	public static void main(String[] args) 
	{
		ProcessFactory f = new ProcessFactory();
		Process p1 = f.getProcess("OLTAS");
		Process p2 = f.getProcess("CMS");
		
		System.out.println(p1.getProcessInstanceId());
		System.out.println(p2.getProcessInstanceId());
		
	}
}

abstract class Process
{
	abstract String getProcessInstanceId();
}


class OLTAS extends Process
{

	@Override
	String getProcessInstanceId() {
		// TODO Auto-generated method stub
		return "This is OLTAS process";
	}
	
}

class CMS extends Process
{

	@Override
	String getProcessInstanceId() {
		// TODO Auto-generated method stub
		return "This is CMS process";
	}
}

class ProcessFactory
{
	public Process getProcess(String planType) 
	{
		if (planType.equalsIgnoreCase("OLTAS")) 
		{
			return new OLTAS();
		} 
		else if (planType.equalsIgnoreCase("CMS")) 
		{
			return new CMS();
		}
		return null;
	} 
}