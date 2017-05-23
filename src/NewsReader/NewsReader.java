package NewsReader;

import java.io.IOException;
import java.util.ArrayList;

public class NewsReader {
	public ArrayList<ArrayList<News>> getNews(){
		NewsRetrieval newsRetrieval = new NewsRetrieval();
		ArrayList<ArrayList<News>> list = new ArrayList<ArrayList<News>>();
		for (int i=1;i<5;i++){
		try {
			//System.out.println(newsRetrieval.getNews(i));
			list.add(newsRetrieval.getNews(i));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		//System.out.println(list);
		return list;
	}
	public static void main(String args[]){
		NewsReader newsReader = new NewsReader();
		System.out.println(newsReader.getNews());
	}
}
