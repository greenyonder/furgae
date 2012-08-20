package falcofinder.android.fuehrerschein.chat.client;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.RequestFactory;
import com.google.web.bindery.requestfactory.shared.ServiceName;

import falcofinder.android.fuehrerschein.chat.shared.MessageProxy;
import falcofinder.android.fuehrerschein.chat.shared.RegistrationInfoProxy;





public interface ChatRequestFactory extends RequestFactory {

  @ServiceName("falcofinder.android.fuehrerschein.chat.server.ChatsService")
  public interface ChatRequest extends RequestContext {
    /**
     * Retrieve a "Hello, World" message from the server.
     */
//    Request<String> getMessage(String key, String keyfather, String qid, String subject, String message, String anon);
	  
	  Request<String> getChat(String jsonobj,String v);
	  Request<String> getChatList(String par,String v);
	  Request<String> getChatDetailsList(String key,String v);	  
	  
	  
	    
  }

  @ServiceName("falcofinder.android.fuehrerschein.chat.server.RegistrationInfo")
  public interface RegistrationInfoRequest extends RequestContext {
    /**
     * Register a device for C2DM messages.
     */
    InstanceRequest<RegistrationInfoProxy, Void> register();

    /**
     * Unregister a device for C2DM messages.
     */
    InstanceRequest<RegistrationInfoProxy, Void> unregister();
  }

  @ServiceName("falcofinder.android.fuehrerschein.chat.server.Message")
  public interface MessageRequest extends RequestContext {
    /**
     * Send a message to a device using C2DM.
     */
    InstanceRequest<MessageProxy, String> send();
  }

  ChatRequest chatRequest();

  RegistrationInfoRequest registrationInfoRequest();

  MessageRequest messageRequest();

}
