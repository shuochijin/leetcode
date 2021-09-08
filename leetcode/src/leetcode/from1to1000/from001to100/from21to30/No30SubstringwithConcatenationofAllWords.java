package leetcode.from1to1000.from001to100.from21to30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class No30SubstringwithConcatenationofAllWords {
	public static void main(String[] args) {
		String s = "123456789";
		System.out.println(s.substring(1, 0 + 2));
		System.out.println(s.substring(2, 0 + 3));
		System.out.println(s.substring(3, 0 + 4));
//		No30SubstringwithConcatenationofAllWords n = new No30SubstringwithConcatenationofAllWords();
//		System.out.println(n.findSubstring("barfoothefoobarman", new String[] {"foo","bar"}));
//		System.out.println(n.findSubstring("wordgoodgoodgoodbestword", new String[] {"word","good","best","word"}));
//		System.out.println(n.findSubstring("wordgoodgoodgoodbestword", new String[] {"word","good","best","good"}));
//		System.out.println(n.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[] {"fooo","barr","wing","ding","wing"}));
	}
	
	class StringListNode{
		public StringListNode() {}
		public StringListNode(String word) {
			this.word = word;
		}
		public String word;
		public StringListNode next = null;
	}
	
	class Bucket{
		Bucket[] next = null;
		String word = null;
	}
	
	public Bucket buildBucketIndex(String[] words) {
		Bucket bucket = new Bucket();
		Bucket[] tmpBucketUnit;
		int length = words[0].length();
		
		for(int i = 0, j; i < words.length; ++ i) {
			bucket.next = new Bucket[26];
			tmpBucketUnit = bucket.next;
			for(j = 0; j < length - 1; ++ j) {
				tmpBucketUnit[words[i].charAt(j) - 'a'].next = new Bucket[26];
				tmpBucketUnit = tmpBucketUnit[words[i].charAt(j) - 'a'].next;
			}
			tmpBucketUnit[j].word = words[i];
		}
		
		return bucket;
	}
	
	public String judgeIndex(String s, Bucket root, int index) {
		String word = null;
		return word;
	}
	
	public List<Integer> findSubstring2(String s, String[] words) {
		List<Integer> result = new ArrayList<Integer>();
		
		StringListNode head = new StringListNode();
		StringListNode tail = new StringListNode();
		tail.next = head;
		
		StringListNode matchedList = new StringListNode();
		
		StringListNode matchedListTail = new StringListNode();
		matchedListTail.next = matchedList;
		
		StringListNode swapTmpNode = new StringListNode();
		
		for(int i = 0; i < words.length; ++ i) {
			tail.next.next = new StringListNode(words[i]);
			tail = tail.next;
		}
		
		Bucket bucketRoot = buildBucketIndex(words);
		
		String tmp;
		for(int i = 0; i < s.length(); ++ i) {
			tmp = judgeIndex(s, bucketRoot, i);
			if(tmp != null) {
				swapTmpNode.next
				for()
			}
		}
		
		return result;
	}
	
	
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<Integer>();
		if(s.length() == 0 || words.length == 0) {
			return result;
		}
		int unitLen = words[0].length();
		int[] indices = new int[s.length() / unitLen];
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		Map<String, Integer> mapCount = new HashMap<String, Integer>();
		for(int i = 0; i < words.length; ++ i) {
			map.put(words[i], i);
			if(mapCount.get(words[i]) != null) {
				mapCount.put(words[i], mapCount.get(words[i]) + 1);
			} else {
				mapCount.put(words[i], 1);
			}
		}
		String tmp;
		for(int i = 0; i < indices.length; ++ i) {
			tmp = s.substring(i * unitLen, (i + 1) * unitLen);
			if(map.get(tmp) != null) {
				indices[i] = map.get(tmp);
			} else {
				indices[i] = -1;
			}
		}
		
		int[] touchFlags = new int[words.length];
		int touchCount = 0;
		
		for(int j = 0; j < touchFlags.length; ++ j) {
			touchFlags[j] = 0;
		}
		
		for(int i = 0; i < indices.length; ++ i) {
			if(indices[i] == -1) {
				for(int j = 0; j < touchFlags.length; ++ j) {
					touchFlags[j] = 0;
				}
				touchCount = 0;
			} else if(touchFlags[indices[i]] == mapCount.get(words[indices[i]])) {
				for(int j = 0; j < touchFlags.length; ++ j) {
					touchFlags[j] = 0;
				}
				i = i - touchCount;
				touchCount = 0;
			} else {
				touchFlags[indices[i]] ++;
				touchCount ++;
			}
			if(touchCount == touchFlags.length) {
				result.add((i + 1 - touchFlags.length) * unitLen);
				for(int j = 0; j < touchFlags.length; ++ j) {
					touchFlags[j] = 0;
				}
				touchCount = 0;
				i = i - touchFlags.length + 1;
			}
		}
		
		return result;
	}
}
