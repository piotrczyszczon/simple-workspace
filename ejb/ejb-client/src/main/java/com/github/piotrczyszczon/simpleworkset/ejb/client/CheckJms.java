package com.github.piotrczyszczon.simpleworkset.ejb.client;

import com.github.piotrczyszczon.simpleworkset.ejb.jms.ClientMessageConsumer;
import com.github.piotrczyszczon.simpleworkset.ejb.jms.MessagePublisher;

import javax.jms.JMSException;
import javax.naming.NamingException;

import static com.github.piotrczyszczon.simpleworkset.ejb.client.context.InitialContextProvider.createInitialContext;

public class CheckJms
{
  public void execute() throws JMSException, NamingException
  {
    sendMessageToServer();

    callBeanToSendMessageToServer();

    callBeanToSendMessageToServerAndReatItFromClient();
  }

  private void sendMessageToServer() throws NamingException, JMSException
  {
    MessagePublisher.messagePublisher(createInitialContext()).publishMessage("Message from Developer!");
  }

  private void callBeanToSendMessageToServer() throws NamingException
  {
    EJBFactory.lookupJmsPublisherBean().askBeanToSendMessage("jms/topic/superTopicForTests", "Message through bean!");
  }

  private void callBeanToSendMessageToServerAndReatItFromClient() throws NamingException, JMSException
  {
    EJBFactory.lookupJmsPublisherBean().askBeanToSendMessage("jms/topic/topicForClients", "Message through bean to Client!!");
    ClientMessageConsumer.messageConsumer(createInitialContext()).receiveMessage("jms/topic/topicForClients");
  }
}
