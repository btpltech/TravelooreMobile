package com.bremskerl.de.interfaces.openerp;

/**
 * OpenERP Interfaces for Java
 * 
 * Copyright (c) 2010+ BREMSKERL-REIBBELAGWERKE Emmerling GmbH & Co. KG
 * Author: Marco Dieckhoff, marco.dieckhoff@bremskerl.de
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 * 
 */

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.Vector;



import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

/**
 * OpenERP Interfaces for Java
 * 
 * @author Marco Dieckhoff, BREMSKERL-REIBBELAGWERKE Emmerling GmbH & Co. KG
 */
public class OpenERP {

	// connection
	private XmlRpcClient xmlrpc;

	// userid, derived from first login
	private int openERPuserid;

	// internally stored
	private String openERPHost;
	private int openERPPort;
	private static int default_openERPPort = 8069;
	private String openERPDB;
	private String openERPUser;
	private String openERPPassword; // esp. the password is needed for every
									// request

	// path, either /openerp/xmlrpc for current or /xmlrpc for legacy
	private String openERPPath;

	// cache variables - we'll only request these once from OpenERP server
	private String cacheServerTimeZone;
	private HashMap<String, OpenERPRecordSet> cacheModelFieldsInformation;

	
	//TODO replace username and password dialog to a common dialog
	/**
	 * Requests user name
	 * 
	 * @return entered name
	 */
	private String usernameDialog() {
		String p = null;
		try {
		//	p = (String)JOptionPane.showInputDialog(null, "OpenERP Username");
		} catch (Exception e) {
			// do nothing, returning null
			// Maybe we simply don't have a graphical UI, e.g. batch usage,
			// which would result in HeadlessException
		}
		return p;
	}
	
	
	/**
	 * Requests user password
	 * 
	 * @return entered password
	 */
	private String passwordDialog() {
		String p = null;
		try {
		//	JPasswordField passwordField = new JPasswordField(10);
			//JTextPane tp = new JTextPane("OpenERP Password");
		//	passwordField.setEchoChar('#');
		//	JOptionPane.showMessageDialog(null, passwordField,
				//	"OpenERP Password", JOptionPane.OK_OPTION);
		//	p = new String(passwordField.getPassword());
		} catch (Exception e) {
			// do nothing, returning null
			// Maybe we simply don't have a graphical UI, e.g. batch usage,
			// which would result in HeadlessException
		}
		return p;
	}
	
	/**
	 * Initialize connection to OpenERP server
	 * 
	 * @param host
	 *            Hostname to connect to. Either DNS-resolvable or IP
	 * @param port
	 *            Port to connect to. OpenERP XML-RPC standard would be 8069.
	 * @throws MalformedURLException
	 * @throws XmlRpcException
	 */
	public OpenERP(String host, int port) {
		openERPHost = host;
		openERPPort = port;
		cacheServerTimeZone = null;
		cacheModelFieldsInformation = null;
	}

	/**
	 * Initialize connection to OpenERP server
	 * 
	 * @param host
	 *            Hostname to connect to. Either DNS-resolvable or IP
	 * @throws MalformedURLException
	 * @throws XmlRpcException
	 */
	public OpenERP(String host) {
		openERPHost = host;
		openERPPort = default_openERPPort;
		cacheServerTimeZone = null;
		cacheModelFieldsInformation = null;
	}

	/**
	 * Initialize connection to OpenERP server and log in
	 * 
	 * @param host
	 *            Hostname to connect to. Either DNS-resolvable or IP
	 * @param port
	 *            Port to connect to. OpenERP XML-RPC standard would be 8869.
	 * @param db
	 *            Database name
	 * @param user
	 *            User name
	 * @param pass
	 *            User password
	 * @throws MalformedURLException
	 * @throws XmlRpcException
	 */
	public OpenERP(String host, int port, String db, String user, String pass)
			throws MalformedURLException, XmlRpcException {
		openERPHost = host;
		openERPPort = port;
		openERPDB = db;
		
		openERPUser = user;
		if ((openERPUser == null) || (openERPUser.trim().length() == 0))
			openERPUser = usernameDialog();

		
		openERPPassword = pass;
		if ((openERPPassword == null) || (openERPPassword.trim().length() == 0))
			openERPPassword = passwordDialog();

		cacheServerTimeZone = null;
		cacheModelFieldsInformation = null;

		loginOpenERP();
		initializeXMLRPC();
	}

