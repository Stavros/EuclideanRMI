import java.rmi.*;
import java.rmi.Naming;
import java.io.*;

/**
 * @title Client for RMI service that calculates Euclidean Distance
 * @author Stavros Kalapothas - Pervasive Computing @ Hellenic Open University - 2012
 */

public class EuclideanServiceClient
{
        // main - supports command line arguments
	public static void main(String args[]) throws Exception
	{
            // main into try & catch exception
            try
            {
                // command line argument not null test
		if (args.length != 1)
		{
			System.out.println
			("Syntax - EuclideanServiceClient host/ip");
			System.exit(1);
		}

		// Apply security manager
		if (System.getSecurityManager() == null)
		{
			System.setSecurityManager
			(new RMISecurityManager());
		}

		// Query RMI registry for method EuclideanService
		EuclideanService service = (EuclideanService) Naming.lookup
			("rmi://" + args[0] + "/EuclideanService");

                // Inputstream object creation (keyboard)
		DataInputStream din = new
			DataInputStream (System.in);

                // Loop
		for (;;)
		{
                        // UI
			System.out.println
			  ("1 - Calculate Euclidean Distance");
			System.out.println
			  ("0 - Exit"); System.out.println();
			System.out.print ("Choice : ");

                        // Allocate din to a string
			String line = din.readLine();
                        // if enter or space is pressed value=0 for exit
                        if (line.isEmpty()){
                            line = "0";
                        }

                        // otherwise assign integer
                        Integer choice = new Integer(line);
                        Integer value = choice.intValue();

                        // define and populate a double array with input values
                        Double choiced;
                        double[] v1 = new double[2];
                        double[] v2 = new double[2];

                        // menu switch/case
			switch (value)
			{
                        case 1:
			  System.out.print ("Point A X-coordinate : ");
			  line = din.readLine();
                          System.out.println();
                          // if enter or space is pressed 1st array element value v1=0
                          if (line == null || line.length() == 0 || line.equals(" "))
                              v1[0]=0;
                          else{
                          // else parse value from keyboard and assign to array 1st element v1
                          choiced = new Double (line);
                          v1[0] = choiced.doubleValue();
                            }

                          System.out.print ("Point A Y-coordinate : ");
			  line = din.readLine();
                          System.out.println();
                          if ( line == null || line.length() == 0||line.equals(" "))
                              v1[1]=0;
                          else{
                          choiced = new Double (line);
                          v1[1] = choiced.doubleValue();
                          }

                          System.out.print ("Point B X-coordinate : ");
			  line = din.readLine();
                          System.out.println();
                          if ( line == null || line.length() == 0||line.equals(" "))
                              v2[0]=0;
                          else{
                          choiced = new Double (line);
                          v2[0] = choiced.doubleValue();
                          }

                          System.out.print ("Point B Y-coordinate : ");
			  line = din.readLine();
                          System.out.println();
                          if ( line == null || line.length() == 0||line.equals(" "))
                              v2[1]=0;
                          else{
                          choiced = new Double (line);
                          v2[1] = choiced.doubleValue();
                          }

			  // Remote Method Invocation with attributes v1,v1
			  System.out.println
			  ("Answer : " + service.EuclideanDistance(v1, v2));

			  break;
			case 0:
			  System.out.println ("Bye...");
                          System.exit(0);
			default :
			  System.out.println ("Invalid option");
			break;
			}
		}
	}
            // catch exception
            catch(Exception e)
            {
		// print exception messsage
                System.out.println("Something went wrong! Exception : "+e);
		System.exit(0); // exit
            }
   }
}
