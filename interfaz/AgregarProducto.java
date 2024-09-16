package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import componentesVisuales.JTextFieldModificado;
import logica.Adaptador;
import logica.Bocina;
import logica.Chasis;
import logica.ComponenteOrdenador;
import logica.DiscoDuro;
import logica.Fuente;
import logica.MemoriaRam;
import logica.Microprocesador;
import logica.Monitor;
import logica.Mouse;
import logica.TarjetaDeVideo;
import logica.TarjetaMadre;
import logica.Teclado;
import logica.TiendaDeComputadoras;

public class AgregarProducto extends JDialog {

	private static final long serialVersionUID = 1L;
	private TiendaDeComputadoras tienda;
	private ComponenteOrdenador componente;
	private ArrayList<ComponenteOrdenador> piezasAgreg;
	private JPanel contentPanel = new JPanel();
	private JPanel panelSecundario;
	private JTextField txtNoSerieFijo;
	private JTextField txtPrecio;
	private JTextFieldModificado txtNoSerieMovible;
	private JSpinner spinner;
	private JComboBox<String> comboBoxComponente;
	private JComboBox<String> comboBoxAtributo1;
	private JButton btnEliminar;
	private JButton btnGuardar;
	private JButton btnAgregar;
	private JButton btnAtras;
	private JTable table;
	private DefaultTableModel tableModel;	
	private static int cantidad;
	private static float precio;
	private static String marca;
	private static String modelo;
	private static String noSerie;	
	private static String primAtrib;
	private static String segundoAtrib;
	private static JLabel lblNoSerie;
	private static JLabel lblCantidad;
	private static JLabel lblPrecio;
	private static JLabel Atributo1;
	private static JLabel Atributo2;
	private static JLabel lblAtributo2;
	private static Object compSeleccionado = null;
	private JComboBox<String> comboBoxMarca;
	private JComboBox<String> comboBoxModelo;
	private JComboBox<String> comboBoxAtributo2;


	public AgregarProducto(Principal principal, TiendaDeComputadoras tiendaC) {
		super(principal, true);
		setResizable(false);
		piezasAgreg = new ArrayList<ComponenteOrdenador>();
		tienda = tiendaC;

		setTitle("Manejo de productos");
		setBounds(100, 100, 900, 746);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 890, 672);
		panelPrincipal.setBackground(UIManager.getColor("Button.disabledShadow"));
		contentPanel.add(panelPrincipal);
		panelPrincipal.setLayout(null);

