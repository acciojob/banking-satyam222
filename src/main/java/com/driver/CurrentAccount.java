package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance,5000); // Minimum balance required for a current account is 5000
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        char[] chars = tradeLicenseId.toCharArray();
        for(int i=0;i<chars.length-1;i++)
        {
            if(chars[i]==chars[i+1])
            {
                for(int j=i+1;j<chars.length-1;j++)
                {
                    char temp=chars[j];//find diff eleemnt at j from i
                    chars[j]=chars[i+1];//copy the j i+1 same elem to j
                    chars[i+1]=temp;
                    break;


                }
                //if last two elemtnt same

                if (chars[chars.length - 1] == chars[chars.length - 2]) {
                    throw new Exception("Valid License can not be generated");
                }


            }

        }
        tradeLicenseId = new String(chars);

    }

}
