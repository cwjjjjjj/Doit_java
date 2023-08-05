package ptj;

//import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

public class main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		VideoDaoImpl vd = VideoDaoImpl.getInstance();
		VideoReviewDaoImpl vr = VideoReviewDaoImpl.getInstance();
		MainUi main = new MainUi();
		SsafitUtil util = new SsafitUtil();
		int reviewsize=0;
		
		//프로그램 시작
		loop1:
		while(true) {
			//Show Video List, Exit 선택지 생성
			main.service();
			int no1 = Integer.parseInt(br.readLine());
			System.out.println(no1);
			if(no1==1) {
				//Video List 출력
				loop2:
				while(true) {
					for(Video i : vd.selectVideo()) {
						System.out.println(i.toString());
					}
					util.printLine();
					//영상 선택 문구 출력
					System.out.println("영상 번호를 입력하세요 : ");
					int no2 = Integer.parseInt(br.readLine());
					//없는 영상일 경우 문구 출력 후 영상 선택 화면으로 복귀
					while(true) {
						if(no2>vd.selectVideo().size() || no2<vd.selectVideo().size()) {
							System.out.println("보기에 없는 번호입니다.");
							break;
						}
						util.printLine();
						System.out.println("번호 :"+vd.selectVideoByNo(no2).getNo());
						System.out.println("제목 :"+vd.selectVideoByNo(no2).getTitle());
						System.out.println("운동 :"+vd.selectVideoByNo(no2).getPart());
						System.out.println("영상URL :"+vd.selectVideoByNo(no2).getUrl());
						util.printLine();
						//영상 개수 출력
						if(vr.selectReview(no2) != null) {
							System.out.println("영상리뷰 : "+vr.selectReview(no2).size()+"개");
							reviewsize=vr.selectReview(no2).size();
						}else {
							System.out.print("영상리뷰 : 0개"+'\n');
						}
						util.printLine();
						if(vr.selectReview(no2) != null) {
							for(VideoReview j : vr.selectReview(no2)) {
								System.out.println(j);
						}
						}
						util.printLine();
						System.out.println("1. 리뷰등록");
						System.out.println("0. 이전으로");
						util.printLine();
						System.out.println("메뉴를 선택하세요 : ");
						int no3 = Integer.parseInt(br.readLine());
						//이전으로 선택 시, 영상 선택 화면으로 복구
						if(no3==0) {
							break;
						} else if (no3 < 0 || no3 > 1) {
							System.out.println("보기에 없는 번호입니다.");
								continue;
						}
						else if(no3==1) {
							//리뷰 등록, 출력되는 입력하세요 : 이후를 클릭 후 내용을 입력해야 출력이 잘됨. 입력하세요 이전에 글자를 입력 후 엔터를 누를 경우 오류 발생
							System.out.println("닉네임을 입력하세요 : ");
							st = new StringTokenizer(br.readLine());
							String nickName="";
							while(st.hasMoreTokens()) {
								nickName += st.nextToken()+" ";
							}
							System.out.println("내용을 입력하세요 : ");
							
							st = new StringTokenizer(br.readLine());
							String content="";
							while(st.hasMoreTokens()) {
								content += st.nextToken()+" ";
							}
							VideoReview review = new VideoReview(no2,reviewsize+1,nickName,content);
							vr.InsertReview(review);
							break loop2;
						}
						}
					}
				}
			else if(no1==2) {
				main.exit();
				br.close();
				break;
			}
			else
				System.out.println("보기에 없는 번호입니다.");
			}
	}

}
