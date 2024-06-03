package modelo;

import libreria.Generica;


public class Producto {
    
    /** Objeto de tipo Generica para almacenar los datos del producto. */
    Generica<String, Double> dt_prd;
    Generica<Integer, Proveedor>dte_prd;
    String codigo;

    /** Constructor por defecto que inicializa los objetos Generica. */
    public Producto() {
        super();
        dt_prd = new Generica<>();
        dte_prd = new Generica<>();
    }

    /**
     * Constructor que inicializa un Producto con los datos proporcionados.
     *
     * @param name El nombre del producto.
     * @param desc La descripción del producto.
     * @param codigo El código del producto.
     * @param precio El precio del producto.
     * @param stock El stock del producto.
     * @param proveedor El proveedor del producto.
     */
    public Producto(String name, String desc, String codigo, double precio, int stock, Proveedor proveedor) {
        super();
        dt_prd = new Generica<>(name, desc, precio);
        dte_prd = new Generica<>(stock, proveedor);
        this.codigo = codigo;
    }

    // Getters
    public String getname() {
        return dt_prd.getAtributo1();
    }

    public String getDesc() {
        return dt_prd.getAtributo2();
    }

    public double getprecio() {
        return dt_prd.getAtributo3();
    }

    public int getstock() {
        return dte_prd.getAtributo1();
    }

    public Proveedor getproveedor() {
        return dte_prd.getAtributo3();
    }

    public String getCodigo() {
        return codigo;
    }

    // Setters
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
        if (precio_ < 0) precio_ = 0;
        this.dt_prd.setAtributo3(precio_);
    }

    public void setstock(int stock_) {
        if (stock_ < 0) stock_ = 0;
        this.dte_prd.setAtributo1(stock_);
    }

    public void setproveedor(Proveedor proveedor_) {
        this.dte_prd.setAtributo3(proveedor_);
    }

    /**
     * Método para vender una cantidad determinada de unidades del producto.
     *
     * @param cantidad La cantidad de unidades a vender.
     * @return true si la venta fue exitosa, false si no hay suficiente stock.
     */
    public boolean vender(int cantidad) {
        if (cantidad <= getstock()) {
            setstock(getstock() - cantidad);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return getname() + ", (" + getprecio() + "$) " + getstock() + " unidades";
    }

    /**
     * Método para obtener una representación del objeto en formato de archivo.
     *
     * @return Una cadena de texto con los datos del producto en formato de archivo.
     */
    public String toFile() {
        return String.format("%s;%s;%s;%.2f;%d;%s", getname(), getDesc(), getCodigo(), getprecio(), getstock(), getproveedor().toFile());
    }

    /**
     * Método para establecer los datos del producto a partir de una línea de texto formateada.
     *
     * @param linea Una cadena de texto con los datos del producto en formato de archivo.
     * @return true si los datos fueron correctamente asignados, false si hubo un error en el formato.
     */
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
