package plugins;

public class RemoveVowel implements Plugin {
	String vowel[] = { "a", "e", "y", "u", "i", "o", "A", "E", "Y", "U", "I",
			"O" };

	@Override
	public String transform(String s) {
		for (String v : vowel) {
			s = s.replaceAll(v, " ");
		}
		return s;
	}

	@Override
	public String getLabel() {
		return "remove vowel";
	}

	@Override
	public String helpMessage() {
		return "Remove all the vowel from the string";
	}

}
