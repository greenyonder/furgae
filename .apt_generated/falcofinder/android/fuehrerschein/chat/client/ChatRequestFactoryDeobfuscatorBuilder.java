// Automatically Generated -- DO NOT EDIT
// falcofinder.android.fuehrerschein.chat.client.ChatRequestFactory
package falcofinder.android.fuehrerschein.chat.client;
import java.util.Arrays;
import com.google.web.bindery.requestfactory.vm.impl.OperationData;
import com.google.web.bindery.requestfactory.vm.impl.OperationKey;
public final class ChatRequestFactoryDeobfuscatorBuilder extends com.google.web.bindery.requestfactory.vm.impl.Deobfuscator.Builder {
{
withOperation(new OperationKey("w96pf5D1OCNOJe$c6ANvwXQb0Qo="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/InstanceRequest;")
  .withDomainMethodDescriptor("()Ljava/lang/String;")
  .withMethodName("send")
  .withRequestContext("falcofinder.android.fuehrerschein.chat.client.ChatRequestFactory$MessageRequest")
  .build());
withOperation(new OperationKey("rKdbUwh4VfD3Y8$0yBEmGuSvQPU="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/InstanceRequest;")
  .withDomainMethodDescriptor("()V")
  .withMethodName("register")
  .withRequestContext("falcofinder.android.fuehrerschein.chat.client.ChatRequestFactory$RegistrationInfoRequest")
  .build());
withOperation(new OperationKey("jpP_2dmpIo3$SyLrpG_72oIHKj4="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/InstanceRequest;")
  .withDomainMethodDescriptor("()V")
  .withMethodName("unregister")
  .withRequestContext("falcofinder.android.fuehrerschein.chat.client.ChatRequestFactory$RegistrationInfoRequest")
  .build());
withOperation(new OperationKey("BPdo0aSdRSJwTDxmv8F30FEojqs="),
  new OperationData.Builder()
  .withClientMethodDescriptor("(Ljava/lang/String;Ljava/lang/String;)Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;")
  .withMethodName("getChatDetailsList")
  .withRequestContext("falcofinder.android.fuehrerschein.chat.client.ChatRequestFactory$ChatRequest")
  .build());
withOperation(new OperationKey("4yA6DpyqGz5OjXy_kXZRGJN92Hc="),
  new OperationData.Builder()
  .withClientMethodDescriptor("(Ljava/lang/String;Ljava/lang/String;)Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;")
  .withMethodName("getChat")
  .withRequestContext("falcofinder.android.fuehrerschein.chat.client.ChatRequestFactory$ChatRequest")
  .build());
withOperation(new OperationKey("NRcYnAIMKciJhDJ09xCyPCUUdKo="),
  new OperationData.Builder()
  .withClientMethodDescriptor("(Ljava/lang/String;Ljava/lang/String;)Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;")
  .withMethodName("getChatList")
  .withRequestContext("falcofinder.android.fuehrerschein.chat.client.ChatRequestFactory$ChatRequest")
  .build());
withRawTypeToken("8KVVbwaaAtl6KgQNlOTsLCp9TIU=", "com.google.web.bindery.requestfactory.shared.ValueProxy");
withRawTypeToken("FXHD5YU0TiUl3uBaepdkYaowx9k=", "com.google.web.bindery.requestfactory.shared.BaseProxy");
withRawTypeToken("3H7UUUNm9l0ImDEwlFVVvDNPdRs=", "falcofinder.android.fuehrerschein.chat.shared.MessageProxy");
withRawTypeToken("nFPyohTFRomTsz_g1Iq2mue1IAE=", "falcofinder.android.fuehrerschein.chat.shared.RegistrationInfoProxy");
withClientToDomainMappings("falcofinder.android.fuehrerschein.chat.server.Message", Arrays.asList("falcofinder.android.fuehrerschein.chat.shared.MessageProxy"));
withClientToDomainMappings("falcofinder.android.fuehrerschein.chat.server.RegistrationInfo", Arrays.asList("falcofinder.android.fuehrerschein.chat.shared.RegistrationInfoProxy"));
}}