		JPanel panelAgregarPiezas = new JPanel();
		panelAgregarPiezas.setBounds(29, 87, 837, 296);
		panelAgregarPiezas.setForeground(UIManager.getColor("Button.frame"));
		panelAgregarPiezas.setBorder(new TitledBorder(new LineBorder(new Color(0, 88, 168)), "Agregar Pieza", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelAgregarPiezas.setBackground(UIManager.getColor("Button.light"));
		panelPrincipal.add(panelAgregarPiezas);
		panelAgregarPiezas.setLayout(null);

		JLabel lblComponente = new JLabel("Componente:");
		lblComponente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblComponente.setBounds(12, 44, 128, 16);
		panelAgregarPiezas.add(lblComponente);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMarca.setBounds(12, 71, 128, 16);
		panelAgregarPiezas.add(lblMarca);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblModelo.setBounds(12, 98, 128, 16);
		panelAgregarPiezas.add(lblModelo);

		lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrecio.setBounds(12, 213, 128, 16);
		panelAgregarPiezas.add(lblPrecio);

		lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCantidad.setBounds(12, 186, 128, 16);
		panelAgregarPiezas.add(lblCantidad);

		lblNoSerie = new JLabel("No. Serie:");
		lblNoSerie.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNoSerie.setBounds(12, 155, 162, 20);
		panelAgregarPiezas.add(lblNoSerie);

		spinner = new JSpinner(new SpinnerNumberModel(0,0,100,1));
		spinner.setFont(new Font("Arial", Font.PLAIN, 15));
		spinner.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		spinner.setBounds(247, 184, 70, 22);
		SpinnerNumberModel model = new SpinnerNumberModel(0,0,100,1);
		spinner.setModel(model);
		panelAgregarPiezas.add(spinner);

		txtNoSerieMovible = new JTextFieldModificado();
		txtNoSerieMovible.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char t = e.getKeyChar();
				if(t==KeyEvent.VK_ENTER)
					btnAgregar.doClick();
				else if ((t < '0' || t > '9') && (t < 'A' || t > 'Z') && (t < 'a' || t > 'z') && t != 8) {
					JOptionPane.showMessageDialog(null, "En este campo no se pueden introducir caracteres especiales", "Datos erróneos", JOptionPane.ERROR_MESSAGE);
					e.consume();
				}
			}
		});
		txtNoSerieMovible.setDisabledTextColor(Color.WHITE);
		txtNoSerieMovible.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		txtNoSerieMovible.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNoSerieMovible.setForeground(UIManager.getColor("Button.foreground"));
		txtNoSerieMovible.setBounds(455, 212, 48, 20);
		panelAgregarPiezas.add(txtNoSerieMovible);
		txtNoSerieMovible.setColumns(10);
		txtNoSerieMovible.setLimite(5);

		txtNoSerieFijo = new JTextField();
		txtNoSerieFijo.setEditable(false);
		txtNoSerieFijo.setDisabledTextColor(Color.WHITE);
		txtNoSerieFijo.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));
		txtNoSerieFijo.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNoSerieFijo.setForeground(UIManager.getColor("Button.foreground"));
		txtNoSerieFijo.setBounds(353, 212, 70, 20);
		panelAgregarPiezas.add(txtNoSerieFijo);
		txtNoSerieFijo.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtPrecio.getText().length() < 10) {
					char t = e.getKeyChar();
					if((t- '0' > 9 || t- '0' < 0) && t!= 8 && t!= '.') {
						JOptionPane.showMessageDialog(null, "Solo se pueden introducir numeros en este campo", "Datos erróneos", JOptionPane.ERROR_MESSAGE);
						e.consume();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "El precio no puede exceder de 10 dígitos", "Datos erróneos", JOptionPane.ERROR_MESSAGE);
					e.consume();
				}
			}
		});
		txtPrecio.setEditable(false);
		txtPrecio.setDisabledTextColor(Color.WHITE);
		txtPrecio.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtPrecio.setFont(new Font("Arial", Font.PLAIN, 13));
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(247, 212, 70, 20);
		panelAgregarPiezas.add(txtPrecio);

		Atributo1 = new JLabel();
		Atributo1.setText("Atributo1");
		Atributo1.setFont(new Font("Tahoma", Font.BOLD, 15));
		Atributo1.setBorder(null);
		Atributo1.setBounds(12, 126, 162, 20);
		panelAgregarPiezas.add(Atributo1);

		lblAtributo2 = new JLabel();
		lblAtributo2.setBorder(null);
		lblAtributo2.setBackground(Color.WHITE);
		lblAtributo2.setText("t");
		lblAtributo2.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelAgregarPiezas.add(lblAtributo2);
		lblAtributo2.setBounds(770, 155, 37, 19);

		Atributo2 = new JLabel();
		Atributo2.setVisible(false);
		Atributo2.setBorder(null);
		Atributo2.setFont(new Font("Tahoma", Font.BOLD, 15));
		Atributo2.setText("Atributo2");
		Atributo2.setBounds(12, 155, 162, 20);
		panelAgregarPiezas.add(Atributo2);

		comboBoxMarca = new JComboBox<String>();
		comboBoxMarca.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					inicializarComboBoxAtrib();
					if(compSeleccionado != null) {
						elegirModelo(compSeleccionado, comboBoxMarca.getSelectedItem());							
						String numSerie = obtenerNoSerie();
						ComponenteOrdenador c = tienda.buscarComponente(numSerie);
						if(numSerie != "") {			
							precio = tienda.obtenerPrecioComp(c, comboBoxComponente.getSelectedIndex(), comboBoxMarca.getSelectedIndex(), comboBoxModelo.getSelectedIndex(), comboBoxAtributo1.getSelectedIndex(), comboBoxAtributo2.getSelectedIndex());
							txtPrecio.setText(String.format("%.2f", precio));
							txtNoSerieMovible.setText("");
							txtNoSerieFijo.setText(numSerie);				
						}
						else {
							precio = tienda.obtenerPrecioComp(c, comboBoxComponente.getSelectedIndex(), comboBoxMarca.getSelectedIndex(), comboBoxModelo.getSelectedIndex(), comboBoxAtributo1.getSelectedIndex(), comboBoxAtributo2.getSelectedIndex());
							txtPrecio.setText(String.format("%.2f", precio));
							ponerNoSeriePiezasNuevas();
							txtNoSerieMovible.setVisible(true);
						}
					}

				}
			}
		});
		comboBoxMarca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c==KeyEvent.VK_ENTER)
					btnAgregar.doClick();
			}
		});
		comboBoxMarca.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		comboBoxMarca.setBounds(247, 71, 560, 20);	
		panelAgregarPiezas.add(comboBoxMarca);

		comboBoxModelo = new JComboBox<String>();
		comboBoxModelo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					inicializarComboBoxAtrib();
					String numSerie = obtenerNoSerie();
					ComponenteOrdenador c = tienda.buscarComponente(numSerie);
					if(numSerie != "") {			
						precio = tienda.obtenerPrecioComp(c, comboBoxComponente.getSelectedIndex(), comboBoxMarca.getSelectedIndex(), comboBoxModelo.getSelectedIndex(), comboBoxAtributo1.getSelectedIndex(), comboBoxAtributo2.getSelectedIndex());
						txtPrecio.setText(String.format("%.2f", precio));
						txtNoSerieMovible.setText("");
						txtNoSerieFijo.setText(numSerie);				
					}
					else {
						precio = tienda.obtenerPrecioComp(c, comboBoxComponente.getSelectedIndex(), comboBoxMarca.getSelectedIndex(), comboBoxModelo.getSelectedIndex(), comboBoxAtributo1.getSelectedIndex(), comboBoxAtributo2.getSelectedIndex());
						txtPrecio.setText(String.format("%.2f", precio));
						ponerNoSeriePiezasNuevas();
						txtNoSerieMovible.setVisible(true);
					}
				}
			}
		});
		comboBoxModelo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c==KeyEvent.VK_ENTER)
					btnAgregar.doClick();
			}
		});
		comboBoxModelo.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		comboBoxModelo.setBounds(247, 98, 560, 20);
		panelAgregarPiezas.add(comboBoxModelo);

		comboBoxAtributo1 = new JComboBox<String>();
		comboBoxAtributo1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					String numSerie = obtenerNoSerie();
					ComponenteOrdenador c = tienda.buscarComponente(numSerie);
					if(numSerie != "") {			
						precio = tienda.obtenerPrecioComp(c, comboBoxComponente.getSelectedIndex(), comboBoxMarca.getSelectedIndex(), comboBoxModelo.getSelectedIndex(), comboBoxAtributo1.getSelectedIndex(), comboBoxAtributo2.getSelectedIndex());
						txtPrecio.setText(String.format("%.2f", precio));
						txtNoSerieMovible.setText("");
						txtNoSerieFijo.setText(numSerie);				
					}
					else {
						precio = tienda.obtenerPrecioComp(c, comboBoxComponente.getSelectedIndex(), comboBoxMarca.getSelectedIndex(), comboBoxModelo.getSelectedIndex(), comboBoxAtributo1.getSelectedIndex(), comboBoxAtributo2.getSelectedIndex());
						txtPrecio.setText(String.format("%.2f", precio));
						ponerNoSeriePiezasNuevas();
						txtNoSerieMovible.setVisible(true);
					}
				}
			}
		});
		comboBoxAtributo1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c==KeyEvent.VK_ENTER)
					btnAgregar.doClick();
			}
		});
		comboBoxAtributo1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		comboBoxAtributo1.setBounds(247, 128, 560, 20);
		panelAgregarPiezas.add(comboBoxAtributo1);

		comboBoxAtributo2 = new JComboBox<String>();
		comboBoxAtributo2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					String numSerie = obtenerNoSerie();
					ComponenteOrdenador c = tienda.buscarComponente(numSerie);
					if(numSerie != "") {			
						precio = tienda.obtenerPrecioComp(c, comboBoxComponente.getSelectedIndex(), comboBoxMarca.getSelectedIndex(), comboBoxModelo.getSelectedIndex(), comboBoxAtributo1.getSelectedIndex(), comboBoxAtributo2.getSelectedIndex());
						txtPrecio.setText(String.format("%.2f", precio));
						txtNoSerieMovible.setText("");
						txtNoSerieFijo.setText(numSerie);				
					}
					else {
						precio = tienda.obtenerPrecioComp(c, comboBoxComponente.getSelectedIndex(), comboBoxMarca.getSelectedIndex(), comboBoxModelo.getSelectedIndex(), comboBoxAtributo1.getSelectedIndex(), comboBoxAtributo2.getSelectedIndex());
						txtPrecio.setText(String.format("%.2f", precio));
						ponerNoSeriePiezasNuevas();
						txtNoSerieMovible.setVisible(true);
					}
				}
			}
		});
		comboBoxAtributo2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c==KeyEvent.VK_ENTER)
					btnAgregar.doClick();
			}
		});
		comboBoxAtributo2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		comboBoxAtributo2.setBounds(247, 157, 513, 20);
		panelAgregarPiezas.add(comboBoxAtributo2);


		comboBoxComponente = new JComboBox<String>();
		comboBoxComponente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c==KeyEvent.VK_ENTER)
					btnAgregar.doClick();
			}
		});
		comboBoxComponente.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		comboBoxComponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				compSeleccionado = comboBoxComponente.getSelectedItem();
				comboBoxMarca.removeAllItems();
				elegirMarca(compSeleccionado);
				elegirModelo(compSeleccionado, comboBoxMarca.getSelectedItem());
				inicializarComboBoxAtrib();
				String numSerie = obtenerNoSerie();
				ComponenteOrdenador c = tienda.buscarComponente(numSerie);
				if(numSerie != "") {			
					precio = tienda.obtenerPrecioComp(c, comboBoxComponente.getSelectedIndex(), comboBoxMarca.getSelectedIndex(), comboBoxModelo.getSelectedIndex(), comboBoxAtributo1.getSelectedIndex(), comboBoxAtributo2.getSelectedIndex());
					txtPrecio.setText(String.format("%.2f", precio));
					txtNoSerieMovible.setText("");
					txtNoSerieFijo.setText(numSerie);				
				}
				else {
					precio = tienda.obtenerPrecioComp(c, comboBoxComponente.getSelectedIndex(), comboBoxMarca.getSelectedIndex(), comboBoxModelo.getSelectedIndex(), comboBoxAtributo1.getSelectedIndex(), comboBoxAtributo2.getSelectedIndex());
					txtPrecio.setText(String.format("%.2f", precio));
					ponerNoSeriePiezasNuevas();
					txtNoSerieMovible.setVisible(true);
				}
			}
		});
		comboBoxComponente.setBounds(247, 44, 560, 20);
		panelAgregarPiezas.add(comboBoxComponente);

		llenarComboBox(comboBoxComponente, inicializaciones.InicializacionDeDatos.nameComponente());
		llenarComboBox(comboBoxMarca, inicializaciones.InicializacionDeDatos.marcasAdaptadores());
		inicializarComboBoxAtrib();
		txtNoSerieFijo.setText(obtenerNoSerie());

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarDatos();
			}
		});
		btnLimpiar.setBounds(737, 263, 70, 22);
		panelAgregarPiezas.add(btnLimpiar);

		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numSerie = obtenerNoSerie();
				boolean datoIncorrecto = false;
				boolean cantidadCero = false;
				boolean IDRepetido = false;
				noSerie = txtNoSerieFijo.getText() + txtNoSerieMovible.getText();
				cantidad = (int) spinner.getValue();
				marca = (String) comboBoxMarca.getSelectedItem();
				modelo = (String) comboBoxModelo.getSelectedItem();
				primAtrib = (String) comboBoxAtributo1.getSelectedItem();
				segundoAtrib = (String) comboBoxAtributo2.getSelectedItem();

				if (numSerie == "" && txtNoSerieMovible.getText().length() == 0) {
					lblNoSerie.setForeground(Color.RED);
					datoIncorrecto = true;
				} else {
					lblNoSerie.setForeground(Color.BLACK);
					boolean stop = false;
					for(int i = 0; i < tienda.getComponentes().size() && !stop; i++) {
						if(tienda.getComponentes().get(i).getNumSerie().equalsIgnoreCase(noSerie)
								&& (!(tienda.getComponentes().get(i).getMarca().equalsIgnoreCase(marca))
										|| (!(tienda.getComponentes().get(i).getModelo().equalsIgnoreCase(modelo))))) {
							stop = true;
							IDRepetido = true;
						}
					}
				}
				if (txtPrecio.getText().trim().isEmpty()) {
					lblPrecio.setForeground(Color.RED);
					datoIncorrecto = true;
				} else {
					lblPrecio.setForeground(Color.BLACK);
				}
				if (cantidad == 0) 
					cantidadCero = true;

				if (datoIncorrecto && cantidadCero) {
					JOptionPane.showMessageDialog(AgregarProducto.this, "No pueden estar vacíos los campos marcados en rojo y la cantidad de piezas a agregar no puede ser 0.");
				} 
				else if (datoIncorrecto) {
					JOptionPane.showMessageDialog(AgregarProducto.this, "No pueden estar vacíos los campos marcados en rojo.");
				}
				else if (IDRepetido) {
					JOptionPane.showMessageDialog(AgregarProducto.this, "Ya existe una pieza distinta en el almacén con ese No de Serie.");
				}
				else if (cantidadCero) {
					JOptionPane.showMessageDialog(AgregarProducto.this, "La cantidad de piezas a agregar no puede ser 0");
				}
				else {
					try {
						precio = Float.parseFloat(txtPrecio.getText());
						if(precio > 0 ) {
							ComponenteOrdenador comp = null;
							if(noSerie.startsWith("A")) {
								comp = new Adaptador(cantidad, noSerie, marca, modelo, precio);
							}
							else if(noSerie.startsWith("B")) {
								comp = new Bocina(cantidad, noSerie, marca, modelo, precio, primAtrib);
							}
							else if(noSerie.startsWith("C")) {
								comp = new Chasis(cantidad, noSerie, marca, modelo, precio, primAtrib);
							}
							else if(noSerie.startsWith("DD")) {
								comp = new DiscoDuro(cantidad, noSerie, marca, modelo, precio, false, Double.parseDouble(segundoAtrib), primAtrib);
							}
							else if(noSerie.startsWith("F")) {
								comp = new Fuente(cantidad, noSerie, marca, modelo, precio, primAtrib);
							}
							else if(noSerie.startsWith("MP")) {
								comp = new Microprocesador(cantidad, noSerie, marca, modelo, precio, primAtrib, Double.parseDouble(segundoAtrib));
							}
							else if(noSerie.startsWith("MN")) {
								comp = new Monitor(cantidad, noSerie, marca, modelo, precio, primAtrib);
							}
							else if(noSerie.startsWith("MR")) {
								comp = new MemoriaRam(cantidad, noSerie, marca, modelo, precio, false, Double.parseDouble(segundoAtrib), primAtrib);
							}
							else if(noSerie.startsWith("R")) {
								comp = new Mouse(cantidad, noSerie, marca, modelo, precio, primAtrib);
							}
							else if(noSerie.startsWith("TM")) {
								comp = new TarjetaMadre(cantidad, noSerie, marca, modelo, precio, primAtrib);
							}
							else if(noSerie.startsWith("TV")) {
								comp = new TarjetaDeVideo(cantidad, noSerie, marca, modelo, precio, primAtrib);
							}
							else {
								if(primAtrib == "Sí")
									comp = new Teclado(cantidad, noSerie, marca, modelo, precio, 1);
								else
									comp = new Teclado(cantidad, noSerie, marca, modelo, precio, 0);
							}
							componente = comp;
							piezasAgreg.add(componente);
							agregarTabla();
							JOptionPane.showMessageDialog(AgregarProducto.this, "Pieza agregada a la tabla de manera satisfactoria");
						}
						else {
							JOptionPane.showMessageDialog(AgregarProducto.this, "El precio debe ser mayor que cero");	
						}
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(AgregarProducto.this, "El precio debe ser un número válido.");
					}

				}		
				limpiarDatos();
			}
		});

		btnAgregar.setBounds(656, 263, 70, 22);
		panelAgregarPiezas.add(btnAgregar);

		JPanel panelPiezasAgregadas = new JPanel();
		panelPiezasAgregadas.setBounds(29, 399, 837, 237);
		panelPiezasAgregadas.setBorder(new TitledBorder(null, "Piezas agregadas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPiezasAgregadas.setBackground(UIManager.getColor("Button.disabledShadow"));
		panelPrincipal.add(panelPiezasAgregadas);
		panelPiezasAgregadas.setLayout(new BorderLayout(0, 0));

		tableModel = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableModel.addColumn("Componente");
		tableModel.addColumn("Marca");
		tableModel.addColumn("Modelo");
		tableModel.addColumn("Precio");
		tableModel.addColumn("Cantidad");
		tableModel.addColumn("No. Serie");

		table = new JTable(tableModel);
		table.setGridColor(new Color(135, 206, 235));
		table.setFocusable(false);
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(java.awt.event.KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
					int i = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar la pieza seleccionada?", "", 0, 3);
					if(i==0) {		
						int pos = table.getSelectedRow();
						if (pos != -1) {
							piezasAgreg.remove(pos);
							((DefaultTableModel) table.getModel()).removeRow(pos);
						} else {
							JOptionPane.showMessageDialog(AgregarProducto.this, "Antes de eliminar debe de seleccionar una pieza de la tabla");
						}
					}
				}
			}
		});
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane = new JScrollPane(table);
		panelPiezasAgregadas.add(scrollPane, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(12, 12, 76, 60);
		lblNewLabel.setIcon(new ImageIcon(AgregarProducto.class.getResource("/gui/icons/logoPeque\u00F1o1.jpg")));
		panelPrincipal.add(lblNewLabel);

		btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(AgregarProducto.class.getResource("/gui/icons/basura.png")));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar la pieza seleccionada?", "", 0, 3);
				if(i==0) {		
					int pos = table.getSelectedRow();
					if (pos != -1) {
						piezasAgreg.remove(pos);
						((DefaultTableModel) table.getModel()).removeRow(pos);
					} else {
						JOptionPane.showMessageDialog(AgregarProducto.this, "Antes de eliminar debe de seleccionar una pieza de la tabla");
					}
				}
			}
		});
		btnEliminar.setContentAreaFilled(false);
		btnEliminar.setBorder(null);
		btnEliminar.setFocusable(false);
		btnEliminar.setActionCommand("OK");
		btnEliminar.setBounds(813, 636, 41, 35);	
		panelPrincipal.add(btnEliminar);

		panelSecundario = new JPanel();
		panelSecundario.setBackground(Color.WHITE);
		panelSecundario.setBounds(0, 676, 890, 40);
		contentPanel.add(panelSecundario);
		panelSecundario.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(actualizarLista() == true) {
					int i = JOptionPane.showConfirmDialog(null, "¿Seguro que desea salir? Los cambios realizados no serán guardados", "", 0, 3);
					if(i==0) {
						dispose();
						piezasAgreg.clear();
					}
				}
				else
					dispose();
			}
		});
		panelSecundario.add(btnAtras);

		btnGuardar = new JButton("Aceptar");
		panelSecundario.add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(actualizarLista() == true) {
					JOptionPane.showMessageDialog(AgregarProducto.this, "Cambios guardados satisfactoriamente");
					dispose();
					limpiarDatos();
				}
				limpiarDatos();
			}
		});
	}

	private void llenarComboBox(JComboBox<String> comboBox, ArrayList<String> items) {
		if(comboBox != null) {
			comboBox.removeAllItems();
			for (String item : items) {
				comboBox.addItem(item);
			}
		}
	}

	private boolean actualizarLista() {
		boolean act = false;
		if(!piezasAgreg.isEmpty()) {
			tienda.agregarProducto(piezasAgreg);
			act = true;
		}
		else {
			JOptionPane.showMessageDialog(AgregarProducto.this, "No se ha realizado ningún cambio");
		}
		return act;
	}

	private void limpiarDatos() {
		comboBoxComponente.setSelectedIndex(0);
		comboBoxMarca.setSelectedIndex(0);
		comboBoxModelo.setSelectedIndex(0);
		spinner.setValue(0);
		txtNoSerieMovible.setText("");
	}

	private void elegirMarca(Object compSeleccionado) {
		if (comboBoxMarca != null) {	
			String comp = compSeleccionado.toString();
			switch (comp) {
			case "Teclado":
				llenarComboBox(comboBoxMarca, inicializaciones.InicializacionDeDatos.marcasTeclado());
				organizarLabelsUnAtrib();
				Atributo1.setText("Retroiluminación");
				break;
			case "Tarjeta de Video":	
				llenarComboBox(comboBoxMarca, inicializaciones.InicializacionDeDatos.marcasTarjetaVideos());
				organizarLabelsUnAtrib();
				Atributo1.setText("Refrigeración");
				break;
			case "Tarjeta Madre":
				llenarComboBox(comboBoxMarca, inicializaciones.InicializacionDeDatos.marcasTarjetaMadre());
				organizarLabelsUnAtrib();
				Atributo1.setText("Conector");
				break;
			case "Microprocesador":
				llenarComboBox(comboBoxMarca, inicializaciones.InicializacionDeDatos.marcasMicroProcesadores());
				organizarLabelsDosAtrib();
				Atributo1.setText("Conexión");
				Atributo2.setText("Procesamiento");
				lblAtributo2.setText("GHz");
				llenarComboBox(comboBoxAtributo2, inicializaciones.InicializacionDeDatos.velocidadaMicro());
				break;
			case "Adaptador":
				Atributo1.setVisible(false);
				Atributo2.setVisible(false);
				comboBoxAtributo1.setVisible(false);
				comboBoxAtributo2.setVisible(false);
				lblNoSerie.setBounds(12, 125, 128, 16);
				lblCantidad.setBounds(12, 152, 128, 16);
				lblPrecio.setBounds(12, 179, 128, 16);
				lblAtributo2.setVisible(false);
				txtNoSerieFijo.setBounds(247, 124, 70, 20);
				spinner.setBounds(247, 151, 70, 22);
				txtPrecio.setBounds(247, 178, 70, 20);
				llenarComboBox(comboBoxMarca, inicializaciones.InicializacionDeDatos.marcasAdaptadores());
				txtNoSerieMovible.setBounds(267, 124, 50, 20);
				break;
			case "Bocina":	
				llenarComboBox(comboBoxMarca, inicializaciones.InicializacionDeDatos.marcasBocinas());
				organizarLabelsUnAtrib();	
				Atributo1.setText("Conectividad");
				break;
			case "Monitor":
				llenarComboBox(comboBoxMarca, inicializaciones.InicializacionDeDatos.marcasPantalla());
				organizarLabelsUnAtrib();
				Atributo1.setText("Resolución");
				break;
			case "Ratón":
				llenarComboBox(comboBoxMarca, inicializaciones.InicializacionDeDatos.marcasRaton());
				organizarLabelsUnAtrib();
				Atributo1.setText("Conectividad");
				break;
			case "Memoria RAM":
				llenarComboBox(comboBoxMarca, inicializaciones.InicializacionDeDatos.marcasMemoriasRAM());
				organizarLabelsDosAtrib();
				Atributo1.setText("Tipo de Memoria");
				Atributo2.setText("Espacio");
				lblAtributo2.setText("Gb");
				llenarComboBox(comboBoxAtributo2, inicializaciones.InicializacionDeDatos.espacioRAM());
				break;
			case "Chasis":
				llenarComboBox(comboBoxMarca, inicializaciones.InicializacionDeDatos.marcasChasis());
				organizarLabelsUnAtrib();
				Atributo1.setText("Material");
				break;		
			case "Disco Duro":
				llenarComboBox(comboBoxMarca, inicializaciones.InicializacionDeDatos.marcasDiscoD());
				organizarLabelsDosAtrib();
				Atributo1.setText("Conexión");
				Atributo2.setText("Capacidad");
				lblAtributo2.setText("Tb");
				break;
			case "Fuente":	
				llenarComboBox(comboBoxMarca, inicializaciones.InicializacionDeDatos.marcasFuente());
				organizarLabelsUnAtrib();
				Atributo1.setText("Eficiencia");
				break;
			default:
			}
		}
		elegirModelo(compSeleccionado, comboBoxMarca.getSelectedItem());
	}

	private void elegirModelo(Object compSeleccionado, Object marcaSeleccionada) {
		if (marcaSeleccionada != null && compSeleccionado!= null) {
			String comp = compSeleccionado.toString();
			String marca = marcaSeleccionada.toString();
			comboBoxModelo.removeAllItems();
			switch (comp) {
			case "Teclado":
				if(marca.equalsIgnoreCase("HyperX")) 
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.tecladosHyperX());			
				else if(marca.equalsIgnoreCase("Corsair"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.tecladosCorsair());
				else if(marca.equalsIgnoreCase("Logitech"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.tecladosLogitech());
				else if(marca.equalsIgnoreCase("Razer"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.tecladosRazer());
				else 
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.tecladosSteelSeries());
				break;
			case "Tarjeta de Video":
				if(marca.equalsIgnoreCase("AMD"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.tarjetasVideoAMD());
				else if(marca.equalsIgnoreCase("ASUS"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.tarjetasVideoASUS());
				else if(marca.equalsIgnoreCase("Gigabyte"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.tarjetasVideoGigabyte());
				else if(marca.equalsIgnoreCase("MSI"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.tarjetasVideoMSI());
				else
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.tarjetasVideoNVIDIA());
				break;
			case "Tarjeta Madre":
				if(marca.equalsIgnoreCase("ASRock"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.tarjetasMadreASRock());
				else if(marca.equalsIgnoreCase("ASUS"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.tarjetasMadreASUS());
				else if(marca.equalsIgnoreCase("EVGA"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.tarjetasMadreEVGA());
				else if(marca.equalsIgnoreCase("MSI"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.tarjetasMadreMSI());
				else
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.tarjetasMadreGigabyte());
				break;
			case "Microprocesador":
				if(marca.equalsIgnoreCase("AMD")) {
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.microprocesadoresAMD());
				}
				else {
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.microprocesadoresIntel());
				}
				break;
			case "Adaptador": 
				comboBoxModelo.removeAllItems();
				if(marca.equalsIgnoreCase("Anker")) {
					comboBoxModelo.addItem("Hub 7en1 Thunderbolt 3");
				}
				else if(marca.equalsIgnoreCase("Amazon Basics")) {					
					comboBoxModelo.addItem("USB-C a USB-A");
				}
				else if(marca.equalsIgnoreCase("Apple")) {
					comboBoxModelo.addItem("USB-C a Ethernet");
				}
				else if(marca.equalsIgnoreCase("Belkin")) {
					comboBoxModelo.addItem("USB-C a HDMI");
				}
				else {
					comboBoxModelo.addItem("HDMI a VGA");
				}
				break; 
			case "Bocina":
				if(marca.equalsIgnoreCase("Bose"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.bocinasBose());
				else if(marca.equalsIgnoreCase("JBL"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.bocinasJBL());
				else if(marca.equalsIgnoreCase("Sony"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.bocinasSony());
				else if(marca.equalsIgnoreCase("Logitech"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.bocinasLogitech());
				else
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.bocinasSennheiser());
				break;
			case "Monitor":
				if(marca.equalsIgnoreCase("Acer"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.pantallasAcer());
				else if(marca.equalsIgnoreCase("ASUS"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.pantallasASUS());
				else if(marca.equalsIgnoreCase("Dell"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.pantallasDell());
				else if(marca.equalsIgnoreCase("LG"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.pantallasLG());
				else
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.pantallasSamsung());
				break;
			case "Ratón":
				if(marca.equalsIgnoreCase("Corsair"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.mouseCorsair());
				else if(marca.equalsIgnoreCase("HyperX"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.mouseHyperX());
				else if(marca.equalsIgnoreCase("Logitech"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.mouseLogitech());
				else if(marca.equalsIgnoreCase("Razer"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.mouseRazer());
				else
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.mouseSteelSeries());
				break;
			case "Memoria RAM":
				if(marca.equalsIgnoreCase("Corsair"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.memoriasCorsair());
				else if(marca.equalsIgnoreCase("Crucial"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.memoriasCrucial());
				else if(marca.equalsIgnoreCase("G.Skill"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.memoriasGSkill());
				else if(marca.equalsIgnoreCase("HyperX"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.memoriasHyperX());
				else
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.memoriasKingston());
				break;
			case "Chasis":
				if(marca.equalsIgnoreCase("NZXT"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.chasisNZXT());
				else if(marca.equalsIgnoreCase("Thermaltake"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.chasisThermaltake());
				else if(marca.equalsIgnoreCase("Cooler Master"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.chasisCoolerMaster());
				else if(marca.equalsIgnoreCase("Corsair"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.chasisCorsair());
				else
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.chasisFractalDesign());
				break;		
			case "Disco Duro":
				if(marca.equalsIgnoreCase("Crucial"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.discosCrucial());
				else if(marca.equalsIgnoreCase("Samsung"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.discosSamsung());
				else if(marca.equalsIgnoreCase("Seagate"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.discosSeagate());
				else if(marca.equalsIgnoreCase("WD"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.discosWD());
				else
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.discosToshiba());
				break;
			case "Fuente":
				if(marca.equalsIgnoreCase("Be Quiet!"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.fuentesBeQuiet());
				else if(marca.equalsIgnoreCase("Corsair"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.fuentesCorsair());
				else if(marca.equalsIgnoreCase("EVGA"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.fuentesEVGA());
				else if(marca.equalsIgnoreCase("Seasonic"))
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.fuentesSeasonic());
				else
					llenarComboBox(comboBoxModelo, inicializaciones.InicializacionDeDatos.fuentesThermaltake());
				break;
			}
		}
	}

	private String obtenerNoSerie() {
		String noSerie = "";
		if(comboBoxMarca != null && comboBoxModelo != null) {	
			int compSelecc = comboBoxComponente.getSelectedIndex();
			String marcaSelecc = comboBoxMarca.getSelectedItem().toString();
			String modeloSelecc = comboBoxModelo.getSelectedItem().toString();	
			String atribSelecc = "";
			String primAtrib = "";
			Double segundoAtrib = 0.0;
			boolean stop = false;
			for(int i = 0; i < tienda.getComponentes().size() && !stop; i++) {
				segundoAtrib = 0.0;
				ComponenteOrdenador c = tienda.getComponentes().get(i);
				if(c.getMarca().equalsIgnoreCase(marcaSelecc)) {
					if(c.getModelo().equalsIgnoreCase(modeloSelecc)) {
						if(compSelecc == 1 && c instanceof Bocina) {					
							primAtrib = ((Bocina) c).getConectividad(); 
						}
						else if(compSelecc == 2 && c instanceof Chasis) {
							primAtrib = ((Chasis) c).getMaterial();
						}
						else if(compSelecc == 3 && c instanceof DiscoDuro) {
							primAtrib = ((DiscoDuro) c).getTipoDeConexion();		
							segundoAtrib = ((DiscoDuro) c).getCapacidad();						
						}
						else if(compSelecc == 4 && c instanceof Fuente) {
							primAtrib = ((Fuente) c).getEficiencia();
						}
						else if(compSelecc == 5 && c instanceof Microprocesador) {
							primAtrib = ((Microprocesador) c).getTipoDeConexion();
							segundoAtrib = ((Microprocesador) c).getVelocidadDeProcesamiento();
						}
						else if(compSelecc == 6 && c instanceof MemoriaRam) {
							primAtrib = ((MemoriaRam) c).getTipoDeMemoria();
							segundoAtrib = ((MemoriaRam) c).getCantEspacio();
						}
						else if(compSelecc == 7 && c instanceof Monitor) {
							primAtrib = ((Monitor) c).getResolucion();
						}
						else if(compSelecc == 8 && c instanceof Mouse) {
							primAtrib = ((Mouse) c).getConectividad();
						}	
						else if(compSelecc == 9 && c instanceof TarjetaMadre) {
							primAtrib = ((TarjetaMadre) c).getTipoDeConector();

						}
						else if(compSelecc == 10 && c instanceof TarjetaDeVideo) {
							primAtrib = ((TarjetaDeVideo) c).getRefrigeracion();
						}
						if(c instanceof Adaptador) {
							noSerie = tienda.getComponentes().get(i).getNumSerie();
							stop = true;
							txtNoSerieMovible.setVisible(false);
							txtNoSerieFijo.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
						}
						else if(c instanceof Teclado) {
							int retroTeclado = ((Teclado) c).getRetroiluminacion();
							if(retroTeclado == comboBoxAtributo1.getSelectedIndex()) {
								noSerie = tienda.getComponentes().get(i).getNumSerie();
								stop = true;
								txtNoSerieMovible.setVisible(false);
								txtNoSerieFijo.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
							}
						}
						else {
							atribSelecc = comboBoxAtributo1.getSelectedItem().toString();
							if(primAtrib.equalsIgnoreCase(atribSelecc))
								if(segundoAtrib > 0 && segundoAtrib == Double.parseDouble(comboBoxAtributo2.getSelectedItem().toString())) {
									noSerie = tienda.getComponentes().get(i).getNumSerie();
									stop = true;
									txtNoSerieMovible.setVisible(false);
									txtNoSerieFijo.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
								}
								else if(segundoAtrib == 0) {
									noSerie = tienda.getComponentes().get(i).getNumSerie();
									stop = true;
									txtNoSerieMovible.setVisible(false);
									txtNoSerieFijo.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
								}
						}
					}
				}	
			}
			if(!stop) {
				for(int i = 0; i < piezasAgreg.size() && !stop; i++) {
					ComponenteOrdenador p = piezasAgreg.get(i);
					if(p.getMarca().equalsIgnoreCase(marcaSelecc)) {
						if(p.getModelo().equalsIgnoreCase(modeloSelecc)) {
							if(compSelecc == 1 && p instanceof Bocina) {					
								primAtrib = ((Bocina) p).getConectividad(); 
							}
							else if(compSelecc == 2 && p instanceof Chasis) {
								primAtrib = ((Chasis) p).getMaterial();
							}
							else if(compSelecc == 3 && p instanceof DiscoDuro) {
								primAtrib = ((DiscoDuro) p).getTipoDeConexion();		
								segundoAtrib = ((DiscoDuro) p).getCapacidad();						
							}
							else if(compSelecc == 4 && p instanceof Fuente) {
								primAtrib = ((Fuente) p).getEficiencia();
							}
							else if(compSelecc == 5 && p instanceof Microprocesador) {
								primAtrib = ((Microprocesador) p).getTipoDeConexion();
								segundoAtrib = ((Microprocesador) p).getVelocidadDeProcesamiento();
							}
							else if(compSelecc == 6 && p instanceof MemoriaRam) {
								primAtrib = ((MemoriaRam) p).getTipoDeMemoria();
								segundoAtrib = ((MemoriaRam) p).getCantEspacio();
							}
							else if(compSelecc == 7 && p instanceof Monitor) {
								primAtrib = ((Monitor) p).getResolucion();
							}
							else if(compSelecc == 8 && p instanceof Mouse) {
								primAtrib = ((Mouse) p).getConectividad();
							}	
							else if(compSelecc == 9 && p instanceof TarjetaMadre) {
								primAtrib = ((TarjetaMadre) p).getTipoDeConector();

							}
							else if(compSelecc == 10 && p instanceof TarjetaDeVideo) {
								primAtrib = ((TarjetaDeVideo) p).getRefrigeracion();
							}						
							if(p instanceof Adaptador) {
								noSerie = p.getNumSerie();
								stop = true;
								txtNoSerieMovible.setVisible(false);
								txtNoSerieFijo.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
							}
							else if(p instanceof Teclado) {
								int retroTeclado = ((Teclado) p).getRetroiluminacion();
								if(retroTeclado == comboBoxAtributo1.getSelectedIndex()) {						
									noSerie = p.getNumSerie();
									stop = true;
									txtNoSerieMovible.setVisible(false);
									txtNoSerieFijo.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
								}
							}
							else {
								atribSelecc = comboBoxAtributo1.getSelectedItem().toString();
								System.out.println(primAtrib);
								if(primAtrib.equalsIgnoreCase(atribSelecc))
									if(segundoAtrib > 0 && segundoAtrib == Double.parseDouble(comboBoxAtributo2.getSelectedItem().toString())) {		
										noSerie = p.getNumSerie();
										stop = true;
										txtNoSerieMovible.setVisible(false);
										txtNoSerieFijo.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
									}
									else if(segundoAtrib == 0) {
										noSerie = p.getNumSerie();
										stop = true;
										txtNoSerieMovible.setVisible(false);
										txtNoSerieFijo.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
									}
							}
						}
					}
				}
			}
		}
		return noSerie;
	}

	private void ponerNoSeriePiezasNuevas() {
		int compSelecc = comboBoxComponente.getSelectedIndex();
		txtNoSerieFijo.setText("");
		switch (compSelecc) {
		case 0: 
			txtNoSerieFijo.setText("A");
			break;
		case 1: 
			txtNoSerieFijo.setText("B");
			break;
		case 2: 
			txtNoSerieFijo.setText("C");
			break;
		case 3: 
			txtNoSerieFijo.setText("DD");
			break;
		case 4: 
			txtNoSerieFijo.setText("F");
			break;
		case 5: 
			txtNoSerieFijo.setText("MP");
			break;
		case 6: 
			txtNoSerieFijo.setText("MR");
			break;
		case 7: 
			txtNoSerieFijo.setText("MN");
			break;
		case 8: 
			txtNoSerieFijo.setText("R");
			break;
		case 9: 
			txtNoSerieFijo.setText("TM");
			break;
		case 10: 
			txtNoSerieFijo.setText("TV");
			break;
		case 11: 
			txtNoSerieFijo.setText("TE");
			break;
		}
	}

	private void organizarLabelsUnAtrib() {
		Atributo1.setVisible(true);	
		comboBoxAtributo1.setVisible(true);
		Atributo2.setVisible(false);		
		lblPrecio.setBounds(12, 213, 128, 16);
		txtPrecio.setBounds(247, 212, 70, 20);
		lblCantidad.setBounds(12, 186, 128, 16);
		spinner.setBounds(247, 184, 70, 22);
		lblNoSerie.setBounds(12, 155, 162, 20);
		txtNoSerieFijo.setBounds(247, 157, 70, 20);
		txtNoSerieMovible.setBounds(269, 157, 48, 20);
		comboBoxAtributo2.setVisible(false);
		lblAtributo2.setVisible(false);
	}

	private void organizarLabelsDosAtrib() {
		Atributo1.setVisible(true);	
		comboBoxAtributo1.setVisible(true);
		Atributo2.setVisible(true);	
		comboBoxAtributo2.setVisible(true);
		lblNoSerie.setBounds(12, 186, 128, 16);
		txtNoSerieFijo.setBounds(247, 185, 70, 20);
		lblCantidad.setBounds(12, 213, 128, 16);
		spinner.setBounds(247, 211, 70, 22);
		lblPrecio.setBounds(12, 240, 128, 16);
		txtPrecio.setBounds(247, 240, 70, 20);	
		txtNoSerieMovible.setBounds(269, 185, 48, 20);
		lblAtributo2.setVisible(true);
	}

	private void agregarTabla() {
		int cantFilas = table.getModel().getRowCount();
		boolean stop = false;
		for(int i = 0; i < cantFilas && !stop; i++) {
			String NoSerie = (String) table.getValueAt(i, 5);
			if(noSerie.equalsIgnoreCase(NoSerie)) {
				stop = true;
				piezasAgreg.get(i).setCantDisponible(piezasAgreg.get(i).getCantDisponible() + cantidad);
				if(piezasAgreg.size() > 1) {
					int lastIndex = piezasAgreg.size() - 1;
					piezasAgreg.remove(lastIndex);
				}
			}					
		}		
		while(((DefaultTableModel) table.getModel()).getRowCount() > 0)
			((DefaultTableModel) table.getModel()).removeRow(0);
		for(ComponenteOrdenador p: piezasAgreg) {
			tableModel.addRow(new Object[]{p.getClass().getSimpleName(), p.getMarca(), p.getModelo(), p.getPrecio(), p.getCantDisponible(), p.getNumSerie()});
		}
	}

	private void inicializarComboBoxAtrib() {
		int comp = comboBoxComponente.getSelectedIndex();
		switch(comp) {
		case 1: 
			llenarComboBox(comboBoxAtributo1, inicializaciones.InicializacionDeDatos.conectividad());
			break;
		case 2: 
			llenarComboBox(comboBoxAtributo1, inicializaciones.InicializacionDeDatos.materialesChasis());
			break;
		case 3: 
			llenarComboBox(comboBoxAtributo1, inicializaciones.InicializacionDeDatos.conexionesDiscoDuro());
			llenarComboBox(comboBoxAtributo2, inicializaciones.InicializacionDeDatos.capacidadDiscoDuroTB());
			break;
		case 4: 
			llenarComboBox(comboBoxAtributo1, inicializaciones.InicializacionDeDatos.eficiencia());
			break;
		case 5: 
			int marca = comboBoxMarca.getSelectedIndex();
			if(marca == 0)
				llenarComboBox(comboBoxAtributo1, inicializaciones.InicializacionDeDatos.conexionesAMD());
			else
				llenarComboBox(comboBoxAtributo1, inicializaciones.InicializacionDeDatos.conexionesIntel());
			llenarComboBox(comboBoxAtributo2, inicializaciones.InicializacionDeDatos.velocidadaMicro());
			break;
		case 6: 
			llenarComboBox(comboBoxAtributo1, inicializaciones.InicializacionDeDatos.tiposDeMemoriaRAM());
			llenarComboBox(comboBoxAtributo2, inicializaciones.InicializacionDeDatos.espacioRAM());
			break;
		case 7: 
			llenarComboBox(comboBoxAtributo1, inicializaciones.InicializacionDeDatos.resolucionVideo());
			break;
		case 8: 
			llenarComboBox(comboBoxAtributo1, inicializaciones.InicializacionDeDatos.conectividad());
			break;
		case 9: 
			llenarComboBox(comboBoxAtributo1, inicializaciones.InicializacionDeDatos.conectores());
			break;
		case 10: 
			llenarComboBox(comboBoxAtributo1, inicializaciones.InicializacionDeDatos.refrigeracion());
			break;
		case 11: 
			llenarComboBox(comboBoxAtributo1, inicializaciones.InicializacionDeDatos.retroiluminacionTeclados());
			break;
		}
	}
	
	/*private float obtenerPrecioAgg(String noSerie) {
		float precio = 0;
		boolean stop = false;
		for(int i = 0; i < piezasAgreg.size() && !stop; i++) {
			if(piezasAgreg.get(i).getNumSerie().equalsIgnoreCase(noSerie)) {
				stop = true;
				precio = piezasAgreg.get(i).getPrecio();
			}
		}
		return precio;
	}*/
}


