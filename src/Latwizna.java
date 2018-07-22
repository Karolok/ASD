import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

class Latwizna {

	private static int maxBaza = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(System.in);
		long suma = 0;
		int sumaZnakow = 0;
		int n = wczytajInt(bis);
		int d = wczytajInt(bis);
		int liczby[] = new int[n];
		long time = System.nanoTime();
		for (int i = 0; i < n; i++) {
			liczby[i] = wczytajInt(bis);
			suma = suma + liczby[i];
		}

		if (d == 1) {
			System.out.print(String.valueOf(suma) + "\n");
		} else {
			System.out.print(convertToBase(suma, d).length() + "\n");
		}
		sumaZnakow = String.valueOf(n).length() + String.valueOf(d).length();
		for (int i = 0; i < liczby.length; i++) {
			sumaZnakow += String.valueOf(liczby[i]).length();
		}
		System.out.print(sumaZnakow);
		System.out.println(System.nanoTime() - time);
	}

	static int wczytajInt(InputStream in) throws IOException {
		int wczytany = 0;
		boolean bool = false;

		for (int c = 0; (c = in.read()) != -1;) {
			if (c >= '0' && c <= '9') {
				bool = true;
				wczytany = wczytany * 10 + c - '0';
			} else if (bool)
				break;
		}

		return wczytany;
	}

	public static char fromDecimalToBase(long reszta) {
		if (reszta >= 0 && reszta <= 9) {
			String string = String.valueOf(reszta);
			return string.charAt(0);
		} else {
			return (char) ('a' + (reszta - 10));
		}
	}

	public static String convertToBase(long suma, int base) {
		String result = "";
		if ((base > maxBaza) || (base < 2)) {
			return null;
		} else if (suma == 0) {
			return "0";
		}
		while (suma > 0) {
			long reszta = suma % base;	
			suma = suma / base;
			result = fromDecimalToBase(reszta) + result;
		}
		return result;
	}
}