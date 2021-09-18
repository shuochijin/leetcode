package leetcode.from1to1000.from001to100.from21to30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class No30SubstringwithConcatenationofAllWords {
	public static void main(String[] args) {
//		String s = "1234567890";
//		System.out.println(s.substring(1, 0 + 2));
//		System.out.println(s.substring(2, 0 + 3));
//		System.out.println(s.substring(3, 0 + 4));
//		System.out.println(s.substring(9, 10));
		No30SubstringwithConcatenationofAllWords n = new No30SubstringwithConcatenationofAllWords();
//		System.out.println(n.findSubstring2("barfoothefoobarman", new String[] {"foo","bar"}));
		System.out.println(n.findSubstring2("wordgoodgoodgoodbestword", new String[] {"word","good","best","word"}));
		System.out.println(n.findSubstring2("barfoofoobarthefoobarman", new String[] {"bar","foo","the"}));
//		System.out.println(n.findSubstring2("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[] {"fooo","barr","wing","ding","wing"}));
	}
	
	class StringListNode{
		public StringListNode() {}
		public StringListNode(String word) {
			this.word = word;
		}
		public String word;
		public StringListNode pre = null;
		public StringListNode next = null;
		public StringListNode headNode = null;
	}
	
	class Bucket{
		Bucket[] next = null;
		StringListNode node = null;
	}
	
	public Bucket buildBucketIndex(StringListNode[] wordsNode) {
		Bucket bucket = new Bucket();
		Bucket[] tmpBucketUnit;
		int length = wordsNode[1].word.length();
		
		for(int i = 1, j; i < wordsNode.length; ++ i) {
			if(bucket.next == null) {
				bucket.next = new Bucket[26];
			}
			tmpBucketUnit = bucket.next;
			for(j = 0; j < length - 1; ++ j) {
				if(tmpBucketUnit[0] == null) {
					for(int k = 0; k < 26; ++ k) {
						tmpBucketUnit[k] = new Bucket();
					}
				}
				if(tmpBucketUnit[wordsNode[i].word.charAt(j) - 'a'].next == null) {
					tmpBucketUnit[wordsNode[i].word.charAt(j) - 'a'].next = new Bucket[26];
				}
				tmpBucketUnit = tmpBucketUnit[wordsNode[i].word.charAt(j) - 'a'].next;
			}
			if(tmpBucketUnit[0] == null) {
				for(int k = 0; k < 26; ++ k) {
					tmpBucketUnit[k] = new Bucket();
				}
			}
			tmpBucketUnit[wordsNode[i].word.charAt(j) - 'a'].node = wordsNode[i];
		}
		
		return bucket;
	}
	
	public void buildList(StringListNode[] wordsNode, String[] words) {
		int length = words.length;
		wordsNode[0] = new StringListNode();
		for(int i = 1; i < length + 1; ++ i) {
			wordsNode[i] = new StringListNode();
			wordsNode[i].headNode = wordsNode[0];
		}
		wordsNode[0].next = wordsNode[1];
		wordsNode[1].pre = wordsNode[0];
		
		for(int i = 1; i <= length; ++ i) {
			wordsNode[i].word = words[i - 1];
			wordsNode[i].pre = wordsNode[i - 1];
			if(i != length) {
				wordsNode[i].next = wordsNode[i + 1];
			}
		}
	}
	
	public StringListNode judgeIndex(String s, Bucket root, int index, int wordLength) {
		StringListNode result = null;
		Bucket[] tmp = root.next;
		for(int i = 0; i < wordLength; ++ i) {
//			System.out.println(wordLength + " " + index + " " + i);
			if(tmp[s.charAt(index + i) - 'a'].next != null) {
				tmp = tmp[s.charAt(index + i) - 'a'].next;
			} else {
				if(i == wordLength - 1) {
					result = tmp[s.charAt(index + i) - 'a'].node;
				}
			}
		}
		return result;
	}
	
	public List<Integer> findSubstring2(String s, String[] words) {
		List<Integer> result = new ArrayList<Integer>();
		
		StringListNode[] wordsNode = new StringListNode[words.length + 1];
		
		buildList(wordsNode, words);
		
		StringListNode head = wordsNode[0];
		
		Bucket bucketRoot = buildBucketIndex(wordsNode);
		
		StringListNode matchedList = new StringListNode();
		StringListNode matchedListTail = new StringListNode();
		matchedListTail.next = matchedList;
		
		int wordLength = words[0].length();
		StringListNode tmp;
		boolean flag;
		for(int i = 0; i <= s.length() - wordLength; ++ i) {
			flag = true;
			while(i <= s.length() - wordLength && (tmp = judgeIndex(s, bucketRoot, i, wordLength)) != null) {
				if(flag) {
					flag = false;
					result.add(i);
				}
				if(tmp.headNode == matchedList) {
					i = result.remove(result.size() - 1);
					break;
				}
				i += wordLength;
				tmp.headNode = matchedList;
				if(tmp.next != null) {
					tmp.next.pre = tmp.pre;
				}
				tmp.pre.next = tmp.next;
				
				tmp.next = matchedList.next;
				if(matchedList.next != null) {
					matchedList.next.pre = tmp;
				}
				tmp.pre = matchedList;
				
				if(matchedListTail.next.next != null) {
					matchedListTail.next = matchedList.next;
				}
			}
			tmp = matchedList;
			while(tmp.next != null) {
				tmp = tmp.next;
				tmp.headNode = head;
			}
			if(head.next != null) {
				matchedListTail.next.next = head.next;
				head.next.pre = matchedListTail.next;
			} else {
				matchedListTail.next.next = null;
			}
			if(matchedList.next != null) {
				head.next = matchedList.next;
				matchedList.next.pre = head;
			}
			
			matchedListTail.next = matchedList;
			matchedList.next = null;
			
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
