# Banking System Readme

This program is a simple command-line banking system implemented in C. It allows you to add customer records and manage their accounts, which includes making deposits, withdrawals, and checking balances. Below is a brief explanation of the key components and functionality of the code.

## Header Files

The program includes several standard C library header files and a custom header file `person.h`:

```c
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>
#include "person.h"
```

- `stdio.h`: Provides input and output functions.
- `string.h`: Allows for string manipulation.
- `stdlib.h`: Provides memory allocation and deallocation functions.
- `stdbool.h`: Enables the use of boolean data types.
- `person.h`: A custom header file that defines the `person` struct and related functions.

## Functions

### `makeDeposit`

```c
void makeDeposit(person* current_person, int amount)
```

This function is used to make a deposit into the current person's account. It adds the specified amount to the person's bank balance.

### `makeWithdraw`

```c
int makeWithdraw(person* current_person, int amount)
```

This function is used to make a withdrawal from the current person's account. It deducts the specified amount from the person's bank balance, as long as the overdraft limit is not exceeded.

### `getBalance`

```c
int getBalance(person* current_person)
```

This function retrieves the current balance of the selected person.

### `manageAccount`

```c
void manageAccount(person* current_person)
```

This function allows you to interact with a customer's account. You can make deposits, withdrawals, and check the account balance. It provides a simple menu-driven interface.

## `main` Function

```c
int main()
```

The `main` function is the entry point of the program and provides the main menu for the banking system. It allows you to:

1. Exit the program.
2. Add a customer record, including name, age, and overdraft limit.
3. Manage a customer's account, including making deposits, withdrawals, and checking the balance.

## Data Structures

- An array of `person` pointers named `customerArray` is used to store customer records.
- The `person` struct is defined in the `person.h` header file and holds information about each customer, including name, age, bank balance, and overdraft limit.

## Usage

1. Run the program, and you will be presented with a main menu.
2. Select options to add customer records or manage customer accounts.
3. Follow the prompts to provide customer information and perform banking operations.

## Note

- The program uses dynamic memory allocation (via `malloc`) to create `person` objects, so it's important to manage memory properly, such as releasing it when it's no longer needed (not implemented in this code).

This readme provides an overview of the code's functionality. To run and test the code, make sure you have the necessary C compiler and the `person.h` file defined correctly.
