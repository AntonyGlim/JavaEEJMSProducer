package glim.antony;


import glim.antony.dto.Message;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class ProducerServlet extends HttpServlet {

    private final Logger log = Logger.getLogger(ProducerServlet.class.getName());
    private static final DateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd"); //2020-05-23

    //simple check if server alive
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        pw.println("<html>");
        pw.println("<h1>Hello Producer!</h1>");
        pw.println("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Message message = createMessageFromRequest(request);
        String xml = marshallMessageToXml(message);
        //sendMessageToJmsQueue(message);

        response.sendRedirect("/producer/input-form-jsp");
    }

    private Message createMessageFromRequest(HttpServletRequest request) {
        String requestNumber = request.getParameter("inputNumber");
        Long inputNumber = requestNumber == null || requestNumber.equals("") ? null : Long.valueOf(requestNumber);
        String inputText = request.getParameter("inputText");
        Date inputDate = null;
        try {
            String requestDate = request.getParameter("inputDate");
            inputDate = requestDate == null || requestDate.equals("") ? null : FORMAT.parse(requestDate);
        } catch (ParseException e) {
            log.warning("Exception cause message: " + e.getCause().getMessage());
            log.warning("Exception message: " + e.getMessage());
        }
        Message message = new Message(inputNumber, inputText, inputDate);
        log.info(" [i] message: " + (message == null ? null : message.toString()));
        return message;
    }

    private String marshallMessageToXml(Message message) throws IOException {
        String xml = null;
        StringWriter writer = new StringWriter();
        try {
            JAXBContext context = JAXBContext.newInstance(Message.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(message, writer);
            xml = writer.toString();
        } catch (JAXBException e) {
            log.warning("Exception cause message: " + e.getCause().getMessage());
            log.warning("Exception message: " + e.getMessage());
        } finally {
            writer.close();
        }
        log.info(" [i] xml: " + xml);
        return xml;
    }


}
