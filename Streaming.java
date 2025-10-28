public class Streaming extends Midia {
	private String plataforma;


	// construtor
	public Streaming(String titulo, double precoBase, String plataforma) {
		super(titulo, precoBase);
		this.setPlataforma(plataforma);
	}


	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	public String getPlataforma() {
		return this.plataforma;
	}


	// calculo do preco da midia
	@Override
	public double calcularPreco() {
		double preco = this.getPrecoBase() * 0.8;
		return Math.round(preco * 100.0) / 100.0;
	}
}