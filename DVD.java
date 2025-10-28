public class DVD extends Midia {
	private boolean possuiExtras;


    // construtor
	public DVD(String titulo, double precoBase, boolean extras) {
		super(titulo, precoBase);
		this.setPossuiExtras(extras);
	}


	public void setPossuiExtras(boolean possuiExtras) {
		this.possuiExtras = possuiExtras;
	}
	public boolean isPossuiExtras() {
		return this.possuiExtras;
	}


    // calculo do preco da midia
	@Override
	public double calcularPreco() {
		if (possuiExtras) {
			return this.getPrecoBase() + 15.25;
		} else {
			return this.getPrecoBase();
		}
	}
}