package com.immoc.test;

/**
 * Created by 18362 on 2017/11/6.
 */
enum AccountType
{
    SAVING("sacid",0), FIXED("dsjk",1), CURRENT("sdjks",2);
    private AccountType(String s,Integer i)
    {

    }
    private AccountType()
    {
        System.out.println("It is a account type");
    }
}
class EnumsTest
{
    public void test1()
    {

    }
    public void test2()
    {
        this.test1();
    }
    public static void main(String[]args)
    {
        System.out.println(AccountType.FIXED);
    }
}
