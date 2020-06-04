package exceptions;

public class myExceptions extends Exception {
	private int errorCode;

	public myExceptions(int errorCode) {
		super();
		this.errorCode = errorCode;
	}
	
	public String getMessage(){
        
        String mensaje;
         
        switch(errorCode){
            case 1:
                mensaje="No se ha podido conectar a la DB";
                break;
            case 2:
                mensaje="DNI incorrecto";
                break;
            default: 
            	mensaje = "Fatal Error";
            	break;
        }
        return mensaje;
    }
}
