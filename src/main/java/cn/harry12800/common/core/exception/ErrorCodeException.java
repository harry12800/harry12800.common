package cn.harry12800.common.core.exception;

/**
 * 错误码携带异常
 * @author harry12800
 *
 */
public class ErrorCodeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4143519479094905222L;

	/**
	 * 错误代码
	 */
	private final int errorCode;

	public int getErrorCode() {
		return errorCode;
	}

	public ErrorCodeException(int errorCode) {
		this.errorCode = errorCode;
	}
}
