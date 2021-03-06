package olympic;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Olympic2Test2 {

	/*
	@Test
	void test() {
		fail("まだ実装されていません");
	}
	*/

	@Test
	public void Step1_イベントが開催されたか判断する() {
		assertThat(Olympic2.eventIsOpened(2019, 1),is(false));
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

}
