
abstract class APICall
{
	abstract String getInputXML();
	abstract String executeAPi();
	abstract String saveResponse();
	
	 public final void callAPi()
	 {
		 getInputXML();
		 executeAPi();
		 saveResponse();
	  }
}

class PANCheck extends APICall
{

	@Override
	String getInputXML() {
		System.out.println("input XML prepared");
		return "<hello>";
	}

	@Override
	String executeAPi() {
		System.out.println("execute api called");
		return "Success";
	}

	@Override
	String saveResponse() {
		System.out.println("response saved");
		return "Saved";
	}
	
}

public class TemplatePattern 
{
	public static void main(String[] args) 
	{
		
		PANCheck p = new PANCheck();
		p.callAPi();
	}
}
