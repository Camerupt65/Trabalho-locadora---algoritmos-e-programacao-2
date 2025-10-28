public class Cliente {
	private String nome;
	private String email;
	private int id;


    // construtor
	public Cliente(String nome, String email, int id) {
		this.setNome(nome);
		this.setEmail(email);
		this.setId(id);
	}
	public Cliente() {}


    // setter e getters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

    // print
	@Override
	public String toString() {
		return "ID: " + id + " | Nome: " + nome + " | Email: " + email;
	}
}
