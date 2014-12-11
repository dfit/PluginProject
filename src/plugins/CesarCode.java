package plugins;

/**
 * This plugin applies a Cesar code to the text (ie. a shift by 1 character: 'a'
 * into 'b', 'b' into 'c',... 'z' into 'a'). Other shifts can be applied.
 * 
 * @author JC
 *
 */
public class CesarCode implements Plugin {

	/**
	 * the shift of character (1 for strict Cesar code)
	 */
	private int shift;

	/**
	 * a Cesar code where shift is 1
	 */
	public CesarCode() {
		this(1);
	}

	/**
	 * Create a code where the shift of character is more than 1 (no more a
	 * strict Cesar code)
	 * 
	 * @param shift
	 *            value of character shift
	 */
	public CesarCode(int shift) {
		this.shift = shift;
	}

	/**
	 * Apply a Cesar code to the text (ie. a shift by 1 character)
	 * 
	 * @see plugin.Plugin#transform(java.lang.String)
	 */
	@Override
	public String transform(String s) {
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isLetter(c)) {
				if (Character.isLowerCase(c)) {
					c = (char) ('a' + (((c - 'a') + this.shift) % 26));
				} else {
					c = (char) ('A' + (((c - 'A') + this.shift) % 26));
				}
			}
			res = res + c;
		}
		return res;
	}

	/**
	 * @see plugin.Plugin#getLabel()
	 */
	@Override
	public String getLabel() {
		return "Cesar Code " + this.shift;
	}

	/**
	 * @see plugin.Plugin#helpMessage()
	 */
	@Override
	public String helpMessage() {
		return "Apply a Cesar code to the text (ie. a shift by 1 character)";
	}
}
