package hw2;

/**
 *
 * @author jenny
 */
public class Account 
{
    private double accountMoney;
    
    public void setAccount(double money)
    {
        this.accountMoney=money;
    }
    
    public double getAccount()
    {
        return accountMoney;
    }
    
    public void Save(double money)
    {
        accountMoney+=money;
        System.out.printf("成功存入$%.2f\n",money);
    }
    
    public void Take(double money)
    {
        if(accountMoney>=money)
        {
            accountMoney-=money;
            System.out.printf("成功領出$%.2f\n",money);
        }
        else
        {
            System.out.println("提款失敗！提款金額大於目前餘額");
        }
        
    }
}
