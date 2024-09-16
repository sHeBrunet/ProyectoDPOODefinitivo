package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import logica.ComponenteOrdenador;
import logica.TiendaDeComputadoras;

public class PiezasMasCaras extends JDialog {

	private static final long serialVersionUID = 1L;
	private static TiendaDeComputadoras tienda;
	private static JTable tableProductos;
	private DefaultTableModel modelPiezas;

	private JLabel totalLabel;

	public PiezasMasCaras(Principal principal, TiendaDeComputadoras t) {
		super(principal, true); 
		tienda = t;
		setTitle("Salario Total");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(900, 746);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		JPanel panelProductos = new JPanel();
		String[] columnNamesPiezas = {"Pieza" ,"Precio"};
		modelPiezas = new DefaultTableModel(columnNamesPiezas, 0);
		tableProductos = new JTable(modelPiezas);
		JScrollPane scrollPane = new JScrollPane(tableProductos);
		scrollPane.setBounds(0, 0, 894, 624);
		panelProductos.setLayout(null);
		panelProductos.add(scrollPane);
		getContentPane().add(panelProductos);

		totalLabel = new JLabel("Total: ");
		totalLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		totalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		totalLabel.setBounds(404, 637, 144, 36);
		panelProductos.add(totalLabel);

		JLabel lblNewLabel = new JLabel("Total:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(359, 647, 83, 16);
		panelProductos.add(lblNewLabel);
		llenarTablaPiezas(modelPiezas);
		actualizarTotal();

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			{
				JButton okButton = new JButton("Atr\u00E1s");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int i = JOptionPane.showConfirmDialog(null, "¿Seguro que desea salir?", "", JOptionPane.YES_NO_OPTION);
						if (i == JOptionPane.YES_OPTION) {
							setVisible(false);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	private void llenarTablaPiezas(DefaultTableModel modelPiezas) {
		modelPiezas.setRowCount(0); 
		for (ComponenteOrdenador c : tienda.PiezasMasCaras()) {
			String nombreCompleto = c.getClass().getSimpleName() + " " + c.getModelo();
			modelPiezas.addRow(new Object[]{nombreCompleto, c.getPrecio()});
		}
	}

	private void actualizarTotal() {
		int total = tienda.cantidadPiezasTotal();
		totalLabel.setText(String.valueOf(total));
	}
}
