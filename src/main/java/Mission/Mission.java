package Mission;
import DroneAccessors.*;


public interface Mission {
    void fly(Communicator communicator) throws Exception;
}
