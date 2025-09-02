package com.kh.statement.run;

import com.kh.statement.view.MemberView;

/*
 * JAVA PROGRAM
 * - Run
 *   -> main(){
 *   프로그램의 실행
 *   (메인화면 출력)
 * }
 * 
 * - View(입/출력 담당)
 *   -> 사용자가 프로그램을 이용할 수 있도록 U.I를 출력
 *   + 사용자에게 필요한 값 입력받음
 *   컨트롤러에게 요청
 *   -Controller로 부터 돌려받은 데이터를 가지고 성공 실패 여부에 따라서
 *   사용자에게 결과 출력
 *   
 *   Controller (중간다리)
 *   -> View로부터 전달받은 데이터 가공 + 요청처리
 *   - DAO로부터 반환받은 요청 처리 결과를 View로 반환
 *   
 *   -Model(데이터 담당)
 *    -VO  : 불변값 담기
 *    -DTO : 데이터 전송
 *    -DAO : DB와의 직접적인 연결관계 (JDBC API를 이용)
 *   Driver 등록
 *   Connection 생성
 *   Statement 생성
 *   SQL실행 및 결과처리
 *   매핑 또는 트랜잭션처리
 *   자원반납
 *   결과 반환
 *   
 *   
 *   
 *   
 */


public class MemberRun {

	public static void main(String[] args) {
		
		MemberView mv = new MemberView();
		mv.mainMenu();
		
	}

}
