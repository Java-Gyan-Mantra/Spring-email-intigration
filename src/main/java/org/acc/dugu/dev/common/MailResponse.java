package org.acc.dugu.dev.common;

public class MailResponse {

	private String status;
	private String errorCode;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		return "MailResponse [status=" + status + ", errorCode=" + errorCode
				+ "]";
	}

}
