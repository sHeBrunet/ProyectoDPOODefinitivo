package interfaz;

import javax.swing.*;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logica.Factura;
import logica.TiendaDeComputadoras;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Facturas extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	@SuppressWarnings("unused")
	private Principal p;
	private TiendaDeComputadoras tienda;
	private JTable table;
	private DefaultTableModel model;
	private JTextField textTotalRecaudado;
	private JTextField ensambladoT;
	private float t = 0;

	public Facturas(Principal principal, TiendaDeComputadoras tiendaC) {
		super(principal, true);
		setResizable(false);
		setTitle("Facturas");
		tienda = tiendaC;
		p = principal;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 894, 643);
		contentPanel.add(scrollPane);

		@SuppressWarnings("unused")
		JPanel panel = new JPanel(new BorderLayout());
		String[] columnNames = {"Fecha","Ensamblado","Nombre", "Marca", "Modelo", "Cantidad", "Costo Total"};
		model = new DefaultTableModel(columnNames, 0) {
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(model);
		table.setGridColor(new Color(135, 206, 235));
		table.setSurrendersFocusOnKeystroke(true);
		table.setRowSelectionAllowed(false);
		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 645, 890, 39);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Total Recaudado:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(591, 12, 134, 16);
		panel_1.add(lblNewLabel);

		textTotalRecaudado = new JTextField();
		textTotalRecaudado.setFont(new Font("Tahoma", Font.BOLD, 15));
		textTotalRecaudado.setEnabled(false);
		textTotalRecaudado.setEditable(false);
		textTotalRecaudado.setBounds(744, 11, 104, 19);
		panel_1.add(textTotalRecaudado);
		textTotalRecaudado.setColumns(10);
		textTotalRecaudado.setText(String.valueOf(tienda.calcularTotalFactura()));

		JLabel lblTotalPorEnsamblado = new JLabel("Total Por Ensamblado:");
		lblTotalPorEnsamblado.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotalPorEnsamblado.setBounds(12, 13, 211, 16);
		panel_1.add(lblTotalPorEnsamblado);

		ensambladoT = new JTextField();
		ensambladoT.setText("0.0");
		ensambladoT.setFont(new Font("Tahoma", Font.BOLD, 15));
		ensambladoT.setEnabled(false);
		ensambladoT.setEditable(false);
		ensambladoT.setColumns(10);
		ensambladoT.setBounds(190, 11, 104, 19);
		panel_1.add(ensambladoT);
		setSize(900, 746);

		actualizarTabla();
		actualizarEnsamblado();

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		JButton cancelButton = new JButton("Atrás");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	}

	private void actualizarTabla() {
		model.setRowCount(0);

		for (Factura f : tienda.getFacturas()) {
			t += f.getPrecioEnsamblado();
			System.out.println("Factura: " + f);
			for (int i = 0; i < f.getCom().size(); i++) {
				Factura fac = f;
				System.out.println("Componente: " + fac.getCom().get(i));
				model.addRow(new Object[]{
						fac.getFecha(),
						fac.getEnsamblado().get(i),
						fac.getCom().get(i).getClass().getSimpleName(),
						fac.getCom().get(i).getMarca(),
						fac.getCom().get(i).getModelo(),
						fac.getCantidadXPieza().get(i),
						fac.calcularMontoXPieza(fac.getCom().get(i))
				});
			}

		}

		model.fireTableDataChanged();
		table.revalidate();
		table.repaint();
	}
	public void actualizarEnsamblado() {
		ensambladoT.setText(String.valueOf(t));
	}

}

