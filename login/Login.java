package login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import componentesVisuales.AvatarCircular;
import componentesVisuales.BotonAnimacion;
import componentesVisuales.JTextFieldModificado;
import interfaz.Principal;
import logica.ManejoDeSesion;
import logica.TiendaDeComputadoras;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelGeneral;
	private JPasswordField passwordField;
	private String userInicial = "Introduzca su nombre de usuario";
	private String usuario = "informatica2024";
	private String passInicial = "Introduzca su contraseña";
	private static String pass = "1234"; 
	private static String pass1 = "4321";
	private String admin = "gerente2024"; 
	private String user = null;
	private static boolean visible = false;
	private static Principal principal;
	private JButton btnHacerVisible;
	private JTextField textField;
	private BotonAnimacion btnIniciar;
	private JTextFieldModificado userField;

	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/gui/icons/logoPeque\u00F1o1.jpg")));
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setBounds(100, 100, 485, 550);
		panelGeneral = new JPanel();
		panelGeneral.setBackground(Color.WHITE);
		panelGeneral.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelGeneral);
		panelGeneral.setLayout(null);

		AvatarCircular avatarCircular = new AvatarCircular();
		avatarCircular.setAvatar(new ImageIcon(Login.class.getResource("/gui/icons/usuario.jpg")));
		avatarCircular.setBounds(159, 44, 156, 133);
		panelGeneral.add(avatarCircular);

		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c == KeyEvent.VK_ENTER)
					btnIniciar.doClick();
			}
		});
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(String.valueOf(passwordField.getPassword()).equals(passInicial)){
					passwordField.setText("");
					passwordField.setForeground(Color.BLACK);
					passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 204)));
					btnHacerVisible.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 204)));
				}
				else {
					passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 204)));
					btnHacerVisible.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 204)));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(String.valueOf(passwordField.getPassword()).isEmpty()){
					passwordField.setText(passInicial);
					passwordField.setForeground(Color.GRAY);
					passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
					btnHacerVisible.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
				}
				else {
					passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
					btnHacerVisible.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
				}
			}
		});
		passwordField.setEchoChar('*');
		passwordField.setBackground(new Color(255, 255, 255));
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordField.setBounds(75, 344, 278, 23);
		passwordField.setText(passInicial);
		passwordField.setForeground(Color.GRAY);
		panelGeneral.add(passwordField);

		userField = new JTextFieldModificado();
		userField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c==KeyEvent.VK_ENTER)
					btnIniciar.doClick();
			}
		});
		userField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(userField.getText().equals(userInicial)){
					userField.setText("");
					userField.setForeground(Color.BLACK);
					userField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 204)));
				}
				else {
					userField.setForeground(Color.BLACK);
					userField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 204)));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(userField.getText().isEmpty()){
					userField.setText(userInicial);
					userField.setForeground(Color.GRAY);
					userField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
				}
				else {
					userField.setForeground(Color.BLACK);
					userField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
				}
			}
		});
		userField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		userField.setText(userInicial);
		userField.setForeground(Color.GRAY);
		userField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		userField.setLimite(25);
		userField.setBounds(75, 271, 310, 23);
		panelGeneral.add(userField);
		panelGeneral.add(userField);

		btnIniciar = new BotonAnimacion();
		btnIniciar.setFocusable(false);
		btnIniciar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnIniciar.setBackground(new Color(30, 144, 255));
			}
			public void mouseExited(MouseEvent e) {
				btnIniciar.setBackground(new Color(135, 206, 250));
			}
		});
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!userField.getText().isEmpty() && !String.valueOf(passwordField.getPassword()).isEmpty()) {
					if ((usuario.equals(userField.getText()) && pass.equals(String.valueOf(passwordField.getPassword()))) || 
							(admin.equals(userField.getText()) && pass1.equals(String.valueOf(passwordField.getPassword())))) {

						// Cerrar sesión anterior
						ManejoDeSesion manejo = ManejoDeSesion.getInstance();
						if (manejo != null) {
							manejo.cerrarSesion();
						} else {
							System.out.println("ManejoDeSesion es null");
						}

						// Iniciar nueva sesión
						user = userField.getText();
						String password = String.valueOf(passwordField.getPassword());
						ManejoDeSesion.getInstance().setUsername(user);
						ManejoDeSesion.getInstance().setPassword(password); 
						dispose();

						try {
							UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
						} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e1) {
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "Error al aplicar el LookAndFeel.", "ERROR", JOptionPane.ERROR_MESSAGE);
						}

						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									if (principal == null) {
										principal = new Principal(TiendaDeComputadoras.getInstancia(), ManejoDeSesion.getInstance());
									}
									principal.setLocationRelativeTo(null);
									principal.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					} else {
						JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrecta.", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos.", "ERROR", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnIniciar.setBackground(new Color(135, 206, 250));
		btnIniciar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnIniciar.setText("Iniciar Sesi\u00F3n");
		btnIniciar.setColorEfecto(new Color(0, 255, 255));
		btnIniciar.setBounds(159, 443, 156, 34);
		panelGeneral.add(btnIniciar);

		JLabel lblPass = new JLabel("Contrase\u00F1a:");
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPass.setBounds(130, 317, 129, 23);
		panelGeneral.add(lblPass);

		JLabel labelUser = new JLabel("Nombre de Usuario:");
		labelUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelUser.setBounds(130, 237, 162, 23);
		panelGeneral.add(labelUser);

		JLabel iconUser = new JLabel("");
		iconUser.setIcon(new ImageIcon(Login.class.getResource("/gui/icons/usuarios3.png")));
		iconUser.setBounds(73, 233, 47, 27);
		panelGeneral.add(iconUser);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/gui/icons/pass2.png")));
		label.setBounds(85, 313, 40, 27);
		panelGeneral.add(label);

		btnHacerVisible = new JButton("");
		btnHacerVisible.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		btnHacerVisible.setFocusable(false);
		btnHacerVisible.setIcon(new ImageIcon(Login.class.getResource("/gui/icons/mostrar pass.png")));
		btnHacerVisible.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!visible){
					passwordField.setEchoChar((char)0);
					visible = true;
					btnHacerVisible.setIcon(new ImageIcon(Login.class.getResource("/gui/icons/ocultar pass.png")));
				}
				else {
					passwordField.setEchoChar('*');
					visible = false;
					btnHacerVisible.setIcon(new ImageIcon(Login.class.getResource("/gui/icons/mostrar pass.png")));
				}
			}

		});
		btnHacerVisible.setBackground(new Color(255, 255, 255));
		btnHacerVisible.setBounds(353, 344, 32, 23);
		panelGeneral.add(btnHacerVisible);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(187, 102, 3, 20);
		panelGeneral.add(textField);
		textField.setColumns(10);

		setLocationRelativeTo(null);

	}
}
