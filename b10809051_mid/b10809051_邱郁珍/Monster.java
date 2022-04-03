/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pclab
 */
public class Monster 
{
    private String name; //怪物名字
    private int hp; //怪物生命值
    
    public void setMonster(String str)
    {
        String[] monster = str.split(",");
        name=monster[0];
        hp=Integer.parseInt(monster[1]);
    }
    
    public void setHp(int h)
    {
        hp+=h;
    }
    public int getHp()
    {
        return hp;
    }
    
    public void Show()
    {
        System.out.println("***目前怪物資訊***");
        System.out.println("名稱：" +name);
        System.out.println("生命：" +hp);
        System.out.println("*******************");
    }
    
    public void Fight()
    {
        int hit=(int) (Math.random() * (20 - 10 + 1) + 10);
        hit-= hit*2;
        setHp(hit);
        System.out.printf("怪物受到 %d 攻擊（生命值剩餘：%d）\n",hit,hp);
    }
    
}
