package br.com.rodrigo.cdc.validation.errorDto;

public class NotFoundErrorDto {
	private Integer status = 404;
	private String code = "error";
	private String message;
	private Integer id;

	public NotFoundErrorDto(Integer id, String message) {
		super();
		this.id = id;
		this.message = message;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}
	
	public String getCode() {
		return code;
	}

}
