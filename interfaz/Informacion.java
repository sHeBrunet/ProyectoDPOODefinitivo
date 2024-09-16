package interfaz;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import logica.Gerente;
import logica.TiendaDeComputadoras;
import logica.Trabajador;
public class Informacion extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private TiendaDeComputadoras tienda;
	Principal p = null;
	private JTextField direccionTienda;
	private JTextField telefonoTiennda;
	private JTextField IDTienda;
	private JTextField nombreTienda;
	@SuppressWarnings("unused")
	private JTable table;
	@SuppressWarnings("unused")
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	private JTable tableGerentes;
	private JPanel panelGerentes;
	private JButton cancelButton;
	
	public Informacion(Principal principal, TiendaDeComputadoras t) {
		super(principal, true);
		p = principal;
		tienda = t;
		setTitle("Información");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(900, 746);
		setLocationRelativeTo(null);
		setBounds(100, 100, 900, 746);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 88, 168), 2, true));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(89, 0, 805, 73);
		contentPanel.add(panel);
		panel.setLayout(null);
		
				JLabel lblNewLabel = new JLabel("Acerca de Nosotros:");
				lblNewLabel.setBounds(12, 12, 359, 54);
				panel.add(lblNewLabel);
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 23));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 88, 168), 2));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 0, 90, 684);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(12, 12, 66, 59);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(Informacion.class.getResource("/gui/icons/logoPeque\u00F1o1.jpg")));

		direccionTienda = new JTextField();
		direccionTienda.setOpaque(false);
		direccionTienda.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		direccionTienda.setFont(new Font("Tahoma", Font.ITALIC, 15));
		direccionTienda.setEditable(false);
		direccionTienda.setBounds(209, 415, 332, 30);
		contentPanel.add(direccionTienda);
		direccionTienda.setColumns(10);

		telefonoTiennda = new JTextField();
		telefonoTiennda.setOpaque(false);
		telefonoTiennda.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		telefonoTiennda.setFont(new Font("Tahoma", Font.ITALIC, 15));

		telefonoTiennda.setEditable(false);
		telefonoTiennda.setColumns(10);
		telefonoTiennda.setBounds(209, 488, 104, 30);
		contentPanel.add(telefonoTiennda);

		IDTienda = new JTextField();
		IDTienda.setOpaque(false);
		IDTienda.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		IDTienda.setFont(new Font("Tahoma", Font.ITALIC, 15));


		IDTienda.setEditable(false);
		IDTienda.setColumns(10);
		IDTienda.setBounds(483, 319, 58, 30);
		contentPanel.add(IDTienda);

		nombreTienda = new JTextField();
		nombreTienda.setOpaque(false);
		nombreTienda.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		nombreTienda.setFont(new Font("Tahoma", Font.ITALIC, 15));
		nombreTienda.setEditable(false);

		nombreTienda.setColumns(10);
		nombreTienda.setBounds(209, 319, 104, 30);
		contentPanel.add(nombreTienda);

		JLabel lblNewLabel_3 = new JLabel("Nombre:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(108, 310, 82, 61);
		contentPanel.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("ID:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(417, 310, 82, 61);
		contentPanel.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("Direcci\u00F3n:");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_2.setBounds(108, 406, 82, 61);
		contentPanel.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_2_1 = new JLabel("Tel\u00E9fono:");
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_2_1.setBounds(108, 479, 82, 61);
		contentPanel.add(lblNewLabel_3_2_1);

		JLabel lblNewLabel_3_2_1_1 = new JLabel("Gerentes:");
		lblNewLabel_3_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_2_1_1.setBounds(108, 561, 82, 61);
		contentPanel.add(lblNewLabel_3_2_1_1);

		panelGerentes = new JPanel();
		String[] columnNamesGerentes = {"Nombre", "Apellidos", "Fecha de Ingreso"};
		DefaultTableModel modelGerentes = new DefaultTableModel(columnNamesGerentes, 0);
		contentPanel.add(panelGerentes);
		tableGerentes = new JTable(modelGerentes);
		scrollPane = new JScrollPane(tableGerentes);
		scrollPane.setBounds(209, 561, 614, 61);
		contentPanel.add(scrollPane);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("C:\\Users\\kbrun\\Downloads\\Background.png"));
		lblLogo.setBounds(108, 85, 206, 197);
		contentPanel.add(lblLogo);
		
		JTextPane txtpnSomosUnaEmpresa = new JTextPane();
		txtpnSomosUnaEmpresa.setEditable(false);
		txtpnSomosUnaEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnSomosUnaEmpresa.setText("Bienvenido a S.A.D PC Store. Desde 2005, ofrecemos computadoras, componenetes y accesorios de marcas reconocidas. Nuestro equipo de expertos brinda asesoramiento personalizado y servicios para ensamblar computadoras. Vis\u00EDtanos para encontrar las soluci\u00F3n perfecta para tus necesidades tecnol\u00F3gicas. Gracias por elegirnos !");
		txtpnSomosUnaEmpresa.setBounds(328, 95, 542, 187);
		contentPanel.add(txtpnSomosUnaEmpresa);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBorder(new LineBorder(UIManager.getColor("Button.frame"), 2));
		lblNewLabel_4.setIcon(new ImageIcon(Informacion.class.getResource("/gui/icons/1724841196534.jpg")));
		lblNewLabel_4.setBounds(652, 319, 171, 165);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("QR:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(611, 332, 29, 16);
		contentPanel.add(lblNewLabel_5);
		
		inicializaciones.InicializacionDeDatos.datosTienda(tienda);
		llenarTablaGerentes(tienda, modelGerentes);
		iniciarDatos();

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(0, 88, 168), 2));
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				cancelButton = new JButton("Atr\u00E1s");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void llenarTablaGerentes(TiendaDeComputadoras tienda, DefaultTableModel model) {
		for (Trabajador t : tienda.getGerentes()) {
			Gerente g = (Gerente) t;
			String Nom = g.getNombre();
			String apellidos = g.getApellidos();
			model.addRow(new Object[]{Nom, apellidos, g.getFechaOcupCargo()});
		}
	}
	
	public void iniciarDatos() {
		nombreTienda.setText(tienda.getNombre());
		IDTienda.setText(tienda.getID());
		telefonoTiennda.setText(tienda.getTelefono());
		direccionTienda.setText(tienda.getDireccion());
	}
}
