
package Payment;

public interface MyPayment {// the content written inside the interface should be shared (written) in all implementations
                            // of the interface

    void pay(double amount); //
}

// so when the interface has the same function and different content : use interface

//Correct understanding
//
//An interface defines a method that all classes must implement, but each class gives it its own behavior


//I use constructor injection for dependencies and new for internal utility objects

//⚡ One-line rule you can memorize
//
//If the Object survives outside the class → parameter.
//If the Object exists only inside → new.

//🔥 The easiest way to decide (THIS is what you say in interview)
//❓ Ask yourself:
//        1. “Do I have multiple ways to do the same thing?”
//
//        👉 YES → Interface  |  Same action (makeSound) → different results
//
//2. “Do I want to share code between them?”
//
//        👉 YES → Abstract class  |  Some things same (sleep)  half code
//                                  |  Some things different (makeSound) half rules
//
//3. “Is it just one thing, no variations?”
//
//        👉 YES → Class  |  One thing, one behavior → no need for abstraction

//super in a class = go one level up in inheritance.
// InterfaceName.super = go to that interface’s default method, even if your class or another interface has the same method name.


//  USE SWITCH WHEN YOU WANNA CHOOSE ONE  FROM MANY CHOICES ,LIKE IN THIS EXAMPLE.

// Notes:
// super = go to parent/interface level
// InterfaceName.super = use default from that interface
// payWithX methods let you choose which payment type to call