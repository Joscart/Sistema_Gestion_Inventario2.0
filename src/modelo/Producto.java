package modelo;

import libreria.Generica;

public class Producto {
	
	Generica<String, Double> dt_prd;
	Generica<Integer, Proveedor>dte_prd;
	String codigo;

	public Producto() {
		
		dt_prd = new Generica<>();
		dte_prd = new Generica<>();
	}
	
	public Producto(String name, String desc, String codigo, double precio, int stock, Proveedor proveedor) {
		dt_prd = new Generica<>(name, desc,precio );
		dte_prd = new Generica<>(stock, proveedor);
		this.codigo = codigo;
		
	}
	
	//Getters
	
	public String getname(){
		return dt_prd.getAtributo1();
	}
	
	public String getDesc() {
		return dt_prd.getAtributo2();
	}
	
	public double getprecio() {
		return dt_prd.getAtributo3();
	}
	
	public int getstock(){
		return dte_prd.getAtributo1();
	}
	
	public Proveedor getproveedor() {
		return dte_prd.getAtributo3();
	}
	public String getCodigo() {
		return codigo;
	}

	//setters 
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public void setname(String name_) {
		this.dt_prd.setAtributo1(name_);
	}
	
	public void setdesc(String desc_) {
		this.dt_prd.setAtributo2(desc_);
	}
	
	public void setprecio(double precio_) {
		this.dt_prd.setAtributo3(precio_);
	}
	public void setstock(int stock_) {
		this.dte_prd.setAtributo1(stock_);
	}
	public void setproveedor(Proveedor proveedor_) {
		this.dte_prd.setAtributo3(proveedor_);
	}

	@Override
	public String toString() {
		return getname() + ", (" + getprecio() + "$) " + getstock() + " unidades";
	}
	
	public String toFile() {
        return String.format("%s;%s;%s;%.2f;%d;%s", getname(), getDesc(), getCodigo(), getprecio(), getstock(), getproveedor().toFile());
    }

	public boolean fromFile(String linea) {
		String[] datos = linea.split(";");
		if (datos.length != 11) return false;
		setname(datos[0]);
		setdesc(datos[1]);
		setCodigo(datos[2]);
		setprecio(Double.parseDouble(datos[3]));
		setstock(Integer.parseInt(datos[4]));
		Proveedor proveedor = new Proveedor();
		if (!proveedor.fromFile(String.format("%s;%s;%s;%s;%s;%s",
				datos[5], datos[6], datos[7], datos[8], datos[9], datos[10]))) return false;
		setproveedor(proveedor);
		return true;
	}
 }
