import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	static class Node{
		HashMap<Character, Node> child;
		boolean endOfWord;

		public Node(){
			child = new HashMap<>();
			endOfWord = false;
		}
	}

	static class Trie{
		Node root;

		public Trie(){
			root = new Node();
		}

		public boolean insert(String word){
			Node current = root;

			for(char tmp : word.toCharArray()){
				current.child.putIfAbsent(tmp, new Node()); // 현재 문자에 해당하는 노드가 없으면 생성
				current = current.child.get(tmp);

				if(current.endOfWord) return false;
			}

			current.endOfWord = true; // 현재 단어의 끝을 표시

			if(!current.child.isEmpty()) // 이 단어의 끝 노드에 자식이 있다면
				return false;

			return true;
		}
	}

	private static boolean isConsistent(String[] nums){
		Trie trie = new Trie();

		for(String n : nums){
			if(!trie.insert(n)) return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while(T-- > 0){
			int N = Integer.parseInt(br.readLine());
			String[] nums = new String[N];
			for(int i = 0; i < N; i++){
				nums[i] = br.readLine();
			}

			sb.append(isConsistent(nums)? "YES\n" : "NO\n");
		}
		System.out.println(sb);
	}
}
