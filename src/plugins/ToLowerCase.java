package plugins;

public class ToLowerCase implements Plugin {

	@Override
	public String transform(String s) {
		return s.toLowerCase();
	}

	@Override
	public String getLabel() {
		return "to lower case";
	}

	@Override
	public String helpMessage() {
		return "Transform all the letters to lower case";
	}

}
