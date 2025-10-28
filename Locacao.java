public class Locacao {
	private Cliente cliente;
	private Midia midia;
	private int diasDeLocacao;
	private double valorTotal;
	private boolean estaLocado;


    // construtor
	public void Aluguel(Cliente cliente, Midia midia) {
		this.cliente = cliente;
		this.midia = midia;
	}
	public void Aluguel() {}


    // settters e getters
	public void setEstaLocado(boolean estaLocado) {
		this.estaLocado = estaLocado;
	}
	public boolean isEstaLocado() {
		return this.estaLocado;
	}
	public Cliente getCliente() {
		return this.cliente;
	}
	public Midia getMidia() {
		return this.midia;
	}
	public void setDiasDeLocacao(int dias) {
		this.diasDeLocacao = dias;
	}
	public int getDiasDeLocacao() {
		return this.diasDeLocacao;
	}


    // calculando o valor da Locacao
	public void calcularValorTotal() {
		this.valorTotal = midia.calcularPreco();
	}
	public double getValorTotal() {
		return this.valorTotal;
	}

    
}