package ds.trie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Trie {

	private HashMap<Character, HashMap> root;
	private final Character END_CHARACTER = '$';

	public Trie() {
		root = new HashMap<>();
	}

	public Trie(Collection<String> collection) {
		root = new HashMap<>();
		for (String s : collection) {
			internalAdd(s);
		}
	}

	public void add(String s) {
		internalAdd(s);
	}

	private void internalAdd(String s) {
		HashMap<Character, HashMap> node = root;
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (!node.containsKey(c)) {
				node.put(c, new HashMap<Character, HashMap>());
			}
			node = node.get(c);
		}
		node.put(END_CHARACTER, new HashMap<>());
	}

	public boolean contains(String s) {
		HashMap<Character, HashMap> node = root;
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (node.containsKey(c)) {
				node = node.get(c);
			} else {
				return false;
			}
		}
		return node.containsKey(END_CHARACTER);
	}

	public List<String> getWords() {
		List<String> result = new ArrayList<String>();
		getWords(root, result, new StringBuilder());
		return result;
	}

	private void getWords(HashMap<Character, HashMap> root, List<String> result, StringBuilder temp) {
		for (Character c : root.keySet()) {
			if (c == END_CHARACTER) {
				result.add(new String(temp));
			} else {
				temp.append(c);
				getWords(root.get(c), result, temp);
				temp.setLength(temp.length() - 1);
			}
		}
	}

}