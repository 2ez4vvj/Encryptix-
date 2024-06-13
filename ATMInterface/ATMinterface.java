

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class Account extends JFrame{
    int balance;
    
    JLabel withdrawStatus, depositStatus, showBalance;
    Account(){
        withdrawStatus=new JLabel();
        depositStatus=new JLabel();
        showBalance=new JLabel();
        

        add(withdrawStatus);
        add(depositStatus);
        add(showBalance);

        setVisible(true);
        setSize(400,400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(3);
    }
    public void withdraw(int money){
        if(this.balance >= money){
            this.withdrawStatus.setText(Integer.toString(money));
            System.out.println("Amount of "+money+" withdrawn");
        }
        else{
            this.withdrawStatus.setText("You don't have enough balance in your account");
        }
    }
    public void deposit(int money) {
    	this.balance = money;
    	this.depositStatus.setText("The amount of "+money+" is deposited");
    }
    public void checkBalance(){
        this.showBalance.setText("You have a balance of "+this.balance+" in your account");
    }
}
public class ATMinterface extends JFrame {
    JButton withdrawal,deposit,balance;
    JTextField withdrawAmt, depositAmt;
    public ATMinterface(){
        withdrawal = new JButton("Withdraw your money");
        deposit = new JButton("Deposit your Money");
        balance = new JButton("Check your Balance");
        withdrawAmt = new JTextField("Enter the amount for withdrawal");
        depositAmt = new JTextField("Enter the amount to be deposited");

        add(withdrawal);
        add(withdrawAmt);
        add(deposit);
        add(depositAmt);
        add(balance);

        withdrawal.addActionListener(l->{
            Account acc = new Account();
            acc.withdraw(Integer.parseInt(withdrawAmt.getText()));
            dispose();
            ATMinterface atmi = new ATMinterface();
        });
        deposit.addActionListener(l->{
        	Account acc = new Account();
        	acc.deposit(Integer.parseInt(depositAmt.getText()));
            dispose();
            ATMinterface atmi = new ATMinterface();
        });
        balance.addActionListener(l->{
            Account acc = new Account();
            acc.checkBalance();
            dispose();
            ATMinterface atmi = new ATMinterface();
        });
        
        setVisible(true);
        setSize(400,400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(3);
    }
}
