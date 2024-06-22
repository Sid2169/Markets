public class PandL
{
    public static void main(String[] args)
    {
        if (args.length != 6)
        {
            System.out.println("Prvode Profit targe, Stoploss, Starting Capital, Number of Trades,Win Rate and number of sample simulations as command line arguments in this this order");
        }
        double target =  1.0 + Double.parseDouble(args[0]) / 100.0;
        double stopLoss = 1.0 - Double.parseDouble(args[1]) / 100.0;
        double cap = Double.parseDouble(args[2]);
        int noOfTrades = Integer.parseInt(args[3]);
        double winRate = Double.parseDouble(args[4]) / 100;
        int samples = Integer.parseInt(args[5]);

        
        double maxReturn = Double.NEGATIVE_INFINITY;
        double minReturn = Double.POSITIVE_INFINITY;
        double averageReturn = 0.0;
        for (int i = 0; i < samples; i++)
        {
            double t = finalSum(target, stopLoss, cap, noOfTrades, winRate);
            averageReturn += t;
            if (t < minReturn)
            {
                minReturn = t;
            }
            if (t > maxReturn)
            {
                maxReturn = t;
            }
        }
        
        System.out.printf("Minimum Return :%.2f\n",minReturn);
        System.out.printf("Maximum Return :%.2f\n",maxReturn);
        System.out.printf("Average Return :%.2f\n",averageReturn / samples);
        System.out.printf("Worst Case :%.2f\n",finalSum(target, stopLoss, cap, noOfTrades, 0.0));
        System.out.printf("Best  Case :%.2f\n",finalSum(target, stopLoss, cap, noOfTrades, 100.0));

        
        
    }

    public static double finalSum(double target, double stopLoss, double cap, int noOfTrades, double winRate)
    {
        double sum = cap;
        for (int i = 0; i < noOfTrades; i++)
        {
            if (Math.random() <= winRate)
            {
                sum *= target;
            }
            else 
            {
                sum *= stopLoss;
            }

            if (sum <= 0)
            {
                break;
            }
        }    
        return sum;
    }
}