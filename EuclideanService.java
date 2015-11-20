import java.rmi.*;

/**
 * @title Interface for RMI service that calculates Euclidean Distance
 * @author Stavros Kalapothas - Pervasive Computing @ Hellenic Open University - 2012
 */

// Implement interface
public interface EuclideanService extends java.rmi.Remote {
    	// Method included into interface is EuclideanDistance
	public double EuclideanDistance (double[] v1, double[] v2)
                throws RemoteException;

}
