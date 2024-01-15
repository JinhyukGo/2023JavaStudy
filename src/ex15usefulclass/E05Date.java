package ex15usefulclass;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class E05Date {
	/*
	Calendar 클래스를 통해 얻은 인스턴스를 초로 변환한 후 매개변수로 전달된 날짜서식으로 변경한 문자열을 반환
	 */

	public static String myDateFormat(Calendar c, String formatStr) {
		/*
		getTime() : 서버의 표준시인 1970-01-01부터 현재까지의 시간을 초 단위로 반환 (타임 스탬프라고 부름)
		 */
		Date date = c.getTime();
		return new SimpleDateFormat(formatStr).format(date);
	}
	public static void main(String[] args) {
		/*
		Calendar 클래스는 대표적인 싱글톤 클래스이므로 new로 인스턴스를 생성할 수 없고, 유틸리티 메서드를 통해 참조값을 얻어옴
		 */
		Calendar calendar = Calendar.getInstance();
		/*
		월을 표현하는 Month, 분을 표현하는 Minute의 이니셜이 동일하므로 구분을 위해 월은 대문자, 분은 소문자로 표현 
		 */
		String nowStr1 = myDateFormat(calendar, "yyyy-MM-dd HH:mm:ss");
		System.out.println("현재1 : " + nowStr1);
		// 그 외 여러 가지 서식문자가 존재함
		String nowStr2 = myDateFormat(calendar, "오늘은 M월의 W번째 주, d번째 날, F번째 E요일");
		System.out.println("현재2 : " + nowStr2);

		// 현재 날짜를 기준으로 전/후를 구하기 위해 add()를 사용
		// 음수를 인수로 주면 과거의 날짜를 구할 수 있음
		calendar.add(Calendar.DATE, 3);
		calendar.add(Calendar.MONTH, 2);
		calendar.add(Calendar.YEAR, 1);
		String nowStr3 = myDateFormat(calendar, "yyyy년 MM월 dd일");
		System.out.println("1년 2개월 3일 후 : " + nowStr3);
		
		// 올해 크리스마스까지 남은 잘짜를 계산
		// 여기서는 두 가지 서식의 날짜를 파싱하여 구한 날짜객체를 통해 계산
		String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String future = "2024/12/25";
		// system.out.println(today + " " + future);
		long result = myDiffDate(today, future);
		System.out.println(today + "에서 " + future + "까지 남은 날짜 : " + result);
	}

	public static long myDiffDate(String today, String future) {
		long diffDays = 0;
		try {
			/*
			매개변수를 통해 전달된 2개의 문자열은 날짜의 서식이 서로 다르기 때문에 각 날짜의 서식을 명확히 지정해야만 날짜를 인식하여 연산 가능
			아래에서는 String을 Date로 반환
			*/
			Date formatToday = new SimpleDateFormat("yyyy-MM-dd").parse(today);
			Date formatFuture = new SimpleDateFormat("yyyy/MM/dd").parse(future);
			// System.out.println(formatToday + " " + formatFuture);
			
			/*
			getTime()으로 얻어오는 시간은 13자리의 정수값인데 10자리는 순수한 초(sec)이고, 11 ~ 13자리는 밀리세컨즈를 의미
			즉 100으로 나눠서 뒤의 3자리를 제거하면 순수한 초가 반환됨
			또한 하루는 60*60*24로 86400초이므로 아래와 같이 남은 날짜를 계산할 수 있음
			 */
			
			diffDays = (formatFuture.getTime() - formatToday.getTime()) / (24*60*60*1000);
		}
		catch (Exception e ) {}
		return diffDays;
	}
}
