import java.util.*;
import java.lang.*;
class Employee
{
    //variables of parent class
    private int id;
    private String name;
    private int age;
    private String department;
    private int salary;
    private String post;
    private int profit;
    private Vector<Employee> unders = new Vector<Employee>();
    private Employee upper=null;
    // Parent class constructor
    Employee(int id,String name,int age, String department,int salary,String post,int profit)
    {
        this.id=id;
        this.name=name;
        this.age=age;
        this.department=department;
        this.salary=salary;
        this.post=post;
        this.profit=profit;
        
    }
    //methods of parent class
    public void printDetails(Employee e)
    {
        System.out.println("Id-"+e.id);
        System.out.println("Name-"+e.name);
        System.out.println("Age-"+e.age);
        System.out.println("Department-"+e.department);
        System.out.println("Salary-"+e.salary);
        System.out.println("Post-"+e.post);
        
    }
    public int getId(Employee e)
    {
        return(e.id);
    }
    public String getName(Employee e)
    {
        return(e.name);
    }
    public int calSalary(Employee e)
    {
        int x=(e.profit/100)*e.salary;
        int y=x+e.salary;
        y=y*12;
        return y;
    }
    public void printAnnualsalary(Employee e)
    {
        int x=calSalary(e);
        System.out.println("Annual Salary-"+x);
    }
    public void setUnders(Employee e1)
    {
        e1.unders.add(null);
    }
    public void setUnders(Employee e1,Employee e2)
    {
        e1.unders.add(e2);
        setUpper(e2,e1);
    }
    public void setUnders(Employee e1,Employee e2,Employee e3)
    {
        e1.unders.add(e2);
        setUpper(e2,e1);
        e1.unders.add(e3);
        setUpper(e3,e1);
    }
    public void printUnders(Employee e)
    {
     if(e.unders.get(0)==null)
        {
            System.out.println("Juniors-No juniors found");
        }
        else
        {
            System.out.print("Juniors-");
            for(int i=0;i<e.unders.size();i++)
            {
                 Employee x=e.unders.get(i);
                System.out.print(x.name+" ");
            }
        }
    }
    public Vector<Employee> getUnders(Employee e)
    {
        return(e.unders);
    }
    public void setUpper(Employee e1,Employee e2)
    {
        e1.upper=e2;
    }
    public void printUpper(Employee e)
    {
        Employee x=e.upper;
        if(x==null)
        {
            System.out.println("Superior:No Superior found");
        }
        else
        {
            System.out.println("Superior-"+x.name);
        }
        
    }
    public Employee getUpper(Employee e)
    {
        return(e.upper);
    }
    
}
class Tier1 extends Employee                    // HODs,Executives
{    
    private HashMap <Integer,Integer> rating=new HashMap<>();
    Tier1(int id,String name,int age, String department,int salary,String post,int profit)
    {
       super(id,name,age,department,salary,post,profit);
     }
    public void setRating(Tier1 t)
    {
        Vector<Employee> v=t.getUnders(t);
        if (v.get(0)==null)
        {
            t.rating.put(-1,-1);
        }
        else
        {
            for(int i=0;i<v.size();i++)
            {
                Employee x=v.get(i);
                int r = (int)(Math.random() * (10 - 1 + 1) + 1);
                int y=t.getId(x);
                t.rating.put(y,r);
            }
        }
    }
    public int getRating(Tier1 t,int id)
    {
        return(t.rating.get(id));
    }
    
}
class Tier2 extends Employee                   // Managers,Supervisors
{
    private HashMap <Integer,Integer> rating=new HashMap<>();
    private int available;
    Tier2(int id,String name,int age, String department,int salary,String post,int profit)
    {
      super(id,name,age,department,salary,post,profit);
      setAvailable(this);
     }
    public void setRating(Tier2 t)
    {
        Vector<Employee> v=t.getUnders(t);
        if (v.get(0)==null)
        {
            t.rating.put(-1,-1);
        }
        else
        {
            for(int i=0;i<v.size();i++)
            {
                Employee x=v.get(i);
                int r = (int)(Math.random() * (10 - 1 + 1) + 1);
                int y=t.getId(x);
                t.rating.put(y,r);
            }
        }
    }
    public int getRating(Tier2 t,int id)
    {
        return(t.rating.get(id));
    }
    public void setAvailable(Tier2 t)
    {
        int r = (int)(Math.random() * (10 - 1 + 1) + 1);
         t.available=r;
    }
    public int getAvailable(Tier2 t)
    {
        return(t.available);
    }
}
class Tier3 extends Employee                   // Inters,Security
{
    private int available;
    private String status;
    Tier3(int id,String name,int age, String department,int salary,String post,int profit)
    {
       super(id,name,age,department,salary,post,profit);
        setAvailable(this);
        setStatus(this);
    }
    public void setAvailable(Tier3 t)
    {
       int r = (int)(Math.random() * (10 - 1 + 1) + 1);
       t.available=r;
    }
    public int getAvailable(Tier3 t)
    {
        return(t.available);
    }
    public void setStatus(Tier3 t)
    { 
        if(t.available>5)
        {
            t.status="Permanent";
        }
        else
        {
            t.status="Probation";
        }
        
    }
    public String getStatus(Tier3 t)
    {
        return(t.status);
    }
}
public class MyClass
{
    static public void main(String args[])
    {
        Tier1 e1= new Tier1(1,"Ram",37,"Finance",55000,"Tier1",10);
        Tier1 e2= new Tier1(2,"Mohan",30,"Accounts",56000,"Tier1",10);
        Tier1 e3= new Tier1(3,"Krish",27,"Design",54000,"Tier1",10);
        Tier1 e4= new Tier1(4,"Kajal",29,"Accounts",53000,"Tier1",10);
        Tier1 e5= new Tier1(5,"Ayush",27,"Accounts",52000,"Tier1",10);
        Tier1 e6= new Tier1(6,"Tarun",28,"Finance",55000,"Tier1",10);
        Tier1 e7= new Tier1(7,"Sandeep",33,"Design",56000,"Tier1",10);
        Tier1 e8= new Tier1(8,"Tushar",24,"Design",57000,"Tier1",10);
        Tier2 e9= new Tier2(9,"Amit",23,"Accounts",46000,"Tier2",5);
        Tier2 e10= new Tier2(10,"Preeti",39,"Design",44000,"Tier2",5);
        Tier2 e11= new Tier2(11,"Yash",35,"Finance",43000,"Tier2",5);
        Tier2 e12= new Tier2(12,"Aarti",25,"Accounts",42000,"Tier2",5);
        Tier2 e13= new Tier2(13,"Shakti",23,"Finance",46000,"Tier2",5);
        Tier2 e14= new Tier2(14,"Harshit",24,"Design",48000,"Tier2",5);
        Tier2 e15= new Tier2(15,"Manish",27,"Finance",49000,"Tier2",5);
        Tier3 e16= new Tier3(16,"Hemant",22,"Accounts",32000,"Tier3",0);
        Tier3 e17= new Tier3(17,"Monica",23,"Finance",33000,"Tier3",0);
        Tier3 e18= new Tier3(18,"Pooja",21,"Design",34000,"Tier3",0);
        Tier3 e19= new Tier3(19,"Jai",25,"Design",34000,"Tier3",0);
        Tier3 e20= new Tier3(20,"Manoj",21,"Accounts",39000,"Tie3",0);
        Tier3 e21= new Tier3(21,"Priya",22,"Finance",37000,"Tier3",0);
        Tier3 e22= new Tier3(22,"Ashu",24,"Design",32000,"Tier3",0);
        // setting unders
      e1.setUnders(e1,e13,e11);
      e2.setUnders(e2);
      e3.setUnders(e3,e10);
      e4.setUnders(e4,e9,e12);
      e5.setUnders(e5);
      e6.setUnders(e6,e15);
      e7.setUnders(e7);
      e8.setUnders(e8,e14);
      e9.setUnders(e9,e16,e20);
      e10.setUnders(e10,e18);
      e11.setUnders(e11);
      e12.setUnders(e12);
      e13.setUnders(e13,e17);
      e14.setUnders(e14,e19,e22);
      e15.setUnders(e15,e21);
      e16.setUnders(e16);
      e17.setUnders(e17);
      e18.setUnders(e18);
      e19.setUnders(e19);
      e20.setUnders(e20);
      e21.setUnders(e21);
      e22.setUnders(e22);
      // hashmaps to map Employee id with their objects
      HashMap <Integer,Tier1> T1=new HashMap<>();
      HashMap <Integer,Tier2> T2=new HashMap<>();
      HashMap <Integer,Tier3> T3=new HashMap<>();
      T1.put(1,e1);
      T1.put(2,e2);
      T1.put(3,e3);
      T1.put(4,e4);
      T1.put(5,e5);
      T1.put(6,e6);
      T1.put(7,e7);
      T1.put(8,e8);
      T2.put(9,e9);
      T2.put(10,e10);
      T2.put(11,e11);
      T2.put(12,e12);
      T2.put(13,e13);
      T2.put(14,e14);
      T2.put(15,e15);
      T3.put(16,e16);
      T3.put(17,e17);
      T3.put(18,e18);
      T3.put(19,e19);
      T3.put(20,e20);
      T3.put(21,e21);
      T3.put(22,e22);
      int choice=1;
     while(choice!=0)
     {
         System.out.println("\t\tWelcome User");
         System.out.println("Enter Employee Id for details");
         Scanner scan=new Scanner(System.in);
         int eid=scan.nextInt();
         if((eid<1)||(eid>22))
            {
               System.out.println("Invalid Input");
              // System.exit(0);
            }
         if(eid<9)
            {
               System.out.println("1.Basic Details");
               System.out.println("2.Annual Salary");
               System.out.println("3.Superior");
               System.out.println("4.Juniors");
               System.out.println("5.Hierarchy");
               System.out.println("0.Exit");
               System.out.println("Press no as per choice");
               choice=scan.nextInt();
               Tier1 E=T1.get(eid);
               switch(choice)
                {
                   case 1:
                      {
                          E.printDetails(E); 
                          break;
                      }
                   case 2:
                      {
                           E.printAnnualsalary(E);
                           break;
                      }
                   case 3:
                      {
                          E.printUpper(E);
                          break;
                      }
                   case 4:
                      {
                         E.printUnders(E);
                         break;
                      }
                  case 5:
                      {
                          String x=E.getName(E);
                          System.out.println("hierarchy-"+x);
                          break;
                      }
                  case 0:
                      {
                         System.exit(0);
                      }
                   default:
                   {
                       System.out.println("Invalid Choice");
                   }
                  
                } 
            } // end of if
         else if(eid<16)
            {
                 System.out.println("1.Basic Details");
                 System.out.println("2.Annual Salary");
                 System.out.println("3.Superior");
                 System.out.println("4.Juniors");
                 System.out.println("5.Hierarchy");
                 System.out.println("0.Exit");
                 System.out.println("Press no as per choice");
                 choice=scan.nextInt();
                 Tier2 E=T2.get(eid);
                 switch(choice)
                   {
                      case 1:
                        {
                             E.printDetails(E); 
                              break;
                        }
                      case 2:
                        {
                             E.printAnnualsalary(E);
                              break;
                        }
                      case 3:
                         {
                              E.printUpper(E);
                              break;
                         }
                      case 4:
                         {
                              E.printUnders(E);
                              break;
                         }
                      case 5:
                         {
                              String x=E.getName(E);
                              System.out.print("hierarchy-"+x);
                              Employee t1=E.getUpper(E);
                              String y=t1.getName(t1);
                              System.out.println("----->"+y);  
                               break;
                         }
                      case 0:
                         {
                               System.exit(0);
                         }
                         default:
                         {
                             System.out.println("Invalid Choice");
                          }
            
                    } 
            }// end of else if
        else if(eid<23)
            {
                   System.out.println("1.Basic Details");
                   System.out.println("2.Annual Salary");
                   System.out.println("3.Superior");
                   System.out.println("4.Juniors");
                   System.out.println("5.Hierarchy");
                   System.out.println("0.Exit");
                   System.out.println("Press no as per choice");
                   choice=scan.nextInt();
                   Tier3 E=T3.get(eid);
                   switch(choice)
                       {
                          case 1:
                            {
                              E.printDetails(E); 
                              break;
                            }
                         case 2:
                             {
                                 E.printAnnualsalary(E);
                                 break;
                             }
                         case 3:
                             {
                                  E.printUpper(E);
                                  break;
                             }
                         case 4:
                             {
                                   E.printUnders(E);
                                   break;
                             }
                          case 5:
                              {
                                  String x=E.getName(E);
                                  System.out.print("hierarchy-"+x);
                                  Employee t2=E.getUpper(E);
                                  String y=t2.getName(t2);
                                  System.out.print("----->"+y);
                                  Employee t1=t2.getUpper(t2);
                                  String z=t1.getName(t1);
                                  System.out.println("----->"+z);
                                  break;
                              }
                         case 0:
                              {
                                      System.exit(0);
                              }
                          default:
                              {
                                  System.out.println("Invalid Choice");
                              }
            
                        } 
            }   //end of else if
     }//end of while
     
    }// end of main
}// end of Myclass
