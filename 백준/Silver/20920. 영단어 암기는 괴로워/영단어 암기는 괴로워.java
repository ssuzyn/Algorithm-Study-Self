import java.io.*;
import java.util.*;

public class Main {

	static class Word{
		String str;
		int length;
		int count;

		Word(String str, int length, int count){
			this.str = str;
			this.length = length;
			this.count = count;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> map = new HashMap<>();
		while(N-- > 0){
			String input = br.readLine();
			if(input.length() < M) continue;
			map.put(input, map.getOrDefault(input, 0) + 1);
		}

		PriorityQueue<Word> pq = new PriorityQueue<>((a, b) -> {
			if(a.count != b.count) return b.count - a.count;
			else if(a.length != b.length) return b.length - a.length;
			return a.str.compareTo(b.str);
		});

		for(String key : map.keySet()){
			pq.add(new Word(key, key.length(), map.get(key)));
		}

		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()){
			sb.append(pq.poll().str).append("\n");
		}
		System.out.print(sb);
	}
}
