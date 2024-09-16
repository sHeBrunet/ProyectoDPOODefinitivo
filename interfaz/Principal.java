package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import inicializaciones.InicializacionDeDatos;
import logica.ManejoDeSesion;
import logica.TiendaDeComputadoras;
import login.Login;
@SuppressWarnings("serial")

public class Principal extends JFrame {
	private TiendaDeComputadoras tiendaC;

	private JPanel panelGeneral;
	private JButton btnButtonTarjetaMadre;
	private JButton btnButtonMicroprocesador;
	private JButton btnButtonmemoriasRAM;
	private JButton btnButtonTarjetasVideo;
	private JButton btnButtonDiscosDuros;
	private JButton btnButtonFuente;
	private JButton btnButtonMonitores;
	private JButton btnButtonTeclado;
	private JButton btnButtonRaton;
	private JButton btnButtonBocina;
	private JButton btnButtonChasis;
	private JButton btnButtonOtro;
	private String nombredeComponente;
	private JMenuItem CerrarSesion;
	private JMenuItem CerrarPrograma;
	private JMenuItem Informacion;
	private JMenuItem VenderProductos;
	private JMenuItem AgregarProductos;
	private JMenuItem ListaDeProductos;
	private JMenuItem Facturas;
	private JMenuItem ListaDeTrabajadores;
	private JMenuItem AgregarTrabajador;

