import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	static StringBuilder sb = new StringBuilder();

	static class TrieNode{
		Map<String, TrieNode> childNode = new HashMap<>();

		public void insert(String[] strs){
			TrieNode cur = this;
			for(String s : strs){
				cur.childNode.putIfAbsent(s, new TrieNode());
				cur = cur.childNode.get(s);
			}
		}

		public void print(TrieNode cur, int depth){
			TrieNode trieNode = cur;

			if(trieNode.childNode != null){
				List<String> list = new ArrayList<>(trieNode.childNode.keySet());
				Collections.sort(list);

				for(String s : list){
					for(int i = 0; i < depth; i++){
						sb.append("--");
					}
					sb.append(s).append("\n");
					print(trieNode.childNode.get(s), depth + 1);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		TrieNode trie = new TrieNode();
		for(int i = 0; i < N; i++){
			String[] input = br.readLine().split(" ");
			int K = Integer.parseInt(input[0]);

			String[] foods = Arrays.copyOfRange(input, 1, K + 1);
			trie.insert(foods);
		}

		trie.print(trie, 0);
		System.out.println(sb);
	}
}
