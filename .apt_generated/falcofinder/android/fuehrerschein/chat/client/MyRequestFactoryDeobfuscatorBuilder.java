// Automatically Generated -- DO NOT EDIT
// falcofinder.android.fuehrerschein.chat.client.MyRequestFactory
package falcofinder.android.fuehrerschein.chat.client;
import java.util.Arrays;
import com.google.web.bindery.requestfactory.vm.impl.OperationData;
import com.google.web.bindery.requestfactory.vm.impl.OperationKey;
public final class MyRequestFactoryDeobfuscatorBuilder extends com.google.web.bindery.requestfactory.vm.impl.Deobfuscator.Builder {
{
withOperation(new OperationKey("g90_UzLIn9Q2RiKRPj42p9kLlkE="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/InstanceRequest;")
  .withDomainMethodDescriptor("()Ljava/lang/String;")
  .withMethodName("send")
  .withRequestContext("falcofinder.android.fuehrerschein.chat.client.MyRequestFactory$MessageRequest")
  .build());
withOperation(new OperationKey("GMaMO8PPuTa7cMuwsV$VwVl2qqQ="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/InstanceRequest;")
  .withDomainMethodDescriptor("()V")
  .withMethodName("register")
  .withRequestContext("falcofinder.android.fuehrerschein.chat.client.MyRequestFactory$RegistrationInfoRequest")
  .build());
withOperation(new OperationKey("0GdwrD7JN7E_KQM2Q6tI$kxuP2w="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/InstanceRequest;")
  .withDomainMethodDescriptor("()V")
  .withMethodName("unregister")
  .withRequestContext("falcofinder.android.fuehrerschein.chat.client.MyRequestFactory$RegistrationInfoRequest")
  .build());
withRawTypeToken("8KVVbwaaAtl6KgQNlOTsLCp9TIU=", "com.google.web.bindery.requestfactory.shared.ValueProxy");
withRawTypeToken("FXHD5YU0TiUl3uBaepdkYaowx9k=", "com.google.web.bindery.requestfactory.shared.BaseProxy");
withRawTypeToken("3H7UUUNm9l0ImDEwlFVVvDNPdRs=", "falcofinder.android.fuehrerschein.chat.shared.MessageProxy");
withRawTypeToken("nFPyohTFRomTsz_g1Iq2mue1IAE=", "falcofinder.android.fuehrerschein.chat.shared.RegistrationInfoProxy");
withClientToDomainMappings("falcofinder.android.fuehrerschein.chat.server.Message", Arrays.asList("falcofinder.android.fuehrerschein.chat.shared.MessageProxy"));
withClientToDomainMappings("falcofinder.android.fuehrerschein.chat.server.RegistrationInfo", Arrays.asList("falcofinder.android.fuehrerschein.chat.shared.RegistrationInfoProxy"));
}}
