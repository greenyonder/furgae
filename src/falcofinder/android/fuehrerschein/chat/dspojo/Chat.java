package falcofinder.android.fuehrerschein.chat.dspojo;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import java.util.Random;

@PersistenceCapable(detachable="false")
public class Chat {

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

    public void setKey(Key key) {
        this.key = key;
    }
	public Key getKey() {
		return key;
	}
	
	public String getKeyfather() {
		return keyfather;
	}
	public void setKeyfather(String keyfather) {
		this.keyfather = keyfather;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getHideemail() {
		return hideemail;
	}
	public void setHideemail(Boolean hideemail) {
		this.hideemail = hideemail;
	}
	public String getEmailto() {
		return emailto;
	}
	public void setEmailto(String emailto) {
		this.emailto = emailto;
	}
	public String getQid() {
		return qid;
	}
	public void setQid(String qid) {
		this.qid = qid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubj(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

	private String keyfather="";
	private Date date;
	private String email="";
	private Boolean hideemail;
	private String emailto="";
	private String qid="";
	private String subject="";
	private String body="";
	
	
	public Chat(String  jsonobj , String email) {
		//System.out.println("---->Chat "+jsonobj);
    JSONObject json;
	try {
		json = new JSONObject(jsonobj);
		hideemail = json.getBoolean("hideemail");
	    subject = json.getString("subject");
	    body = json.getString("body");
	    qid = json.getString("qid");
	    
	    
	    date = new Date();
	    
	    String keystring = json.getString("keystring");
	    
	    if (!"".equals(keystring)) {
	    	
	    	Key keyf = KeyFactory.stringToKey(keystring);
	    	keyfather = keyf.getName();
	    }
	    
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		//  System.out.println("--->Chat.JSONException");
		e.printStackTrace();
		
	}
	
	//System.out.println("--->Random.next date:"+date);
	
    this.email=email;
    Random r = new Random();
    
    //System.out.println("--->Random.next"+r.nextLong()+"-"+new Date());
    
    
		 this.key  = KeyFactory.createKey("Chat", ""+r.nextLong()+"-"+new Date());
			

	
	}
}
