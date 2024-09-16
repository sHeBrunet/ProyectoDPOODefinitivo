package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logica.Adaptador;
import logica.Bocina;
import logica.Chasis;
import logica.ComponenteOrdenador;
import logica.DiscoDuro;
import logica.Factura;
import logica.Fuente;
import logica.MemoriaRam;
import logica.Microprocesador;
import logica.Monitor;
import logica.Mouse;
import logica.TarjetaDeVideo;
import logica.TarjetaMadre;
import logica.Teclado;
import logica.TiendaDeComputadoras;



public class VenderPieza extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private TiendaDeComputadoras tiendaC;
	private Principal p;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxComponenetes;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxMarca;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxModelo;
	private String nombre;
	private JComboBox<String> comboBoxAtributo1;
	private ArrayList<String> modelo; 
	private JTextField nombretext;
	private JTextField modelotext;
	private JTextField notext;
	private JTextField preciotext;
	private JTextField cantidadtxt;
	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField MarcaEncontText;
	private ArrayList <Integer> extraida; 
	private ArrayList<ComponenteOrdenador> componentes;
	private ArrayList<Integer> cant;
	private int cantidad;
	private JSpinner spinnerAtributo2;
	private JTextField totalFactura;
	private Factura f;
	private JComboBox<String> comboBoxAtributo2;
	private JTextField txtMemoriaRamCompatible;
	private JTextField txtLis;
	private JPanel panelInfoTarjetaMadre;
	private JComboBox<String> comboBoxCDisco;
	private JComboBox<String> comboBoxCRAM;
	private TarjetaMadre m = null;
	private JTextField txtMicroprocesadores;
	private JComboBox<String> comboBoxCMicro;
	private JSpinner spinner;
	private JButton okButton_1;
	private JButton btnCarrito;
	private JButton ensamblar;
	private ArrayList <Boolean> ensamblado;
	private JLabel Atributo1;
	private JLabel Atributo2;
	private JButton btnBuscar;
	@SuppressWarnings({ "unchecked", "rawtypes" })

	public VenderPieza(Principal principal, TiendaDeComputadoras tienda, String nombreDeComponente) {
		super(principal, true);
		nombre = nombreDeComponente;
		setTitle("Vender Piezas");
		p = principal;
		tiendaC = tienda;
		modelo = new ArrayList<>();
		cant = new ArrayList<Integer>();
		ensamblado = new ArrayList<Boolean>();
		setBounds(100, 100, 906, 783);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null); 

		{
			extraida  =new ArrayList<Integer>();
			componentes = new ArrayList<>();
			new ArrayList<ComponenteOrdenador>();
			JPanel FiltradodeProducto = new JPanel();
			FiltradodeProducto.setBackground(Color.WHITE);
			FiltradodeProducto.setBorder(new MatteBorder(2, 2, 0, 0, (Color) new Color(0, 0, 0)));
			FiltradodeProducto.setBounds(0, 0, 466, 462);
			contentPanel.add(FiltradodeProducto);
			FiltradodeProducto.setLayout(null);
			panelInfoTarjetaMadre = new JPanel();
			panelInfoTarjetaMadre.setBorder(new TitledBorder(new LineBorder(new Color(0, 88, 168)), "Informaci\u00F3n de Componentes Compatibles", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelInfoTarjetaMadre.setBackground(Color.WHITE);
			panelInfoTarjetaMadre.setBounds(12, 217, 442, 174);
			FiltradodeProducto.add(panelInfoTarjetaMadre);
			panelInfoTarjetaMadre.setLayout(null);

			txtMemoriaRamCompatible = new JTextField();
			txtMemoriaRamCompatible.setBounds(12, 25, 124, 19);
			txtMemoriaRamCompatible.setText("Memoria RAM:");
			txtMemoriaRamCompatible.setFont(new Font("Tahoma", Font.BOLD, 15));
			txtMemoriaRamCompatible.setEditable(false);
			txtMemoriaRamCompatible.setColumns(10);
			txtMemoriaRamCompatible.setBorder(null);
			panelInfoTarjetaMadre.add(txtMemoriaRamCompatible);

			comboBoxCRAM = new JComboBox();
			comboBoxCRAM.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseMoved(MouseEvent e) {
					int index = comboBoxCRAM.getSelectedIndex();
					if(index != -1) {
						String tooltipText = "<html><fontface = 'Arial' size ='3'> Datos de la RAM: <br>" +
								"Tipo de memoria:" + "  " +  m.getMemoriasR().get(index).getTipoDeMemoria() + "<br>" +
								"Cantidad de Espacio:" + "  " + m.getMemoriasR().get(index).getCantEspacio() + "<br>" +
								"Precio:"             +  "   " + m.getMemoriasR().get(index).getPrecio();
						comboBoxCRAM.setToolTipText(tooltipText);
					}
				}
			});
			comboBoxCRAM.addMouseListener(new MouseAdapter() {

			});
			comboBoxCRAM.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				}
			});
			comboBoxCRAM.setBounds(175, 25, 255, 20);
			panelInfoTarjetaMadre.add(comboBoxCRAM);

			txtLis = new JTextField();
			txtLis.setBounds(12, 72, 109, 20);
			txtLis.setHorizontalAlignment(SwingConstants.LEFT);
			txtLis.setText("Discos Duros:");
			txtLis.setFont(new Font("Tahoma", Font.BOLD, 15));
			txtLis.setEditable(false);
			txtLis.setColumns(10);
			txtLis.setBorder(null);
			panelInfoTarjetaMadre.add(txtLis);

			comboBoxCDisco = new JComboBox<String>();
			comboBoxCDisco.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseMoved(MouseEvent e) {
					int index = comboBoxCDisco.getSelectedIndex();
					if(index != -1) {
						String tooltipText = "<html><fontface = 'Arial' size ='3'> Datos del Disco Duro: <br>" +
								"Tipo de conexión:" + "  " +  m.getDiscos().get(index).getTipoDeConexion() + "<br>" +
								"Cantidad de Espacio:" + "  " + m.getDiscos().get(index).getCapacidad() + "<br>" +
								"Precio:"             +  "   " + m.getDiscos().get(index).getPrecio();
						comboBoxCDisco.setToolTipText(tooltipText);
					}
				}
			});
			comboBoxCDisco.setBounds(175, 72, 255, 20);
			panelInfoTarjetaMadre.add(comboBoxCDisco);

			txtMicroprocesadores = new JTextField();
			txtMicroprocesadores.setText("Microprocesadores:");
			txtMicroprocesadores.setHorizontalAlignment(SwingConstants.LEFT);
			txtMicroprocesadores.setFont(new Font("Tahoma", Font.BOLD, 15));
			txtMicroprocesadores.setEditable(false);
			txtMicroprocesadores.setColumns(10);
			txtMicroprocesadores.setBorder(null);
			txtMicroprocesadores.setBounds(12, 123, 152, 20);
			panelInfoTarjetaMadre.add(txtMicroprocesadores);

			comboBoxCMicro = new JComboBox<String>();
			comboBoxCMicro.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseMoved(MouseEvent e) {
					int index = comboBoxCMicro.getSelectedIndex();
					if(index != -1) {
						String tooltipText = "<html><fontface = 'Arial' size ='3'> Datos del Microprocesador: <br>" +
								"Tipo de conexión:" + "  " +  m.getMicro().getTipoDeConexion() + "<br>" +
								"Velocidad de Procesamiento:" + "  " + m.getMicro().getVelocidadDeProcesamiento() + "<br>" +
								"Precio:"             +  "   " + m.getMicro().getPrecio();
						comboBoxCMicro.setToolTipText(tooltipText);
					}
				}
			});
			comboBoxCMicro.setBounds(175, 123, 255, 20);
			panelInfoTarjetaMadre.add(comboBoxCMicro);
			panelInfoTarjetaMadre.setVisible(false);

			comboBoxAtributo2 = new JComboBox();
			comboBoxAtributo2.setBounds(176, 157, 277, 20);
			FiltradodeProducto.add(comboBoxAtributo2);

			primeraVisualizacionAtributo();



			JLabel Componentelabel = new JLabel("Componentes:");
			Componentelabel.setFont(new Font("Tahoma", Font.BOLD, 15));
			Componentelabel.setBounds(12, 78, 141, 16);
			FiltradodeProducto.add(Componentelabel);


			comboBoxComponenetes = new JComboBox();
			comboBoxComponenetes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object seleccionado = comboBoxComponenetes.getSelectedItem();
					limpiarComboBox();
					elegirMarca(seleccionado);
				}
			});
			comboBoxComponenetes.setBounds(177, 77, 276, 20);
			FiltradodeProducto.add(comboBoxComponenetes);

			comboBoxMarca = new JComboBox();
			comboBoxMarca.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	

				}
			});
			comboBoxMarca.setBounds(177, 105, 276, 20);
			FiltradodeProducto.add(comboBoxMarca);

			JLabel lblMarca = new JLabel("Marca:");
			lblMarca.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblMarca.setBounds(12, 106, 162, 16);
			FiltradodeProducto.add(lblMarca);
			comboBoxModelo = new JComboBox();
			comboBoxModelo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					limpiarDatos();
					actualizarComponente((String) comboBoxModelo.getSelectedItem(), (String)comboBoxComponenetes.getSelectedItem());
				}
			});

			comboBoxModelo.setBounds(197, 432, 257, 20);
			FiltradodeProducto.add(comboBoxModelo);
			if (nombre == null) {
				llenarComboBox(comboBoxComponenetes, inicializaciones.InicializacionDeDatos.nameComponente());
				llenarComboBox(comboBoxMarca, inicializaciones.InicializacionDeDatos.marcasTeclado());
				Atributo1.setText("Retroiluminacion:");
				componenetesVentaLibreNV();
				comboBoxAtributo2.setVisible(false);
				ensamblar.setVisible(false);
				Atributo2.setVisible(false);
			} else {
				List<String> itemExp1 = inicializaciones.InicializacionDeDatos.nameComponente();
				itemExp1.remove(nombreDeComponente);
				itemExp1.add(0, nombreDeComponente);
				llenarComboBox(comboBoxComponenetes, (ArrayList<String>) itemExp1);
				componenetesVentaLibreNV();
			}


			JLabel lblNewLabel = new JLabel("Buscar Componente");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel.setBounds(12, 12, 332, 51);
			FiltradodeProducto.add(lblNewLabel);

			comboBoxAtributo1 = new JComboBox();
			comboBoxAtributo1.setBounds(177, 130, 276, 20);

			btnBuscar = new JButton("Buscar");
			btnBuscar.setContentAreaFilled(false);
			btnBuscar.setBorder(UIManager.getBorder("Button.border"));
			btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnBuscar.setBackground(Color.WHITE);
			btnBuscar.setIcon(new ImageIcon(VenderPieza.class.getResource("/gui/icons/lupa.png")));
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String decision = (String) comboBoxComponenetes.getSelectedItem();
					switch (decision) {
					case "Teclado":
						actualizarModeloTeclado((String) comboBoxMarca.getSelectedItem(), (String) comboBoxAtributo1.getSelectedItem());
						break;
					case "Tarjeta de Video":
						actualizarModeloTarjetaVideo((String) comboBoxMarca.getSelectedItem(), (String) comboBoxAtributo1.getSelectedItem());
						break;
					case "Tarjeta Madre":
						actualizarModeloTarjetaMadre((String) comboBoxMarca.getSelectedItem(), (String) comboBoxAtributo1.getSelectedItem());
						break;
					case "Microprocesador":
						actualizarModeloMicroprocesador((String) comboBoxMarca.getSelectedItem(), (String) comboBoxAtributo1.getSelectedItem(), (String) comboBoxAtributo2.getSelectedItem());
						break;
					case "Adaptador":
						actualizarModeloAdaptador((String) comboBoxMarca.getSelectedItem());
						break;
					case "Bocina":
						actualizarModeloBocina((String) comboBoxMarca.getSelectedItem(), (String) comboBoxAtributo1.getSelectedItem());
						break;
					case "Monitor":
						actualizarModeloMonitor((String) comboBoxMarca.getSelectedItem(), (String) comboBoxAtributo1.getSelectedItem());
						break;
					case "Ratón":
						actualizarModeloRaton((String) comboBoxMarca.getSelectedItem(), (String) comboBoxAtributo1.getSelectedItem());
						break;
					case "Memoria RAM":
						actualizarModeloMemoriaRAM((String) comboBoxMarca.getSelectedItem(), (String) comboBoxAtributo2.getSelectedItem(), (String) comboBoxAtributo1.getSelectedItem());
						break;
					case "Chasis":
						actualizarModeloChasis((String) comboBoxMarca.getSelectedItem(), (String) comboBoxAtributo1.getSelectedItem());
						break;		
					case "Disco Duro":
						actualizarModeloDiscoDuro((String) comboBoxMarca.getSelectedItem(), (String) comboBoxAtributo2.getSelectedItem(), (String) comboBoxAtributo1.getSelectedItem());
						break;
					case "Fuente":
						actualizarModeloFuente((String) comboBoxMarca.getSelectedItem(), (String) comboBoxAtributo1.getSelectedItem());
						break;
					default:
						break;
					}
				}
			});



			btnBuscar.setBounds(12, 431, 124, 20);
			FiltradodeProducto.add(btnBuscar);
			ensamblar = new JButton("Ensamblar");
			ensamblar.setVisible(false);
			ensamblar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i = JOptionPane.showConfirmDialog(null, "¿Seguro que desea ir a la página de ensamblado del producto?", "", 0, 3);
					if(i == 0) {
						if(comboBoxComponenetes.getSelectedItem().equals("Tarjeta Madre")) {
							try {
								Ensamblado dialog = new Ensamblado(m, VenderPieza.this, p, tiendaC);
								dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
								dialog.setLocationRelativeTo(null);
								dialog.setVisible(true);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			});
			ensamblar.setBounds(385, 43, 70, 22);
			FiltradodeProducto.add(ensamblar);


			FiltradodeProducto.add(comboBoxAtributo1);

			Atributo1 = new JLabel("New label");
			Atributo1.setFont(new Font("Tahoma", Font.BOLD, 15));
			Atributo1.setBounds(12, 132, 162, 16);
			FiltradodeProducto.add(Atributo1);

			Atributo2 = new JLabel("New label");
			Atributo2.setFont(new Font("Tahoma", Font.BOLD, 15));
			Atributo2.setBounds(12, 159, 162, 16);
			FiltradodeProducto.add(Atributo2);
			Object seleccionado = nombreDeComponente;
			limpiarComboBox();
			elegirMarca(seleccionado);

			primeraVisualizacionComponenetes();

		}
		{
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 902, 719);
			panel.setBackground(UIManager.getColor("Button.disabledShadow"));
			contentPanel.add(panel);
			panel.setLayout(null);
			JPanel ProductosAgregados = new JPanel();
			ProductosAgregados.setBounds(0, 504, 902, 177);
			ProductosAgregados.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
			ProductosAgregados.setBackground(UIManager.getColor("Button.disabledShadow"));
			panel.add(ProductosAgregados);
			ProductosAgregados.setLayout(new BorderLayout(0, 0));

			tableModel = new DefaultTableModel();
			tableModel.addColumn("No. Serie");
			tableModel.addColumn("Componenete");
			tableModel.addColumn("Marca");
			tableModel.addColumn("Modelo");
			tableModel.addColumn("Cantidad");
			tableModel.addColumn("Precio");

			table = new JTable(tableModel);
			table.setGridColor(new Color(135, 206, 235));
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
			ProductosAgregados.add(scrollPane, BorderLayout.CENTER);

			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new MatteBorder(2, 2, 1, 2, (Color) new Color(0, 0, 0)));
			panel_1.setBackground(Color.WHITE);
			panel_1.setBounds(0, 463, 902, 42);
			panel.add(panel_1);
			panel_1.setLayout(null);

			okButton_1 = new JButton("");
			okButton_1.setContentAreaFilled(false);
			okButton_1.setBorderPainted(false);
			okButton_1.setFocusPainted(false);
			okButton_1.setFocusTraversalKeysEnabled(false);
			okButton_1.setFocusable(false);
			okButton_1.setRequestFocusEnabled(false);
			okButton_1.setBackground(Color.WHITE);
			okButton_1.setBorder(null);
			okButton_1.setIcon(new ImageIcon(VenderPieza.class.getResource("/gui/icons/basura.png")));
			okButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar el producto seleccionado?", "", 0, 3);
					if(i == 0) {		
						int pos = table.getSelectedRow();
						if (pos != -1) {
							componentes.remove(pos);
							ComponenteOrdenador c = tiendaC.buscarComponente((String)table.getValueAt(pos, 0));
							tiendaC.actualizarCantidadComponenteAgregar(c, cantidad);
							((DefaultTableModel) table.getModel()).removeRow(pos);
							btnBuscar.doClick();
							actualizarTotal();
							if(componentes.isEmpty()) {
								btnCarrito.setIcon(new ImageIcon(VenderPieza.class.getResource("/gui/icons/carritovaciom.jpg")));
							}
						} else {
							JOptionPane.showMessageDialog(VenderPieza.this, "Antes de eliminar debe de seleccionar producto de la tabla");
						}
					}
				}
			});
			okButton_1.setActionCommand("OK");
			okButton_1.setBounds(847, 0, 43, 42);
			panel_1.add(okButton_1);
			JPanel ProductoEncontrado = new JPanel();
			ProductoEncontrado.setBounds(468, 0, 434, 463);
			panel.add(ProductoEncontrado);
			ProductoEncontrado.setBackground(Color.WHITE);
			ProductoEncontrado.setBorder(new MatteBorder(2, 2, 0, 2, (Color) new Color(0, 0, 0)));
			ProductoEncontrado.setLayout(null);

			JLabel lblComponenteEncontrado = new JLabel("Componente Encontrado");
			lblComponenteEncontrado.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblComponenteEncontrado.setBounds(41, 12, 402, 51);
			ProductoEncontrado.add(lblComponenteEncontrado);

			nombretext = new JTextField();
			nombretext.setEditable(false);
			nombretext.setBounds(175, 75, 220, 20);
			ProductoEncontrado.add(nombretext);
			nombretext.setColumns(10);

			modelotext = new JTextField();
			modelotext.setEditable(false);
			modelotext.setColumns(10);
			modelotext.setBounds(175, 136, 220, 20);
			ProductoEncontrado.add(modelotext);

			notext = new JTextField();
			notext.setEditable(false);
			notext.setColumns(10);
			notext.setBounds(175, 168, 220, 20);
			ProductoEncontrado.add(notext);

			preciotext = new JTextField();
			preciotext.setEditable(false);
			preciotext.setColumns(10);
			preciotext.setBounds(175, 200, 220, 20);
			ProductoEncontrado.add(preciotext);

			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNombre.setBounds(41, 75, 141, 16);
			ProductoEncontrado.add(lblNombre);

			JLabel lblModelo = new JLabel("Modelo:");
			lblModelo.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblModelo.setBounds(41, 137, 141, 16);
			ProductoEncontrado.add(lblModelo);

			JLabel lblNoDeSerie = new JLabel("No. de Serie:");
			lblNoDeSerie.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNoDeSerie.setBounds(41, 169, 141, 16);
			ProductoEncontrado.add(lblNoDeSerie);

			JLabel lblPrecio = new JLabel("Precio:");
			lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblPrecio.setBounds(41, 201, 141, 16);
			ProductoEncontrado.add(lblPrecio);

			JLabel lblCantidadExistente = new JLabel("Cantidad:");
			lblCantidadExistente.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblCantidadExistente.setBounds(41, 233, 141, 16);
			ProductoEncontrado.add(lblCantidadExistente);

			cantidadtxt = new JTextField();
			cantidadtxt.setEditable(false);
			cantidadtxt.setColumns(10);
			cantidadtxt.setBounds(175, 232, 220, 20);
			ProductoEncontrado.add(cantidadtxt);

			spinner = new JSpinner(new SpinnerNumberModel(0,0,100,1));
			spinner.setBounds(133, 435, 63, 22);
			ProductoEncontrado.add(spinner);
			SpinnerNumberModel modelo = new SpinnerNumberModel(0,0,100,1);
			spinner.setModel(modelo);


			JLabel lblCantidadExistente_1 = new JLabel("Cantidad:");
			lblCantidadExistente_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblCantidadExistente_1.setBounds(45, 437, 101, 16);
			ProductoEncontrado.add(lblCantidadExistente_1);

			JLabel lblCantidadExistente_1_1 = new JLabel("A\u00F1adir al carrito");
			lblCantidadExistente_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblCantidadExistente_1_1.setBounds(234, 437, 141, 16);
			ProductoEncontrado.add(lblCantidadExistente_1_1);

			btnCarrito = new JButton("");
			btnCarrito.setContentAreaFilled(false);
			btnCarrito.setBorder(null);
			btnCarrito.setBackground(Color.WHITE);
			btnCarrito.setIcon(new ImageIcon(VenderPieza.class.getResource("/gui/icons/carritovaciom.jpg")));
			btnCarrito.setBounds(367, 423, 42, 34);
			ProductoEncontrado.add(btnCarrito);
			btnCarrito.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!nombretext.getText().equals("")) {
						int num = 0;
						String numero = cantidadtxt.getText();
						int cantidadPieza = Integer.parseInt(numero);
						int sp = (int) spinner.getValue();
						if(nombretext.getText().isEmpty() || spinner.getValue().equals(num)){
							JOptionPane.showMessageDialog(VenderPieza.this, "Error. Debe de agregar algún producto al carrito");  
						}	
						else if(cantidadPieza < sp) {
							JOptionPane.showMessageDialog(VenderPieza.this, "Error. La cantidad deseada no esta disponible");  
						}
						else {
							ComponenteOrdenador c = null;
							String numSerie = notext.getText();
							float precio = Float.parseFloat(preciotext.getText());
							cantidad = (int) spinner.getValue();
							float result = precio * cantidad;
							String coste = String.valueOf(result);
							c = tiendaC.buscarComponente(numSerie);
							tableModel.addRow(new Object[]{numSerie, nombretext.getText(), MarcaEncontText.getText(), modelotext.getText(), spinner.getValue(), coste});
							componentes.add(c);
							extraida.add(c.getCantDisponible());
							tiendaC.actualizarCantidadComponente(c, cantidad);
							cantidadtxt.setText(String.valueOf(c.getCantDisponible()));
							cant.add(cantidad);
							actualizarTotal();
							btnCarrito.setIcon(new ImageIcon(VenderPieza.class.getResource("/gui/icons/photo_5062105677371124742_m.jpg")));
							ensamblado.add(false);
						}
					}
					else {
						JOptionPane.showMessageDialog(VenderPieza.this, "Error. No ha elegido ningún componente");  
					}
				}
			});



			JLabel lblMarca_1 = new JLabel("Marca:");
			lblMarca_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblMarca_1.setBounds(41, 107, 141, 16);
			ProductoEncontrado.add(lblMarca_1);

			MarcaEncontText = new JTextField();
			MarcaEncontText.setEditable(false);
			MarcaEncontText.setColumns(10);
			MarcaEncontText.setBounds(175, 107, 220, 20);
			ProductoEncontrado.add(MarcaEncontText);

			totalFactura = new JTextField();
			totalFactura.setFont(new Font("Tahoma", Font.BOLD, 15));
			totalFactura.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
			totalFactura.setEditable(false);
			totalFactura.setEnabled(false);
			totalFactura.setBounds(786, 682, 116, 37);
			panel.add(totalFactura);
			totalFactura.setColumns(10);


			JLabel lblNewLabel_1 = new JLabel("Total:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1.setBounds(727, 693, 50, 16);
			panel.add(lblNewLabel_1);


		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 0, 0)));
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Atr\u00E1s");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int i = JOptionPane.showConfirmDialog(null, "¿Seguro que desea salir? Los cambios realizados no serán guardados", "", 0, 3);
						if(i==0) {
							dispose();
							componentes.clear();
						}
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			{
				JButton okButton = new JButton("Aceptar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(actualizarLista() == true) {
							JOptionPane.showMessageDialog(VenderPieza.this, "Cambios guardados satisfactoriamente");
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

	private boolean actualizarLista() {
		boolean act = false;
		obtenerObjeto();
		if (!componentes.isEmpty() ) {
			LocalDate fecha = LocalDate.now();
			f = new Factura(fecha);
			f.setCantidadXPieza(cant);
			f.setCom(componentes);
			f.setEnsamblado(ensamblado);
			f.setPrecioEnsamblado(0);
			tiendaC.agregarFactura(f);
			act = true;
		} else {
			JOptionPane.showMessageDialog(VenderPieza.this, "No se ha realizado ningún cambio o las listas no tienen el mismo tamaño.");
		}
		return act;
	}
	private void primeraVisualizacionComponenetes() {
		if (nombre != null) {
			if (nombre.equals("Tarjeta Madre") || nombre.equals("Microprocesador") || nombre.equals("Disco Duro") || nombre.equals("Memoria RAM")) {
				if (spinnerAtributo2  != null) spinnerAtributo2.setVisible(true);
				ensamblar.setEnabled(true);


			} else {
				if (spinnerAtributo2  != null) spinnerAtributo2.setVisible(false);

			}
		} else {
			System.out.println("Error: nombre es null");
		}
	}
	private void primeraVisualizacionAtributo() {
		if (nombre != null) {
			if (nombre.equals("Tarjeta Madre") || nombre.equals("Microprocesador") || nombre.equals("Disco Duro") || nombre.equals("Memoria RAM")) {
				if (Atributo2 != null) Atributo2.setVisible(true);
			} else {
				if (Atributo2 != null) Atributo2.setVisible(false);
			}
		} else {
			System.out.println("Error: nombre es null");
		}
	}
	private void componenetesVentaLibreNV() {
		if (Atributo2 != null) Atributo2.setVisible(false);
		if (comboBoxAtributo2 != null) comboBoxAtributo2.setVisible(false);
		if(ensamblar!= null) ensamblar.setVisible(false);
	}

	private void componenetesVentaLibreV() {
		if (Atributo2 != null) Atributo2.setVisible(true);
		if (spinnerAtributo2  != null) spinnerAtributo2.setVisible(true);

		repaint();
		validate();

	}
	private void componenetesVentaLibreMicro() {
		if (Atributo2 != null) Atributo2.setVisible(true);
		if (spinnerAtributo2  != null) spinnerAtributo2.setVisible(true);

		repaint();
		validate();

	}
	private void llenarComboBox(JComboBox<String> comboBox, ArrayList<String> items) {
		comboBox.removeAllItems(); 
		for (String item : items) {
			comboBox.addItem(item);
		}
	}

	/*****************Funcion para elegir las marcas************************************/
	@SuppressWarnings({ "unchecked" })
	private void elegirMarca(Object seleccionado) {
		if (comboBoxMarca != null && comboBoxAtributo1 != null) {
			comboBoxAtributo1.setVisible(true); 
			String nombreC = seleccionado.toString();
			ArrayList<String> Decision = new ArrayList<>();
			Decision.add("Sí");
			Decision.add("No");
			ensamblar.setVisible(false);
			switch (nombreC) {
			case "Teclado":
				Atributo1.setVisible(true);
				llenarComboBox(comboBoxMarca, inicializaciones.InicializacionDeDatos.marcasTeclado());
				Atributo1.setText("Retroiluminacion:");
				llenarComboBox(comboBoxAtributo1, Decision);
				componenetesVentaLibreNV();
				ensamblar.setVisible(false);
				comboBoxAtributo2.setVisible(false);
				panelInfoTarjetaMadre.setVisible(false);
				break;
			case "Tarjeta de Video":
				Atributo1.setVisible(true);
				llenarComboBox(comboBoxMarca, inicializaciones.InicializacionDeDatos.marcasTarjetaVideos());
				Atributo1.setText("Refrigeración:");
				llenarComboBox(comboBoxAtributo1, inicializaciones.InicializacionDeDatos.refrigeracion());
				componenetesVentaLibreNV();
				comboBoxModelo.removeAllItems();
				ensamblar.setVisible(false);
				comboBoxAtributo2.setVisible(false);
				panelInfoTarjetaMadre.setVisible(false);
				break;
			case "Tarjeta Madre":
				Atributo1.setVisible(true);
				llenarComboBox(comboBoxMarca, inicializaciones.InicializacionDeDatos.marcasTarjetaMadre());
				Atributo1.setText("Conector:");
				llenarComboBox(comboBoxAtributo1, inicializaciones.InicializacionDeDatos.conectores());
				componenetesVentaLibreMicro();
				Atributo2.setVisible(false);
				ensamblar.setVisible(false);
				comboBoxModelo.removeAllItems();
				comboBoxAtributo2.setVisible(false);
				panelInfoTarjetaMadre.setVisible(false);
				break;
			case "Microprocesador":
				Atributo1.setVisible(true);
				llenarComboBox(comboBoxMarca, inicializaciones.InicializacionDeDatos.marcasMicroProcesadores());
				if(comboBoxMarca.getSelectedItem().equals("AMD")) {
					llenarComboBox(comboBoxAtributo1, inicializaciones.InicializacionDeDatos.conexionesAMD());
				}
				else {
					llenarComboBox(comboBoxAtributo1, inicializaciones.InicializacionDeDatos.conexionesIntel());	
				}
				componenetesVentaLibreV();
				Atributo1.setText("Conexión:");
				comboBoxModelo.removeAllItems();
				Atributo2.setText("Procesamiento:");
				comboBoxAtributo2.setVisible(true);
				llenarComboBox(comboBoxAtributo2, inicializaciones.InicializacionDeDatos.velocidadaMicro());
				panelInfoTarjetaMadre.setVisible(false);
				break;
			case "Adaptador":
				llenarComboBox(comboBoxMarca, inicializaciones.InicializacionDeDatos.marcasAdaptadores());
				Atributo1.setVisible(false);
				comboBoxAtributo1.setVisible(false);
				componenetesVentaLibreNV();
				comboBoxModelo.removeAllItems();
				ensamblar.setVisible(false);
				comboBoxAtributo2.setVisible(false);
				panelInfoTarjetaMadre.setVisible(false);
				break;
			case "Bocina":
				llenarComboBox(comboBoxMarca, inicializaciones.InicializacionDeDatos.marcasBocinas());
				Atributo1.setVisible(true);
				Atributo1.setText("Conectividad:");
				llenarComboBox(comboBoxAtributo1, inicializaciones.InicializacionDeDatos.conectividad());
				componenetesVentaLibreNV();
				comboBoxModelo.removeAllItems();
				ensamblar.setVisible(false);
				comboBoxAtributo2.setVisible(false);
				panelInfoTarjetaMadre.setVisible(false);
				break;
			case "Monitor":
				Atributo1.setVisible(true);
				llenarComboBox(comboBoxMarca, inicializaciones.InicializacionDeDatos.marcasPantalla());
				Atributo1.setText("Resolución:");
				llenarComboBox(comboBoxAtributo1, inicializaciones.InicializacionDeDatos.resolucionVideo());
				componenetesVentaLibreNV();
				comboBoxModelo.removeAllItems();
				ensamblar.setVisible(false);
				comboBoxAtributo2.setVisible(false);
				panelInfoTarjetaMadre.setVisible(false);
				break;
			case "Ratón":
				Atributo1.setVisible(true);
				llenarComboBox(comboBoxMarca, inicializaciones.InicializacionDeDatos.marcasRaton());
				Atributo1.setText("Conectividad:");
				llenarComboBox(comboBoxAtributo1, inicializaciones.InicializacionDeDatos.conectividad());
				componenetesVentaLibreNV();
				comboBoxModelo.removeAllItems();
				ensamblar.setVisible(false);
				comboBoxAtributo2.setVisible(false);
				panelInfoTarjetaMadre.setVisible(false);
				break;
			case "Memoria RAM":
				Atributo1.setVisible(true);
				llenarComboBox(comboBoxMarca, inicializaciones.InicializacionDeDatos.marcasMemoriasRAM());
				Atributo2.setText("Espacio:");
				componenetesVentaLibreV();
				Atributo1.setText("Tipo de Memoria:");
				llenarComboBox(comboBoxAtributo1, inicializaciones.InicializacionDeDatos.tiposDeMemoriaRAM());
				comboBoxModelo.removeAllItems();
				Atributo2.setText("Espacio:");
				comboBoxAtributo2.setVisible(true);
				llenarComboBox(comboBoxAtributo2, inicializaciones.InicializacionDeDatos.espacioRAM());
				panelInfoTarjetaMadre.setVisible(false);
				break;
			case "Chasis":
				Atributo1.setVisible(true);
				llenarComboBox(comboBoxMarca, inicializaciones.InicializacionDeDatos.marcasChasis());
				Atributo1.setText("Material:");
				llenarComboBox(comboBoxAtributo1, inicializaciones.InicializacionDeDatos.materialesChasis());
				componenetesVentaLibreNV();
				comboBoxModelo.removeAllItems();
				ensamblar.setVisible(false);
				comboBoxAtributo2.setVisible(false);
				panelInfoTarjetaMadre.setVisible(false);
				break;		
			case "Disco Duro":
				Atributo1.setVisible(true);
				llenarComboBox(comboBoxMarca, inicializaciones.InicializacionDeDatos.marcasDiscoD());
				Atributo2.setText("Capacidad:");
				Atributo1.setText("Conexiones:");
				llenarComboBox(comboBoxAtributo1, inicializaciones.InicializacionDeDatos.conexionesDiscoDuro());
				componenetesVentaLibreV();
				comboBoxModelo.removeAllItems();
				comboBoxAtributo2.setVisible(true);
				llenarComboBox(comboBoxAtributo2, inicializaciones.InicializacionDeDatos.capacidadDiscoDuroTB());
				panelInfoTarjetaMadre.setVisible(false);
				break;
			case "Fuente":
				llenarComboBox(comboBoxMarca, inicializaciones.InicializacionDeDatos.marcasFuente());
				Atributo1.setVisible(true);
				Atributo1.setText("Eficiencia:");
				llenarComboBox(comboBoxAtributo1, inicializaciones.InicializacionDeDatos.eficiencia());
				componenetesVentaLibreNV();
				comboBoxModelo.removeAllItems();
				ensamblar.setVisible(false);
				comboBoxAtributo2.setVisible(false);
				panelInfoTarjetaMadre.setVisible(false);
				break;
			default:
				break;
			}
		} else {
			System.out.println("Uno o más comboBox son null");
		}
	}
	@SuppressWarnings("unused")
	public void actualizarDatos(String combobox1, String combobox2,String componente, String modelo) {
		try {
			panelInfoTarjetaMadre.setVisible(true);
			comboBoxCRAM.removeAllItems();
			comboBoxCDisco.removeAllItems();
			m = tiendaC.encontComponente(combobox1, combobox2, componente, modelo);
			ArrayList<String> ramList = new ArrayList<String>();
			ArrayList<String> discoList = new ArrayList<String>();
			ArrayList<String> microList = new ArrayList<String>();
			for(int i = 0; i < m.getMemoriasR().size(); i++) {
				ramList.add(i, m.getMemoriasR().get(i).getMarca() + "   " +  m.getMemoriasR().get(i).getModelo());
			}
			if(ramList != null) {
				llenarComboBox(comboBoxCRAM, ramList);
			}
			else {
				limpiar();
			}
			for(int i = 0; i < m.getDiscos().size(); i++) {
				discoList.add(i, m.getDiscos().get(i).getMarca() + "   " +  m.getDiscos().get(i).getModelo());
			}
			if(discoList != null) {
				llenarComboBox(comboBoxCDisco, discoList);
			}
			else {
				limpiar();
			}
			microList.add(m.getMicro().getMarca() + "   " +  m.getMicro().getModelo());

			if(microList!= null) {
				llenarComboBox(comboBoxCMicro, microList);
			}
			else {
				limpiar();
			}
		}
		catch(Exception e) {

		}
	}

	private void limpiar() {
		comboBoxCDisco.removeAllItems();
		comboBoxCMicro.removeAllItems();
		comboBoxCRAM.removeAllItems();
	}

	/*******************************Teclado**********************************/
	@SuppressWarnings("unchecked")
	private void actualizarModeloTeclado(String combo1, String combo2) {
		try {
			modelo.clear();
			comboBoxModelo.removeAllItems();
			modelo = tiendaC.modelo("Teclado", combo1, combo2);
			if (modelo != null && !modelo.isEmpty()) {
				llenarComboBox(comboBoxModelo, modelo);
				comboBoxModelo.setEnabled(true);
			} else {
				limpiarDatos();
				comboBoxModelo.setEnabled(false);
				JOptionPane.showMessageDialog(VenderPieza.this, "Componente no encontrado");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(VenderPieza.this, "Error al actualizar el modelo: " + e.getMessage());
		}
	}
	/*******************************Adaptador**********************************/
	@SuppressWarnings("unchecked")
	private void actualizarModeloAdaptador(String combo1) {
		try {
			modelo.clear();
			comboBoxModelo.removeAllItems();
			modelo = tiendaC.modeloAdaptador("Adaptador", combo1);
			if (modelo != null && !modelo.isEmpty()) {
				llenarComboBox(comboBoxModelo, modelo);
				comboBoxModelo.setEnabled(true);
			} else {
				limpiarDatos();
				comboBoxModelo.setEnabled(false);
				JOptionPane.showMessageDialog(VenderPieza.this, "Componente no encontrado");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(VenderPieza.this, "Error al actualizar el modelo: " + e.getMessage());
		}
	}
	/*******************************Bocina**********************************/
	@SuppressWarnings("unchecked")
	private void actualizarModeloBocina(String combo1, String combo2) {
		try {
			modelo.clear();
			comboBoxModelo.removeAllItems();
			modelo = tiendaC.modeloBocina("Bocina", combo1, combo2);
			if (modelo != null && !modelo.isEmpty()) {
				llenarComboBox(comboBoxModelo, modelo);
				comboBoxModelo.setEnabled(true);
			} else {
				limpiarDatos();
				comboBoxModelo.setEnabled(false);
				JOptionPane.showMessageDialog(VenderPieza.this, "Componente no encontrado");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(VenderPieza.this, "Error al actualizar el modelo: " + e.getMessage());
		}
	}
	/*******************************Adaptador**********************************/
	@SuppressWarnings("unchecked")
	private void actualizarModeloChasis(String combo1, String combo2) {
		try {
			modelo.clear();
			comboBoxModelo.removeAllItems();
			modelo = tiendaC.modeloChasis("Chasis", combo1, combo2);
			if (modelo != null && !modelo.isEmpty()) {
				llenarComboBox(comboBoxModelo, modelo);
				comboBoxModelo.setEnabled(true);
			} else {
				limpiarDatos();
				comboBoxModelo.setEnabled(false);
				JOptionPane.showMessageDialog(VenderPieza.this, "Componente no encontrado");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(VenderPieza.this, "Error al actualizar el modelo: " + e.getMessage());
		}	
	}
	/*******************************Monitor**********************************/
	@SuppressWarnings("unchecked")
	private void actualizarModeloMonitor(String combo1, String combo2) {
		try {
			modelo.clear();
			comboBoxModelo.removeAllItems();
			modelo = tiendaC.modeloMonitor("Monitor", combo1, combo2);
			if (modelo != null && !modelo.isEmpty()) {
				llenarComboBox(comboBoxModelo, modelo);
				comboBoxModelo.setEnabled(true);
			} else {
				limpiarDatos();
				comboBoxModelo.setEnabled(false);
				JOptionPane.showMessageDialog(VenderPieza.this, "Componente no encontrado");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(VenderPieza.this, "Error al actualizar el modelo: " + e.getMessage());
		}
	}

	/*******************************Tarjeta de Video **********************************/
	@SuppressWarnings("unchecked")
	private void actualizarModeloTarjetaVideo(String combo1, String combo2) {
		try {
			modelo.clear();
			comboBoxModelo.removeAllItems();
			modelo = tiendaC.modeloTarjetaVideo("TarjetaDeVideo", combo1, combo2);
			if (modelo != null && !modelo.isEmpty()) {
				llenarComboBox(comboBoxModelo, modelo);
				comboBoxModelo.setEnabled(true);
			} else {
				limpiarDatos();
				comboBoxModelo.setEnabled(false);
				JOptionPane.showMessageDialog(VenderPieza.this, "Componente no encontrado");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(VenderPieza.this, "Error al actualizar el modelo: " + e.getMessage());
		}

	}
	/***************************************Raton****************************************/
	@SuppressWarnings("unchecked")
	private void actualizarModeloRaton(String combo1, String combo2) {
		try {
			modelo.clear();
			comboBoxModelo.removeAllItems();
			modelo = tiendaC.modeloMouse("Mouse", combo1, combo2);
			if (modelo != null && !modelo.isEmpty()) {
				llenarComboBox(comboBoxModelo, modelo);
				comboBoxModelo.setEnabled(true);
			} else {
				limpiarDatos();
				comboBoxModelo.setEnabled(false);
				JOptionPane.showMessageDialog(VenderPieza.this, "Componente no encontrado");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(VenderPieza.this, "Error al actualizar el modelo: " + e.getMessage());
		}
	}
	/*****************************************Fuente************************************************/
	@SuppressWarnings("unchecked")
	private void actualizarModeloFuente(String combo1, String combo2) {
		try {
			modelo.clear();
			comboBoxModelo.removeAllItems();
			modelo = tiendaC.modeloFuente("Mouse", combo1, combo2);
			if (modelo != null && !modelo.isEmpty()) {
				llenarComboBox(comboBoxModelo, modelo);
				comboBoxModelo.setEnabled(true);
			} else {
				limpiarDatos();
				comboBoxModelo.setEnabled(false);
				JOptionPane.showMessageDialog(VenderPieza.this, "Componente no encontrado");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(VenderPieza.this, "Error al actualizar el modelo: " + e.getMessage());
		}
	}
	/***********************************Microprocesador*******************************************/
	@SuppressWarnings("unchecked")
	private void actualizarModeloMicroprocesador(String combo1, String combo2, String combo3) {
		try {
			modelo.clear();
			comboBoxModelo.removeAllItems();
			modelo = tiendaC.modeloMicroprocesador("Microprocesador", combo1, combo2,  combo3);
			if (modelo != null && !modelo.isEmpty()) {
				llenarComboBox(comboBoxModelo, modelo);
				comboBoxModelo.setEnabled(true);
			} else {
				limpiarDatos();
				comboBoxModelo.setEnabled(false);
				JOptionPane.showMessageDialog(VenderPieza.this, "Componente no encontrado");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(VenderPieza.this, "Error al actualizar el modelo: " + e.getMessage());
		}
	}
	/***********************************DiscoDuro*******************************************/
	@SuppressWarnings("unchecked")
	private void actualizarModeloDiscoDuro(String combo1, String combo3, String combo2) {
		try {
			modelo.clear();
			comboBoxModelo.removeAllItems();
			modelo = tiendaC.modeloDiscoDuro("DiscoDuro", combo1, combo3, combo2);
			if (modelo != null && !modelo.isEmpty()) {
				llenarComboBox(comboBoxModelo, modelo);
				comboBoxModelo.setEnabled(true);
			} else {
				limpiarDatos();
				comboBoxModelo.setEnabled(false);
				JOptionPane.showMessageDialog(VenderPieza.this, "Componente no encontrado");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(VenderPieza.this, "Error al actualizar el modelo: " + e.getMessage());
		}
	}
	/*************************************Memoria RAM*********************************************/
	@SuppressWarnings("unchecked")
	private void actualizarModeloMemoriaRAM(String combo1, String combo3, String combo2) {
		try {
			modelo.clear();
			comboBoxModelo.removeAllItems();
			modelo = tiendaC.modeloMemoriaRam("MemoriaRAM", combo1, combo3, combo2);
			if (modelo != null && !modelo.isEmpty()) {
				llenarComboBox(comboBoxModelo, modelo);	
				comboBoxModelo.setEnabled(true);
			} else {
				limpiarDatos();
				comboBoxModelo.setEnabled(false);
				JOptionPane.showMessageDialog(VenderPieza.this, "Componente no encontrado");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(VenderPieza.this, "Error al actualizar el modelo: " + e.getMessage());
		}
	}
	/*************************************Tarjeta Madre*********************************************/
	@SuppressWarnings("unchecked")
	private void actualizarModeloTarjetaMadre(String combo1, String combo2) {
		try {
			modelo.clear();
			comboBoxModelo.removeAllItems();
			ArrayList<TarjetaMadre> m = new ArrayList<TarjetaMadre>();
			m = tiendaC.modeloTarjetaMadre("TarjetaMadre", combo1, combo2);
			for(int i = 0; i< m.size(); i++) {
				modelo.add(m.get(i).getModelo());
			}
			if (modelo != null && !modelo.isEmpty()) {
				llenarComboBox(comboBoxModelo, modelo);
				comboBoxModelo.setEnabled(true);
			} else {
				limpiarDatos();
				comboBoxModelo.setEnabled(false);
				JOptionPane.showMessageDialog(VenderPieza.this, "Componente no encontrado");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(VenderPieza.this, "Error al actualizar el modelo: " + e.getMessage());
		}	
	}
	private void limpiarComboBox() {
		comboBoxMarca.removeAllItems();
	}

	private void actualizarComponente(String modelo, String componente) {
		String nombreC = componente;
		switch (nombreC) {
		case "Memoria RAM":
			try {
				MemoriaRam memoriaR = tiendaC.encontMemoriaRAM("MemoriaRam", (String) comboBoxMarca.getSelectedItem(), (String) comboBoxAtributo2.getSelectedItem(), (String) comboBoxAtributo1.getSelectedItem(), modelo);
				if (memoriaR != null) {
					System.out.print("a");
					nombretext.setText("Memoria RAM");
					MarcaEncontText.setText(memoriaR.getMarca());
					modelotext.setText(memoriaR.getModelo());
					notext.setText(memoriaR.getNumSerie());
					preciotext.setText(String.valueOf(memoriaR.getPrecio()));
					cantidadtxt.setText(String.valueOf(memoriaR.getCantDisponible()));
				} else {
					limpiarDatos();
				}
			}
			catch(Exception e) {
			}
			break;
		case "Teclado":
			try {	
				Teclado t = tiendaC.encontTeclado("Teclado", (String) comboBoxMarca.getSelectedItem(), (String) comboBoxAtributo1.getSelectedItem(), modelo);
				if (t != null) {
					nombretext.setText("Teclado");
					MarcaEncontText.setText(t.getMarca());
					modelotext.setText(t.getModelo());
					notext.setText(t.getNumSerie());
					preciotext.setText(String.valueOf(t.getPrecio()));
					cantidadtxt.setText(String.valueOf(t.getCantDisponible()));
				} else {
					limpiarDatos(); 
				}
			} catch (Exception e) {
			}
			break;
		case "Adaptador":
			try {
				Adaptador a = tiendaC.encontAdaptador("Teclado", (String) comboBoxMarca.getSelectedItem(), modelo);
				if (a != null) {
					nombretext.setText("Adaptador");
					MarcaEncontText.setText(a.getMarca());
					modelotext.setText(a.getModelo());
					notext.setText(a.getNumSerie());
					preciotext.setText(String.valueOf(a.getPrecio()));
					cantidadtxt.setText(String.valueOf(a.getCantDisponible()));
				} else {
					limpiarDatos();
				}
			} catch (Exception e) {
			}
			break;
		case "Bocina":
			try {
				Bocina b = tiendaC.encontBocina("Bocina", (String) comboBoxMarca.getSelectedItem(), (String) comboBoxAtributo1.getSelectedItem(), modelo);
				if (b != null) {
					nombretext.setText("Bocina");
					MarcaEncontText.setText(b.getMarca());
					modelotext.setText(b.getModelo());
					notext.setText(b.getNumSerie());
					preciotext.setText(String.valueOf(b.getPrecio()));
					cantidadtxt.setText(String.valueOf(b.getCantDisponible()));
				} else {
					limpiarDatos();
				}
			} catch (Exception e) {
			}
			break;
		case "Chasis":
			try {
				Chasis c = tiendaC.encontChasis("Chasis", (String) comboBoxMarca.getSelectedItem(), (String) comboBoxAtributo1.getSelectedItem(), modelo);
				if (c != null) {
					nombretext.setText("Chasis");
					MarcaEncontText.setText(c.getMarca());
					modelotext.setText(c.getModelo());
					notext.setText(c.getNumSerie());
					preciotext.setText(String.valueOf(c.getPrecio()));
					cantidadtxt.setText(String.valueOf(c.getCantDisponible()));
				} else {
					limpiarDatos();
				}
			} catch (Exception e) {
			}
			break;
		case "Monitor":
			try {
				Monitor m = tiendaC.encontMonitor("Monitor", (String) comboBoxMarca.getSelectedItem(), (String) comboBoxAtributo1.getSelectedItem(), modelo);
				if (m != null) {
					nombretext.setText("Monitor");
					MarcaEncontText.setText(m.getMarca());
					modelotext.setText(m.getModelo());
					notext.setText(m.getNumSerie());
					preciotext.setText(String.valueOf(m.getPrecio()));
					cantidadtxt.setText(String.valueOf(m.getCantDisponible()));
				} else {
					limpiarDatos();
				}
			} catch (Exception e) {
			}
			break;
		case "Tarjeta de Video":
			try {
				TarjetaDeVideo t = tiendaC.encontTarjetaVideo("TarjetaDeVideo", (String) comboBoxMarca.getSelectedItem(), (String) comboBoxAtributo1.getSelectedItem(), modelo);
				if (t != null) {
					nombretext.setText("Tarjeta de Video");
					MarcaEncontText.setText(t.getMarca());
					modelotext.setText(t.getModelo());
					notext.setText(t.getNumSerie());
					preciotext.setText(String.valueOf(t.getPrecio()));
					cantidadtxt.setText(String.valueOf(t.getCantDisponible()));
				} else {
					limpiarDatos();
				}
			} catch (Exception e) {
			}
			break;
		case "Ratón":
			try {
				Mouse b = tiendaC.encontMouse("Mouse", (String) comboBoxMarca.getSelectedItem(), (String) comboBoxAtributo1.getSelectedItem(), modelo);
				if (b != null) {
					nombretext.setText("Ratón");
					MarcaEncontText.setText(b.getMarca());
					modelotext.setText(b.getModelo());
					notext.setText(b.getNumSerie());
					preciotext.setText(String.valueOf(b.getPrecio()));
					cantidadtxt.setText(String.valueOf(b.getCantDisponible()));
				} else {
					limpiarDatos();
				}
			} catch (Exception e) {
			}
			break;
		case "Fuente":
			try {
				Fuente f = tiendaC.encontFuente("Fuente", (String) comboBoxMarca.getSelectedItem(), (String) comboBoxAtributo1.getSelectedItem(), modelo);
				if (f != null) {
					nombretext.setText("Fuente");
					MarcaEncontText.setText(f.getMarca());
					modelotext.setText(f.getModelo());
					notext.setText(f.getNumSerie());
					preciotext.setText(String.valueOf(f.getPrecio()));
					cantidadtxt.setText(String.valueOf(f.getCantDisponible()));
				} else {
					limpiarDatos();
				}
			} catch (Exception e) {
			}
			break;
		case "Microprocesador":
			try {
				Microprocesador m = tiendaC.encontMicro("Microprocesador", (String) comboBoxMarca.getSelectedItem(), (String) comboBoxAtributo1.getSelectedItem(), (String) comboBoxAtributo2.getSelectedItem(),modelo);
				if (m != null) {
					nombretext.setText("Microprocesador");
					MarcaEncontText.setText(m.getMarca());
					modelotext.setText(m.getModelo());
					notext.setText(m.getNumSerie());
					preciotext.setText(String.valueOf(m.getPrecio()));
					cantidadtxt.setText(String.valueOf(m.getCantDisponible()));
				} else {
					limpiarDatos();
				}
			} catch (Exception e) {
			}
			break;
		case "Tarjeta Madre":
			actualizarDatos((String)comboBoxMarca.getSelectedItem(), (String)comboBoxAtributo1.getSelectedItem(), componente, modelo);
			ensamblar.setVisible(true);
			try {
				if(m != null) {
					nombretext.setText("Tarjeta Madre");
					MarcaEncontText.setText(m.getMarca());
					modelotext.setText(m.getModelo());
					notext.setText(m.getNumSerie());
					preciotext.setText(String.valueOf(m.getPrecio()));
					cantidadtxt.setText(String.valueOf(m.getCantDisponible()));
				}
				else {
					limpiarDatos();
				}
			}
			catch(Exception e) {
			}
			break;
		case "Disco Duro":
			try {
				DiscoDuro d = tiendaC.encontDiscoDuro("DiscoDuro", (String) comboBoxMarca.getSelectedItem(), (String) comboBoxAtributo2.getSelectedItem(), (String) comboBoxAtributo1.getSelectedItem(), modelo);
				if (d != null) {
					nombretext.setText("Disco Duro");
					MarcaEncontText.setText(d.getMarca());
					modelotext.setText(d.getModelo());
					notext.setText(d.getNumSerie());
					preciotext.setText(String.valueOf(d.getPrecio()));
					cantidadtxt.setText(String.valueOf(d.getCantDisponible()));
				} else {
					limpiarDatos();
				}
			} catch (Exception e) {
			}
			break;
		default:
			break;
		}
	}



	public void obtenerObjeto() {
		for(int j = 0; j < tableModel.getRowCount(); j++) {
			cant.add((Integer) tableModel.getValueAt(j, 4));
		}
	}
	private void limpiarDatos() {
		nombretext.setText("");
		modelotext.setText("");
		MarcaEncontText.setText("");
		notext.setText("");
		preciotext.setText("");
		cantidadtxt.setText("");

	}
	private void actualizarTotal() {
		float totalF = 0;
		float t = 0;
		for(int i = 0; i < tableModel.getRowCount(); i++) {
			totalF = Float.valueOf((String) tableModel.getValueAt(i, 5));
			t += Float.valueOf(totalF);
		}
		totalFactura.setText(String.valueOf(t));
	}
}