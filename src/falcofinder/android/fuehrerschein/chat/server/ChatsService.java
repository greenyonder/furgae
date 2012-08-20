/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package falcofinder.android.fuehrerschein.chat.server;


import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.SortDirection;


import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import falcofinder.android.fuehrerschein.chat.dspojo.Chat;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatsService {

	private static final Logger log = Logger.getLogger(ChatsService.class
			.getName());

	public ChatsService() {
	}

	/****
	 * 
	 * @param jsonobj
	 * @param v  client version
	 * @return
	 */
	public static String getChat(String jsonobj, String v) {
		
		//log.warning("getChat");
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();

		String res;
		if (user == null) {
			res = "No one is logged in!\nPress menu/accounts to log in ";
	
		} else {
			res = "Hallo , " + user.getEmail()
					+ "!\nMessage,  posted";
		//	log.warning("getChat " + jsonobj);
			insertMessage(jsonobj);
		}
		log.info("Returning message \"" + res + "\"");
		return res;
	}

	
	
	
	private static void insertMessage(String jsonobj) {
		// TODO Auto-generated method stub
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
				

		 PersistenceManager pm = PMF.get().getPersistenceManager();
		
		 
		 
	           Chat c = new Chat(jsonobj, user.getEmail());
	       //	datastore.put(c);  	
	               pm.makePersistent(c);
	        
	               pm.close();
	}

	public static String getChatList(String par1, String v) {
		
			
		String message = "";
		// Get the Datastore Service
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query q = new Query("Chat");
		if (par1.equals("")) {
			q.addFilter("keyfather", Query.FilterOperator.EQUAL, "");
			
		}
		
		q.addSort("date", SortDirection.DESCENDING);

		
	//System.out.println("--->getChatList");
		
		// PreparedQuery contains the methods for fetching query results
		// from the datastore
		PreparedQuery pq = datastore.prepare(q);

		JSONArray jsonArray = new JSONArray();
		
		List<Entity> entities = pq.asList(FetchOptions.Builder.withLimit(100));
		try {
				if (entities.size()==0) {
					JSONObject jsono = new JSONObject();
					
						jsono.put("qid", "00000");
	
					jsonArray.put(jsono);
				}
		
					for (Entity result : entities) {
			
						try {
							JSONObject object =  getJSONObject(result);
							
							jsonArray.put(object);
						
						} catch (SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchMethodException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					  
					  
					}
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	//	System.out.println("--->getChatList z"+jsonArray);
		//log.info("Returning message \"" + message + "\"");

		return jsonArray.toString();
	}

	public static String getChatDetailsList(String keystring, String v) {

		JSONArray jsonArray = new JSONArray();
		
	//	System.out.println("--->getChatDetailsList b");
		
		String message = "";
		// Get the Datastore Service
		

		// PersistenceManager pm = PMF.get().getPersistenceManager();
		// System.out.println("--->getChatDetailsList eb");
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		//Key k = KeyFactory.createKey(Chat.class.getSimpleName(), key);
		
        Entity chat1;
		try {
			
			Key kk = KeyFactory.stringToKey(keystring);
			
			chat1 = datastore.get(KeyFactory.stringToKey(keystring));
			
			 JSONObject objectChat1 =  getJSONObject(chat1);
			 jsonArray.put(objectChat1);
		//	System.out.println("--->getChatDetailsList f" + chat1.getProperty("email"));
		} catch (EntityNotFoundException e1) {
			// TODO Auto-generated catch block
			//System.out.println("--->getChatDetailsList father not found");
			e1.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
      
        
		Query q = new Query("Chat");

		 
	//	System.out.println("---->keystring"+keystring);
		//System.out.println("---->KeyFactory.stringToKey(keystring)"+KeyFactory.stringToKey(keystring));

		//	System.out.println("---->KeyFactory.stringToKey(keystring).getName()"+KeyFactory.stringToKey(keystring).getName());

			//q.addFilter("keyfather", Query.FilterOperator.EQUAL, KeyFactory.stringToKey(keystring).getName());
			
			q.addFilter("keyfather",
				     Query.FilterOperator.EQUAL,
				     KeyFactory.stringToKey(keystring).getName());
			
			q.addSort("date" , SortDirection.ASCENDING);
		
			
			//q.addSort("date", SortDirection.DESCENDING);
		// from the datastore
//System.out.println("----> pq");

		PreparedQuery pq = datastore.prepare(q);
		//		System.out.println("----> pq PreparedQuery");
		
		List<Entity> entities = pq.asList(FetchOptions.Builder.withDefaults());
		
		
		//System.out.println("--->getChatDetailsList entities"+entities.size());
		
		for (int i=0;i<entities.size();i++) {

			//System.out.println("--->result"+entities.get(i));
		 
			try {
				  
				 JSONObject object =  getJSONObject(entities.get(i));
				 
				// System.out.println("--->result object"+object);
				 
				 
				jsonArray.put(object);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  
		  
		}
		//log.info("Returning message \"" + message + "\"");

		return jsonArray.toString();
	}
   
	/*****
	 *  result
	 * 	private static JSONObject getJSONObject(Object result) {
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws JSONException 
	 * @throws IllegalArgumentException 
	 */
	private static JSONObject getJSONObject(Entity object) throws SecurityException, NoSuchMethodException, IllegalArgumentException, JSONException, IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		  JSONObject jsonobject = new JSONObject();
		  //System.out.println("--->getJSONObject");
		  
		 Class c= object.getClass();
	
		
		Method mkey = c.getMethod("getKey", null);
		
		 

 jsonobject.put("keystring",  KeyFactory.keyToString(object.getKey()));	

		
		Class[] parameterTypes = new Class[] { String.class };
		Method m = c.getMethod("getProperty", parameterTypes);
		
		Object[] param = { "qid" };
		
		jsonobject.put("qid", ""+m.invoke(object, param));
			param[0]="subject";
			jsonobject.put("subject", ""+m.invoke(object, param));
			param[0]="body";
			jsonobject.put("body", ""+m.invoke(object, param));

			param[0]="hideemail";
			if ((Boolean) m.invoke(object, param)) {
				jsonobject.put("email",  "");	
			} else {
				param[0]="email";
				jsonobject.put("email",  ""+m.invoke(object, param));
			}
			
			param[0]="keyfather";
			jsonobject.put("keyfather",  ""+m.invoke(object, param));
			param[0]="emailto";
			jsonobject.put("emailto",  ""+m.invoke(object, param));

			
		
			param[0]="hideemail";
			jsonobject.put("hideemail", ""+m.invoke(object, param));
			param[0]="date";
			jsonobject.put("date",  ""+m.invoke(object, param));
			
		return jsonobject;
	}

}