	/**
	 * Initialize connection to OpenERP server, request password and log in
	 * 
	 * @param host
	 *            Hostname to connect to. Either DNS-resolvable or IP
	 * @param port
	 *            Port to connect to. OpenERP XML-RPC standard would be 8869.
	 * @param db
	 *            Database name
	 * @param user
	 *            User name
	 * @throws MalformedURLException
	 * @throws XmlRpcException
	 */
	public OpenERP(String host, int port, String db, String user)
			throws MalformedURLException, XmlRpcException {
		this(host, port, db, user, null);
	}
	
	/**
	 * Initialize connection to OpenERP server, request user and log in
	 * 
	 * @param host
	 *            Hostname to connect to. Either DNS-resolvable or IP
	 * @param port
	 *            Port to connect to. OpenERP XML-RPC standard would be 8869.
	 * @param db
	 *            Database name
	 * @param user
	 *            User name
	 * @throws MalformedURLException
	 * @throws XmlRpcException
	 */
	public OpenERP(String host, int port, String db)
			throws MalformedURLException, XmlRpcException {
		this(host, port, db, null, null);
	}

	/**
	 * Initialize connection to OpenERP server on default port 8069 and log in
	 * 
	 * @param host
	 *            Hostname to connect to. Either DNS-resolvable or IP
	 * @param db
	 *            Database name
	 * @param user
	 *            User name
	 * @param pass
	 *            User password
	 * @throws MalformedURLException
	 * @throws XmlRpcException
	 */
	public OpenERP(String host, String db, String user, String pass)
			throws MalformedURLException, XmlRpcException {
		this(host, default_openERPPort, db, user, pass);
	}

	/**
	 * Initialize connection to OpenERP server on default port 8069, request
	 * password and log in
	 * 
	 * @param host
	 *            Hostname to connect to. Either DNS-resolvable or IP
	 * @param db
	 *            Database name
	 * @param user
	 *            User name
	 * @throws MalformedURLException
	 * @throws XmlRpcException
	 */
	public OpenERP(String host, String db, String user)
			throws MalformedURLException, XmlRpcException {
		this(host, default_openERPPort, db, user, null);
	}

	/**
	 * List databases from OpenERP Host No login needed, just servername on
	 * class initialisation
	 * 
	 * @return
	 * @throws MalformedURLException
	 * @throws XmlRpcException
	 */
	public String[] list() throws MalformedURLException, XmlRpcException {
		XmlRpcClient xmlrpcLogin = new XmlRpcClient();

		XmlRpcClientConfigImpl xmlrpcConfigLogin = new XmlRpcClientConfigImpl();
		xmlrpcConfigLogin.setEnabledForExtensions(true);

		URL serverURL = null;
		// processing is done with /db, unlike login (/common) or queries
		// (/object)
		serverURL = new URL("http", openERPHost, openERPPort, openERPPath+"/db");
		xmlrpcConfigLogin.setServerURL(serverURL);

		xmlrpcLogin.setConfig(xmlrpcConfigLogin);

		// Try current path /openerp/xmlrpc
		Object[] params = new Object[] {};
		Object id = xmlrpcLogin.execute("list", params);
		Object[] ids = (Object[]) id;

		String[] strs = new String[ids.length];
		for (int i = 0; i < ids.length; i++) {
			Object idsi = ids[i];
			strs[i] = (String) idsi;
		}
		return strs;
	}

	/**
	 * Login to OpenERP with the specified credentials. May be used to change user
	 * in mid-session.
	 * 
	 * @param username
	 * @param password
	 * @return true if login was successful
	 * @throws MalformedURLException
	 * @throws XmlRpcException
	 */
	public boolean loginOpenERP(String username, String password)
			throws MalformedURLException, XmlRpcException {
		openERPUser = username;
		openERPPassword = password;
		return loginOpenERP();
	}


	/**
	 * Login to OpenERP with the preset credentials.
	 * 
	 * @return true if login was successful
	 * @throws MalformedURLException
	 * @throws XmlRpcException
	 */
	private boolean loginOpenERP(String path) throws MalformedURLException, XmlRpcException {
		XmlRpcClient xmlrpcLogin = new XmlRpcClient();

		XmlRpcClientConfigImpl xmlrpcConfigLogin = new XmlRpcClientConfigImpl();
		xmlrpcConfigLogin.setEnabledForExtensions(true);

		URL serverURL = null;

		// processing is done with /common, unlike queries (/object)
		serverURL = new URL("http", openERPHost, openERPPort, path+"/common");
		xmlrpcConfigLogin.setServerURL(serverURL);

		xmlrpcLogin.setConfig(xmlrpcConfigLogin);
		// Connect
		Object[] params = new Object[] { openERPDB, openERPUser,
				openERPPassword };
		Object id = xmlrpcLogin.execute("login", params);
		if (id instanceof Integer)
			openERPuserid = ((Integer) id).intValue();

		// return "true" if user id exists
		return (openERPuserid > 0);
	}

