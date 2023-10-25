#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>
#include "person.h"

void makeDeposit(person* current_person, int amount){
    if(current_person != NULL) {
    current_person->bank_balance = current_person->bank_balance +  amount;
    } else {
        printf("No person selected");
    }

}
int makeWithdraw(person* current_person, int amount){
    int provisional_balance;
    printf("Provisional Balance");
    provisional_balance = current_person->bank_balance - amount ;
    if(provisional_balance >= -(current_person->overdraft) ){
    
        current_person->bank_balance = provisional_balance;
        return 1;
    }
    else {
        return 0;
    }
    

}



int getBalance(person* current_person){
    return current_person -> bank_balance;
}
void manageAccount(person* current_person){
    int amount;
    int choice_=1;
    while(choice_ != 0){
        printf("\n CHOOSE AN OPTION FROM THE MENU \n");
        printf("O: EXIT MANAGE ACCOUNT ! \n");
        printf("1: MAKE DEPOSIT \n");
        printf("2: MAKE WITHDRAWAL  \n");
        printf("3: GET BALANCE \n");
        printf(" SELECT AN OPTION \n");
        scanf("%d" , &choice_);
        
        switch (choice_) {
            case 0:
             printf("\n EXITING PROGRAM \n");
             break;
            case 1:
                printf("HOW MUCH WILL YOU DEPOSIT ? \n");
                scanf("%d" ,  &amount);
                makeDeposit(current_person,  amount);
                break;
            case 2:
                printf("HOW MUCH WIL YOU WITHDRAW \n");
                scanf("%d" , &amount);
                int success = makeWithdraw(current_person,  amount);
            
                 if(success == 0){
                    printf("\n Exceeded value for withdraw , Current balance is: %d \n", getBalance(current_person));
                 }

                

                break;
            case 3:
                printf("CURRENT BALANCE IS: %d  \n", getBalance(current_person));
                break;
            default:
                printf("YOU ENTERED AN INVALID CHOICE YOU  IDIOT !!! \n");
        }
    }
}


int main(){
    int age, overdraft;
    char name[30];
    person* customerArray[30];
    int choice=1;
    int pers_index=0;
    int counter = 0;
    while(choice !=0) {
        printf("\n MAIN MENU \n");
        printf("0:EXIT \n");
        printf("1:ADD CUSTOMER RECORD \n");
        printf("2:MANAGE CUSTOMER ACCOUNT \n");
        printf("OPTION ? \n");

        //scanf is similar to in_stream as java
        scanf("%d", &choice);
        switch ( choice ){
            case 0:
                printf("\n EXITING PROGRAM");
                break;
            case 1:
            ///   I have to create a new customer record then add it here
            /// next_free++; is an array 
            printf("\n TO ADD BANK CUSTOMER");
            printf("\n CUSTOMER NAME: ");
            scanf("%s" , name);
            printf("\n CUSTOMER AGE: ");
            scanf("%d" , &age);
            printf("\n CUSTOMER OVERDRAFT: ");
            scanf("%d" , &overdraft);
            person* customer = (person*) malloc(sizeof(person));
            strcpy(customer->name, name);
            customer->age = age;
            customer->bank_balance = 0;
            customer->overdraft = overdraft;
            customerArray[counter] = customer;
            counter++; /// next free is same as counter
            /// counter is set to increase , where customer first name is 0 , then increase from there
            printf(" NUMBER OF CUSTOMERS %d", counter);
            
            break;
        case 2:
            printf("\n WHICH CUSTOMER?..");
            scanf("%d", &pers_index); /// scanf calling the initial pers_index for which customer
            manageAccount(customerArray[pers_index - 1]);
            break;   
        default:
            printf("\n YOU ENTERED AN INVALID CHOICE YOU  IDIOT !!!");    
        }

    }
return 0;  
}
