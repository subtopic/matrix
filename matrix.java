
public class matrix {

	private static int counter = 0;
	public static final String ANSI_GREEN = "\u001B[32m";

	public static void main(String args[]) {
		String[] matrix = new String[120];
		int[] repeatCheck = new int[matrix.length];
		String concat = "";
		String alphabet = "0┏1┐2└3┙4├5┟6┣7┤8┨9┬┴╋╌╍╎╏║╟╠╡╢╣╤╥╦╧╨╩╪╫╝╚╔╗╬ ═╓╩ ┠┨┯┷┏ ┓┗┛┳⊥";
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = " ";
		}

		// BEGIN LOOP
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			double pos = Math.round(Math.random() * (matrix.length - 1));
			int aPos = (int) pos;

			double numPos = Math.round(Math.random() * (matrix.length - 1));
			int nPos = (int) numPos;

			double lCt2 = Math.round(Math.random() * (alphabet.length() - 1));
			int ranAlp2 = (int) lCt2;

			double lCt = Math.round(Math.random() * (alphabet.length() - 1));
			int ranAlp = (int) lCt;

			if (ranAlp2 < 0 || ranAlp < 0) {
				ranAlp2 = 0;
				ranAlp = 0;
			}
			for (int y = 0; y < matrix.length; y++) {
				// THIS IS THE MAGIC... I created a second array that increases
				// the position by one if the matrix array is filled
				// then if that position equals 10, reset that position in the
				// matrix array
				if (!matrix[y].equals(" ")) {
					repeatCheck[y]++;
				}
				if (repeatCheck[y] == 10) {
					matrix[y] = " ";
					repeatCheck[y] = 0;

				}
				if (repeatCheck[y] == ranAlp) {
					matrix[y] = " ";
					repeatCheck[y] = 0;
				}
			}

			matrix[aPos] = " ";
			counter++;

			// This is making sure you are only writing a random character to a
			// space
			for (int r = 0; r < 2; r++) {
				if (matrix[aPos].equals(" ")) {
					matrix[aPos] = Character.toString(alphabet.charAt(ranAlp));
				} else {
					// double pos2 = Math.round(Math.random() * matrix.length -
					// 1);
					int aPos2 = (int) (Math.random() * matrix.length - 1);
					if (matrix[aPos2].equals(" ")) {
						matrix[aPos2] = Character.toString(alphabet.charAt(ranAlp));
					} else {
						r = 0;
					}
				}
				if (matrix[nPos].equals(" ")) {
					matrix[nPos] = Character.toString(alphabet.charAt(ranAlp2));
					break;
				} else {
					// double pos2 = Math.round(Math.random() * matrix.length -
					// 1);
					int aPos2 = (int) (Math.random() * matrix.length - 1);
					if (matrix[aPos2].equals(" ")) {
						matrix[aPos2] = Character.toString(alphabet.charAt(ranAlp2));
						break;
					} else {
						r = 0;
					}
				}
			}

			if (counter == alphabet.length() - 1) {
				counter = 0;
			}

			// making the string from the array to print
			for (int k = 0; k < matrix.length; k++) {
				concat += matrix[k];
			}
			System.out.println(ANSI_GREEN + concat);
			concat = "";
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}
