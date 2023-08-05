package ptj;

import java.util.List;

public interface VideoReviewDao {
	
	void InsertReview(VideoReview videoReview);
	List<VideoReview> selectReview(int videoNo);
	
}
