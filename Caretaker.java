import java.util.ArrayList;

class Caretaker {
    
    ArrayList<Memento> textosSalvos = new ArrayList<Memento>();

    public void addMemento(Memento m){

        textosSalvos.add(m);
    }

    public Memento getMemento(int i){
        
        return textosSalvos.get(i);
    }
}
