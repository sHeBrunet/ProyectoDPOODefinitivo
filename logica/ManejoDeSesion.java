package logica;

public class ManejoDeSesion {
	private static ManejoDeSesion instance;
	private String username;
	private String password;

	public ManejoDeSesion() {	
	}
	public static ManejoDeSesion getInstance() {
		if(instance == null) {
			instance = new ManejoDeSesion();
		}
		return instance;

	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void cerrarSesion() {
		System.out.println("Cerrando sesión...");
		if (this.username != null && this.password != null) {
			
		} else {
			System.out.println("Username y password es null");
		}
		this.password = null;
		this.username = null;
		System.out.println("Sesión cerrada.");
	}



}
