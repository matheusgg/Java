package base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

public class Encoding {

	public static void main(String[] args) throws IOException {
		File img = new File("img\\ipem14.jpg");
		try (FileInputStream is = new FileInputStream(img)) {
			byte[] bytes = new byte[is.available()];
			is.read(bytes);
			byte[] encoded = Base64.getEncoder().encode(bytes);
			System.out.println(new String(encoded));
		}
	}
}
