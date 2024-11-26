import javax.swing.JOptionPane;

// exception for funds
class FundsException extends Exception {
    public FundsException(String message) {
        super(message);
    }
}

// exception for quality
class QuantityException extends Exception {
    public QuantityException(String message) {
        super(message);
    }
}

public class ExceptionHandling {

    public static void main(String[] args) {
        // user menu so they can choose
        String choice = JOptionPane.showInputDialog("Choose an option:\n1. Banking System\n2. Online Shopping Cart");

        // if else to check user's choice
        if (choice.equals("1")) {
            bankingSystem();
        } else if (choice.equals("2")) {
            shoppingCart();
        } else {
//            invalid input message in case 1 or 2 isn't chosen
            JOptionPane.showMessageDialog(null, "Invalid choice. Please enter 1 or 2.");
        }
    }

    // bank system method
    private static void bankingSystem() {
        double balance = 2000.0;  // Starting balance

        try {
            // try catch to check for withdrawal
            String input = JOptionPane.showInputDialog("Enter withdrawal amount:");
            double withdrawAmount = Double.parseDouble(input);

            // checks if amount inputted is too much
            if (withdrawAmount > balance) {
                throw new FundsException("Not enough money to withdraw!");
            }

            // balance is updated by subtracting from the withdrawal amount
            balance -= withdrawAmount;
            JOptionPane.showMessageDialog(null, "Withdrawal is successful! Your new balance is: " + balance);
        } catch (NumberFormatException withdraw) {
            JOptionPane.showMessageDialog(null, "Please enter a valid input.");
        } catch (FundsException funds) {
            JOptionPane.showMessageDialog(null, funds.getMessage());
        }
    }

    // shopping system method
    private static void shoppingCart() {
        int stock = 20;

        try {
            // get user input on quantity
            String input = JOptionPane.showInputDialog("Enter quantity of product:");
            int productQuantity = Integer.parseInt(input);

            // if else to check quantity validity
            if (productQuantity < 0) {
                throw new QuantityException("Quantity cannot be negative!");
            } else if (productQuantity > stock) {
                throw new QuantityException("Not enough stock!");
            }

            // purchase confirmation is checked
            JOptionPane.showMessageDialog(null, "Your purchase is successful! Stock quantity is : " + productQuantity);
        } catch (NumberFormatException purchase) {
            JOptionPane.showMessageDialog(null, "Please enter a valid input.");
        } catch (QuantityException quantity) {
            JOptionPane.showMessageDialog(null, quantity.getMessage());
        }
    }
}
