package Mission;
import Common.Communicator;


public interface Mission {
    void fly(Communicator communicator) throws Exception;
}
