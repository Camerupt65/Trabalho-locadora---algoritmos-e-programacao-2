public class FitaVHS extends Midia {
	private boolean rebobinada;


    // construtor
	public FitaVHS(String titulo, double precoBase, boolean rebobinada) {
		super(titulo, precoBase);
		this.setRebobinada(rebobinada);
	}


	public void setRebobinada(boolean rebobinada) {
		this.rebobinada = rebobinada;
	}
	public boolean isRebobinada() {
		return this.rebobinada;
	}


    // calculo do preco da midia
	@Override
	public double calcularPreco() {
		if (rebobinada) {
			return this.getPrecoBase();
		} else {
			return this.getPrecoBase() + 10.50;
		}
	}
}