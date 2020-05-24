package glim.antony;

import glim.antony.dto.Message;
import junit.framework.TestCase;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ProducerServletMarshallMessageToXmlTest extends TestCase {

    ProducerServlet producerServlet;
    private static final DateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd"); //2020-05-23

    @Override
    protected void setUp() throws Exception {
        producerServlet = new ProducerServlet();
    }

    @Override
    protected void tearDown() throws Exception {
        producerServlet = null;
    }

    public void test1marshallMessageToXml() throws Throwable {
        Message message = new Message();
        String expectXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<message/>\n";

        Method method = producerServlet.getClass().getDeclaredMethod("marshallMessageToXml", Message.class);
        method.setAccessible(true);
        String xml = (String) method.invoke(producerServlet, new Message());
        assertEquals(expectXml, xml);
    }

    public void test2marshallMessageToXml() throws Throwable {
        Message message = new Message(0L, "text_0", FORMAT.parse("2020-05-22"));
        String expectXml ="" +
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<message>\n" +
                "    <inputDate>2020-05-22T00:00:00+04:00</inputDate>\n" +
                "    <inputNumber>0</inputNumber>\n" +
                "    <inputText>text_0</inputText>\n" +
                "</message>\n";

        Method method = producerServlet.getClass().getDeclaredMethod("marshallMessageToXml", Message.class);
        method.setAccessible(true);
        String xml = (String) method.invoke(producerServlet, message);
        assertEquals(expectXml, xml);
    }

    public void test3marshallMessageToXml() throws Throwable {
        String expectXml ="" +
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<message>\n" +
                "    <inputNumber>100</inputNumber>\n" +
                "    <inputText>text_8</inputText>\n" +
                "</message>\n";
        Message message = new Message(100L, "text_8", null);

        Method method = producerServlet.getClass().getDeclaredMethod("marshallMessageToXml", Message.class);
        method.setAccessible(true);
        String xml = (String) method.invoke(producerServlet, message);
        assertEquals(expectXml, xml);
    }

    public void test4marshallMessageToXml() throws Throwable {
        String expectXml ="" +
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<message>\n" +
                "    <inputDate>2021-07-27T00:00:00+04:00</inputDate>\n" +
                "    <inputText>text_2</inputText>\n" +
                "</message>\n";
        Message message = new Message(null, "text_2", FORMAT.parse("2021-07-27"));

        Method method = producerServlet.getClass().getDeclaredMethod("marshallMessageToXml", Message.class);
        method.setAccessible(true);
        String xml = (String) method.invoke(producerServlet, message);
        assertEquals(expectXml, xml);
    }

    public void test5marshallMessageToXml() throws Throwable {
        String expectXml ="" +
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<message>\n" +
                "    <inputText>text_3</inputText>\n" +
                "</message>\n";
        Message message = new Message(null, "text_3", null);

        Method method = producerServlet.getClass().getDeclaredMethod("marshallMessageToXml", Message.class);
        method.setAccessible(true);
        String xml = (String) method.invoke(producerServlet, message);
        assertEquals(expectXml, xml);
    }
}