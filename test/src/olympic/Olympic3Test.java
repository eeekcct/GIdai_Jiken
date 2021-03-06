package olympic;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class Olympic3Test {

	@Test
	public void step01_isLeapYear_Test() {
		assertThat(Olympic3.isLeapYear(2019), is(false));
		assertThat(Olympic3.isLeapYear(2020), is(true));

		assertThat(Olympic3.isLeapYear(1900), is(false));
		assertThat(Olympic3.isLeapYear(2000), is(true));
		assertThat(Olympic3.isLeapYear(2100), is(false));
	}

	@Test
	public void step02_daysOfYear_Test() {
		assertThat(Olympic3.daysOfYear(2019), is(365));
		assertThat(Olympic3.daysOfYear(2020), is(366));

		assertThat(Olympic3.daysOfYear(1900), is(365));
		assertThat(Olympic3.daysOfYear(2000), is(366));
		assertThat(Olympic3.daysOfYear(2100), is(365));
	}

	@Test
	public void step03_daysOfMonth_Test() {
		assertThat(Olympic3.daysOfMonth(2019, 1), is(31));
		assertThat(Olympic3.daysOfMonth(2019, 2), is(28));
		assertThat(Olympic3.daysOfMonth(2019, 3), is(31));
		assertThat(Olympic3.daysOfMonth(2019, 4), is(30));
		assertThat(Olympic3.daysOfMonth(2019, 5), is(31));
		assertThat(Olympic3.daysOfMonth(2019, 6), is(30));
		assertThat(Olympic3.daysOfMonth(2019, 7), is(31));
		assertThat(Olympic3.daysOfMonth(2019, 8), is(31));
		assertThat(Olympic3.daysOfMonth(2019, 9), is(30));
		assertThat(Olympic3.daysOfMonth(2019, 10), is(31));
		assertThat(Olympic3.daysOfMonth(2019, 11), is(30));
		assertThat(Olympic3.daysOfMonth(2019, 12), is(31));

		assertThat(Olympic3.daysOfMonth(2020, 1), is(31));
		assertThat(Olympic3.daysOfMonth(2020, 2), is(29));
		assertThat(Olympic3.daysOfMonth(2020, 3), is(31));
		assertThat(Olympic3.daysOfMonth(2020, 4), is(30));
		assertThat(Olympic3.daysOfMonth(2020, 5), is(31));
		assertThat(Olympic3.daysOfMonth(2020, 6), is(30));
		assertThat(Olympic3.daysOfMonth(2020, 7), is(31));
		assertThat(Olympic3.daysOfMonth(2020, 8), is(31));
		assertThat(Olympic3.daysOfMonth(2020, 9), is(30));
		assertThat(Olympic3.daysOfMonth(2020, 10), is(31));
		assertThat(Olympic3.daysOfMonth(2020, 11), is(30));
		assertThat(Olympic3.daysOfMonth(2020, 12), is(31));
	}

	@Test
	public void step04_daysFrom_1_1_To_Test() {
		assertThat(Olympic3.daysFromNewYearsDay(2019, 1,1), is(0));
		assertThat(Olympic3.daysFromNewYearsDay(2019, 1,31), is(30));
		assertThat(Olympic3.daysFromNewYearsDay(2019, 2,1), is(31));
		assertThat(Olympic3.daysFromNewYearsDay(2019, 2,28), is(58));
		assertThat(Olympic3.daysFromNewYearsDay(2019, 3,1), is(59));
		assertThat(Olympic3.daysFromNewYearsDay(2019, 3,31), is(89));
		assertThat(Olympic3.daysFromNewYearsDay(2019, 4,1), is(90));
		assertThat(Olympic3.daysFromNewYearsDay(2019, 4,30), is(119));
		assertThat(Olympic3.daysFromNewYearsDay(2019, 5,1), is(120));
		assertThat(Olympic3.daysFromNewYearsDay(2019, 5,31), is(150));
		assertThat(Olympic3.daysFromNewYearsDay(2019, 6,1), is(151));
		assertThat(Olympic3.daysFromNewYearsDay(2019, 6,30), is(180));
		assertThat(Olympic3.daysFromNewYearsDay(2019, 7,1), is(181));
		assertThat(Olympic3.daysFromNewYearsDay(2019, 7,31), is(211));
		assertThat(Olympic3.daysFromNewYearsDay(2019, 8,1), is(212));
		assertThat(Olympic3.daysFromNewYearsDay(2019, 8,31), is(242));
		assertThat(Olympic3.daysFromNewYearsDay(2019, 9,1), is(243));
		assertThat(Olympic3.daysFromNewYearsDay(2019, 9,30), is(272));
		assertThat(Olympic3.daysFromNewYearsDay(2019, 10,1), is(273));
		assertThat(Olympic3.daysFromNewYearsDay(2019, 10,31), is(303));
		assertThat(Olympic3.daysFromNewYearsDay(2019, 11,1), is(304));
		assertThat(Olympic3.daysFromNewYearsDay(2019, 11,30), is(333));
		assertThat(Olympic3.daysFromNewYearsDay(2019, 12,1), is(334));
		assertThat(Olympic3.daysFromNewYearsDay(2019, 12,31), is(364));

		assertThat(Olympic3.daysFromNewYearsDay(2020, 1,31), is(30));
		assertThat(Olympic3.daysFromNewYearsDay(2020, 2,29), is(59));
		assertThat(Olympic3.daysFromNewYearsDay(2020, 3,31), is(90));
		assertThat(Olympic3.daysFromNewYearsDay(2020, 4,30), is(120));
		assertThat(Olympic3.daysFromNewYearsDay(2020, 5,31), is(151));
		assertThat(Olympic3.daysFromNewYearsDay(2020, 6,30), is(181));
		assertThat(Olympic3.daysFromNewYearsDay(2020, 7,31), is(212));
		assertThat(Olympic3.daysFromNewYearsDay(2020, 8,31), is(243));
		assertThat(Olympic3.daysFromNewYearsDay(2020, 9,30), is(273));
		assertThat(Olympic3.daysFromNewYearsDay(2020, 10,31), is(304));
		assertThat(Olympic3.daysFromNewYearsDay(2020, 11,30), is(334));
		assertThat(Olympic3.daysFromNewYearsDay(2020, 12,31), is(365));
	}

	@Test
	public void step05_daysTo_12_31_From_Test() {
		assertThat(Olympic3.daysToNewYearsEve(2019, 1,1), is(364));
		assertThat(Olympic3.daysToNewYearsEve(2019, 1,31), is(334));
		assertThat(Olympic3.daysToNewYearsEve(2019, 2,1), is(333));
		assertThat(Olympic3.daysToNewYearsEve(2019, 2,28), is(306));
		assertThat(Olympic3.daysToNewYearsEve(2019, 3,1), is(305));
		assertThat(Olympic3.daysToNewYearsEve(2019, 3,31), is(275));
		assertThat(Olympic3.daysToNewYearsEve(2019, 4,1), is(274));
		assertThat(Olympic3.daysToNewYearsEve(2019, 4,30), is(245));
		assertThat(Olympic3.daysToNewYearsEve(2019, 5,1), is(244));
		assertThat(Olympic3.daysToNewYearsEve(2019, 5,31), is(214));
		assertThat(Olympic3.daysToNewYearsEve(2019, 6,1), is(213));
		assertThat(Olympic3.daysToNewYearsEve(2019, 6,30), is(184));
		assertThat(Olympic3.daysToNewYearsEve(2019, 7,1), is(183));
		assertThat(Olympic3.daysToNewYearsEve(2019, 7,31), is(153));
		assertThat(Olympic3.daysToNewYearsEve(2019, 8,1), is(152));
		assertThat(Olympic3.daysToNewYearsEve(2019, 8,31), is(122));
		assertThat(Olympic3.daysToNewYearsEve(2019, 9,1), is(121));
		assertThat(Olympic3.daysToNewYearsEve(2019, 9,30), is(92));
		assertThat(Olympic3.daysToNewYearsEve(2019, 10,1), is(91));
		assertThat(Olympic3.daysToNewYearsEve(2019, 10,31), is(61));
		assertThat(Olympic3.daysToNewYearsEve(2019, 11,1), is(60));
		assertThat(Olympic3.daysToNewYearsEve(2019, 11,30), is(31));
		assertThat(Olympic3.daysToNewYearsEve(2019, 12,1), is(30));
		assertThat(Olympic3.daysToNewYearsEve(2019, 12,31), is(0));

		assertThat(Olympic3.daysToNewYearsEve(2020, 1,1), is(365));
		assertThat(Olympic3.daysToNewYearsEve(2020, 2,1), is(334));
		assertThat(Olympic3.daysToNewYearsEve(2020, 3,1), is(305));
		assertThat(Olympic3.daysToNewYearsEve(2020, 4,1), is(274));
		assertThat(Olympic3.daysToNewYearsEve(2020, 5,1), is(244));
		assertThat(Olympic3.daysToNewYearsEve(2020, 6,1), is(213));
		assertThat(Olympic3.daysToNewYearsEve(2020, 7,1), is(183));
		assertThat(Olympic3.daysToNewYearsEve(2020, 8,1), is(152));
		assertThat(Olympic3.daysToNewYearsEve(2020, 9,1), is(121));
		assertThat(Olympic3.daysToNewYearsEve(2020, 10,1), is(91));
		assertThat(Olympic3.daysToNewYearsEve(2020, 11,1), is(60));
		assertThat(Olympic3.daysToNewYearsEve(2020, 12,1), is(30));
	}

	@Test
	public void Step06_daysFrom_2019_1_1_To() {
		assertThat(Olympic3.daysFromNewYearsDayOf2019(2019, 1,1), is(0));
		assertThat(Olympic3.daysFromNewYearsDayOf2019(2019, 1,31), is(30));
		assertThat(Olympic3.daysFromNewYearsDayOf2019(2019, 2,28), is(58));
		assertThat(Olympic3.daysFromNewYearsDayOf2019(2019, 3,31), is(89));
		assertThat(Olympic3.daysFromNewYearsDayOf2019(2019, 4,30), is(119));
		assertThat(Olympic3.daysFromNewYearsDayOf2019(2019, 5,31), is(150));
		assertThat(Olympic3.daysFromNewYearsDayOf2019(2019, 6,30), is(180));
		assertThat(Olympic3.daysFromNewYearsDayOf2019(2019, 7,31), is(211));
		assertThat(Olympic3.daysFromNewYearsDayOf2019(2019, 8,31), is(242));
		assertThat(Olympic3.daysFromNewYearsDayOf2019(2019, 9,30), is(272));
		assertThat(Olympic3.daysFromNewYearsDayOf2019(2019, 10,31), is(303));
		assertThat(Olympic3.daysFromNewYearsDayOf2019(2019, 11,30), is(333));
		assertThat(Olympic3.daysFromNewYearsDayOf2019(2019, 12,31), is(364));
		assertThat(Olympic3.daysFromNewYearsDayOf2019(2020, 1,1), is(365+0));
		assertThat(Olympic3.daysFromNewYearsDayOf2019(2020, 1,31), is(365+30));
		assertThat(Olympic3.daysFromNewYearsDayOf2019(2020, 2,29), is(365+59));
		assertThat(Olympic3.daysFromNewYearsDayOf2019(2020, 3,31), is(365+90));
		assertThat(Olympic3.daysFromNewYearsDayOf2019(2020, 4,30), is(365+120));
		assertThat(Olympic3.daysFromNewYearsDayOf2019(2020, 5,31), is(365+151));
		assertThat(Olympic3.daysFromNewYearsDayOf2019(2020, 6,30), is(365+181));
		assertThat(Olympic3.daysFromNewYearsDayOf2019(2020, 7,31), is(365+212));
		assertThat(Olympic3.daysFromNewYearsDayOf2019(2020, 8,31), is(365+243));
		assertThat(Olympic3.daysFromNewYearsDayOf2019(2020, 9,30), is(365+273));
		assertThat(Olympic3.daysFromNewYearsDayOf2019(2020, 10,31), is(365+304));
		assertThat(Olympic3.daysFromNewYearsDayOf2019(2020, 11,30), is(365+334));
		assertThat(Olympic3.daysFromNewYearsDayOf2019(2020, 12,31), is(365+365));
	}

	@Test
	public void Step07_daysBetween_Test() {
		assertThat(Olympic3.daysBetween(2019, 1, 1, 2019, 1, 1), is(0));
		assertThat(Olympic3.daysBetween(2019, 1, 1, 2019, 12, 31), is(364));
		assertThat(Olympic3.daysBetween(2019, 1, 1, 2020, 12, 31), is(365+365));

		assertThat(Olympic3.daysBetween(2019, 5, 1, 2019, 5, 1), is(0));
		assertThat(Olympic3.daysBetween(2019, 5, 1, 2020, 5, 1), is(366));
	}

	@Test
	public void Step08_daysToOpen_Test() {
		assertThat(Olympic3.daysToOpen(2019, 1, 1), is(570));
		assertThat(Olympic3.daysToOpen(2019, 9, 28), is(300));
		assertThat(Olympic3.daysToOpen(2020, 1, 1), is(205));
		assertThat(Olympic3.daysToOpen(2020, 7, 1), is(23));
		assertThat(Olympic3.daysToOpen(2020, 7, 23), is(1));
		assertThat(Olympic3.daysToOpen(2020, 7, 24), is(0));
		assertThat(Olympic3.daysToOpen(2020, 7, 25), is(-1));
		assertThat(Olympic3.daysToOpen(2020, 8, 9), is(-16));
		assertThat(Olympic3.daysToOpen(2020, 8, 10), is(-17));
		assertThat(Olympic3.daysToOpen(2020, 9, 1), is(-39));
		assertThat(Olympic3.daysToOpen(2020, 12, 31), is(-160));
	}

	@Test
	public void Step09_daysToClose_Test() {
		assertThat(Olympic3.daysToClose(2019, 1, 1), is(586));
		assertThat(Olympic3.daysToClose(2019, 10, 14), is(300));
		assertThat(Olympic3.daysToClose(2020, 1, 1), is(221));
		assertThat(Olympic3.daysToClose(2020, 7, 1), is(39));
		assertThat(Olympic3.daysToClose(2020, 7, 23), is(17));
		assertThat(Olympic3.daysToClose(2020, 7, 24), is(16));
		assertThat(Olympic3.daysToClose(2020, 7, 25), is(15));
		assertThat(Olympic3.daysToClose(2020, 8, 9), is(0));
		assertThat(Olympic3.daysToClose(2020, 8, 10), is(-1));
		assertThat(Olympic3.daysToClose(2020, 9, 1), is(-23));
		assertThat(Olympic3.daysToClose(2020, 12, 31), is(-144));
	}

	@Test
	public void Step10_eventIsOpened_Test() {
		assertThat(Olympic3.eventIsOpened(2019, 1, 1), is(false));
		assertThat(Olympic3.eventIsOpened(2019, 9, 28), is(false));
		assertThat(Olympic3.eventIsOpened(2020, 1, 1), is(false));
		assertThat(Olympic3.eventIsOpened(2020, 7, 1), is(false));
		assertThat(Olympic3.eventIsOpened(2020, 7, 23), is(false));
		assertThat(Olympic3.eventIsOpened(2020, 7, 24), is(true));
		assertThat(Olympic3.eventIsOpened(2020, 7, 25), is(true));
		assertThat(Olympic3.eventIsOpened(2020, 8, 9), is(true));
		assertThat(Olympic3.eventIsOpened(2020, 8, 10), is(true));
		assertThat(Olympic3.eventIsOpened(2020, 9, 1), is(true));
		assertThat(Olympic3.eventIsOpened(2020, 12, 31), is(true));
	}

	@Test
	public void Step11_eventIsClosed_Test() {
		assertThat(Olympic3.eventIsClosed(2019, 1, 1), is(false));
		assertThat(Olympic3.eventIsClosed(2019, 9, 28), is(false));
		assertThat(Olympic3.eventIsClosed(2020, 1, 1), is(false));
		assertThat(Olympic3.eventIsClosed(2020, 7, 1), is(false));
		assertThat(Olympic3.eventIsClosed(2020, 7, 23), is(false));
		assertThat(Olympic3.eventIsClosed(2020, 7, 24), is(false));
		assertThat(Olympic3.eventIsClosed(2020, 7, 25), is(false));
		assertThat(Olympic3.eventIsClosed(2020, 8, 9), is(false));
		assertThat(Olympic3.eventIsClosed(2020, 8, 10), is(true));
		assertThat(Olympic3.eventIsClosed(2020, 9, 1), is(true));
		assertThat(Olympic3.eventIsClosed(2020, 12, 31), is(true));
	}

	@Test
	public void Step12_eventIsBeingHeld_Test() {
		assertThat(Olympic3.eventIsBeingHeld(2019, 1, 1), is(false));
		assertThat(Olympic3.eventIsBeingHeld(2019, 9, 28), is(false));
		assertThat(Olympic3.eventIsBeingHeld(2020, 1, 1), is(false));
		assertThat(Olympic3.eventIsBeingHeld(2020, 7, 1), is(false));
		assertThat(Olympic3.eventIsBeingHeld(2020, 7, 23), is(false));
		assertThat(Olympic3.eventIsBeingHeld(2020, 7, 24), is(true));
		assertThat(Olympic3.eventIsBeingHeld(2020, 7, 25), is(true));
		assertThat(Olympic3.eventIsBeingHeld(2020, 8, 9), is(true));
		assertThat(Olympic3.eventIsBeingHeld(2020, 8, 10), is(false));
		assertThat(Olympic3.eventIsBeingHeld(2020, 9, 1), is(false));
		assertThat(Olympic3.eventIsBeingHeld(2020, 12, 31), is(false));
		assertThat(Olympic3.eventIsBeingHeld(2021, 1, 1), is(false));
	}

}
