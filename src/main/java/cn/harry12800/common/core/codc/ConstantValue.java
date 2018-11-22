package cn.harry12800.common.core.codc;

/**
 * 静态值
 * @author harry12800
 *
 */
public interface ConstantValue {
	/**
	 * 包头标识
	 */
	public static int HEADER_FLAG = -21415431;

	public static void main(String[] args) {
		String hexString = Integer.toHexString(-21415431);
		System.out.println(hexString);
	}
}
