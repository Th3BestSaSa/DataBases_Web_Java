package Producto1;

import java.util.Objects;

public class Categoria {
	private static final int MAX_IVA=30;
	private String nombreCategoria;
	private double ivaAplicable ;
	
	public Categoria(String nombreCategoria, double iva) throws ProductoEsception {
		super();
		this.nombreCategoria = nombreCategoria;
		setIvaAplicable(iva);
	}
	
	/**
	 * @return the nombreCategoria
	 */
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	/**
	 * @param nombreCategoria the nombreCategoria to set
	 */
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	/**
	 * @return the ivaAplicable
	 */
	public double getIvaAplicable() {
		return ivaAplicable;
	}
	/**
	 * @param ivaAplicable the ivaAplicable to set
	 */
	public void setIvaAplicable(double ivaAplicable) throws ProductoEsception{
		if (ivaAplicable<0 || ivaAplicable > MAX_IVA) {
			throw new  ProductoEsception("ERROR");
		}
		this.ivaAplicable = ivaAplicable;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(ivaAplicable, nombreCategoria);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Double.doubleToLongBits(ivaAplicable) == Double.doubleToLongBits(other.ivaAplicable)
				&& Objects.equals(nombreCategoria, other.nombreCategoria);
	}

	@Override
	public String toString() {
		return "Categoria [nombreCategoria=" + nombreCategoria + ", ivaAplicable=" + ivaAplicable + "]";
	}
	
}
