package modelo;

public interface Parametrizable {
	
	public final String ERNames="^([A-Za-z][a-zá-ú]{2,}\s?)+$";
    //Valida nombres de productos, Teclado Gamer led o teclado gamer led
	public final String ERPrice="^([0-9]{1,}[.]?){1,}$";
	//Puede validar ejemplo: 1212.12 o 12112 o 18
	public final String ErDesc="^[a-zA-Z0-9 ,.()-]{10,200}$";
	//Puede validar de 10 a 200 caracteres
	public final String Erstock="^[0-9]+$";
	//Valida stock positivo
	public final String ErCode="^[0-9]{6}$";
	//Valida un código de 6 dígitos
}


