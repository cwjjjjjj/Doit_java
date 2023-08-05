package ptj;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import java.io.*;

public class VideoDaoImpl implements VideoDao{
	private List<Video> list = new ArrayList<Video>();
	private static VideoDaoImpl instance = new VideoDaoImpl();
	
	private VideoDaoImpl() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream("data/video.json")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		String str = null; // 문자열 임시 저장 변수
		try {
			while((str = br.readLine()) != null) {
				sb.append(str).append("\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		Video[] arr = gson.fromJson(sb.toString(), Video[].class);
		for(int i = 0; i<arr.length; i++) {
			list.add(arr[i]);
		}
	}
	
	public static VideoDaoImpl getInstance() {
		return instance;
	}
	
	@Override
	public List<Video> selectVideo() {
		return list;
	}
	
	@Override
	public Video selectVideoByNo(int no) {
		Video result = new Video();
		for(Video i: list) {
			if(i.getNo()==no)
				result=i;
		}
		return result;
	}
}
