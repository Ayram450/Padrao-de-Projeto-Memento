public class Memento {
   
    private String texto;

    public Memento(String salvarTexto){
        texto = salvarTexto;
    }

    public String getTextoSalvo(){
        return texto; 
    }

}