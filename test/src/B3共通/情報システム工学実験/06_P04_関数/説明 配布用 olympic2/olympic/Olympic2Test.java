package olympic;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class Olympic2Test {

	@Test
	public void Step1_イベントが開催されたか判定する() {
		assertThat(Olympic2.eventIsOpened(2019, 1), is(false));
		assertThat(Olympic2.eventIsOpened(2019, 7), is(false));
		assertThat(Olympic2.eventIsOpened(2019, 8), is(false));
		assertThat(Olympic2.eventIsOpened(2019, 12), is(false));
		assertThat(Olympic2.eventIsOpened(2020, 1), is(false));
		assertThat(Olympic2.eventIsOpened(2020, 6), is(false));
		assertThat(Olympic2.eventIsOpened(2020, 7), is(true));
		assertThat(Olympic2.eventIsOpened(2020, 8), is(true));
		assertThat(Olympic2.eventIsOpened(2020, 9), is(true));
		assertThat(Olympic2.eventIsOpened(2020, 12), is(true));
		assertThat(Olympic2.eventIsOpened(2021, 1), is(true));
		assertThat(Olympic2.eventIsOpened(2021, 7), is(true));
		assertThat(Olympic2.eventIsOpened(2021, 8), is(true));
	}

//	@Test
//	public void Step2_イベントが終了したか判定する() {
//		assertThat(Olympic2.eventIsClosed(2019, 1), is(false));
//		assertThat(Olympic2.eventIsClosed(2019, 7), is(false));
//		assertThat(Olympic2.eventIsClosed(2019, 8), is(false));
//		assertThat(Olympic2.eventIsClosed(2019, 12), is(false));
//		assertThat(Olympic2.eventIsClosed(2020, 1), is(false));
//		assertThat(Olympic2.eventIsClosed(2020, 6), is(false));
//		assertThat(Olympic2.eventIsClosed(2020, 7), is(false));
//		assertThat(Olympic2.eventIsClosed(2020, 8), is(false));
//		assertThat(Olympic2.eventIsClosed(2020, 9), is(true));
//		assertThat(Olympic2.eventIsClosed(2020, 12), is(true));
//		assertThat(Olympic2.eventIsClosed(2021, 1), is(true));
//		assertThat(Olympic2.eventIsClosed(2021, 7), is(true));
//		assertThat(Olympic2.eventIsClosed(2021, 8), is(true));
//	}
//
//	@Test
//	public void Step3_イベント開催中か判定する() {
//		assertThat(Olympic2.eventIsBeingHeld(2019, 1), is(false));
//		assertThat(Olympic2.eventIsBeingHeld(2019, 6), is(false));
//		assertThat(Olympic2.eventIsBeingHeld(2019, 7), is(false));
//		assertThat(Olympic2.eventIsBeingHeld(2019, 8), is(false));
//		assertThat(Olympic2.eventIsBeingHeld(2019, 12), is(false));
//		assertThat(Olympic2.eventIsBeingHeld(2020, 1), is(false));
//		assertThat(Olympic2.eventIsBeingHeld(2020, 6), is(false));
//		assertThat(Olympic2.eventIsBeingHeld(2020, 7), is(true));
//		assertThat(Olympic2.eventIsBeingHeld(2020, 8), is(true));
//		assertThat(Olympic2.eventIsBeingHeld(2020, 9), is(false));
//		assertThat(Olympic2.eventIsBeingHeld(2020, 12), is(false));
//		assertThat(Olympic2.eventIsBeingHeld(2021, 1), is(false));
//		assertThat(Olympic2.eventIsBeingHeld(2021, 7), is(false));
//		assertThat(Olympic2.eventIsBeingHeld(2021, 8), is(false));
//	}
//
//	@Test
//	public void Step4_開催日まで何ヶ月か調べる() {
//		assertThat(Olympic2.monthsToOpen(2019, 1), is(18));
//		assertThat(Olympic2.monthsToOpen(2019, 7), is(12));
//		assertThat(Olympic2.monthsToOpen(2019, 8), is(11));
//		assertThat(Olympic2.monthsToOpen(2019, 12), is(7));
//		assertThat(Olympic2.monthsToOpen(2020, 1), is(6));
//		assertThat(Olympic2.monthsToOpen(2020, 6), is(1));
//		assertThat(Olympic2.monthsToOpen(2020, 7), is(0));
//		assertThat(Olympic2.monthsToOpen(2020, 8), is(-1));
//		assertThat(Olympic2.monthsToOpen(2020, 9), is(-2));
//		assertThat(Olympic2.monthsToOpen(2020, 12), is(-5));
//	}
}
