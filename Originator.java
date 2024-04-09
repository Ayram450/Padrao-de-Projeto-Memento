public class Originator {
    
    private String texto;

    public void set(String novoTexto){

        System.out.println("Do Originator: Versão atual do Texto\n" + novoTexto + "\n");

        texto = novoTexto;

    }

    public Memento armazenarNoMemento(){

        System.out.println("Do Originator: Salvando Memento");

        return new Memento(texto);
    }

    public String restaurarDoMemento(Memento memento){

        texto = memento.getTextoSalvo();

        System.out.println("Do Originator: Texto Anterior Salvo no Memento\n" + texto + "\n");

        return texto;

    }

}
