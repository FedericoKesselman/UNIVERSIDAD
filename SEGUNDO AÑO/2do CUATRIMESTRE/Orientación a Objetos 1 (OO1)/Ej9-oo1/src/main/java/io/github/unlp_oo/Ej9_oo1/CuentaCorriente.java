package io.github.unlp_oo.Ej9_oo1;

public class CuentaCorriente extends Cuenta{
	private double descubierto;
	
	public CuentaCorriente () {
		super();
		this.descubierto = 0;
	}
	
	public double getDescubierto() {
		return this.descubierto;
	}
	
	public void setDescubierto(double descubierto) {
		this.descubierto = descubierto;
	}
	
	
	public boolean puedeExtraer(double monto) {
		return (this.getSaldo() + this.descubierto) >= monto;
	}
}
