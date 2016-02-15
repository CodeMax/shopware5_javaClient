package com.shopware.shopwareRestClient.dto.media;

public class Media {

    public MediaData data;
    public Boolean success;
    public String message;
    
	public MediaData getData() {
		return data;
	}
	public void setData(MediaData data) {
		this.data = data;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "Article [data=" + data + ", success=" + success + "]";
	}
}