package com.mog.Exceptions;

import java.io.Serializable;

public class StandError implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long timestamp;
	private int satus;
	private String erro,path,message;
	
	public StandError() {
		
	}

	public StandError(Long timestamp, int satus, String erro, String path, String message) {
		super();
		this.timestamp = timestamp;
		this.satus = satus;
		this.erro = erro;
		this.path = path;
		this.message = message;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public int getSatus() {
		return satus;
	}

	public void setSatus(int satus) {
		this.satus = satus;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
