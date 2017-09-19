package cn.jeeweb.modules.order.entity;
import java.io.Serializable;
import java.sql.*;

//
/**
 * 
 * @author lixiaofei
 * 2015年9月16日
 */
public class Test implements Serializable{
	private static final long serialVersionUID = -4337253965534925424L;

	//
	private String sysname;
	//
	private String faceSys;
	//
	private String faceTable;
	//
	private String faceType;
	//
	private String faceRate;
	//
	private Timestamp insertTime;
	

	public Test(){
	}
	


	public void setSysname(String sysname) {
		this.sysname = sysname;
	}
	
	public String getSysname() {
		return this.sysname;
	}

	public void setFaceSys(String faceSys) {
		this.faceSys = faceSys;
	}
	
	public String getFaceSys() {
		return this.faceSys;
	}

	public void setFaceTable(String faceTable) {
		this.faceTable = faceTable;
	}
	
	public String getFaceTable() {
		return this.faceTable;
	}

	public void setFaceType(String faceType) {
		this.faceType = faceType;
	}
	
	public String getFaceType() {
		return this.faceType;
	}

	public void setFaceRate(String faceRate) {
		this.faceRate = faceRate;
	}
	
	public String getFaceRate() {
		return this.faceRate;
	}

	public void setInsertTime(Timestamp insertTime) {
		this.insertTime = insertTime;
	}
	
	public Timestamp getInsertTime() {
		return this.insertTime;
	}




	@Override
	public String toString() {
		return  "Test ["
			+ "Sysname = " + getSysname() + ","
			+ "FaceSys = " + getFaceSys() + ","
			+ "FaceTable = " + getFaceTable() + ","
			+ "FaceType = " + getFaceType() + ","
			+ "FaceRate = " + getFaceRate() + ","
			+ "InsertTime = " + getInsertTime() + ","
		+"]";
	}
	
}


