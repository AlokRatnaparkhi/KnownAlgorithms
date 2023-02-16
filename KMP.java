public class KMP {
	
	private String text = null;
	private String pattern = null;
	
	public KMP(String text, String pattern) {
		this.text = text;
		this.pattern = pattern;
	}
	
	private boolean checkUsingKmp() {
		int[] lps = calculateLPSForAString(pattern);
		int i = 0;
		int j = 0;
		int N = text.length();
		int M = pattern.length();
		while (i < N) {
			if (text.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			} else if (j != 0) {
					j = lps[j - 1];
			} else {
					i++;
			}
			if (j == M) {
				return true;
			}
		}
		return false;
	}
	
	private int[] calculateLPSForAString(String str) {
		int[] lps = new int[str.length()];
		lps[0] = 0;
		int i = 1;
		int N = str.length();
		int len = 0;
		while (i < N) {
			if (str.charAt(i) == str.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else if (len != 0) {
					len = lps[len - 1];
					
			} else {
					len = 0;
					i++;
			}
		}
		return lps;
	}
	
	public static void main(String[] args) {
		KMP obj = new KMP("aabacdefaabbcdefg", "aabbc");
		if (obj.checkUsingKmp()) {
			System.out.println("Pattern exists in text");
		} else {
			System.out.println("Pattern does not exist in text");
		}
	}
}
