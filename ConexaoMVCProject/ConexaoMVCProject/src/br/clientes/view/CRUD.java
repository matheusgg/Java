package br.clientes.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.clientes.controller.ClienteDAO;
import br.clientes.model.Cliente;


public class CRUD extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JPanel ButtonPanel;
	private JPanel TextPanel;
	private JButton cadastrar = new JButton("Cadastrar");
	private JButton excluir = new JButton("Excluir");
	private JButton alterar = new JButton("Alterar");
	private JButton limpar = new JButton("Limpar");
	private JLabel nome = new JLabel("Nome:");
	private JLabel endereco = new JLabel("Endereço:");
	private JLabel telefone = new JLabel("Telefone:");
	private JLabel cpf = new JLabel("CPF:");
	private JTextField nom = new JTextField();
	private JTextField end = new JTextField();
	private JTextField tel = new JTextField();
	private JTextField numCpf = new JTextField();
	private static String linha[] = { "Nome", "Endereço", "Telefone", "CPF" };
	private static String matriz[][];
	private JPanel TablePanel;
	private static TableModel tm = new DefaultTableModel(matriz, linha) {
		private static final long serialVersionUID = 1L;

		@Override
		public boolean isCellEditable(int arg0, int arg1) {
			return false;
		}
	};
	private static JTable table = new JTable(tm);
	private JScrollPane scroll;

	public CRUD() {
		super("Cadastro de Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 221);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		cadastrar.setToolTipText("Cadastrar cliente");
		excluir.setToolTipText("Excluir cliente");
		alterar.setToolTipText("Alterar cliente");
		limpar.setToolTipText("Limpar informações dos campos");
		nom.setToolTipText("Informe aqui o nome do cliente");
		end.setToolTipText("Informe aqui o endereço do cliente");
		tel.setToolTipText("Informe aqui o telefone do cliente");
		numCpf.setToolTipText("Informe aqui o número do CPF do cliente");

		cadastrar.addActionListener(new CadastarCliente());
		excluir.addActionListener(new ExcluirCliente());
		alterar.addActionListener(new AlterarCliente());
		limpar.addActionListener(new LimparCampos());
		table.addMouseListener(new SelecaoDeRegistro());

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		alterar.setEnabled(false);
		excluir.setEnabled(false);

		ButtonPanel = new JPanel();
		ButtonPanel.setLayout(new GridLayout(4, 1));
		ButtonPanel.add(cadastrar);
		ButtonPanel.add(excluir);
		ButtonPanel.add(alterar);
		ButtonPanel.add(limpar);
		ButtonPanel.setBounds(374, 72, 123, 101);
		contentPane.add(ButtonPanel, BorderLayout.EAST);

		TextPanel = new JPanel();
		TextPanel.setLayout(null);

		nome.setBounds(6, 0, 37, 25);
		nom.setBounds(69, -1, 208, 25);
		endereco.setBounds(222, 28, 65, 25);
		end.setBounds(283, 27, 208, 25);
		telefone.setBounds(6, 28, 65, 25);
		tel.setBounds(68, 27, 152, 25);
		cpf.setBounds(283, 0, 37, 25);
		numCpf.setBounds(315, -1, 176, 25);

		TextPanel.add(nome);
		TextPanel.add(nom);
		TextPanel.add(endereco);
		TextPanel.add(end);
		TextPanel.add(telefone);
		TextPanel.add(tel);
		TextPanel.add(cpf);
		TextPanel.add(numCpf);
		TextPanel.setBounds(6, 6, 491, 58);
		contentPane.add(TextPanel);

		scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		TablePanel = new JPanel();
		TablePanel.setLayout(new BorderLayout());
		TablePanel.add(BorderLayout.CENTER, scroll);
		TablePanel.setBounds(16, 72, 346, 101);
		contentPane.add(TablePanel);
	}

	public static void atualizaGrid(ArrayList<Cliente> clientes) {
		matriz = new String[clientes.size()][4];
		for (int i = 0; i < clientes.size(); i++) {
			for (int j = 0; j < 4; j++) {
				switch (j) {
				case 0:
					matriz[i][j] = clientes.get(i).getNome();
					break;
				case 1:
					matriz[i][j] = clientes.get(i).getEndereco();
					break;
				case 2:
					matriz[i][j] = clientes.get(i).getTelefone();
					break;
				case 3:
					matriz[i][j] = clientes.get(i).getCpf();
					break;
				}
			}
		}

		table.setModel(new DefaultTableModel(matriz, linha) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int arg0, int arg1) {
				return false;
			}
		});
	}

	private class CadastarCliente implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			ClienteDAO controler = new ClienteDAO();
			if (controler.verificaDadosCliente(nom.getText(), end.getText(),
					tel.getText(), numCpf.getText())) {
				Cliente cli = new Cliente(nom.getText(), end.getText(),
						tel.getText(), numCpf.getText());
				controler.cadastro(cli);
			} else {
				JOptionPane
						.showMessageDialog(
								null,
								"Por favor, preencha todos os campos para completar o cadastro do cliente.",
								"Erro", 0);
			}
		}
	}

	private class ExcluirCliente implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			ClienteDAO controler = new ClienteDAO();
			if (controler.verificaDadosCliente(nom.getText(), end.getText(),
					tel.getText(), numCpf.getText())) {
				int ver = JOptionPane.showConfirmDialog(null,
						"Deseja realmente excluir este cliente?", "Exclusão",
						0, 3);
				if (ver == 0) {
					int row = table.getSelectedRow();
					Cliente cli = new Cliente(matriz[row][0], matriz[row][1],
							matriz[row][2], matriz[row][3]);
					new ClienteDAO().exclusao(cli);
					new LimparCampos().actionPerformed(new ActionEvent(limpar,
							0, "Limpar"));
				}
			} else {
				JOptionPane
						.showMessageDialog(
								null,
								"Por favor, preencha todos os campos para completar a exclusão do cliente.",
								"Erro", 0);
			}
		}
	}

	private class AlterarCliente implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			ClienteDAO controler = new ClienteDAO();
			if (controler.verificaDadosCliente(nom.getText(), end.getText(),
					tel.getText(), numCpf.getText())) {
				int ver = JOptionPane.showConfirmDialog(null,
						"Deseja realmente alterar o registro deste cliente?",
						"Alteração", 0, 3);
				if (ver == 0) {
					Cliente cli = new Cliente(nom.getText(), end.getText(),
							tel.getText(), numCpf.getText());
					new ClienteDAO().alteracao(cli);
				}
			} else {
				JOptionPane
						.showMessageDialog(
								null,
								"Por favor, preencha todos os campos para completar a alteração do cliente.",
								"Erro", 0);
			}
		}
	}

	private class LimparCampos implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			nom.setText("");
			end.setText("");
			tel.setText("");
			numCpf.setText("");

			numCpf.setEditable(true);
			cadastrar.setEnabled(true);
			alterar.setEnabled(false);
			excluir.setEnabled(false);
		}
	}

	private class SelecaoDeRegistro implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			int row = table.getSelectedRow();
			nom.setText(matriz[row][0]);
			end.setText(matriz[row][1]);
			tel.setText(matriz[row][2]);
			numCpf.setText(matriz[row][3]);

			numCpf.setEditable(false);
			cadastrar.setEnabled(false);
			alterar.setEnabled(true);
			excluir.setEnabled(true);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		}
	}

}
