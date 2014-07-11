package com.btpl.database;

import android.provider.BaseColumns;

public class AddTask_Table {

	public static final String addtask_id = BaseColumns._ID;
	public static final String description = "descriptionOfTask";
	public static final String  date= "dateOfTask";
    public static final String time= "timeOfTask";
    public static final String associatedwith= "associatedWith";
    public static final String associatedValue="associationValue";
    public static final String fetch_task_lead="task_lead";
    public static final String assignedto = "assignedTo";
    public static final String tabletype = "tableType";
    public static final String status = "status";
    public static final String signinEmail="signin";
	
	public static final String TABLE_NAME = "addtask_table";
	
	public static final String my_addtask_sql = "CREATE TABLE " + TABLE_NAME
			+ "( " + addtask_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + description
			+ " TEXT,"+ date +" TEXT,"+ time +" TEXT,"+ associatedwith +" TEXT,"+ associatedValue +" TEXT," 
			+ fetch_task_lead +" TEXT,"+assignedto+" TEXT,"+ tabletype +" TEXT NOT NULL," + status +" TEXT ," + signinEmail + " TEXT);";
}