	public Principal(TiendaDeComputadoras tienda, ManejoDeSesion manejoDeSesion) {
		tiendaC = tienda;
		setTitle("S.A.D PC Store");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/gui/icons/logoPeque\u00F1o1.jpg")));
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 746);
		inicializarDatos();


		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Tahoma", Font.BOLD, 15));
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);

		JMenu MenuInicio = new JMenu("Inicio");
		MenuInicio.setBackground(Color.WHITE);
		menuBar.add(MenuInicio);

		Informacion = new JMenuItem("Informaci\u00F3n");
		Informacion.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		Informacion.setBackground(Color.WHITE);
		Informacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Informacion dialog = new Informacion(Principal.this, tiendaC);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				} catch (Exception e4) {
					e4.printStackTrace();
				}
			}
		});
		Informacion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
		MenuInicio.add(Informacion);

		CerrarSesion = new JMenuItem("Cerrar Sesi\u00F3n");
		CerrarSesion.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		CerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ManejoDeSesion manejo = ManejoDeSesion.getInstance();
					if (manejo != null) {
						manejo.cerrarSesion();
						dispose();
						Login frame = new Login();
						frame.setVisible(true);
					} else {
						System.out.println("ManejoDeSesion es null");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error al cerrar sesión.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		CerrarSesion.setBackground(Color.WHITE);
		CerrarSesion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		MenuInicio.add(CerrarSesion);

		CerrarPrograma = new JMenuItem("Cerrar Programa");
		CerrarPrograma.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		CerrarPrograma.setBackground(Color.WHITE);
		CerrarPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		CerrarPrograma.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, InputEvent.ALT_MASK));
		MenuInicio.add(CerrarPrograma);

		JMenu MenuProductos = new JMenu("Productos");
		MenuProductos.setBackground(Color.WHITE);
		menuBar.add(MenuProductos);

		ListaDeProductos = new JMenuItem("Listado de Productos");
		ListaDeProductos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		ListaDeProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ListadoDeProductos dialog = new ListadoDeProductos(Principal.this, tiendaC);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				} catch (Exception e6) {
					e6.printStackTrace();
				}
			}
		});
		ListaDeProductos.setBackground(Color.WHITE);
		ListaDeProductos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		MenuProductos.add(ListaDeProductos);

		AgregarProductos = new JMenuItem("Agregar Productos ");
		AgregarProductos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		AgregarProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AgregarProducto dialog = new AgregarProducto(Principal.this, tiendaC);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				} catch (Exception e5) {
					e5.printStackTrace();
				}
			}
		});
		AgregarProductos.setBackground(Color.WHITE);
		AgregarProductos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		MenuProductos.add(AgregarProductos);

		VenderProductos = new JMenuItem("Vender Productos");
		VenderProductos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		VenderProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (tiendaC != null) {
						VenderPieza dialog = new VenderPieza(Principal.this, tiendaC, "Adaptador");
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setLocationRelativeTo(null);
						dialog.setVisible(true);
					} else {
						System.out.println("Error: tiendaC es null");
					}
				} catch (Throwable e3) {
					e3.printStackTrace();
				}
			}
		});
		VenderProductos.setBackground(Color.WHITE);
		VenderProductos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		MenuProductos.add(VenderProductos);

		Facturas = new JMenuItem("Facturas");
		Facturas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		Facturas.setBackground(Color.WHITE);
		Facturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!tiendaC.getFacturas().isEmpty()) {
						Facturas dialog = new Facturas(Principal.this, tiendaC);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setLocationRelativeTo(null);
						dialog.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(Principal.this, "Mientras no se haya vendido ninguna pieza, no se mostrarán las facturas");
				} catch (Exception e8) {
					e8.printStackTrace();
				}
			}
		});
		Facturas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
		MenuProductos.add(Facturas);

		JMenu MenuTrabajadores = new JMenu("Trabajadores");
		MenuTrabajadores.setBackground(Color.WHITE);
		menuBar.add(MenuTrabajadores);

		ListaDeTrabajadores = new JMenuItem("Listado de Trabajadores");
		ListaDeTrabajadores.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		ListaDeTrabajadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = ManejoDeSesion.getInstance().getUsername();
				if (user.equals("gerente2024")) {
					try {
						ListadoDeTrabajadores dialog = new ListadoDeTrabajadores(Principal.this, tiendaC);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setSize(900, 746); 
						dialog.setLocationRelativeTo(null);
						dialog.setVisible(true);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(Principal.this, "Error. A este campo solo puede acceder el gerente");
				}
			}
		});
		ListaDeTrabajadores.setBackground(Color.WHITE);
		ListaDeTrabajadores.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.ALT_MASK));
		MenuTrabajadores.add(ListaDeTrabajadores);

		AgregarTrabajador = new JMenuItem("Agregar Trabajador");
		AgregarTrabajador.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		AgregarTrabajador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = ManejoDeSesion.getInstance().getUsername();
				if (user.equals("gerente2024")) {
					try {
						AgregarTrabajador dialog = new AgregarTrabajador(Principal.this, tiendaC);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setSize(900, 746); 
						dialog.setLocationRelativeTo(null);
						dialog.setVisible(true);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(Principal.this, "Error. A este campo solo puede acceder el gerente");
				}
			}
		});
		AgregarTrabajador.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));
		AgregarTrabajador.setBackground(Color.WHITE);
		MenuTrabajadores.add(AgregarTrabajador);
		
		JMenu MenuReportes = new JMenu("Reportes");
		MenuReportes.setBackground(Color.WHITE);
		menuBar.add(MenuReportes);

		JMenuItem CantidadPiezas = new JMenuItem("Cantidad de piezas");
		CantidadPiezas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					CantidadDePiezas dialog = new CantidadDePiezas(null, tiendaC);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		CantidadPiezas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_MASK));
		CantidadPiezas.setBackground(Color.WHITE);
		MenuReportes.add(CantidadPiezas);
		
		JMenuItem PiezasMasCarasBtn = new JMenuItem("Piezas m\u00E1s caras");
		PiezasMasCarasBtn.addActionListener(new ActionListener() {
			
		public void actionPerformed(ActionEvent arg0) {
			try {
				PiezasMasCaras dialog = new PiezasMasCaras(null, tiendaC);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			} catch (Exception e7) {
				e7.printStackTrace();
			}
		}
	});
		PiezasMasCarasBtn.setBackground(Color.WHITE);
		PiezasMasCarasBtn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_MASK));
		MenuReportes.add(PiezasMasCarasBtn);
		
		JMenuItem DineroTotalRecaudado = new JMenuItem("Dinero Total Recaudado");
		DineroTotalRecaudado.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
				try {
					if(tiendaC.getFacturas().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Error. Todavia no se ha ejecutado ninguna venta" );
					} 
					else {
					DineroTotalRecaudado dialog = new DineroTotalRecaudado(null, tiendaC);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					}
				} catch (Exception e8) {
					e8.printStackTrace();
				}
			}
		});
		DineroTotalRecaudado.setBackground(Color.WHITE);
		DineroTotalRecaudado.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.ALT_MASK));
		MenuReportes.add(DineroTotalRecaudado);
		
		JMenuItem DineroPorVenta = new JMenuItem("Dinero por venta de una pieza dada");
		DineroPorVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(tiendaC.getFacturas().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Error. Todavia no se ha ejecutado ninguna venta" );
				} 
				else {
					DineroTotalRecaudado dialog = new DineroTotalRecaudado(null, tiendaC);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				} catch (Exception e9) {
					e9.printStackTrace();
				}
			}
		});
		DineroPorVenta.setBackground(Color.WHITE);
		DineroPorVenta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_MASK));
		MenuReportes.add(DineroPorVenta);
		
		
		JMenuItem SalarioTotal = new JMenuItem("Salario Total ");
		SalarioTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SalarioTotal dialog = new SalarioTotal(null, tiendaC);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e4) {
					e4.printStackTrace();
				}
			}
		});
		SalarioTotal.setBackground(Color.WHITE);
		SalarioTotal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.ALT_MASK));
		MenuReportes.add(SalarioTotal);
		
		JMenuItem PiezasVendidasPor = new JMenuItem("Piezas vendidas por encima de precio dado");
		PiezasVendidasPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(tiendaC.getFacturas().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Error. Todavia no se ha ejecutado ninguna venta" );
					} 
					else {
					PiezasVendidasPrecios dialog = new PiezasVendidasPrecios(null, tiendaC);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					}
				} catch (Exception e11) {
					e11.printStackTrace();
				}
			}
		});
		PiezasVendidasPor.setBackground(Color.WHITE);
		PiezasVendidasPor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.ALT_MASK));
		MenuReportes.add(PiezasVendidasPor);
		
		

		panelGeneral = new JPanel();
		panelGeneral.setBackground(Color.WHITE);
		panelGeneral.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelGeneral);
		panelGeneral.setLayout(null);

		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBorder(null);
		panelPrincipal.setBackground(Color.WHITE);
		panelPrincipal.setBounds(0, 0, 894, 696);
		panelGeneral.add(panelPrincipal);
		panelPrincipal.setLayout(null);

		JPanel Fila1 = new JPanel();
		Fila1.setBackground(Color.WHITE);
		Fila1.setBounds(20, 64, 846, 149);
		panelPrincipal.add(Fila1);
		Fila1.setLayout(new GridLayout(0, 4, 0, 0));

		btnButtonTarjetaMadre = new JButton("New button");
		btnButtonTarjetaMadre.setBorder(null);
		btnButtonTarjetaMadre.setFocusable(false);
		btnButtonTarjetaMadre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnButtonTarjetaMadre.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(135, 206, 235)));
			}
			public void mouseExited(MouseEvent e) {
				btnButtonTarjetaMadre.setBorder(null);
			}
		});
		btnButtonTarjetaMadre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					nombredeComponente = "Tarjeta Madre";
					VenderPieza dialog = new VenderPieza(Principal.this, tiendaC, nombredeComponente);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				} catch (Throwable e3) {
					e3.printStackTrace();
				}


			}
		});
		btnButtonTarjetaMadre.setIcon(new ImageIcon(Principal.class.getResource("/gui/images/Motherboards/motherboard2.jpg")));
		Fila1.add(btnButtonTarjetaMadre);

		btnButtonMicroprocesador = new JButton("New button");
		btnButtonMicroprocesador.setBorder(null);
		btnButtonMicroprocesador.setFocusable(false);
		btnButtonMicroprocesador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnButtonMicroprocesador.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(135, 206, 235)));
			}
			public void mouseExited(MouseEvent e) {
				btnButtonMicroprocesador.setBorder(null);


			}
		});
		btnButtonMicroprocesador.setBackground(Color.WHITE);
		btnButtonMicroprocesador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					nombredeComponente = "Microprocesador";
					VenderPieza dialog = new VenderPieza(Principal.this, tiendaC,  nombredeComponente);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				} catch (Throwable e3) {
					e3.printStackTrace();
				}
			}
		});
		btnButtonMicroprocesador.setIcon(new ImageIcon(Principal.class.getResource("/gui/images/Micro/OIP.jpg")));
		Fila1.add(btnButtonMicroprocesador);

		btnButtonmemoriasRAM = new JButton("New button");
		btnButtonmemoriasRAM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombredeComponente = "Memoria RAM";
				try {
					VenderPieza dialog = new VenderPieza(Principal.this, tiendaC,  nombredeComponente);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				} catch (Throwable e3) {
					e3.printStackTrace();
				}

			}
		});
		btnButtonmemoriasRAM.setBorder(null);
		btnButtonmemoriasRAM.setFocusable(false);
		btnButtonmemoriasRAM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnButtonmemoriasRAM.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(135, 206, 235)));
			}
			public void mouseExited(MouseEvent e) {
				btnButtonmemoriasRAM.setBorder(null);

			}
		});
		btnButtonmemoriasRAM.setIcon(new ImageIcon(Principal.class.getResource("/gui/images/RAM/ram9.jpg")));
		Fila1.add(btnButtonmemoriasRAM);

		btnButtonTarjetasVideo = new JButton("New button");
		btnButtonTarjetasVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombredeComponente = "Tarjeta de Video";
				try {
					VenderPieza dialog = new VenderPieza(Principal.this, tiendaC,  nombredeComponente);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				} catch (Throwable e3) {
					e3.printStackTrace();
				}
			}
		});
		btnButtonTarjetasVideo.setBorder(null);
		btnButtonTarjetasVideo.setFocusable(false);
		btnButtonTarjetasVideo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnButtonTarjetasVideo.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(135, 206, 235)));
			}
			public void mouseExited(MouseEvent e) {
				btnButtonTarjetasVideo.setBorder(null);

			}
		});
		btnButtonTarjetasVideo.setIcon(new ImageIcon(Principal.class.getResource("/gui/images/Tarjetas/tarjetas3.jpg")));
		Fila1.add(btnButtonTarjetasVideo);

		JPanel Fila2 = new JPanel();
		Fila2.setBackground(Color.WHITE);
		Fila2.setBounds(20, 266, 846, 149);
		panelPrincipal.add(Fila2);
		Fila2.setLayout(new GridLayout(0, 4, 0, 0));

		btnButtonDiscosDuros = new JButton("New button");
		btnButtonDiscosDuros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombredeComponente = "Disco Duro";
				try {
					VenderPieza dialog = new VenderPieza(Principal.this, tiendaC,  nombredeComponente);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				} catch (Throwable e3) {
					e3.printStackTrace();
				}
			}
		});
		btnButtonDiscosDuros.setBorder(null);
		btnButtonDiscosDuros.setFocusable(false);
		btnButtonDiscosDuros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnButtonDiscosDuros.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(135, 206, 235)));
			}
			public void mouseExited(MouseEvent e) {
				btnButtonDiscosDuros.setBorder(null);

			}
		});
		btnButtonDiscosDuros.setIcon(new ImageIcon(Principal.class.getResource("/gui/images/Discos/discos3.jpg")));
		Fila2.add(btnButtonDiscosDuros);

		btnButtonFuente = new JButton("New button");
		btnButtonFuente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombredeComponente = "Fuente";
				try {
					VenderPieza dialog = new VenderPieza(Principal.this, tiendaC,  nombredeComponente);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				} catch (Throwable e3) {
					e3.printStackTrace();
				}
			}
		});
		btnButtonFuente.setBorder(null);
		btnButtonFuente.setFocusable(false);
		btnButtonFuente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnButtonFuente.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(135, 206, 235)));
			}
			public void mouseExited(MouseEvent e) {
				btnButtonFuente.setBorder(null);
			}
		});
		btnButtonFuente.setIcon(new ImageIcon(Principal.class.getResource("/gui/images/Fuentes/R.jpg")));
		Fila2.add(btnButtonFuente);

		btnButtonMonitores = new JButton("New button");
		btnButtonMonitores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombredeComponente = "Monitor";
				try {
					VenderPieza dialog = new VenderPieza(Principal.this, tiendaC, nombredeComponente);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				} catch (Throwable e3) {
					e3.printStackTrace();
				}
			}
		});
		btnButtonMonitores.setBorder(null);
		btnButtonMonitores.setFocusable(false);
		btnButtonMonitores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnButtonMonitores.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(135, 206, 235)));
			}
			public void mouseExited(MouseEvent e) {
				btnButtonMonitores.setBorder(null);
			}
		});
		btnButtonMonitores.setIcon(new ImageIcon(Principal.class.getResource("/gui/images/Monitores/monitor7.jpg")));
		Fila2.add(btnButtonMonitores);

		btnButtonTeclado = new JButton("New button");
		btnButtonTeclado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombredeComponente = "Teclado";
				try {
					VenderPieza dialog = new VenderPieza(Principal.this, tiendaC,  nombredeComponente);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				} catch (Throwable e3) {
					e3.printStackTrace();
				}
			}
		});
		btnButtonTeclado.setBorder(null);
		btnButtonTeclado.setFocusable(false);
		btnButtonTeclado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnButtonTeclado.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(135, 206, 235)));
			}
			public void mouseExited(MouseEvent e) {
				btnButtonTeclado.setBorder(null);
			}
		});
		btnButtonTeclado.setIcon(new ImageIcon(Principal.class.getResource("/gui/images/Teclados/teclados4.jpg")));
		Fila2.add(btnButtonTeclado);

		JPanel Fila3 = new JPanel();
		Fila3.setBackground(Color.WHITE);
		Fila3.setBounds(20, 468, 846, 149);
		panelPrincipal.add(Fila3);
		Fila3.setLayout(new GridLayout(0, 4, 0, 0));

		btnButtonRaton = new JButton("New button");
		btnButtonRaton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombredeComponente = "Ratón";
				try {
					VenderPieza dialog = new VenderPieza(Principal.this, tiendaC, nombredeComponente);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				} catch (Throwable e3) {
					e3.printStackTrace();
				}
			}
		});
		btnButtonRaton.setBorder(null);
		btnButtonRaton.setFocusable(false);
		btnButtonRaton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnButtonRaton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(135, 206, 235)));
			}
			public void mouseExited(MouseEvent e) {
				btnButtonRaton.setBorder(null);
			}
		});
		btnButtonRaton.setIcon(new ImageIcon(Principal.class.getResource("/gui/images/Mouse/mouse6.jpg")));
		Fila3.add(btnButtonRaton);

		btnButtonBocina = new JButton("New button");
		btnButtonBocina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombredeComponente = "Bocina";
				try {
					VenderPieza dialog = new VenderPieza(Principal.this, tiendaC, nombredeComponente);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				} catch (Throwable e3) {
					e3.printStackTrace();
				}
			}
		});
		btnButtonBocina.setBorder(null);
		btnButtonBocina.setFocusable(false);
		btnButtonBocina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnButtonBocina.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(135, 206, 235)));
			}
			public void mouseExited(MouseEvent e) {
				btnButtonBocina.setBorder(null);
			}
		});
		btnButtonBocina.setIcon(new ImageIcon(Principal.class.getResource("/gui/images/Bocinas/bocinas13.jpg")));
		Fila3.add(btnButtonBocina);

		btnButtonChasis = new JButton("New button");
		btnButtonChasis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombredeComponente = "Chasis";
				try {
					VenderPieza dialog = new VenderPieza(Principal.this, tiendaC, nombredeComponente);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				} catch (Throwable e3) {
					e3.printStackTrace();
				}
			}
		});
		btnButtonChasis.setBorder(null);
		btnButtonChasis.setFocusable(false);
		btnButtonChasis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnButtonChasis.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(135, 206, 235)));
			}
			public void mouseExited(MouseEvent e) {
				btnButtonChasis.setBorder(null);
			}
		});
		btnButtonChasis.setIcon(new ImageIcon(Principal.class.getResource("/gui/images/Chasis/chasis3.jpg")));
		Fila3.add(btnButtonChasis);

		btnButtonOtro = new JButton("New button");
		btnButtonOtro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombredeComponente = "Adaptador";
				try {
					VenderPieza dialog = new VenderPieza(Principal.this, tiendaC, nombredeComponente);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				} catch (Throwable e3) {
					e3.printStackTrace();
				}
			}
		});
		btnButtonOtro.setBorder(null);
		btnButtonOtro.setFocusable(false);
		btnButtonOtro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnButtonOtro.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(135, 206, 235)));
			}
			public void mouseExited(MouseEvent e) {
				btnButtonOtro.setBorder(null);
			}
		});
		btnButtonOtro.setIcon(new ImageIcon(Principal.class.getResource("/gui/images/Otros/otros3.jpg")));
		Fila3.add(btnButtonOtro);

		JPanel FilaLabels1 = new JPanel();
		FilaLabels1.setBackground(Color.WHITE);
		FilaLabels1.setBounds(20, 223, 846, 33);
		panelPrincipal.add(FilaLabels1);
		FilaLabels1.setLayout(new GridLayout(0, 4, 0, 0));

		JLabel lblMotherboard = new JLabel("Tarjetas Madres");
		lblMotherboard.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMotherboard.setHorizontalAlignment(SwingConstants.CENTER);
		FilaLabels1.add(lblMotherboard);

		JLabel lblMicros = new JLabel("Microprocesadores");
		lblMicros.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMicros.setHorizontalAlignment(SwingConstants.CENTER);
		FilaLabels1.add(lblMicros);

		JLabel lblRam = new JLabel("Memorias RAM");
		lblRam.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRam.setHorizontalAlignment(SwingConstants.CENTER);
		FilaLabels1.add(lblRam);

		JLabel lblTarjetaVideo = new JLabel("Tarjetas de Video");
		lblTarjetaVideo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTarjetaVideo.setHorizontalAlignment(SwingConstants.CENTER);
		FilaLabels1.add(lblTarjetaVideo);

		JPanel FilaLabels2 = new JPanel();
		FilaLabels2.setBackground(Color.WHITE);
		FilaLabels2.setBounds(20, 425, 846, 33);
		panelPrincipal.add(FilaLabels2);
		FilaLabels2.setLayout(new GridLayout(0, 4, 0, 0));

		JLabel lblDiscos = new JLabel("Discos Duros");
		lblDiscos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDiscos.setHorizontalAlignment(SwingConstants.CENTER);
		FilaLabels2.add(lblDiscos);

		JLabel lblFuentes = new JLabel("Fuentes");
		lblFuentes.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFuentes.setHorizontalAlignment(SwingConstants.CENTER);
		FilaLabels2.add(lblFuentes);

		JLabel lblMonitores = new JLabel("Monitores");
		lblMonitores.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMonitores.setHorizontalAlignment(SwingConstants.CENTER);
		FilaLabels2.add(lblMonitores);

		JLabel lblTeclados = new JLabel("Teclados");
		lblTeclados.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTeclados.setHorizontalAlignment(SwingConstants.CENTER);
		FilaLabels2.add(lblTeclados);

		JPanel FilaLabels3 = new JPanel();
		FilaLabels3.setBackground(Color.WHITE);
		FilaLabels3.setBounds(20, 627, 846, 33);
		panelPrincipal.add(FilaLabels3);
		FilaLabels3.setLayout(new GridLayout(0, 4, 0, 0));

		JLabel lblMouse = new JLabel("Ratones");
		lblMouse.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMouse.setHorizontalAlignment(SwingConstants.CENTER);
		FilaLabels3.add(lblMouse);

		JLabel lblBocina = new JLabel("Bocinas");
		lblBocina.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBocina.setHorizontalAlignment(SwingConstants.CENTER);
		FilaLabels3.add(lblBocina);

		JLabel lblChasis = new JLabel("Chasis");
		lblChasis.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChasis.setHorizontalAlignment(SwingConstants.CENTER);
		FilaLabels3.add(lblChasis);

		JLabel lblAdaptadores = new JLabel("Adaptadores");
		lblAdaptadores.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdaptadores.setHorizontalAlignment(SwingConstants.CENTER);
		FilaLabels3.add(lblAdaptadores);

		JLabel lblEncabezado = new JLabel("Productos en Venta:");
		lblEncabezado.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 23));
		lblEncabezado.setBounds(10, 10, 293, 44);
		panelPrincipal.add(lblEncabezado);
	}

	private void inicializarDatos() {
		InicializacionDeDatos.crearTrabajadores(tiendaC);
		InicializacionDeDatos.crearGerentes(tiendaC);
		inicializaciones.InicializacionDeDatos.llamarInicializaciones(tiendaC);
	}
}
