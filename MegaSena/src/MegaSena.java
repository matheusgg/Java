import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MegaSena {
	public static void main(String[] args) throws Exception {
		MegaSena ms = new MegaSena();
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("C:\\Users\\Matheus\\Downloads\\Planilha-Megasena.xlsx"));
		XSSFSheet sheet = workbook.getSheetAt(0);
		Map<Integer, Set<Integer>> mapa = ms.recuperaNumeros(sheet);
		Set<Integer> numerosSorteados = ms.solicitaNumeros();
		int[] resultados = ms.verificaAcertos(mapa, numerosSorteados);
		System.out.println("Máximos Acertos >>>>>>>>>>>>>> " + resultados[0]);
		System.out.println("Jogo >>>>>>>>>>>>>> " + resultados[1]);
	}

	private int[] verificaAcertos(Map<Integer, Set<Integer>> mapa, Set<Integer> numerosSorteados) {
		int acertos;
		int maxAcertos = 0;
		int numJogoMaxAcertos = 0;
		mapFor: for (Integer key : mapa.keySet()) {
			Set<Integer> jogo = mapa.get(key);
			acertos = 0;
			for (Integer tentativa : jogo) {
				if (numerosSorteados.contains(tentativa)) {
					acertos++;
				}
			}
			if (acertos > maxAcertos || acertos == 6) {
				maxAcertos = acertos;
				numJogoMaxAcertos = key;
				if (acertos == 6) {
					break mapFor;
				}
			}
		}
		return new int[] { maxAcertos, numJogoMaxAcertos };
	}

	private Map<Integer, Set<Integer>> recuperaNumeros(XSSFSheet sheet) {
		Set<Integer> set = null;
		Map<Integer, Set<Integer>> mapa = new HashMap<>();
		for (int i = 4; i < 254; i++) {
			set = new TreeSet<>();
			for (int j = 0; j < 6; j++) {
				XSSFRow row = sheet.getRow(i);
				XSSFCell cell = row.getCell(j);
				set.add((int) cell.getNumericCellValue());
			}
			mapa.put(i + 1, set);
		}
		return mapa;
	}

	private Set<Integer> solicitaNumeros() {
		Set<Integer> set = new TreeSet<>();
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < 6; i++) {
			System.out.println("Informe o " + (i + 1) + "° número: ");
			set.add(scan.nextInt());
		}
		scan.close();
		return set;
	}

}
