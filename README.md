# JavaEEJMSProducer
Java EE 5 JMS Producer (EXAMPLE)

**Приложение**  
Приложение содержит форму (JSP-страницу) для ввода трёх значений разного типа 
(число, строка из списка значений, дата) и кнопку для отправки содержимого формы в виде XML-сообщения в JMS очередь;  
Реализация ограничена стеком Java EE 5.  
![Форма ввода значений](https://github.com/AntonyGlim/JavaEEJMSProducer/blob/master/about/form.png)  
Из формы на странице jsp данные приходят в метод doPost(), сериализуются в XML и отправляются в JMS очередь.
```java
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Message message = createMessageFromRequest(request);
        String xml = marshallMessageToXml(message);
        sendMessageToJmsQueue(xml);
        response.sendRedirect("/producer/input-form-jsp");
    }
```
![Интерфейс activemq](https://github.com/AntonyGlim/JavaEEJMSProducer/blob/master/about/activemq.png)  
В качестве сервера сервера jms сообщений выступает apache-activemq-5.15.12.  
Параметры подключения:  
```java
  URL = ActiveMQConnection.DEFAULT_BROKER_URL;
  JMS_QUEUE_NAME = "MyJmsQueueName";
```
**Тестирование:**  
Тесты покрывают серриализацию сообщения в XML формат.
