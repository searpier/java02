package ui;

import manager.PersonManager;
import vo.Person;

import java.util.Scanner;

public class PersonUI {

    private PersonManager personManager=new PersonManager();
    private Scanner scString = new Scanner(System.in);
    private Scanner scInt = new Scanner(System.in);
    private boolean flag= true;
    private int choice;

    public PersonUI(){

        while(flag){

            menu();
            choice=scInt.nextInt();

            switch(choice){
                case 1:
                    registPerson();
                    break;
                case 2:
                    printAll();
                    break;
                case 3:
                    deletePerson();
                    break;
                case 4:
                    flag=false;
                    System.out.println("프로그램을 종료합니다.");
                    break;
            }

        }

    }

    public void deletePerson(){
        System.out.println("삭제 할 주민번호를 입력 해주세요.");
        String ssn= scString.nextLine();


        boolean result = personManager.deletePerson(ssn);

        if(result){
            System.out.println("삭제완료");
        }else{
            System.out.println("삭제실패");

        }

    }

    public void printAll(){

        for(Person person:personManager.getPersonList()){
            System.out.println(person);
        }

    }
    public void registPerson(){

        System.out.println("이름을 입력 해주세요.");
        String name= scString.nextLine();
        System.out.println("주민번호를 입력 해주세요.");
        String ssn= scString.nextLine();

        boolean result = personManager.registPerson(new Person(name,ssn));

        if(!result){
            System.out.println("등록성공.");
        }else{
            System.out.println("등록실패.");
        }
    }


    public void menu(){

        System.out.println("===========");
        System.out.println("1.등록");
        System.out.println("2.출력");
        System.out.println("3.삭제");
        System.out.println("4.종료");
        System.out.println("===========");

    }
}
