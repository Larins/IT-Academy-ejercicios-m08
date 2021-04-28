package domain;
import java.util.*;

public class Video {
	
	public static String url;
	public static String title;
	public static String[] tags;

	
	public Video(String url, String title) {
		this.url = url;
		this.title = title;
	}
	
	public String geturl() {
		return url;
	}
	
	public String gettitle() {
		return title;
	}
	
	public static void main(String[] args) {
	}

}
