public abstract class Midia {
	private String nome;
	private double precoBase;
	private boolean disponivel;


	//construtor
	public Midia(String nome, double precoBase) {
		this.setNome(nome);
		this.setPrecoBase(precoBase);
		this.setDisponivel(true);
	}
	public Midia() {
		this.disponivel = true;
	}


	//setters e getters
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
	public void setPrecoBase(double precoBase) {
		this.precoBase = precoBase;
	}
	public double getPrecoBase() {
		return this.precoBase;
	}
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	public boolean isDisponivel() {
		return this.disponivel;
	}


	//funcao abstrata de caclulo de preco
	public abstract double calcularPreco();


	//print
	@Override
	public String toString() {
		return "Nome: " + nome + "\n" +
		       "Preco: " + calcularPreco() + " | " + (disponivel ? "DisponC-vel" : "IndisponC-vel");
	}
}