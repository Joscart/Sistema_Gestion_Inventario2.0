package modelo;

public interface Parametrizable {
	
	public final String ERNOMBRES_COMPLETOS = "^([A-ZÁ-Ú][a-zá-ú]{2,}\s?){2,7}$";

	public final String ERPRECIO = "^([0-9]+[.]?)+$";

	public final String ERDESCRIPCION = "^[a-zA-Z0-9 ,.()-]{10,200}$";

	public final String ERSTOCK = "^[0-9]+$";

	public final String ERCODIGO = "^[0-9A-Z]{6}$";

	public final String ERNOMBRES = "^([A-ZÁ-Ú][a-zá-ú]+\s?)+$";
	
	public final String ERCEDULA = "^[0-2][0-9]{9}$";
	
	public final String ERCORREO = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+(\\.[a-zA-Z]{2,4})+$";
	
	public final String ERTELEFONO = "^[0-9]{10}$";
	
	public final String ERDIRECCION = "^([A-Za-z]+\s?)+$";
	
	public final String ERRAZON_SOCIAL = "^([A-ZÁ-Ú][a-zá-ú]+[,.; ]?)+$";
}


