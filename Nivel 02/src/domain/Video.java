package domain;
import java.time.LocalDateTime;
import java.util.*;
public class Video {
	
	public static String url;
	public static String title;
	public static String tags;
	public static LocalDateTime regDateTime;
	public static String status;
	
	public Video(String url, String title, String tags, LocalDateTime regDateTime, String status) {
		this.url = url;
		this.title = title;
		this.tags = tags;
		this.regDateTime = regDateTime;
		this.status = status;
	}
	
	public String geturl() {
		return url;
	}
	
	public String gettitle() {
		return title;
	}
	
	public String gettags() {
		return tags;
	}
	
	public LocalDateTime getregDateTime() {
		return regDateTime;
	}
	
	public String getstatus() {
		return status;
	}
	
	public static void main(String[] args) {
	}

}
