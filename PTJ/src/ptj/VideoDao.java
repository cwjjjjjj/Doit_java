package ptj;

import java.io.IOException;
import java.util.List;

public interface VideoDao {
	List<Video> selectVideo() throws IOException;
	Video selectVideoByNo(int no);
}
