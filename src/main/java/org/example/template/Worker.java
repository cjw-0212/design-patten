package org.example.template;

/**
 * @author CJW
 * @since 2024/7/12
 */
public abstract class Worker
{
    protected String name;

    public Worker(String name)
    {
        this.name = name;
    }

    public final void workOneDay()
    {

        System.out.println("-----------------work start ---------------");
        enterCompany();
        computerOn();
        work();
        computerOff();
        exitCompany();
        System.out.println("-----------------work end ---------------");

    }

    public abstract void work();

    private void computerOff()
    {
        System.out.println(name + "关闭电脑");
    }

    private void computerOn()
    {
        System.out.println(name + "打开电脑");
    }

    public void enterCompany()
    {
        System.out.println(name + "进入公司");
    }

    void exitCompany()
    {
        System.out.println(name + "离开公司");
    }

}