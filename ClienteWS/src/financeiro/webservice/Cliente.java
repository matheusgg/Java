package financeiro.webservice;

import java.net.URL;
import java.util.Calendar;

/**
 * Classe consumidora do WebService
 * 
 * @author Matheus
 * 
 */
public class Cliente {
	public static void main(String[] args) {
		try {
			FinanceiroWSServiceLocator service = new FinanceiroWSServiceLocator();
			FinanceiroWS financeiroWS = service.getFinanceiroWSPort(new URL("http://localhost:8080/Financeiro/webservice/financeiroWS"));

			Calendar inicio = Calendar.getInstance();
			inicio.add(Calendar.MONTH, -30);
			Calendar hoje = Calendar.getInstance();

			int conta = 3;

			Float saldo = financeiroWS.saldo(conta, "17/07/2012");
			System.out.println("Saldo da conta: " + saldo);
			System.out.println("============== Lançamentos ==============");
			LancamentoItem[] lancamentos = financeiroWS.extrato(conta, inicio, hoje);
			for (LancamentoItem item : lancamentos) {
				System.out.println("Data: " + item.getData().getTime() + ". Descrição: " + item.getDescricao() + ". Valor: " + item.getValor());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
