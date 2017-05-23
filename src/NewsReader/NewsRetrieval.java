package NewsReader;

import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;

public class NewsRetrieval
{

	public static final int TAIWAN = 1;
	public static final int TECH = 2;
	public static final int SPORT = 3;
	public static final int ENTERTAINMENT = 4;

	public static ArrayList<News> getNews (int type) throws IOException
	{
		String url = "https://news.google.com/news/section?sdm=EXPANDO&topic=";
		String titleClass = "esc-lead-article-title-wrapper";

		String typeChar = "";
		switch (type)
		{
		case TAIWAN:
			typeChar = "n";
			break;
		case TECH:
			typeChar = "t";
			break;
		case SPORT:
			typeChar = "s";
			break;
		case ENTERTAINMENT:
			typeChar = "e";
			break;
		}
		url += typeChar;

		ArrayList<News> newsList = new ArrayList<News>();

		Connection.Response res = Jsoup.connect(url)
				.userAgent(
						"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:26.0) Gecko/20100101 Firefox/26.0")
				.method(Method.GET).execute();
		Document doc = res.parse();

		// get information block
		Elements items = doc.select("div." + titleClass);

		int counter = 0;

		for (Element item : items)
		{
			News news = new News();
			news.setSerialNumber(++counter);
			String newsUrl = item.getElementsByTag("a").get(0).attr("href");
			news.setUrl(newsUrl);
			String newsTitle = item.getElementsByTag("span").get(0).text();
			news.setTitle(newsTitle);
			String content = item.nextElementSibling().nextElementSibling()
					.text();
			content = content.substring(0, content.length() - 4);
			news.setContent(content + "...");
			try
			{
				Element img = item.parent().previousElementSibling()
						.getElementsByTag("img").get(0);
				String imgUrl = "#";
				if (!"".equals(img.attr("src")))
				{
					imgUrl = img.attr("src");
				}
				else if (!"".equals(img.attr("imgsrc")))
				{
					imgUrl = img.attr("imgsrc");
				}
				news.setImageUrl(imgUrl);
			} catch (java.lang.NullPointerException npe)
			{
				System.out.println("Cannot get image!!");
				continue;
			} finally
			{
				// System.out.println(news);
				newsList.add(news);
			}
		}
		return newsList;
	}

	public static void main (String args[])
	{
		try
		{
			ArrayList<News> newsList = getNews(NewsRetrieval.TAIWAN);
			System.out.println(newsList);
		} catch (IOException e)
		{
			System.err.println(e);
		}
	}

}