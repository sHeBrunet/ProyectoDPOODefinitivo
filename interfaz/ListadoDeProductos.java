package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
import javax.swing.border.MatteBorder;

public class ListadoDeProductos extends JDialog {

	private static final long serialVersionUID = 1L;

	private static TiendaDeComputadoras tienda;
	private static Principal p;
	private JButton btnBorrar;
	private JButton btnAtras;
	private JButton btnGuardar;
	private String[] columnNames = {"No.", "Marca", "Modelo", "Precio", "Cantidad", "No. Serie"};
	private static JTable tableBocinas;
	private static JTable tableChasis;
	private static JTable tableDiscos;
	private static JTable tableFuentes;
	private static JTable tableMicros;
	private static JTable tableMonitores;
	private static JTable tableMotherboards;
	private static JTable tableMouses;
	private static JTable tableRAM;
	private static JTable tableTarjetas;
	private static JTable tableTeclados;
	private static JTable tableAdaptadores;
	private static JTable tableTotalPiezas;
	private static String ID;
	private boolean cambios = false;
	private static ArrayList <String> piezasAElim = new ArrayList <>();
	private static int count;

	public ListadoDeProductos(Principal principal, TiendaDeComputadoras t) {
		super(principal, true);
		setBackground(new Color(255, 255, 255));
		getContentPane().setBackground(new Color(255, 255, 255));
		tienda = t;
		setTitle("Listado de Productos");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(900, 746);
		setLocationRelativeTo(null);

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(135, 206, 235)));
		tabbedPane.setFocusable(false);
		tabbedPane.setBackground(Color.WHITE);

		JPanel panelChasis = new JPanel(new BorderLayout());
		panelChasis.setBackground(new Color(255, 255, 255));
		JPanel panelBocinas = new JPanel(new BorderLayout());
		panelBocinas.setBackground(new Color(255, 255, 255));
		JPanel panelDiscos = new JPanel(new BorderLayout());
		panelDiscos.setBackground(new Color(255, 255, 255));
		JPanel panelFuentes = new JPanel(new BorderLayout());
		panelFuentes.setBackground(new Color(255, 255, 255));
		JPanel panelMicros = new JPanel(new BorderLayout());
		panelMicros.setBackground(new Color(255, 255, 255));
		JPanel panelMonitores = new JPanel(new BorderLayout());
		panelMonitores.setBackground(new Color(255, 255, 255));
		JPanel panelMotherboards = new JPanel(new BorderLayout());
		panelMotherboards.setBackground(new Color(255, 255, 255));
		JPanel panelMouse = new JPanel(new BorderLayout());
		panelMouse.setBackground(new Color(255, 255, 255));
		JPanel panelAdaptadores = new JPanel(new BorderLayout());
		panelAdaptadores.setBackground(new Color(255, 255, 255));
		JPanel panelRAM = new JPanel(new BorderLayout());
		panelRAM.setBackground(new Color(255, 255, 255));
		JPanel panelTarjetas = new JPanel(new BorderLayout());
		panelTarjetas.setBackground(new Color(255, 255, 255));
		JPanel panelTeclados = new JPanel(new BorderLayout());
		panelTeclados.setBackground(new Color(255, 255, 255));
		JPanel panelTotalPiezas = new JPanel(new BorderLayout());
		panelTotalPiezas.setBackground(new Color(255, 255, 255));

		final DefaultTableModel modelTotalPiezas = new DefaultTableModel(columnNames, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		final DefaultTableModel modelChasis = new DefaultTableModel(columnNames, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableChasis = new JTable(modelChasis);
		tableChasis.setGridColor(new Color(135, 206, 235));
		tableChasis.setFocusable(false);
		tableChasis.setToolTipText("<html><fontface = 'Arial' size ='3'> Si da doble click encima de cualquier pieza, <br>" + "se mostrar\u00E1 m\u00E1s informaci\u00F3n sobre esta.");
		tableChasis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				if (event.getClickCount()> 1) {
					int pos = tableChasis.getSelectedRow();
					ID = (String) tableChasis.getValueAt(pos, 5);
					informacionProd();
				}
			}
		});
		tableChasis.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					int i = JOptionPane.showConfirmDialog(null, "¿Seguro que desea borrar la pieza seleccionada?", "", 0, 3);
					if(i==0) {		
						int pos = tableChasis.getSelectedRow();
						if (pos != -1) {
							cambios = true;
							ID = (String) tableChasis.getValueAt(pos, 5);
							piezasAElim.add(ID);
							((DefaultTableModel) tableChasis.getModel()).removeRow(pos);
							limpiarChasis();
							limpiarTotalPiezas();
							llenarTablaChasis(modelChasis);
							llenarTablaTotalPiezas(modelTotalPiezas);
						} else {
							JOptionPane.showMessageDialog(ListadoDeProductos.this, "Antes de eliminar debe de seleccionar un componente de la tabla");
						}
					}
				}
			}
		});
		tableChasis.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane_12 = new JScrollPane(tableChasis);
		scrollPane_12.setFocusable(false);
		panelChasis.add(scrollPane_12, BorderLayout.CENTER);

		final DefaultTableModel modelBocinas = new DefaultTableModel(columnNames, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableBocinas = new JTable(modelBocinas);
		tableBocinas.setGridColor(new Color(135, 206, 235));
		tableBocinas.setFocusable(false);
		tableBocinas.setToolTipText("<html><fontface = 'Arial' size ='3'> Si da doble click encima de cualquier pieza, <br>" + "se mostrar\u00E1 m\u00E1s informaci\u00F3n sobre esta.");
		tableBocinas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				if (event.getClickCount()> 1) {
					int pos = tableBocinas.getSelectedRow();
					ID = (String) tableBocinas.getValueAt(pos, 5);
					informacionProd();
				}
			}
		});
		tableBocinas.setBackground(new Color(255, 255, 255));
		tableBocinas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					int i = JOptionPane.showConfirmDialog(null, "¿Seguro que desea borrar la pieza seleccionada?", "", 0, 3);
					if(i==0) {		
						int pos = tableBocinas.getSelectedRow();
						if (pos != -1) {
							cambios = true;
							ID = (String) tableBocinas.getValueAt(pos, 5);
							piezasAElim.add(ID);
							((DefaultTableModel) tableBocinas.getModel()).removeRow(pos);
							limpiarBocinas();
							limpiarTotalPiezas();
							llenarTablaBocinas(modelBocinas);
							llenarTablaTotalPiezas(modelTotalPiezas);
						} else {
							JOptionPane.showMessageDialog(ListadoDeProductos.this, "Antes de eliminar debe de seleccionar un componente de la tabla");
						}
					}
				}
			}
		});
		tableBocinas.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane_1 = new JScrollPane(tableBocinas);
		scrollPane_1.setFocusable(false);
		scrollPane_1.setBackground(new Color(255, 255, 255));
		panelBocinas.add(scrollPane_1, BorderLayout.CENTER);

		final DefaultTableModel modelDiscos = new DefaultTableModel(columnNames, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableDiscos = new JTable(modelDiscos);
		tableDiscos.setGridColor(new Color(135, 206, 235));
		tableDiscos.setFocusable(false);
		tableDiscos.setToolTipText("<html><fontface = 'Arial' size ='3'> Si da doble click encima de cualquier pieza, <br>" + "se mostrar\u00E1 m\u00E1s informaci\u00F3n sobre esta.");
		tableDiscos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				if (event.getClickCount()> 1) {
					int pos = tableDiscos.getSelectedRow();
					ID = (String) tableDiscos.getValueAt(pos, 5);
					informacionProd();
				}
			}
		});
		tableDiscos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					int i = JOptionPane.showConfirmDialog(null, "¿Seguro que desea borrar la pieza seleccionada?", "", 0, 3);
					if(i==0) {		
						int pos = tableDiscos.getSelectedRow();
						if (pos != -1) {
							cambios = true;
							ID = (String) tableDiscos.getValueAt(pos, 5);
							piezasAElim.add(ID);
							((DefaultTableModel) tableDiscos.getModel()).removeRow(pos);
							limpiarDiscos();
							limpiarTotalPiezas();
							llenarTablaDiscos(modelDiscos);
							llenarTablaTotalPiezas(modelTotalPiezas);
						} else {
							JOptionPane.showMessageDialog(ListadoDeProductos.this, "Antes de eliminar debe de seleccionar un componente de la tabla");
						}
					}
				}
			}
		});
		tableDiscos.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane_2 = new JScrollPane(tableDiscos);
		scrollPane_2.setFocusable(false);
		scrollPane_2.setBackground(new Color(255, 255, 255));
		panelDiscos.add(scrollPane_2, BorderLayout.CENTER);

		final DefaultTableModel modelFuentes = new DefaultTableModel(columnNames, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableFuentes = new JTable(modelFuentes);
		tableFuentes.setGridColor(new Color(135, 206, 235));
		tableFuentes.setFocusable(false);
		tableFuentes.setToolTipText("<html><fontface = 'Arial' size ='3'> Si da doble click encima de cualquier pieza, <br>" + "se mostrar\u00E1 m\u00E1s informaci\u00F3n sobre esta.");
		tableFuentes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				if (event.getClickCount()> 1) {
					int pos = tableFuentes.getSelectedRow();
					ID = (String) tableFuentes.getValueAt(pos, 5);
					informacionProd();
				}
			}
		});
		tableFuentes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					int i = JOptionPane.showConfirmDialog(null, "¿Seguro que desea borrar la pieza seleccionada?", "", 0, 3);
					if(i==0) {		
						int pos = tableFuentes.getSelectedRow();
						if (pos != -1) {
							cambios = true;
							ID = (String) tableFuentes.getValueAt(pos, 5);
							piezasAElim.add(ID);
							((DefaultTableModel) tableFuentes.getModel()).removeRow(pos);
							limpiarFuentes();
							limpiarTotalPiezas();
							llenarTablaFuentes(modelFuentes);
							llenarTablaTotalPiezas(modelTotalPiezas);
						} else {
							JOptionPane.showMessageDialog(ListadoDeProductos.this, "Antes de eliminar debe de seleccionar un componente de la tabla");
						}
					}
				}
			}
		});
		tableFuentes.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane_3 = new JScrollPane(tableFuentes);
		scrollPane_3.setFocusable(false);
		scrollPane_3.setBackground(new Color(255, 255, 255));
		panelFuentes.add(scrollPane_3, BorderLayout.CENTER);

		final DefaultTableModel modelMicros = new DefaultTableModel(columnNames, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableMicros = new JTable(modelMicros);
		tableMicros.setGridColor(new Color(135, 206, 235));
		tableMicros.setFocusable(false);
		tableMicros.setToolTipText("<html><fontface = 'Arial' size ='3'> Si da doble click encima de cualquier pieza, <br>" + "se mostrar\u00E1 m\u00E1s informaci\u00F3n sobre esta.");
		tableMicros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				if (event.getClickCount()> 1) {
					int pos = tableMicros.getSelectedRow();
					ID = (String) tableMicros.getValueAt(pos, 5);
					informacionProd();
				}
			}
		});
		tableMicros.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					int i = JOptionPane.showConfirmDialog(null, "¿Seguro que desea borrar la pieza seleccionada?", "", 0, 3);
					if(i==0) {		
						int pos = tableMicros.getSelectedRow();
						if (pos != -1) {
							cambios = true;
							ID = (String) tableMicros.getValueAt(pos, 5);
							piezasAElim.add(ID);
							((DefaultTableModel) tableMicros.getModel()).removeRow(pos);
							limpiarMicros();
							limpiarTotalPiezas();
							llenarTablaMicros(modelMicros);
							llenarTablaTotalPiezas(modelTotalPiezas);
						} else {
							JOptionPane.showMessageDialog(ListadoDeProductos.this, "Antes de eliminar debe de seleccionar un componente de la tabla");
						}
					}
				}
			}
		});
		tableMicros.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane_4 = new JScrollPane(tableMicros);
		scrollPane_4.setFocusable(false);
		scrollPane_4.setBackground(new Color(255, 255, 255));
		panelMicros.add(scrollPane_4, BorderLayout.CENTER);

		final DefaultTableModel modelMonitores = new DefaultTableModel(columnNames, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableMonitores = new JTable(modelMonitores);
		tableMonitores.setGridColor(new Color(135, 206, 235));
		tableMonitores.setFocusable(false);
		tableMonitores.setToolTipText("<html><fontface = 'Arial' size ='3'> Si da doble click encima de cualquier pieza, <br>" + "se mostrar\u00E1 m\u00E1s informaci\u00F3n sobre esta.");
		tableMonitores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				if (event.getClickCount()> 1) {
					int pos = tableMonitores.getSelectedRow();
					ID = (String) tableMonitores.getValueAt(pos, 5);
					informacionProd();
				}
			}
		});
		tableMonitores.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					int i = JOptionPane.showConfirmDialog(null, "¿Seguro que desea borrar la pieza seleccionada?", "", 0, 3);
					if(i==0) {		
						int pos = tableMonitores.getSelectedRow();
						if (pos != -1) {
							cambios = true;
							ID = (String) tableMonitores.getValueAt(pos, 5);
							piezasAElim.add(ID);
							((DefaultTableModel) tableMonitores.getModel()).removeRow(pos);
							limpiarMonitores();
							limpiarTotalPiezas();
							llenarTablaMonitores(modelMonitores);
							llenarTablaTotalPiezas(modelTotalPiezas);
						} else {
							JOptionPane.showMessageDialog(ListadoDeProductos.this, "Antes de eliminar debe de seleccionar un componente de la tabla");
						}
					}
				}
			}
		});
		tableMonitores.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane_5 = new JScrollPane(tableMonitores);
		scrollPane_5.setFocusable(false);
		scrollPane_5.setBackground(new Color(255, 255, 255));
		panelMonitores.add(scrollPane_5, BorderLayout.CENTER);

		final DefaultTableModel modelMotherboards = new DefaultTableModel(columnNames, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableMotherboards = new JTable(modelMotherboards);
		tableMotherboards.setGridColor(new Color(135, 206, 235));
		tableMotherboards.setFocusable(false);
		tableMotherboards.setToolTipText("<html><fontface = 'Arial' size ='3'> Si da doble click encima de cualquier pieza, <br>" + "se mostrar\u00E1 m\u00E1s informaci\u00F3n sobre esta.");
		tableMotherboards.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				if (event.getClickCount()> 1) {
					int pos = tableMotherboards.getSelectedRow();
					ID = (String) tableMotherboards.getValueAt(pos, 5);
					informacionProd();
				}
			}
		});
		tableMotherboards.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					int i = JOptionPane.showConfirmDialog(null, "¿Seguro que desea borrar la pieza seleccionada?", "", 0, 3);
					if(i==0) {		
						int pos = tableMotherboards.getSelectedRow();
						if (pos != -1) {
							cambios = true;
							ID = (String) tableMotherboards.getValueAt(pos, 5);
							piezasAElim.add(ID);
							((DefaultTableModel) tableMotherboards.getModel()).removeRow(pos);
							limpiarMotherboards();
							limpiarTotalPiezas();
							llenarTablaMotherboards(modelMotherboards);
							llenarTablaTotalPiezas(modelTotalPiezas);
						} else {
							JOptionPane.showMessageDialog(ListadoDeProductos.this, "Antes de eliminar debe de seleccionar un componente de la tabla");
						}
					}
				}
			}
		});
		tableMotherboards.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane_6 = new JScrollPane(tableMotherboards);
		scrollPane_6.setFocusable(false);
		scrollPane_6.setBackground(new Color(255, 255, 255));
		panelMotherboards.add(scrollPane_6, BorderLayout.CENTER);

		final DefaultTableModel modelMouse = new DefaultTableModel(columnNames, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableMouses = new JTable(modelMouse);
		tableMouses.setGridColor(new Color(135, 206, 235));
		tableMouses.setFocusable(false);
		tableMouses.setToolTipText("<html><fontface = 'Arial' size ='3'> Si da doble click encima de cualquier pieza, <br>" + "se mostrar\u00E1 m\u00E1s informaci\u00F3n sobre esta.");
		tableMouses.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				if (event.getClickCount()> 1) {
					int pos = tableMouses.getSelectedRow();
					ID = (String) tableMouses.getValueAt(pos, 5);
					informacionProd();
				}
			}
		});
		tableMouses.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					int i = JOptionPane.showConfirmDialog(null, "¿Seguro que desea borrar la pieza seleccionada?", "", 0, 3);
					if(i==0) {		
						int pos = tableMouses.getSelectedRow();
						if (pos != -1) {
							cambios = true;
							ID = (String) tableMouses.getValueAt(pos, 5);
							piezasAElim.add(ID);
							((DefaultTableModel) tableMouses.getModel()).removeRow(pos);
							limpiarMouses();
							limpiarTotalPiezas();
							llenarTablaMouses(modelMouse);
							llenarTablaTotalPiezas(modelTotalPiezas);
						} else {
							JOptionPane.showMessageDialog(ListadoDeProductos.this, "Antes de eliminar debe de seleccionar un componente de la tabla");
						}
					}
				}
			}
		});
		tableMouses.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane_7 = new JScrollPane(tableMouses);
		scrollPane_7.setFocusable(false);
		scrollPane_7.setBackground(new Color(255, 255, 255));
		panelMouse.add(scrollPane_7, BorderLayout.CENTER);

		final DefaultTableModel modelRAM = new DefaultTableModel(columnNames, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableRAM = new JTable(modelRAM);
		tableRAM.setGridColor(new Color(135, 206, 235));
		tableRAM.setFocusable(false);
		tableRAM.setToolTipText("<html><fontface = 'Arial' size ='3'> Si da doble click encima de cualquier pieza, <br>" + "se mostrar\u00E1 m\u00E1s informaci\u00F3n sobre esta.");
		tableRAM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				if (event.getClickCount()> 1) {
					int pos = tableRAM.getSelectedRow();
					ID = (String) tableRAM.getValueAt(pos, 5);
					informacionProd();
				}
			}
		});
		tableRAM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					int i = JOptionPane.showConfirmDialog(null, "¿Seguro que desea borrar la pieza seleccionada?", "", 0, 3);
					if(i==0) {		
						int pos = tableRAM.getSelectedRow();
						if (pos != -1) {
							cambios = true;
							ID = (String) tableRAM.getValueAt(pos, 5);
							piezasAElim.add(ID);
							((DefaultTableModel) tableRAM.getModel()).removeRow(pos);
							limpiarRAM();
							limpiarTotalPiezas();
							llenarTablaRAM(modelRAM);
							llenarTablaTotalPiezas(modelTotalPiezas);
						} else {
							JOptionPane.showMessageDialog(ListadoDeProductos.this, "Antes de eliminar debe de seleccionar un componente de la tabla");
						}
					}
				}
			}
		});
		tableRAM.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane_8 = new JScrollPane(tableRAM);
		scrollPane_8.setFocusable(false);
		scrollPane_8.setBackground(new Color(255, 255, 255));
		panelRAM.add(scrollPane_8, BorderLayout.CENTER);

		final DefaultTableModel modelTarjetas = new DefaultTableModel(columnNames, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableTarjetas = new JTable(modelTarjetas);
		tableTarjetas.setGridColor(new Color(135, 206, 235));
		tableTarjetas.setFocusable(false);
		tableTarjetas.setToolTipText("<html><fontface = 'Arial' size ='3'> Si da doble click encima de cualquier pieza, <br>" + "se mostrar\u00E1 m\u00E1s informaci\u00F3n sobre esta.");
		tableTarjetas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				if (event.getClickCount()> 1) {
					int pos = tableTarjetas.getSelectedRow();
					ID = (String) tableTarjetas.getValueAt(pos, 5);
					informacionProd();
				}
			}
		});
		tableTarjetas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					int i = JOptionPane.showConfirmDialog(null, "¿Seguro que desea borrar la pieza seleccionada?", "", 0, 3);
					if(i==0) {		
						int pos = tableTarjetas.getSelectedRow();
						if (pos != -1) {
							cambios = true;
							ID = (String) tableTarjetas.getValueAt(pos, 5);
							piezasAElim.add(ID);
							((DefaultTableModel) tableTarjetas.getModel()).removeRow(pos);
							limpiarTarjetas();
							limpiarTotalPiezas();
							llenarTablaTarjetaVideo(modelTarjetas);
							llenarTablaTotalPiezas(modelTotalPiezas);
						} else {
							JOptionPane.showMessageDialog(ListadoDeProductos.this, "Antes de eliminar debe de seleccionar un componente de la tabla");
						}
					}
				}
			}
		});
		tableTarjetas.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane_9 = new JScrollPane(tableTarjetas);
		scrollPane_9.setFocusable(false);
		scrollPane_9.setBackground(new Color(255, 255, 255));
		panelTarjetas.add(scrollPane_9, BorderLayout.CENTER);

		final DefaultTableModel modelTeclados = new DefaultTableModel(columnNames, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableTeclados = new JTable(modelTeclados);
		tableTeclados.setGridColor(new Color(135, 206, 235));
		tableTeclados.setFocusable(false);
		tableTeclados.setToolTipText("<html><fontface = 'Arial' size ='3'> Si da doble click encima de cualquier pieza, <br>" + "se mostrar\u00E1 m\u00E1s informaci\u00F3n sobre esta.");
		tableTeclados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				if (event.getClickCount()> 1) {
					int pos = tableTeclados.getSelectedRow();
					ID = (String) tableTeclados.getValueAt(pos, 5);
					informacionProd();
				}
			}
		});
		tableTeclados.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					int i = JOptionPane.showConfirmDialog(null, "¿Seguro que desea borrar la pieza seleccionada?", "", 0, 3);
					if(i==0) {		
						int pos = tableTeclados.getSelectedRow();
						if (pos != -1) {
							cambios = true;
							ID = (String) tableTeclados.getValueAt(pos, 5);
							piezasAElim.add(ID);
							((DefaultTableModel) tableTeclados.getModel()).removeRow(pos);
							limpiarTeclados();
							limpiarTotalPiezas();
							llenarTablaTeclados(modelTeclados);
							llenarTablaTotalPiezas(modelTotalPiezas);
						} else {
							JOptionPane.showMessageDialog(ListadoDeProductos.this, "Antes de eliminar debe de seleccionar un componente de la tabla");
						}
					}
				}
			}
		});
		tableTeclados.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane_10 = new JScrollPane(tableTeclados);
		scrollPane_10.setFocusable(false);
		scrollPane_10.setBackground(new Color(255, 255, 255));
		panelTeclados.add(scrollPane_10, BorderLayout.CENTER);

		final DefaultTableModel modelAdaptadores = new DefaultTableModel(columnNames, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableAdaptadores = new JTable(modelAdaptadores);
		tableAdaptadores.setGridColor(new Color(135, 206, 235));
		tableAdaptadores.setFocusable(false);
		tableAdaptadores.setToolTipText("<html><fontface = 'Arial' size ='3'> Si da doble click encima de cualquier pieza, <br>" + "se mostrar\u00E1 m\u00E1s informaci\u00F3n sobre esta.");
		tableAdaptadores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				if (event.getClickCount()> 1) {
					JOptionPane.showMessageDialog(ListadoDeProductos.this, "No hay más información que mostrar sobre esta pieza");
				}
			}
		});
		tableAdaptadores.setBackground(new Color(255, 255, 255));
		tableAdaptadores.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					int i = JOptionPane.showConfirmDialog(null, "¿Seguro que desea borrar la pieza seleccionada?", "", 0, 3);
					if(i==0) {		
						int pos = tableAdaptadores.getSelectedRow();
						if (pos != -1) {
							cambios = true;
							ID = (String) tableAdaptadores.getValueAt(pos, 5);
							piezasAElim.add(ID);
							((DefaultTableModel) tableAdaptadores.getModel()).removeRow(pos);
							limpiarAdaptadores();
							limpiarTotalPiezas();
							llenarTablaAdaptadores(modelAdaptadores);
							llenarTablaTotalPiezas(modelTotalPiezas);
						} else {
							JOptionPane.showMessageDialog(ListadoDeProductos.this, "Antes de eliminar debe de seleccionar un componente de la tabla");
						}
					}
				}
			}
		});
		tableAdaptadores.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane = new JScrollPane(tableAdaptadores);
		scrollPane.setFocusable(false);
		scrollPane.setBackground(new Color(255, 255, 255));
		panelAdaptadores.add(scrollPane, BorderLayout.CENTER);

		tableTotalPiezas = new JTable(modelTotalPiezas);
		tableTotalPiezas.setGridColor(new Color(135, 206, 235));
		tableTotalPiezas.setFocusable(false);
		tableTotalPiezas.setToolTipText("<html><fontface = 'Arial' size ='3'> Si da doble click encima de cualquier pieza, <br>" + "se mostrar\u00E1 m\u00E1s informaci\u00F3n sobre esta.");
		tableTotalPiezas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				if (event.getClickCount()> 1) {
					int pos = tableTotalPiezas.getSelectedRow();
					ID = (String) tableTotalPiezas.getValueAt(pos, 5);	
					ComponenteOrdenador c = tienda.buscarComponente(ID);
					if(c instanceof Adaptador) {
						JOptionPane.showMessageDialog(ListadoDeProductos.this, "No hay más información que mostrar sobre esta pieza");
					} 
					else
						informacionProd();	
				}
			}
		});
		tableTotalPiezas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					int i = JOptionPane.showConfirmDialog(null, "¿Seguro que desea borrar la pieza seleccionada?", "", 0, 3);
					if(i==0) {		
						int pos = tableTotalPiezas.getSelectedRow();
						if (pos != -1) {
							cambios = true;
							ID = (String) tableTotalPiezas.getValueAt(pos, 5);
							piezasAElim.add(ID);
							((DefaultTableModel) tableTotalPiezas.getModel()).removeRow(pos);		
							limpiarTodo();
							llenarTablaAdaptadores(modelAdaptadores);
							llenarTablaBocinas(modelBocinas);
							llenarTablaChasis(modelChasis);
							llenarTablaDiscos(modelDiscos);
							llenarTablaFuentes(modelFuentes);
							llenarTablaMicros(modelMicros);
							llenarTablaMonitores(modelMonitores);
							llenarTablaMotherboards(modelMotherboards);
							llenarTablaMouses(modelMouse);
							llenarTablaRAM(modelRAM);
							llenarTablaTarjetaVideo(modelTarjetas);
							llenarTablaTeclados(modelTeclados);
							llenarTablaTotalPiezas(modelTotalPiezas);
						} else {
							JOptionPane.showMessageDialog(ListadoDeProductos.this, "Antes de eliminar debe de seleccionar un componente de la tabla");
						}
					}
				}
			}
		});
		tableTotalPiezas.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane_11 = new JScrollPane(tableTotalPiezas);
		scrollPane_11.setFocusable(false);
		scrollPane_11.setBackground(new Color(255, 255, 255));
		panelTotalPiezas.add(scrollPane_11, BorderLayout.CENTER);

		tabbedPane.addTab("Adaptadores", panelAdaptadores);
		tabbedPane.addTab("Bocinas", panelBocinas);
		tabbedPane.addTab("Chasis", panelChasis);
		tabbedPane.addTab("Discos", panelDiscos);
		tabbedPane.addTab("Fuentes", panelFuentes);
		tabbedPane.addTab("Micros", panelMicros);
		tabbedPane.addTab("Monitores", panelMonitores);
		tabbedPane.addTab("Motherboards", panelMotherboards);
		tabbedPane.addTab("Mouses", panelMouse);
		tabbedPane.addTab("RAM", panelRAM);
		tabbedPane.addTab("Tarjetas de Video", panelTarjetas);
		tabbedPane.addTab("Teclados", panelTeclados);
		tabbedPane.addTab("General", panelTotalPiezas);

		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(new Color(255, 255, 255));
		btnAtras = new JButton("Atrás");
		btnAtras.setFocusable(false);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cambios) {
					int i = JOptionPane.showConfirmDialog(null, "¿Seguro que desea salir? No se guardarán los cambios realizados", "", 0, 3);
					if(i==0) {
						setVisible(false);
						piezasAElim.clear();
					}
				}
				else
					setVisible(false);
			}
		});

		panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelBotones.add(btnAtras);

		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		getContentPane().add(panelBotones, BorderLayout.SOUTH);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setToolTipText("Luego de realizados los cambios, presione este bot\u00F3n para que estos se guarden.");
		btnGuardar.setFocusable(false);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cambios) {
					int count = tienda.eliminarPiezas(piezasAElim);
					JOptionPane.showMessageDialog(ListadoDeProductos.this, "Cambios guardados satisfactoriamente. Se eliminaron " + count + " piezas");		
					setVisible(false);
					cambios = false;
					piezasAElim.clear();
				}
				else
					JOptionPane.showMessageDialog(ListadoDeProductos.this, "No ha realizado ningún cambio");	
			}
		});
		panelBotones.add(btnGuardar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setToolTipText("Seleccione una de las piezas y luego presione este bot\u00F3n o la tecla Delete, para eliminarla del almac\u00E9n.");
		btnBorrar.setFocusable(false);
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar la pieza seleccionada?", "", 0, 3);
				if(i==0) {		
					cambios = true;
					int posAd = tableAdaptadores.getSelectedRow();
					int posB = tableBocinas.getSelectedRow(); 
					int posC = tableChasis.getSelectedRow();
					int posD = tableDiscos.getSelectedRow();
					int posF = tableFuentes.getSelectedRow();
					int posMic = tableMicros.getSelectedRow();
					int posMon = tableMonitores.getSelectedRow();
					int posMoth = tableMotherboards.getSelectedRow();
					int posMous = tableMouses.getSelectedRow();
					int posR = tableRAM.getSelectedRow();
					int posTV = tableTarjetas.getSelectedRow();
					int posT = tableTeclados.getSelectedRow();
					int posPT = tableTotalPiezas.getSelectedRow();
					if (posAd != -1) {
						ID = (String) tableAdaptadores.getValueAt(posAd, 5);
						piezasAElim.add(ID);
						((DefaultTableModel) tableAdaptadores.getModel()).removeRow(posAd);
						limpiarAdaptadores();
						limpiarTotalPiezas();
						llenarTablaAdaptadores(modelAdaptadores);
						llenarTablaTotalPiezas(modelTotalPiezas);
					} else if (posB != -1) {
						ID = (String) tableBocinas.getValueAt(posB, 5);
						piezasAElim.add(ID);
						((DefaultTableModel) tableBocinas.getModel()).removeRow(posB);
						limpiarBocinas();
						limpiarTotalPiezas();
						llenarTablaBocinas(modelBocinas);
						llenarTablaTotalPiezas(modelTotalPiezas);
					} else if (posC != -1) {
						ID = (String) tableChasis.getValueAt(posC, 5);
						piezasAElim.add(ID);
						((DefaultTableModel) tableChasis.getModel()).removeRow(posC);
						limpiarChasis();
						limpiarTotalPiezas();
						llenarTablaChasis(modelChasis);
						llenarTablaTotalPiezas(modelTotalPiezas);
					} else if (posD != -1) {
						ID = (String) tableDiscos.getValueAt(posD, 5);
						piezasAElim.add(ID);
						((DefaultTableModel) tableDiscos.getModel()).removeRow(posD);
						limpiarDiscos();
						limpiarTotalPiezas();
						llenarTablaDiscos(modelDiscos);
						llenarTablaTotalPiezas(modelTotalPiezas);
					} else if (posF != -1) {
						ID = (String) tableFuentes.getValueAt(posF, 5);
						piezasAElim.add(ID);
						((DefaultTableModel) tableFuentes.getModel()).removeRow(posF);
						limpiarFuentes();
						limpiarTotalPiezas();
						llenarTablaFuentes(modelFuentes);
						llenarTablaTotalPiezas(modelTotalPiezas);
					} else if (posMic != -1) {
						ID = (String) tableMicros.getValueAt(posMic, 5);
						piezasAElim.add(ID);
						((DefaultTableModel) tableMicros.getModel()).removeRow(posMic);
						limpiarMicros();
						limpiarTotalPiezas();
						llenarTablaMicros(modelMicros);
						llenarTablaTotalPiezas(modelTotalPiezas);
					} else if (posMon != -1) {
						ID = (String) tableMonitores.getValueAt(posMon, 5);
						piezasAElim.add(ID);
						((DefaultTableModel) tableMonitores.getModel()).removeRow(posMon);
						limpiarMonitores();
						limpiarTotalPiezas();
						llenarTablaMonitores(modelMonitores);
						llenarTablaTotalPiezas(modelTotalPiezas);
					} else if (posMoth != -1) {
						ID = (String) tableMotherboards.getValueAt(posMoth, 5);
						piezasAElim.add(ID);
						((DefaultTableModel) tableMotherboards.getModel()).removeRow(posMoth);
						limpiarMotherboards();
						limpiarTotalPiezas();
						llenarTablaMotherboards(modelMotherboards);
						llenarTablaTotalPiezas(modelTotalPiezas);
					} else if (posMous != -1) {
						ID = (String) tableMouses.getValueAt(posMous, 5);
						piezasAElim.add(ID);
						((DefaultTableModel) tableMouses.getModel()).removeRow(posMous);
						limpiarMouses();
						limpiarTotalPiezas();
						llenarTablaMouses(modelMouse);
						llenarTablaTotalPiezas(modelTotalPiezas);
					} else if (posR != -1) {
						ID = (String) tableRAM.getValueAt(posR, 5);
						piezasAElim.add(ID);
						((DefaultTableModel) tableRAM.getModel()).removeRow(posR);
						limpiarRAM();
						limpiarTotalPiezas();
						llenarTablaRAM(modelRAM);
						llenarTablaTotalPiezas(modelTotalPiezas);
					} else if (posTV != -1) {
						ID = (String) tableTarjetas.getValueAt(posTV, 5);
						piezasAElim.add(ID);
						((DefaultTableModel) tableTarjetas.getModel()).removeRow(posTV);
						limpiarTarjetas();
						limpiarTotalPiezas();
						llenarTablaTarjetaVideo(modelTarjetas);
						llenarTablaTotalPiezas(modelTotalPiezas);
					} else if (posT != -1) {
						ID = (String) tableTeclados.getValueAt(posT, 5);
						piezasAElim.add(ID);
						((DefaultTableModel) tableTeclados.getModel()).removeRow(posT);		
						limpiarTeclados();
						limpiarTotalPiezas();
						llenarTablaTeclados(modelTeclados);
						llenarTablaTotalPiezas(modelTotalPiezas);
					} else if (posPT != -1) {
						ID = (String) tableTotalPiezas.getValueAt(posPT, 5);
						piezasAElim.add(ID);
						((DefaultTableModel) tableTotalPiezas.getModel()).removeRow(posPT);		
						limpiarTodo();
						llenarTablaAdaptadores(modelAdaptadores);
						llenarTablaBocinas(modelBocinas);
						llenarTablaChasis(modelChasis);
						llenarTablaDiscos(modelDiscos);
						llenarTablaFuentes(modelFuentes);
						llenarTablaMicros(modelMicros);
						llenarTablaMonitores(modelMonitores);
						llenarTablaMotherboards(modelMotherboards);
						llenarTablaMouses(modelMouse);
						llenarTablaRAM(modelRAM);
						llenarTablaTarjetaVideo(modelTarjetas);
						llenarTablaTeclados(modelTeclados);
						llenarTablaTotalPiezas(modelTotalPiezas);
					} else {
						JOptionPane.showMessageDialog(ListadoDeProductos.this, "Antes de eliminar debe de seleccionar un componente de la tabla");
					}
				}
			}
		});
		panelBotones.add(btnBorrar);

		piezasAElim.clear();				
		llenarTablaAdaptadores(modelAdaptadores);
		llenarTablaBocinas(modelBocinas);
		llenarTablaChasis(modelChasis);
		llenarTablaDiscos(modelDiscos);
		llenarTablaFuentes(modelFuentes);
		llenarTablaMicros(modelMicros);
		llenarTablaMonitores(modelMonitores);
		llenarTablaMotherboards(modelMotherboards);
		llenarTablaMouses(modelMouse);
		llenarTablaRAM(modelRAM);
		llenarTablaTarjetaVideo(modelTarjetas);
		llenarTablaTeclados(modelTeclados);
		llenarTablaTotalPiezas(modelTotalPiezas);
	}

	private static void llenarTablaAdaptadores(DefaultTableModel model) {
		count = 1;             
		for (ComponenteOrdenador c : tienda.getComponentes()) {
			if(c instanceof Adaptador && c.getCantDisponible() > 0)
				if(!piezasAElim.isEmpty()) {
					boolean encontrado = false;
					for(int i = 0; i < piezasAElim.size(); i++) {
						if(c.getNumSerie().equals(piezasAElim.get(i))) {
							encontrado = true;
						}
					}
					if(!encontrado)
						model.addRow(new Object[]{count++, c.getMarca(), c.getModelo(), (String.format("%.2f", c.getPrecio())), c.getCantDisponible(), c.getNumSerie()});
				}
				else {
					model.addRow(new Object[]{count++, c.getMarca(), c.getModelo(), (String.format("%.2f", c.getPrecio())), c.getCantDisponible(), c.getNumSerie()});
				}
		}
	}

	private static void llenarTablaBocinas(DefaultTableModel model) {
		count = 1;
		for (ComponenteOrdenador c : tienda.getComponentes()) {
			if(c instanceof Bocina && c.getCantDisponible() > 0) 
				if(!piezasAElim.isEmpty()) {
					boolean encontrado = false;
					for(int i = 0; i < piezasAElim.size(); i++) {
						if(c.getNumSerie().equals(piezasAElim.get(i))) {
							encontrado = true;
						}
					}
					if(!encontrado)
						model.addRow(new Object[]{count++, c.getMarca(), c.getModelo(), (String.format("%.2f", c.getPrecio())), c.getCantDisponible(), c.getNumSerie()});
				}
				else {
					model.addRow(new Object[]{count++, c.getMarca(), c.getModelo(), (String.format("%.2f", c.getPrecio())), c.getCantDisponible(), c.getNumSerie()});
				}
		}
	}

	private static void llenarTablaChasis(DefaultTableModel model) {
		count= 1;
		for (ComponenteOrdenador c : tienda.getComponentes()) {
			if(c instanceof Chasis && c.getCantDisponible() > 0)
				if(!piezasAElim.isEmpty()) {
					boolean encontrado = false;
					for(int i = 0; i < piezasAElim.size(); i++) {
						if(c.getNumSerie().equals(piezasAElim.get(i))) {
							encontrado = true;
						}
					}
					if(!encontrado)
						model.addRow(new Object[]{count++, c.getMarca(), c.getModelo(), (String.format("%.2f", c.getPrecio())), c.getCantDisponible(), c.getNumSerie()});
				}
				else {
					model.addRow(new Object[]{count++, c.getMarca(), c.getModelo(), (String.format("%.2f", c.getPrecio())), c.getCantDisponible(), c.getNumSerie()});
				}
		}
	}

	private static void llenarTablaDiscos(DefaultTableModel model) {
		count= 1;
		for (ComponenteOrdenador c : tienda.getComponentes()) {
			if(c instanceof DiscoDuro && c.getCantDisponible() > 0)
				if(!piezasAElim.isEmpty()) {
					boolean encontrado = false;
					for(int i = 0; i < piezasAElim.size(); i++) {
						if(c.getNumSerie().equals(piezasAElim.get(i))) {
							encontrado = true;
						}
					}
					if(!encontrado)
						model.addRow(new Object[]{count++, c.getMarca(), c.getModelo(), (String.format("%.2f", c.getPrecio())), c.getCantDisponible(), c.getNumSerie()});
				}
				else {
					model.addRow(new Object[]{count++, c.getMarca(), c.getModelo(), (String.format("%.2f", c.getPrecio())), c.getCantDisponible(), c.getNumSerie()});
				}
		}
	}

	private static void llenarTablaFuentes(DefaultTableModel model) {
		count = 1;
		for (ComponenteOrdenador c : tienda.getComponentes()) {
			if(c instanceof Fuente && c.getCantDisponible() > 0)
				if(!piezasAElim.isEmpty()) {	
					boolean encontrado = false;
					for(int i = 0; i < piezasAElim.size(); i++) {
						if(c.getNumSerie().equals(piezasAElim.get(i))) {
							encontrado = true;
						}
					}
					if(!encontrado)
						model.addRow(new Object[]{count++, c.getMarca(), c.getModelo(), (String.format("%.2f", c.getPrecio())), c.getCantDisponible(), c.getNumSerie()});
				}
				else {
					model.addRow(new Object[]{count++, c.getMarca(), c.getModelo(), (String.format("%.2f", c.getPrecio())), c.getCantDisponible(), c.getNumSerie()});
				}
		}
	}

	private static void llenarTablaMicros(DefaultTableModel model) {
		count = 1;
		for (ComponenteOrdenador c : tienda.getComponentes()) {
			if(c instanceof Microprocesador && c.getCantDisponible() > 0)
				if(!piezasAElim.isEmpty()) {
					boolean encontrado = false;
					for(int i = 0; i < piezasAElim.size(); i++) {
						if(c.getNumSerie().equals(piezasAElim.get(i))) {
							encontrado = true;
						}
					}
					if(!encontrado)
						model.addRow(new Object[]{count++, c.getMarca(), c.getModelo(), (String.format("%.2f", c.getPrecio())), c.getCantDisponible(), c.getNumSerie()});
				}
				else {
					model.addRow(new Object[]{count++, c.getMarca(), c.getModelo(), (String.format("%.2f", c.getPrecio())), c.getCantDisponible(), c.getNumSerie()});
				}
		}
	}

	private static void llenarTablaMonitores(DefaultTableModel model) {
		count = 1;
		for (ComponenteOrdenador c : tienda.getComponentes()) {
			if(c instanceof Monitor && c.getCantDisponible() > 0)
				if(!piezasAElim.isEmpty()) {
					boolean encontrado = false;
					for(int i = 0; i < piezasAElim.size(); i++) {
						if(c.getNumSerie().equals(piezasAElim.get(i))) {
							encontrado = true;
						}
					}
					if(!encontrado)
						model.addRow(new Object[]{count++, c.getMarca(), c.getModelo(), (String.format("%.2f", c.getPrecio())), c.getCantDisponible(), c.getNumSerie()});
				}
				else {
					model.addRow(new Object[]{count++, c.getMarca(), c.getModelo(), (String.format("%.2f", c.getPrecio())), c.getCantDisponible(), c.getNumSerie()});
				}
		}
	}

	private static void llenarTablaMotherboards(DefaultTableModel model) {
		count = 1;
		for (ComponenteOrdenador c : tienda.getComponentes()) {
			if(c instanceof TarjetaMadre && c.getCantDisponible() > 0)
				if(!piezasAElim.isEmpty()) {
					boolean encontrado = false;
					for(int i = 0; i < piezasAElim.size(); i++) {
						if(c.getNumSerie().equals(piezasAElim.get(i))) {
							encontrado = true;
						}
					}
					if(!encontrado)
						model.addRow(new Object[]{count++, c.getMarca(), c.getModelo(), (String.format("%.2f", c.getPrecio())), c.getCantDisponible(), c.getNumSerie()});
				}
				else {
					model.addRow(new Object[]{count++, c.getMarca(), c.getModelo(), (String.format("%.2f", c.getPrecio())), c.getCantDisponible(), c.getNumSerie()});
				}
		}
	}

	private static void llenarTablaMouses(DefaultTableModel model) {
		count = 1;
		for (ComponenteOrdenador c : tienda.getComponentes()) {
			if(c instanceof Mouse && c.getCantDisponible() > 0)
				if(!piezasAElim.isEmpty()) {
					boolean encontrado = false;
					for(int i = 0; i < piezasAElim.size(); i++) {
						if(c.getNumSerie().equals(piezasAElim.get(i))) {
							encontrado = true;
						}
					}
					if(!encontrado)
						model.addRow(new Object[]{count++, c.getMarca(), c.getModelo(), (String.format("%.2f", c.getPrecio())), c.getCantDisponible(), c.getNumSerie()});
				}
				else {
					model.addRow(new Object[]{count++, c.getMarca(), c.getModelo(), (String.format("%.2f", c.getPrecio())), c.getCantDisponible(), c.getNumSerie()});
				}
		}
	}

	private static void llenarTablaRAM(DefaultTableModel model) {
		count = 1;
		for (ComponenteOrdenador c : tienda.getComponentes()) {
			if(c instanceof MemoriaRam && c.getCantDisponible() > 0)
				if(!piezasAElim.isEmpty()) {
					boolean encontrado = false;
					for(int i = 0; i < piezasAElim.size(); i++) {
						if(c.getNumSerie().equals(piezasAElim.get(i))) {
							encontrado = true;
						}
					}
					if(!encontrado)
						model.addRow(new Object[]{count++, c.getMarca(), c.getModelo(), (String.format("%.2f", c.getPrecio())), c.getCantDisponible(), c.getNumSerie()});
				}
				else {
					model.addRow(new Object[]{count++, c.getMarca(), c.getModelo(), (String.format("%.2f", c.getPrecio())), c.getCantDisponible(), c.getNumSerie()});
				}
		}
	}

	private static void llenarTablaTarjetaVideo(DefaultTableModel model) {
		count = 1;
		for (ComponenteOrdenador c : tienda.getComponentes()) {
			if(c instanceof TarjetaDeVideo && c.getCantDisponible() > 0)
				if(!piezasAElim.isEmpty()) {
					boolean encontrado = false;
					for(int i = 0; i < piezasAElim.size(); i++) {
						if(c.getNumSerie().equals(piezasAElim.get(i))) {
							encontrado = true;
						}
					}
					if(!encontrado)
						model.addRow(new Object[]{count++, c.getMarca(), c.getModelo(), (String.format("%.2f", c.getPrecio())), c.getCantDisponible(), c.getNumSerie()});
				}
				else {
					model.addRow(new Object[]{count++, c.getMarca(), c.getModelo(), (String.format("%.2f", c.getPrecio())), c.getCantDisponible(), c.getNumSerie()});
				}
		}
	}

	private static void llenarTablaTeclados(DefaultTableModel model) {
		count = 1;
		for (ComponenteOrdenador c : tienda.getComponentes()) {
			if(c instanceof Teclado && c.getCantDisponible() > 0)
				if(!piezasAElim.isEmpty()) {
					boolean encontrado = false;
					for(int i = 0; i < piezasAElim.size(); i++) {
						if(c.getNumSerie().equals(piezasAElim.get(i))) {
							encontrado = true;
						}
					}
					if(!encontrado)
						model.addRow(new Object[]{count++, c.getMarca(), c.getModelo(), (String.format("%.2f", c.getPrecio())), c.getCantDisponible(), c.getNumSerie()});
				}
				else {
					model.addRow(new Object[]{count++, c.getMarca(), c.getModelo(), (String.format("%.2f", c.getPrecio())), c.getCantDisponible(), c.getNumSerie()});
				}
		}
	}

	private static void llenarTablaTotalPiezas(DefaultTableModel model) {
		count = 1;
		for (ComponenteOrdenador c : tienda.getComponentes()) {
			if(c.getCantDisponible() > 0) {
				if(!piezasAElim.isEmpty()) {
					boolean encontrado = false;
					for(int i = 0; i < piezasAElim.size(); i++) {
						if(c.getNumSerie().equals(piezasAElim.get(i))) {
							encontrado = true;
						}
					}
					if(!encontrado)
						model.addRow(new Object[]{count++, c.getMarca(), c.getModelo(), (String.format("%.2f", c.getPrecio())), c.getCantDisponible(), c.getNumSerie()});
				}
				else {
					model.addRow(new Object[]{count++, c.getMarca(), c.getModelo(), (String.format("%.2f", c.getPrecio())), c.getCantDisponible(), c.getNumSerie()});
				}
			}
		}
	}

	private static void limpiarAdaptadores() {
		while(((DefaultTableModel) tableAdaptadores.getModel()).getRowCount() > 0)
			((DefaultTableModel) tableAdaptadores.getModel()).removeRow(0);
	}

	private static void limpiarBocinas() {
		while(((DefaultTableModel) tableBocinas.getModel()).getRowCount() > 0)
			((DefaultTableModel) tableBocinas.getModel()).removeRow(0);
	}

	private static void limpiarChasis() {
		while(((DefaultTableModel) tableChasis.getModel()).getRowCount() > 0)
			((DefaultTableModel) tableChasis.getModel()).removeRow(0);
	}

	private static void limpiarDiscos() {
		while(((DefaultTableModel) tableDiscos.getModel()).getRowCount() > 0)
			((DefaultTableModel) tableDiscos.getModel()).removeRow(0);
	}

	private static void limpiarFuentes() {
		while(((DefaultTableModel) tableFuentes.getModel()).getRowCount() > 0)
			((DefaultTableModel) tableFuentes.getModel()).removeRow(0);
	}

	private static void limpiarMicros() {
		while(((DefaultTableModel) tableMicros.getModel()).getRowCount() > 0)
			((DefaultTableModel) tableMicros.getModel()).removeRow(0);
	}

	private static void limpiarMonitores() {
		while(((DefaultTableModel) tableMonitores.getModel()).getRowCount() > 0)
			((DefaultTableModel) tableMonitores.getModel()).removeRow(0);
	}

	private static void limpiarMotherboards() {
		while(((DefaultTableModel) tableMotherboards.getModel()).getRowCount() > 0)
			((DefaultTableModel) tableMotherboards.getModel()).removeRow(0);
	}

	private static void limpiarMouses() {
		while(((DefaultTableModel) tableMouses.getModel()).getRowCount() > 0)
			((DefaultTableModel) tableMouses.getModel()).removeRow(0);
	}

	private static void limpiarRAM() {
		while(((DefaultTableModel) tableRAM.getModel()).getRowCount() > 0)
			((DefaultTableModel) tableRAM.getModel()).removeRow(0);
	}

	private static void limpiarTarjetas() {
		while(((DefaultTableModel) tableTarjetas.getModel()).getRowCount() > 0)
			((DefaultTableModel) tableTarjetas.getModel()).removeRow(0);
	}

	private static void limpiarTeclados() {
		while(((DefaultTableModel) tableTeclados.getModel()).getRowCount() > 0)
			((DefaultTableModel) tableTeclados.getModel()).removeRow(0);
	}

	private static void limpiarTotalPiezas() {
		while(((DefaultTableModel) tableTotalPiezas.getModel()).getRowCount() > 0)
			((DefaultTableModel) tableTotalPiezas.getModel()).removeRow(0);
	}

	private static void limpiarTodo() {
		limpiarAdaptadores();
		limpiarBocinas();
		limpiarChasis();
		limpiarDiscos();
		limpiarFuentes();
		limpiarMicros();
		limpiarMonitores();
		limpiarMotherboards();
		limpiarMouses();
		limpiarRAM();
		limpiarTarjetas();
		limpiarTeclados();
		limpiarTotalPiezas();
	}

	private void informacionProd() {
		try {
			InformacionProductos dialog = new InformacionProductos(p, tienda, ID);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

