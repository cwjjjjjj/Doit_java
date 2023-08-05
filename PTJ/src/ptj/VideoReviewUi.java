package ptj;

public class VideoReviewUi {
	private VideoReviewDao videoReviewDao;
	private static VideoReviewUi instance = new VideoReviewUi();
	private int videoNo;
	
	private VideoReviewUi() {
	}
	
	public static VideoReviewUi getInstance(int videoNo) {
		return instance;
	}
	
	public void service() {
		
	};
	
	private void listReview() {
		
	}
	
	private void registReview() {
		
	}
	
	
	
}
