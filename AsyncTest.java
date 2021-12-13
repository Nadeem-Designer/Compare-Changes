import org.junit.Test;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import .htmlunit.html.HtmlTextInput;
public class AsyncTest {
    @Test
    public void testChatRoom() throws Exception {
        try (final WebClient webClient = new WebClient()) {
             HtmlPage page = webClient.getPage(ParameterUtils.getBaseUrl() + "/async/index.html");
            final HtmlForm form = page.getForms().get(0);
            final HtmlTextInput textField = form.getInputByName("msg");
            textField.type("hello");
            final HtmlSubmitInput button = form.getInputByValue("Send");
            final HtmlPage page2 = button.click();
            Thread.sleep(4000);
        final DomElement msgs = page2.getElementById("msgs");
            Assert.assertEquals("hello", msgs.asText());
        }
    }
}
