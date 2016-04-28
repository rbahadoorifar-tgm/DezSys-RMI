package server.commands;

import java.io.Serializable;

/**
 * Command interface
 *
 * @author Michael Borko
 * @version unknown
 */
public interface Command extends Serializable {

    public void execute();

}