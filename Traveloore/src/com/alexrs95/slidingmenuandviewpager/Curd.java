


package com.alexrs95.slidingmenuandviewpager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import com.bremskerl.de.interfaces.openerp.OpenERP;
import com.bremskerl.de.interfaces.openerp.OpenERPDomain;
import com.bremskerl.de.interfaces.openerp.OpenERPRecordSet;

public class Curd {
	Object result;
	@SuppressWarnings("rawtypes")
	
	Vector params;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	XmlRpcClient xmlrpcLogin;
	XmlRpcClientConfigImpl xmlrpcConfigLogin;
	String email="email_from";
	String phone="phone";
	String street="street";
	String lname="contact_name";
	String description="description";
	String fname="name";
	String website="street2";
	String company="company";
	String skype="zip";
	String linkedin="fax";
	Boolean checker=false;
	Vector<Object> vactor;
String getEmail,getPhone,getStreet,getFname,getLname,getDesc,getWeb,getCompany,getSkype,getLinkedin;
	public Object login(String username,String password,String database,String serverIP) throws Exception
	{
		//final Object result=null;
    System.out.println("going to log in");
  //  System.out.println("");
   // int check=0;
		Vector params=new Vector();
		params.addElement(database);
		params.addElement(username);
		params.addElement(password);
		
		//valuesPass=getValues;
		XmlRpcClient xmlrpcLogin = new XmlRpcClient();
		XmlRpcClientConfigImpl xmlrpcConfigLogin = new XmlRpcClientConfigImpl();
		xmlrpcConfigLogin.setEnabledForExtensions(true);
		try {
			xmlrpcConfigLogin.setServerURL(new URL("http",serverIP, 8069, "/xmlrpc/common"));
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		xmlrpcLogin.setConfig(xmlrpcConfigLogin);

	
	
			//check=1;
		  result =xmlrpcLogin.execute("login", params);
          checker=true;
		  System.out.println("Login Id : " + result);
		
        return result;
	}

	public void create(String getFname,String getLname,String getCompany,String getPhone,String getEmail,
			String getWebsite,String getAddress,String getFacebook,String getLinkedin,String getUniqueCode,String getDescription,String serverIP,String database
			,String username,String password,Object result) throws Exception
	{
		XmlRpcClient client = new XmlRpcClient();
		XmlRpcClientConfigImpl clientConfig = new XmlRpcClientConfigImpl();
		clientConfig.setEnabledForExtensions(true);
		clientConfig.setServerURL(new URL("http",serverIP, 8069, "/xmlrpc/object"));
		client.setConfig(clientConfig);

		HashMap<Object, Object> params = new HashMap<Object, Object>();

		params.put("name",getFname);
		params.put("contact_name",getLname);
		params.put("partner_name",getCompany);
		params.put("phone",getPhone);   //street email_from
		//System.out.println("hello hello......");
	    params.put("email_from",getEmail);
		params.put("city", getWebsite);
		//params.put("name", "ShameerHabeeb3");
	    params.put("street",getAddress);
	    params.put("street2",getFacebook);
	    params.put("fax",getLinkedin);
	    params.put("description",getDescription);
	    params.put("zip",getUniqueCode);
	    //params.put("partner_address_email","abc@gmail.com");
	    //params.put("user_email","xyz@yahoo.com");
		Vector<Object> arg = new Vector<Object>();

		arg.add(database);
		arg.add(result);
		arg.add(password);
		arg.add("crm.lead");
		arg.add("create");
		arg.add(params);
		client.execute("execute",arg);
		System.out.println("data inserted,...........");
	
	}
	//first company phone facebook address email website description generated code

	public void insertContact(String getFname,String getCompany,String getPhone,String getFacebook,String getAddress,
			String getEmail,String getWebsite,String getDescription,String getUniqueCode,String serverIP,String database,
			  String username,String password,Object result) throws Exception
	{
			XmlRpcClient client = new XmlRpcClient();
			XmlRpcClientConfigImpl clientConfig = new XmlRpcClientConfigImpl();
			clientConfig.setEnabledForExtensions(true);
			clientConfig.setServerURL(new URL("http",serverIP, 8069, "/xmlrpc/object"));
			client.setConfig(clientConfig);

			HashMap<Object, Object> params = new HashMap<Object, Object>();

			 params.put("name",getFname );
			 params.put("partner_id", getCompany);
			 params.put("phone",getPhone);
			 params.put("street2",getFacebook);
			 params.put("street",getAddress);
			 params.put("email",getEmail);
			
			 params.put("website",getWebsite);
             params.put("description",getDescription);
		    //System.out.println("hello hello......");
		    		   
		   // params.put("title",title.getText().toString());
		  //  params.put("comment", getDescription);
		    
		     params.put("city", getUniqueCode);//params.put("partner_address_email","abc@gmail.com");
		   // params.put("user_email","xyz@yahoo.com");

			Vector<Object> arg = new Vector<Object>();

			arg.add(database);
			arg.add(result);
			arg.add(password);
			arg.add("res.partner");
			arg.add("create");
			arg.add(params);
			client.execute("execute",arg);
			System.out.println("data inserted,...........");
	
	}

	public void insertDeal(String dealName, String dealValue,String serverIP,String database
			,String username,String password, Object login) throws Exception
	{
		XmlRpcClient client = new XmlRpcClient();
		XmlRpcClientConfigImpl clientConfig = new XmlRpcClientConfigImpl();
		clientConfig.setEnabledForExtensions(true);
		clientConfig.setServerURL(new URL("http",serverIP, 8069, "/xmlrpc/object"));
		client.setConfig(clientConfig);

		HashMap<Object, Object> params = new HashMap<Object, Object>();

		params.put("type","opportunity");
		params.put("name",dealName);
		params.put("email_from", dealValue);
		Vector<Object> arg = new Vector<Object>();

		arg.add(database);
		arg.add(login);
		arg.add(password);
		arg.add("crm.lead");
		arg.add("create");
		arg.add(params);
		client.execute("execute",arg);
		System.out.println("data inserted,...........");
	
	}

	public void insertTask(String taskValue,String serverIP,String database
			,String username,String password,Object result) throws Exception
	{
		XmlRpcClient client = new XmlRpcClient();
		XmlRpcClientConfigImpl clientConfig = new XmlRpcClientConfigImpl();
		clientConfig.setEnabledForExtensions(true);
		clientConfig.setServerURL(new URL("http",serverIP, 8069, "/xmlrpc/object"));
		client.setConfig(clientConfig);

		HashMap<Object, Object> params = new HashMap<Object, Object>();

		params.put("name", taskValue);
		Vector<Object> arg = new Vector<Object>();

		arg.add(database);
		arg.add(result);
		arg.add(password);
		arg.add("project.task");
		arg.add("create");
		arg.add(params);
		client.execute("execute",arg);
		System.out.println("data inserted,...........");
	
	}

	
	
	public OpenERPRecordSet search_and_output(String host,String dbName , String userName, String password) throws Exception {
		OpenERP openerp;
		ArrayList<String> resultSet,getServerValues;
		
		resultSet=new ArrayList<String>();
		//getServerValues = new ArrayList<String>();
		vactor=new Vector<Object>();
		openerp = new OpenERP(host, dbName, userName, password);
		OpenERPDomain domain = new OpenERPDomain();
    //	domain.add("id", 2);

		Object[] result_ids = openerp.search("crm.lead");
		OpenERPRecordSet results = openerp.readRecords("crm.lead", result_ids, new String[] { "name","contact_name","partner_name","phone","email_from","city","street","street2","fax","description"});
		
		System.out.println(results);
	//vactor= new Vector<Object>();
	//vactor=results.getFieldContents("create_date");
	//System.out.println(vactor.get(0));
	//String []stringSet=new String[vactor.size()];
	///for(int i=0;i<vactor.size();i++)
	 //   stringSet[i]=vactor.get(i).toString();	
	//for(int i=0;i<vactor.size();i++)
	//System.out.println(stringSet[i]);
//return null;
		return results;
	}
	
	OpenERP openerp;
	public void update(String host,String dbName , String userName, String password,String serverIP,String database
			,String username,String passWord) throws Exception {
			
		openerp = new OpenERP(host, dbName, userName, password);
		OpenERPDomain domain = new OpenERPDomain();
		HashMap<String, Object> update = new HashMap<String, Object>();
		update.put("name", "update");
		//OpenERPRecord value = new OpenERPRecord();
		//Vector<OpenERPRecord> updateVector = new Vector<OpenERPRecord>();
		//updateVector.add("","");
		//updateVector.add(update);
		openerp.write("crm.lead", 2161, update);
			}
	public void createUser(String getFname,String getEmail,String getPassword,String serverIP,String database
			,String username,String password) throws Exception
	{
		XmlRpcClient client = new XmlRpcClient();
		XmlRpcClientConfigImpl clientConfig = new XmlRpcClientConfigImpl();
		clientConfig.setEnabledForExtensions(true);
		clientConfig.setServerURL(new URL("http","54.251.186.100", 8069, "/xmlrpc/object"));
		client.setConfig(clientConfig);

		HashMap<Object, Object> params1 = new HashMap<Object, Object>();

		params1.put("name",getFname);
		params1.put("login",getEmail);
	params1.put("password",getPassword);
	   
		Vector<Object> arg = new Vector<Object>();

		arg.add("traveloore");
		arg.add(1);
		arg.add("1234");
		arg.add("res.users");
		arg.add("create");
		arg.add(params1);
		client.execute("execute",arg);
		System.out.println("data inserted,...........");
	
	}

	@SuppressWarnings("unused")
	public InputStream OpenHttpConnection(String urlString) throws Exception
	{
	    InputStream in = null;
	    int response = -1;
	               
	    URL url = new URL(urlString); 
	    URLConnection conn = url.openConnection();
	                 
	    if (!(conn instanceof HttpURLConnection))                     
		throw new IOException("Not an HTTP connection");
	        
	    try{
		HttpURLConnection httpConn = (HttpURLConnection) conn;
	        httpConn.setAllowUserInteraction(false);
	        httpConn.setInstanceFollowRedirects(true);
	        httpConn.setRequestMethod("GET");
	        httpConn.connect(); 

		response = httpConn.getResponseCode();                 
	        if (response == HttpURLConnection.HTTP_OK) {
			in = httpConn.getInputStream();                                 
	        }                     
	    }
	    catch (Exception ex)
	    {
		throw new IOException("Error connecting");            
	    }
	    return in;     
	}
	public static String convertStreamToString(InputStream is) 
	{
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
 
		String line;
		try {
 
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
 
		return sb.toString();
 

	}
	
	}

