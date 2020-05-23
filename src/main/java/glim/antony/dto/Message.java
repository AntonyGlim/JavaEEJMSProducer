package glim.antony.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Date;

@XmlType(name = "message")
@XmlRootElement
public class Message implements Serializable {
    private static final long serialVersionUID = -90027356L;

    private Long inputNumber;
    private String inputText;
    private Date inputDate;

    public Message() {
    }

    public Message(Long inputNumber, String inputText, Date inputDate) {
        this.inputNumber = inputNumber;
        this.inputText = inputText;
        this.inputDate = inputDate;
    }

    public Long getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(Long inputNumber) {
        this.inputNumber = inputNumber;
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Message{" +
                "inputNumber=" + inputNumber +
                ", inputText='" + inputText + '\'' +
                ", inputDate=" + inputDate +
                '}';
    }
}
