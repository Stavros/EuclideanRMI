import java.rmi.*;
import java.rmi.server.*;

/**
 * @title Server for RMI service that calculates Euclidean Distance
 * @author Stavros Kalapothas - Pervasive Computing @ Hellenic Open University - 2012
 */

// RMI service implements
public class EuclideanServiceServer extends UnicastRemoteObject
implements EuclideanService
{
    public EuclideanServiceServer () throws RemoteException
    {
        super();
    }

    // Euclidean Distance method implementation
    public double EuclideanDistance(double[] v1,double[] v2)
    {
        int m=Math.min(v1.length,v2.length);
        int n=Math.max(v1.length,v2.length);
        double sum=0;
        for(int i=0;i<n;i++)
        {
            double d=0;
            if(i<m)
            {
                d=v1[i]-v2[i];
                }
                    else if(i<v1.length)
                    {
                        d=v1[i];
                    }
                    else
                {
                d=v2[i];
            }
            sum=sum+(d*d);
        }
        return Math.sqrt(sum);
    }

    // main - command line argument support
    public static void main ( String args[] ) throws Exception
    {
        // Εφαμοργή security manager
        if (System.getSecurityManager() == null)
            System.setSecurityManager ( new RMISecurityManager() );

        // Instantiate
	EuclideanServiceServer svr = new EuclideanServiceServer();

        // bind into RMI registry
        Naming.bind ("EuclideanService", svr);

        // show message
        System.out.println ("Service running...");
    }
}
