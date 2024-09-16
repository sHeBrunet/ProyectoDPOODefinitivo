package interfaz;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import logica.ComponenteOrdenador;
import logica.Factura;
import logica.TiendaDeComputadoras;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PiezasVendidasPrecios extends JDialog {
    private static final long serialVersionUID = 1L;
    private static TiendaDeComputadoras tienda;
    private JButton btnAtras;
    private JButton btnActualizar;
    private JTable tableProductos;
    private DefaultTableModel modelPiezas;
    private JLabel totalLabel;
    private JTextField textFieldPrecio;
    private JRadioButton BtnMax;
    private JRadioButton BtnMin;

    public PiezasVendidasPrecios(Principal principal, TiendaDeComputadoras t) {
        super(principal, true);
        tienda = t;
        setTitle("Dinero por encima de un precio dado");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(900, 746);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        tabbedPane.setBounds(0, 0, 894, 676);

        JPanel panelProductos = new JPanel();
        String[] columnNamesPiezas = { "Nombre", "Cantidad", "Precio" };
        modelPiezas = new DefaultTableModel(columnNamesPiezas, 0);
        tableProductos = new JTable(modelPiezas);
        tableProductos.setGridColor(new Color(135, 206, 235));
        tableProductos.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(tableProductos);
        scrollPane.setBounds(259, 0, 618, 609);
        panelProductos.setLayout(null);
        panelProductos.add(scrollPane);

        tabbedPane.addTab("Piezas", panelProductos);

        totalLabel = new JLabel("Total: 0");
        totalLabel.setHorizontalAlignment(SwingConstants.CENTER);
        totalLabel.setBounds(271, 610, 618, 36);
        panelProductos.add(totalLabel);

        textFieldPrecio = new JTextField();
        textFieldPrecio.addKeyListener(new KeyAdapter() {
        	public void keyTyped(KeyEvent e) {
				if(textFieldPrecio.getText().length() < 11) {
					char t = e.getKeyChar();
					if((t- '0' > 9 || t- '0' < 0) && t!= 8) {
						JOptionPane.showMessageDialog(null, "Solo se pueden introducir numeros en este campo", "Datos erróneos", JOptionPane.ERROR_MESSAGE);
						e.consume();
					}
				}
				else {
					e.consume();
				}
			}
        });
        textFieldPrecio.setBounds(120, 102, 127, 29);
        panelProductos.add(textFieldPrecio);
        textFieldPrecio.setColumns(10);

        JLabel lblNewLabel = new JLabel("Precio  :");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(4, 97, 112, 36);
        panelProductos.add(lblNewLabel);
        
        BtnMax = new JRadioButton("Mayor que");
        BtnMax.setFont(new Font("Tahoma", Font.BOLD, 15));
        BtnMax.setBounds(4, 50, 127, 25);
        panelProductos.add(BtnMax);
        
        BtnMin = new JRadioButton("Menor que");
        BtnMin.setFont(new Font("Tahoma", Font.BOLD, 15));
        BtnMin.setBounds(133, 50, 112, 25);
        panelProductos.add(BtnMin);

        ButtonGroup group = new ButtonGroup();
        group.add(BtnMax);
        group.add(BtnMin);

        JPanel panelBotones = new JPanel();
        panelBotones.setBounds(0, 676, 894, 35);
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarTabla();
            }
        });
        panelBotones.add(btnActualizar);

        btnAtras = new JButton("Atrás");
        btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = JOptionPane.showConfirmDialog(null, "¿Seguro que desea salir?", "", JOptionPane.YES_NO_OPTION);
                if (i == JOptionPane.YES_OPTION) {
                    setVisible(false);
                }
            }
        });
        panelBotones.add(btnAtras);

        getContentPane().setLayout(null);
        getContentPane().add(tabbedPane);
        getContentPane().add(panelBotones);
    }

    private void actualizarTabla() {
        try {
            float precioMinimo = Float.parseFloat(textFieldPrecio.getText());
            llenarTablaPiezas(modelPiezas, precioMinimo);
            actualizarTotal();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, introduzca un precio válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void llenarTablaPiezas(DefaultTableModel modelPiezas, float precioMinimo) {
        modelPiezas.setRowCount(0); 
        for (Factura factura : tienda.getFacturas()) {
            ArrayList<ComponenteOrdenador> componentes = factura.getCom();
            ArrayList<Integer> cantidades = factura.getCantidadXPieza();
            for (int i = 0; i < componentes.size(); i++) {
                ComponenteOrdenador componente = componentes.get(i);
                int cantidad = cantidades.get(i);
                float precio = componente.getPrecio();
                String nameComplete = componente.getModelo() + " " + componente.getMarca();
                if (BtnMax.isSelected() && precio >= precioMinimo || BtnMin.isSelected() && precio <= precioMinimo) {
                    modelPiezas.addRow(new Object[]{nameComplete, cantidad, precio});    
                }
            }
        }
    }

    private void actualizarTotal() {
        float total = tienda.DineroToTalRecaudado();
        totalLabel.setText("Total: " + total);
    }
}
