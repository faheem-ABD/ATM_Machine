#ifndef person_r
#define person_r
typedef struct Person person;
struct Person
{
    char name[30];
    int age;
    int bank_balance;
    int overdraft;
    ///int provisional_balance;
    
};

person* newCustomer(char name[30], int age, int bank_balance, int overdraft);
const char* getName(person* j);
#endif

// When you create a header file , you need IFndef, define amnd endif
//Hello wrod