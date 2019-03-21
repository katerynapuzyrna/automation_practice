package lesson10.b_file_downloading;

import lesson10.a_add_wd_event_listener.LandingPage;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;

public class FirstTest extends BaseTest {

	@Test
	public void verifyFirstTip() {
		// Given
		final String query1 = "Dress";
		final String query2 = "T-shirt";
		final LandingPage landingPage = new LandingPage(driver);
		landingPage.visit();
		landingPage.searchFor(query1);
		final String oldTipText = landingPage.getFirstTipText();
		// When
		landingPage.searchFor(query2, oldTipText);
		// Then
		final String newTipText = landingPage.getFirstTipText();
		assertAll(() -> Assert.assertThat(newTipText, containsString(query2 + "0")),
				() -> Assert.assertThat(newTipText, containsString(query2)),
				() -> Assert.assertThat(newTipText, containsString(query2 + "1")));
	}
}