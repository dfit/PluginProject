package plugins;


/** this plugin transforms all the letters to upper case
 * 
 * @author JC
 */
public class ToUpperCase implements Plugin {

	/** transform all the letters to upper case
	 * @see plugin.Plugin#transform(java.lang.String)
	 */
	public String transform(String s) {
		return s.toUpperCase();
	}

	/**
	 * @see plugin.Plugin#getLabel()
	 */
	public String getLabel() {
		return "to upper case";
	}

	/**
	 * @see plugin.Plugin#helpMessage()
	 */
	public String helpMessage() {
		return "Transform all the letters to upper case";
	}
}
