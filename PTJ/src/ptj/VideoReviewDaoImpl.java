package ptj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VideoReviewDaoImpl implements VideoReviewDao{

    private static int reviewNo = 0;
    private Map<Integer, List<VideoReview>> videoReviewDB = new HashMap<Integer, List<VideoReview>>(); //여기에 리뷰 넣어서 관리
    private static VideoReviewDaoImpl instance = new VideoReviewDaoImpl();
    Scanner sc = new Scanner(System.in);


    private VideoReviewDaoImpl() {
    }

    public static VideoReviewDaoImpl getInstance() {
        return instance;
    }


    @Override
    public void InsertReview(VideoReview videoReview) {
        int num = videoReview.getVideoNo();
        if(videoReviewDB.containsKey(num)) { //그 비디오 넘버(키)를 가지고 있으면
            videoReviewDB.get(num).add(videoReview); //해당하는 밸류에 videoReview 추가 
        }
        else {
        	List<VideoReview> templist = new ArrayList<VideoReview>();
        	templist.add(videoReview);
            videoReviewDB.put(num, templist); //리뷰  넘버와 내용 put
        }
    }

    @Override
    public List<VideoReview> selectReview(int videoNo) {
    	if(videoReviewDB.containsKey(videoNo)) {
    		List<VideoReview> numList = videoReviewDB.get(videoNo);
            return numList;
    	}
    	else
    		return null;
        
    }
}