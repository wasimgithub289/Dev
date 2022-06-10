
public class BuilderPattern 
{
	public static void main(String[] args) 
	{
		HtmlPage page = new HtmlPageBuilder().
				setHeader("This is header").
				setBody("This is body").
				setFooter("This is footer").
				build();
		System.out.println(page.toString());
		
	}

}

class HtmlPageBuilder
{
	private String header;
	private String body;
	private String footer;

	public HtmlPageBuilder setHeader(String header) {
		this.header = header;
		return this;
	}
	public HtmlPageBuilder setBody(String body) {
		this.body = body;
		return this;
	}
	public HtmlPageBuilder setFooter(String footer) {
		this.footer = footer;
		return this;
	}
	
	public HtmlPage build()
	{
		return new HtmlPage(header, body, footer);
	}
}

class HtmlPage
{
	private String header;
	private String body;
	private String footer;

	public HtmlPage(String header, String body, String footer) {
		super();
		this.header = header;
		this.body = body;
		this.footer = footer;
	}

	@Override
	public String toString() {
		return "HtmlPage [header=" + header + ", body=" + body + ", footer=" + footer + "]";
	}
	
}

