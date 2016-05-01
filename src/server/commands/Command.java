package server.commands;
import java.io.Serializable;

/**
 * Command Interface, welcher von allen Command-Klassen implementiert wird.
 */
public interface Command extends Serializable {

    public void execute();

}