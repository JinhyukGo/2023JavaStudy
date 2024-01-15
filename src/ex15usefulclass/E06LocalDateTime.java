package ex15usefulclass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class E06LocalDateTime {

	public static void main(String[] args) {

		// 날짜를 표현
		LocalDate localDate = LocalDate.now();
		System.out.println("오늘 날짜 : "+ localDate);

		// 시간을 표현
		LocalTime localTime = LocalTime.now();
		System.out.println("오늘 시간 : "+ localDate);

		// 날짜와 시간을 동시에 표현
		LocalDateTime moment = LocalDateTime.now();
		System.out.println("지금 : "+ moment);
		
		// 날짜와 시간의 서식을 적용
		DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
		DateTimeFormatter format2 = DateTimeFormatter.ofPattern("HH시 mm분 ss초");
		DateTimeFormatter format3 = DateTimeFormatter.ofPattern("오늘은 M월의 W번재 주, d번째 날, E요일");

		System.out.println("서식1 : "+ moment.format(format1));
		System.out.println("서식2 : "+ moment.format(format2));
		System.out.println("서식3 : "+ moment.format(format3));

		// 특정 날짜 지정하기 : LocalDate.of(년, 월, 일)
		LocalDate xMas = LocalDate.of(localDate.getYear(), 12, 25);
		// 앞에서 지정했던 날짜 서식을 적용해서 출력
		System.out.println("크리스마스 : " + xMas.format(format1));
		
		// Period클래스 : 두 날짜 사이의 간격 / ?개월 ?일 남음으로 표시 가능
		Period period = Period.between(localDate,  xMas);
		System.out.println(period.getMonths() + "개월 "+ period.getDays() + "일 남음");
		
		// ChronoUnit클래스 : 특정 시간 단위로 날짜의 차이를 구함
		// 남은 개월 수
		System.out.println(ChronoUnit.MONTHS.between(localDate,  xMas) + "개월 남음");
		// 남은 일수
		System.out.println(ChronoUnit.DAYS.between(localDate,  xMas) + "일 남음");
		
		System.out.println("5일 전 : " + moment.minusDays(5));
		System.out.println("3일 후 : " + moment.plusDays(5));
		System.out.println("2개월 후 : " + moment.plusMonths(2));
		System.out.println("1년 후 : " + moment.plusYears(1));
		System.out.println("1년 2개월 3일 후 : " + moment.plusYears(1).plusMonths(2).plusDays(3));
	}
}
