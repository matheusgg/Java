package oracle.storedprocedurecall;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Calendar;

import oracle.jdbc.OracleTypes;

public class Caller {

	/*
	 * BEGIN PR_CONS_LEVANTAMENTO_DEMANDA(?, ?, ?, ?, ?, ?, ?, ?,
	 * VO_RETURN_SET=>?); END; bind => [2015-01-01 00:00:00.0, 2015-12-12
	 * 00:00:00.0, 1, 1, 1, 1, null, null, => VO_RETURN_SET]
	 */
	public static void main(String[] args) throws Exception {
		Calendar dataInicial = Calendar.getInstance();
		dataInicial.set(Calendar.DAY_OF_MONTH, 1);
		dataInicial.set(Calendar.MONTH, 1);
		dataInicial.set(Calendar.YEAR, 2015);

		Calendar dataFinal = Calendar.getInstance();
		dataFinal.set(Calendar.DAY_OF_MONTH, 1);
		dataFinal.set(Calendar.MONTH, 12);
		dataFinal.set(Calendar.YEAR, 2016);

		// Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@<server>:<port>/<sid>", "<user>", "<password>");
		// String query =
		// "BEGIN PR_CONS_LEVANTAMENTO_DEMANDA(?, ?, ?, ?, ?, ?, ?, ?, VO_RETURN_SET=>?); END;";
		String query = "{CALL PR_CONS_LEVANTAMENTO_DEMANDA(?, ?, ?, ?, ?, ?, ?, ?, ?)}";

		CallableStatement stmt = con.prepareCall(query);
		stmt.setDate(1, new Date(dataInicial.getTimeInMillis()));
		stmt.setDate(2, new Date(dataFinal.getTimeInMillis()));
		stmt.setLong(3, 1l);
		stmt.setLong(4, 1l);
		stmt.setLong(5, 1l);
		stmt.setLong(6, 1l);
		stmt.setLong(7, 1l);
		stmt.setLong(8, 1l);
		stmt.registerOutParameter(9, OracleTypes.CURSOR);
		stmt.execute();

		ResultSet rs = (ResultSet) stmt.getObject(9);
		while (rs.next()) {
			System.out.println(rs.getString("CD_PROTOCOLO"));
			System.out.println(rs.getDate("DT_ATENDIMENTO"));
			System.out.println(rs.getString("CD_2PTRAZAOSOCIAL"));
			System.out.println(rs.getString("DS_LOGRADOURO"));
			System.out.println(rs.getString("DS_BAIRRO"));
			System.out.println(rs.getString("DS_MUNICIPIO"));
			System.out.println(rs.getString("DS_NOME_INDICADOR"));
			System.out.println(rs.getString("DS_AUTO_INFRACAO_N3N4"));
		}

		con.close();
	}

}