	/**
	 * Login to OpenERP with the preset credentials.
	 * 
	 * @return true if login was successful
	 * @throws MalformedURLException
	 * @throws XmlRpcException
	 */
	public boolean loginOpenERP() throws MalformedURLException, XmlRpcException {
		
		// try current path /openerp/xmlrpc
		try {
			openERPPath = "/openerp/xmlrpc";
			return loginOpenERP(openERPPath);
		} catch (Exception e) {
			// e.printStackTrace();
			// any exception? try next path
		}

		// try v1 path /openerp/xmlrpc/1
		try {
			openERPPath = "/openerp/xmlrpc/1";
			return loginOpenERP(openERPPath);
		} catch (Exception e) {
			// e.printStackTrace();
			// any exception? try next path
		}

		// try legacy path /xmlrpc
		try {
			openERPPath = "/xmlrpc";
			return loginOpenERP(openERPPath);
		} catch (Exception e) {
			// e.printStackTrace();
			// any exception? try next path
		}

		// oh, there is no next path available. ok, that's a problem.
		throw new MalformedURLException("OpenERP Server does not react to any xmlrpc path request.");
	}

	/**
	 * Find server time zone
	 * 
	 * @return timezone identified. BEWARE: function DOES NOT WORK. Will return "MET" every time until "someone" repairs it :)
	 * @throws MalformedURLException
	 * @throws XmlRpcException
	 */
	public String getServerTimeZone() {

		// FIXME Workaround: Mitteleuropäische Zeit (MET in german system)
		// generates UnicodeDecodeError: 'ascii' codec can't decode byte 0xe4 in
		// position 11: ordinal not in range(128)
		// !!!for now, returning only MET, no real server time zone!!!
		cacheServerTimeZone = "MET";

		if (cacheServerTimeZone != null)
			return cacheServerTimeZone;

		XmlRpcClient xmlrpcTimezone = new XmlRpcClient();

		XmlRpcClientConfigImpl xmlrpcConfigTimezone = new XmlRpcClientConfigImpl();
		xmlrpcConfigTimezone.setEnabledForExtensions(true);

		URL serverURL = null;
		// processing is done with /common, unlike queries (/object)
		try {
			serverURL = new URL("http", openERPHost, openERPPort,
					openERPPath+"/common");
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
		xmlrpcConfigTimezone.setServerURL(serverURL);

		xmlrpcTimezone.setConfig(xmlrpcConfigTimezone);
		// Connect
		Object[] params = new Object[] { openERPDB, openERPuserid,
				openERPPassword };
		Object timezone = null;
		try {
			timezone = xmlrpcTimezone.execute("timezone_get", params);
		} catch (XmlRpcException e) {
			e.printStackTrace();
			return null;
		}
		if (timezone instanceof String)
			cacheServerTimeZone = (String) timezone;

		// return "true" if user id exists
		return cacheServerTimeZone;
	}

	/**
	 * initialize XML RPC request object
	 * 
	 * @throws MalformedURLException
	 */
	private void initializeXMLRPC() throws MalformedURLException {
		xmlrpc = new XmlRpcClient();

		XmlRpcClientConfigImpl xmlrpcConfig = new XmlRpcClientConfigImpl();
		xmlrpcConfig.setEnabledForExtensions(true);

		URL serverURL = null;
		serverURL = new URL("http", openERPHost, openERPPort, openERPPath+"/object");
		xmlrpcConfig.setServerURL(serverURL);

		xmlrpc.setConfig(xmlrpcConfig);
	}

	/**
	 * tests if the last login to OpenERP was successful.
	 * 
	 * @return true if last login was successful
	 */
	public boolean isConnected() {
		// return "true" if user id exists
		return (openERPuserid > 0);
	}

	/**
	 * tests if a module exists or is installed
	 * 
	 * @param modulename
	 *            Name of the module to test for
	 * @param isInstalled
	 *            Do test if the module is installed in addition to mere
	 *            existence
	 * @return true if the module exists (resp. is installed)
	 */
	public boolean hasModule(String modulename, boolean isInstalled) {
		OpenERPDomain domain = new OpenERPDomain();
		domain.add("name", "=", modulename);
		if (isInstalled) {
			domain.add("state", "=", "installed");
		}
		// use a simple search on the module model/table
		Object[] is = search("ir.module.module", domain);
		return ((is != null) && (is.length > 0));
	}

	/**
	 * tests if a module is installed
	 * 
	 * @param modulename
	 *            Name of the module to test for
	 * @return true if the module is installed
	 */
	public boolean hasModule(String modulename) {
		return hasModule(modulename, true);
	}

	/**
	 * Returns information about the requested model
	 * 
	 * @param model
	 *            model name to look up
	 * @param useCache
	 *            determines if caching is used or every request is sent to the
	 *            database
	 * @return
	 */
	public OpenERPRecordSet getModelInformation(String model, boolean useCache) {
		if (model == null)
			return null;

		// initialize caching, if neccessary
		if (cacheModelFieldsInformation == null)
			cacheModelFieldsInformation = new HashMap<String, OpenERPRecordSet>();

		// look for cached values, if requested
		if ((useCache) && (cacheModelFieldsInformation.containsKey(model))) {
			return cacheModelFieldsInformation.get(model);
		}

		// search & read data
		OpenERPDomain domain = new OpenERPDomain();
		domain.add("model", "=", model);
		Object[] is = search("ir.model.fields", domain);
		OpenERPRecordSet rs = readRecords("ir.model.fields", is, new String[] {
				"name", "required", "translatable", });

		// store in cache
		cacheModelFieldsInformation.put(model, rs);

		return rs;
	}

	/**
	 * Returns information about the requested model and field
	 * 
	 * @param model
	 *            model name to look up
	 * @param fieldname
	 *            field name to look up
	 * @param useCache
	 *            determines if caching is used or every request is sent to the
	 *            database
	 * @return
	 */
	public OpenERPRecord getFieldInformation(String model, String fieldname,
			boolean useCache) {
		OpenERPRecordSet m = getModelInformation(model, useCache);
		OpenERPRecord f = m.get("name", fieldname);
		return f;
	}

	/**
	 * Gets a list of all field names for the named model.
	 * 
	 * @param model
	 *            model name to look up
	 * @param useCache
	 *            determines if caching is used or every request is sent to the
	 *            database
	 * @return list of all field names belonging to the model
	 * 
	 */
	public String[] getFieldNames(String model, boolean useCache) {
		if (model == null)
			return null;

		OpenERPRecordSet rs = getModelInformation(model, useCache);
		if (rs == null)
			return null;

		Vector<String> v = new Vector<String>();

		Iterator<OpenERPRecord> ir = rs.iterator();
		while (ir.hasNext()) {
			OpenERPRecord r = ir.next();
			v.add(r.getString("name"));
		}
		String[] ret = (String[]) v.toArray(new String[v.size()]);
		return ret;
	}

	/**
	 * Gets a list of all field names for the named model (caches results)
	 * 
	 * @param model
	 *            model name to look up
	 * @return list of all field names belonging to the model
	 * 
	 */
	public String[] getFieldNames(String model) {
		// use cache = true
		return getFieldNames(model, true);
	}

	/**
	 * Returns whether a field is a required field
	 * 
	 * @param model
	 *            model of the field
	 * @param fieldname
	 *            name of the field
	 * @param useCache
	 *            determines if caching is used or every request is sent to the
	 *            database
	 * @return true if field is required
	 */
	public boolean isRequired(String model, String fieldname, boolean useCache) {
		OpenERPRecord r = getFieldInformation(model, fieldname, useCache);
		return r.getBoolean("required", false);
	}

	/**
	 * Returns whether a field is a required field (caches results)
	 * 
	 * @param model
	 *            model of the field
	 * @param fieldname
	 *            name of the field
	 * @return true if field is required
	 */
	public boolean isRequired(String model, String fieldname) {
		return isRequired(model, fieldname, true);
	}

	/**
	 * create params for use with XMLRPC call
	 * 
	 * @param model
	 *            modelname to act on
	 * @param action
	 *            action to perform
	 * @return parametrized Vector
	 */
	private Vector<Object> createParams(String model, String action) {
		Vector<Object> params = new Vector<Object>();
		params.add(openERPDB);
		params.add(openERPuserid);
		params.add(openERPPassword);
		params.add(model);
		params.add(action);
		return params;
	}

	/**
	 * performs a search (kind of SELECT WHERE) on an OpenERP model (table)
	 * 
	 * @param model
	 *            model to search in
	 * @param domain
	 *            search domain
	 * @return null if no result, or Object[] castable to Integer[], list of IDs
	 * @throws nothing
	 *             will print stack trace and return null
	 */
	public Object[] search(String model, OpenERPDomain domain) {
		return search(model, domain.get());
	}

	/**
	 * performs a search (kind of SELECT WHERE) on an OpenERP model (table)
	 * 
	 * @param model
	 *            model to search in
	 * @param domain
	 *            search domain, list of (key, operator, value) lists.
	 * @return null if no result, or Object[] castable to Integer[], list of IDs
	 * @throws nothing
	 *             will print stack trace and return null
	 */
	public Object[] search(String model, Object[] domain) {
		Vector<Object> params = createParams(model, "search");

		domain = handleDateTimes(domain);

		params.add(domain);
		params.add(0); // offset
		params.add(0); // set the max number of result items
		params.add(0); // another 0. is this offset to the results size? but
						// what would the first 0 be then?
						// if you know what this is, please tell me :)

		Object[] resultArray = null;
		try {
			Object result = xmlrpc.execute("execute", params);
			resultArray = (Object[]) result;
		} catch (XmlRpcException e) {
			e.printStackTrace();
			return null;
		}

		if (resultArray != null)
			if (resultArray.length == 0)
				return null;

		return resultArray;
	}

	/**
	 * Performs a search (kind of SELECT WHERE) on an OpenERP model (table).
	 * Special case: do not search anything, returns all ids.
	 * 
	 * @param model
	 *            model to search in
	 * @return null if no result, or Object[] castable to Integer[], list of IDs
	 */
	public Object[] search(String model) {
		// hm, can't figure out how to do "no" request. just all ids. So id>0
		// looks ok :)
		return search(model, new Object[] { new Object[] { "id", ">",
				new Integer(0) } });
	}

	/**
	 * Performs a search (kind of SELECT WHERE) on an OpenERP model (table).
	 * Simplification for searching only one parameter.
	 * 
	 * @param model
	 *            model to search in
	 * @param fieldname
	 *            fieldname to search for
	 * @param operator
	 *            operator to use in comparism
	 * @param compare
	 *            object to compare to
	 * @return null if no result, or Object[] castable to Integer[], list of IDs
	 */
	public Object[] search(String model, String fieldname, String operator,
			Object compare) {
		OpenERPDomain domain = new OpenERPDomain();
		domain.add(fieldname, operator, compare);
		return search(model, domain);
	}

	/**
	 * Read (SELECT) content from model
	 * 
	 * @param model
	 *            model name to read from
	 * @param readlist
	 *            list of IDs to read (is Object[] here, but really Integer[] is
	 *            expected)
	 * @param fieldlist
	 *            list of field names to return
	 * @return null if empty, castable to HashMap(String,Object) otherwise
	 * @throws nothing
	 *             will print stack trace and return null
	 */
	public Object[] read(String model, Object[] readlist, Object[] fieldlist) {
		Vector<Object> params = createParams(model, "read");
		params.add(readlist);
		params.add(fieldlist);

		Object[] resultArray = null;
		try {
			Object result = xmlrpc.execute("execute", params);
			resultArray = (Object[]) result;
		} catch (XmlRpcException e) {
			e.printStackTrace();
			return null;
		}

		return resultArray;
	}

	/**
	 * Read (SELECT) content from model
	 * 
	 * @param model
	 *            model name to read from
	 * @param readlist
	 *            list of IDs to read (is Object[] here, but really Integer[] is
	 *            expected)
	 * @param fieldlist
	 *            list of field names to return
	 * @return null if empty, castable to HashMap(String,Object) otherwise
	 * @throws nothing
	 *             will print stack trace and return null
	 */
	public Object[] read(String model, Object[] readlist, String[] fieldlist) {
		if (readlist == null)
			return null;

		Vector<Object> params = createParams(model, "read");
		params.add(readlist);
		params.add(fieldlist);

		Object[] resultArray = null;
		try {
			Object result = xmlrpc.execute("execute", params);
			resultArray = (Object[]) result;
		} catch (XmlRpcException e) {
			e.printStackTrace();
			return null;
		}

		return resultArray;
	}

	/**
	 * Read (SELECT) content from model
	 * 
	 * @param model
	 *            model name to read from
	 * @param readlist
	 *            single ID to read
	 * @param fieldlist
	 *            list of field names to return
	 * @return null if empty, castable to HashMap(String,Object) otherwise
	 * @throws nothing
	 *             will print stack trace and return null
	 */
	public Object[] read(String model, Integer readlist, String[] fieldlist) {
		return this.read(model, new Object[] { readlist }, fieldlist);
	}

	/**
	 * Read (SELECT) content from model
	 * 
	 * @param model
	 *            model name to read from
	 * @param readlist
	 *            list of IDs to read (is Object[] here, but really Integer[] is
	 *            expected)
	 * @param fieldlist
	 *            list of field names to return
	 * @return null if empty, castable to HashMap(String,Object) otherwise
	 * @throws nothing
	 *             will print stack trace and return null
	 */
	public OpenERPRecord readRecord(String model, Object readlist,
			Object[] fieldlist) {
		Object[] o = this.read(model, new Object[] { readlist }, fieldlist);
		if (o.length >= 1) {
			return new OpenERPRecord(o[0]);
		}
		return null;
	}

	/**
	 * Read (SELECT) content from model
	 * 
	 * @param model
	 *            model name to read from
	 * @param readlist
	 *            list of IDs to read (is Object[] here, but really Integer[] is
	 *            expected)
	 * @param fieldlist
	 *            list of field names to return
	 * @return null if empty, castable to HashMap(String,Object) otherwise
	 * @throws nothing
	 *             will print stack trace and return null
	 */
	public OpenERPRecordSet readRecords(String model, Object[] readlist,
			Object[] fieldlist) {
		return new OpenERPRecordSet(this.read(model, readlist, fieldlist));
	}

	/**
	 * Read (SELECT) content from model
	 * 
	 * @param model
	 *            model name to read from
	 * @param readlist
	 *            list of IDs to read (is Object[] here, but really Integer[] is
	 *            expected)
	 * @param fieldlist
	 *            list of field names to return
	 * @return null if empty, castable to HashMap(String,Object) otherwise
	 * @throws nothing
	 *             will print stack trace and return null
	 */
	public OpenERPRecordSet readRecords(String model, Vector<Object> readlist,
			Object[] fieldlist) {
		return new OpenERPRecordSet(this.read(model, readlist.toArray(),
				fieldlist));
	}

	/**
	 * Read (SELECT) content from model
	 * 
	 * @param model
	 *            model name to read from
	 * @param readlist
	 *            list of IDs to read (is Object[] here, but really Integer[] is
	 *            expected)
	 * @param fieldlist
	 *            list of field names to return
	 * @return null if empty, castable to HashMap(String,Object) otherwise
	 * @throws nothing
	 *             will print stack trace and return null
	 */
	public OpenERPRecordSet readRecords(String model, Vector<Object> readlist,
			String[] fieldlist) {
		return new OpenERPRecordSet(this.read(model, readlist.toArray(),
				fieldlist));
	}

	/**
	 * Read (SELECT) content from model
	 * 
	 * @param model
	 *            model name to read from
	 * @param readlist
	 *            list of IDs to read (is Object[] here, but really Integer[] is
	 *            expected)
	 * @param fieldlist
	 *            list of field names to return
	 * @return null if empty, castable to HashMap(String,Object) otherwise
	 * @throws nothing
	 *             will print stack trace and return null
	 */
	public OpenERPRecordSet readRecords(String model, Object[] readlist,
			String[] fieldlist) {
		return new OpenERPRecordSet(this.read(model, readlist, fieldlist));
	}

	/**
	 * Read (SELECT) content from model
	 * 
	 * @param model
	 *            model name to read from
	 * @param readlist
	 *            list of IDs to read (is Object[] here, but really Integer[] is
	 *            expected)
	 * @param fieldlist
	 *            list of field names to return
	 * @return null if empty, castable to HashMap(String,Object) otherwise
	 * @throws nothing
	 *             will print stack trace and return null
	 */
	public OpenERPRecordSet readRecords(String model, OpenERPDomain domain,
			String[] fieldlist) {
		Object[] readlist = this.search(model, domain);
		return new OpenERPRecordSet(this.read(model, readlist, fieldlist));
	}

	/**
	 * creates (INSERT) a new data record
	 * 
	 * @param model
	 *            model to create in
	 * @param data
	 *            key,value pairs to store
	 * @return id (primary key) of the data record created, or null if errors
	 *         occured
	 * @throws nothing
	 *             will print stack trace and return null
	 */
	public Integer create(String model, HashMap<String, Object> data) {
		Vector<Object> params = createParams(model, "create");

		// Handles DateTime as Strings
		data = handleDateTimes(data);

		// remove null values
		data = removeNulls(data);

		// add parameters to be created
		params.add(data);

		Integer resultID = null;
		try {
			Object result = xmlrpc.execute("execute", params);
			resultID = (Integer) result;
		} catch (XmlRpcException e) {
			e.printStackTrace();
		}

		return resultID;
	}

	/**
	 * creates (INSERT) a new data record
	 * 
	 * @param model
	 *            model to create in
	 * @param data
	 *            {@link OpenERPRecord} to store
	 * @return id (primary key) of the data record created, or null if errors
	 *         occured
	 * @throws nothing
	 *             will print stack trace and return null
	 */
	public Integer create(String model, OpenERPRecord data) {
		return this.create(model, data.toCreate());
	}

	/**
	 * Writes (UPDATE) to a single id
	 * 
	 * @param model
	 *            model to write to
	 * @param id
	 *            id to write/update
  	 * @param data
	 *            {@link OpenERPRecord} to store. Data will be updated (overwritten).
	 * @return
	 */
	public Boolean write(String model, Integer id,
			OpenERPRecord data) {
		return write(model, new Integer[] { id }, data.toUpdate());
	}

	/**
	 * Writes (UPDATE) to a single id
	 * 
	 * @param model
	 *            model to write to
	 * @param id
	 *            id to write/update
	 * @param values
	 *            map of key:value pairs. Data will be updated (overwritten).
	 *            You don't need to fill all fields available in the model.
	 * @return
	 */
	public Boolean write(String model, Integer id,
			HashMap<String, Object> values) {
		return write(model, new Integer[] { id }, values);
	}

	
	/**
	 * Writes (UPDATE) to multiple data records at once
	 * 
	 * @param model
	 *            model to write to
	 * @param ids
	 *            ids to write/update
  	 * @param data
	 *            {@link OpenERPRecord} to store. Data will be updated (overwritten).
	 * @return
	 */
	public Boolean write(String model, Integer[] ids,
			OpenERPRecord data) {
		return write(model, ids, data.toUpdate());
	}

	/**
	 * Writes (UPDATE) to multiple data records at once
	 * 
	 * @param model
	 *            model to write to
	 * @param ids
	 *            ids to write/update
	 * @param values
	 *            map of key:value pairs. Data will be updated (overwritten).
	 *            You don't need to fill all fields available in the model.
	 * @return
	 */
	public Boolean write(String model, Integer[] ids,
			HashMap<String, Object> values) {
		Vector<Object> params = createParams(model, "write");
		params.add(ids);

		values = handleDateTimes(values);
		params.add(values);

		Boolean resultID = null;
		try {
			Object result = xmlrpc.execute("execute", params);
			resultID = (Boolean) result;
		} catch (XmlRpcException e) {
			e.printStackTrace();
		}

		return resultID;

	}

	/**
	 * Deletes (unlink) to a single id
	 * 
	 * @param model
	 *            model to delete from
	 * @param id
	 *            id to unlink/delete
	 * @return
	 */
	public Boolean delete(String model, Integer id) {
		return unlink(model, new Integer[] { id });
	}

	/***
	 * Unlinks (DELETE) to multiple data records at once
	 * 
	 * @param model
	 *            model to delete from
	 * @param ids
	 *            ids to unlink/delete
	 * @return
	 */
	public Boolean unlink(String model, Integer[] ids) {
		Vector<Object> params = createParams(model, "unlink");
		params.add(ids);

		Boolean resultID = null;
		try {
			Object result = xmlrpc.execute("execute", params);
			resultID = (Boolean) result;
		} catch (XmlRpcException e) {
			e.printStackTrace();
			return null;
		}

		return resultID;

	}

	/**
	 * Calls a method
	 * 
	 * @param model
	 *            model that provides the method
	 * @param method
	 *            method to call
	 * @param methodParams
	 *            parameters for the method
	 * @return Object any return the method provides
	 */
	public Object methodCall(String model, String method,
			List<Object> methodParams) {
		Vector<Object> params = createParams(model, method);
		params.addAll(methodParams);

		Object result = null;
		try {
			result = xmlrpc.execute("execute", params);
		} catch (XmlRpcException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Calls a method
	 * 
	 * @param model
	 *            model that provides the method
	 * @param method
	 *            method to call
	 * @param methodParams
	 *            parameters for the method
	 * @return Object any return the method provides
	 */
	public Object methodCall(String model, String method, Object[] methodParams) {
		return methodCall(model, method, Arrays.asList(methodParams));
	}

	/**
	 * Get Time if object is {@link java.util.Date} or {@link java.sql.Date}
	 * 
	 * @see https://bugs.launchpad.net/openobject-server/+bug/397294
	 * @see https://bugs.launchpad.net/openobject-server/+bug/742439
	 * @param values
	 *            any {@link Object} to parse
	 * @return {@link Long} containing Date.getTime() or null
	 */
	private Long handleDateTime_getTime(Object value) {
		// get time
		Long d = null;
		if (value instanceof java.util.Date) {
			d = ((java.util.Date) value).getTime();
		}
		if (value instanceof java.sql.Date) {
			d = ((java.sql.Date) value).getTime();
		}
		if (value instanceof java.sql.Timestamp) {
			d = ((java.sql.Timestamp) value).getTime();
		}
		if ((d==null) && (value instanceof String)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				java.util.Date dt = sdf.parse((String)value);
				d = dt.getTime();
			} catch (ParseException e) {
				// do nothing, most likely the string did not match the date format
			}
		}
		return d;
	}

	private String handleDateTime_toString(Long d) {
		/*
		 * - For the formats, there are constants in the code, e.g. in
		 * server/tools
		 * 
		 * server/tools/misc.py (6.0.1)
		 * 
		 * DEFAULT_SERVER_DATE_FORMAT = "%Y-%m-%d"
		 * 
		 * DEFAULT_SERVER_TIME_FORMAT = "%H:%M:%S"
		 * 
		 * DEFAULT_SERVER_DATETIME_FORMAT = "%s %s" %
		 * (DEFAULT_SERVER_DATE_FORMAT, DEFAULT_SERVER_TIME_FORMAT)
		 */

		/*
		 * - For the timezone, keep in mind that all timestamps sent to the
		 * server must be expressed in the _server_'s timezone, not the timezone
		 * of the client. You can ask the server for its timezone by calling the
		 * common/timezone_get RPC method
		 */
		String timezone = getServerTimeZone();
		TimeZone tz = TimeZone.getTimeZone(timezone);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		return sdf.format(new java.util.Date(d + tz.getRawOffset()));
	}

	/**
	 * Converts DateTime to String
	 * 
	 * @see https://bugs.launchpad.net/openobject-server/+bug/397294
	 * @see https://bugs.launchpad.net/openobject-server/+bug/742439
	 * @param values
	 *            HashMap to parse
	 */
	private String handleDateTime(Object value) {
		Long d = handleDateTime_getTime(value);
		if (d == null)
			return null;
		return handleDateTime_toString(d);
	}

	/**
	 * Handles DateTime as Strings
	 * 
	 * @see https://bugs.launchpad.net/openobject-server/+bug/397294
	 * @see https://bugs.launchpad.net/openobject-server/+bug/742439
	 * @param values
	 *            Object array to parse
	 * @return Object array with handled dates.
	 */
	private Object[] handleDateTimes(Object[] values) {
		if (values == null)
			return null;

		Vector<Object> newValues = new Vector<Object>();

		for (int i = 0; i < values.length; i++) {
			Object value = values[i];

			String formattedDate = handleDateTime(value);
			if (formattedDate == null) {
				// no date
				newValues.add(value);
			} else {
				// was a date, converted to String
				newValues.add(formattedDate);
			}

		}

		return newValues.toArray();
	}

	/**
	 * Handles DateTime as Strings
	 * 
	 * @see https://bugs.launchpad.net/openobject-server/+bug/397294
	 * @see https://bugs.launchpad.net/openobject-server/+bug/742439
	 * @param values
	 *            HashMap to parse
	 * @return HashMap with handled dates.
	 */
	private HashMap<String, Object> handleDateTimes(
			HashMap<String, Object> values) {
		if (values == null)
			return null;
		@SuppressWarnings("unchecked")
		HashMap<String, Object> newValues = (HashMap<String, Object>) values
				.clone();
		Iterator<String> iKey = values.keySet().iterator();
		while (iKey.hasNext()) {
			String key = iKey.next();
			Object value = values.get(key);

			String formattedDate = handleDateTime(value);
			if (formattedDate == null) {
				newValues.put(key, value);
			} else {
				newValues.put(key, formattedDate);
			}
		}
		return newValues;
	}

	/**
	 * removes null values from the hashmap
	 * 
	 * @param values
	 *            HashMap to parse
	 * @return HashMap without null in values
	 */
	private HashMap<String, Object> removeNulls(HashMap<String, Object> values) {
		if (values == null)
			return null;

		// iterate through Hashmap and fill new return HashMap
		// only if it's not a null value
		HashMap<String, Object> newValues = new HashMap<String, Object>();
		Iterator<String> iKey = values.keySet().iterator();
		while (iKey.hasNext()) {
			String key = iKey.next();
			Object value = values.get(key);
			if (value != null)
				newValues.put(key, value);
		}
		return newValues;
	}

	/**
	 * get the numeric OpenERP user id, available after login
	 * 
	 * @return user id
	 */
	public int getOpenERPuserid() {
		return openERPuserid;
	}

	// TODO REMOVE, for debugging purposes!
	public void setPort(int p) throws MalformedURLException {
		this.openERPPort = p;
		this.initializeXMLRPC();
	}

}
