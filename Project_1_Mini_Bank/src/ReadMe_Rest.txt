🚀 Suggested Learning Path (based on your code)

Here’s a clean roadmap from where you are:
1️⃣ Refactor this code
Make fields private (done)
Remove duplicate balance logic
Separate input from logic
2️⃣ Add exception handling
Handle invalid input
Create custom exceptions
3️⃣ Introduce interfaces
Account
TransactionService
4️⃣ Add persistence
Save transactions to a file
Reload on startup
5️⃣ Add unit tests
JUnit
Test edge cases
6️⃣ Move to REST backend
Spring Boot
Replace Scanner with HTTP requests
Iterator
hashmap  stream etc ,,,,

===>Bank_Operations → only logic
Stores transactions internally
Calculates total balance
Adds deposits and withdrawals
Clears account
Returns data when asked (e.g., getTransactions())
Does NOT read input from Scanner
Does NOT print menus or messages

===> Main → only user interaction
Shows menu options
Reads user input (Scanner)
Calls Bank_Operations methods based on input
Prints results to the user
