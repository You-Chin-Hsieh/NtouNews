package NewsReader;

public class News
{

	int serialNumber;
	String title;
	String url;
	String content;
	String imageUrl;

	public News ()
	{
		title = "No title";
		url = "#";
		content = "No content";
		imageUrl = "#";
	}

	public int getSerialNumber ()
	{
		return serialNumber;
	}

	public void setSerialNumber (int serialNumber)
	{
		this.serialNumber = serialNumber;
	}

	public String getTitle ()
	{
		return title;
	}

	public void setTitle (String title)
	{
		this.title = title;
	}

	public String getUrl ()
	{
		return url;
	}

	public void setUrl (String url)
	{
		this.url = url;
	}

	public String getContent ()
	{
		return content;
	}

	public void setContent (String content)
	{
		this.content = content;
	}

	public String getImageUrl ()
	{
		return imageUrl;
	}

	public void setImageUrl (String imageUrl)
	{
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString ()
	{
		return "News [serialNumber=" + serialNumber + ", title=" + title
				+ ", url=" + url + ", content=" + content + ", imageUrl="
				+ imageUrl + "]";
	}
}
