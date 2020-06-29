package com.fjnu.kbms.response;

public class Response {

	//表明请求处理结果，"success"为成功
	private String status;
	//如果status为200,则返回需要的对象，如果请求错误，则返回通用错误码格式
	private Object data;
	
	public static Response create(Object result) {
		return Response.create(result,"success");
	}
	
	public static Response create(Object result, String status) {
		Response type = new Response();
		type.setStatus(status);
		type.setData(result);
		return type;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
}
