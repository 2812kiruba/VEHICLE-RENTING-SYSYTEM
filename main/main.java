import java.util.*;

public class main {
    static void Admin(String us, ArrayList<String> carname, ArrayList<String> carplate, ArrayList<String> price,
            ArrayList<String> avl) {
        Scanner s = new Scanner(System.in);
        System.out.println("WELCOME TO CAR INVENTORY");
        System.out.println("1.ADD A CAR");
        System.out.println("2.RREMOVE A CAR");
        int as = s.nextInt();
        if (as == 1) {
            System.out.println("HOW MANY CARS YOU WANT TO ADD");
            int acar = s.nextInt();
            s.nextLine();
            for (int i = 0; i < acar; i++) {
                System.out.println("ENTER THE CAR ID or NAME");
                String cn = s.nextLine();
                carname.add(cn);
                System.out.println("ENTER THE PLATE NO");
                String pn = s.nextLine();
                carplate.add(pn);
                System.out.println("ENTER THE PRICE ");
                String pp = s.nextLine();
                price.add(pp);
                avl.add("YES");
            }
            System.out.println("SUCCESSFULLY ADDED");

        } else if (as == 2) {
            System.out.println("ENTER THE CAR ID or NAME");
            String cnw = s.nextLine();
            int pos = carname.indexOf(cnw);
            carname.remove(pos);
            carplate.remove(pos);
            price.remove(pos);
            avl.remove(pos);
        } else
            System.out.println("GIVE VALID OPTION");

    }

    static void customerBlock(String ID, String CS, ArrayList<String> carname, ArrayList<String> carplate,
            ArrayList<String> price, ArrayList<String> avl) {
        Scanner s = new Scanner(System.in);
        int k = 0;
        System.out.println("WELCOME " + ID);
        System.out.println("1.RENT A VEHICLE");
        System.out.println("2.RETURN A VEHICLE");
        int re = s.nextInt();
        if (re == 1) {
            System.out.println("CAR INVENTORY");
            for (int i = 0; i < carname.size(); i++) {
                System.out.println(carname.get(i) + "---" + carplate.get(i) + "---" + price.get(i) + "---" + avl.get(i));
            }
            System.out.println("SELECT YOUR CAR");
            int d = s.nextInt();
            if (avl.get(d).equals("YES")) {
                System.out.println("Customer ID " + ID + " have rented car " + carname.get(d) + " with price "
                        + price.get(d) + " for 500kms.");
                carname.remove(d);
                carplate.remove(d);
                price.remove(d);
                avl.remove(d);
            }

        } else if (re == 2) {
            s.nextLine();
            System.out.println("ENTER THE CAR ID or NAME");
            String cn = s.nextLine();
            carname.add(cn);
            System.out.println("ENTER THE PLATE NO");
            String pn = s.nextLine();
            carplate.add(pn);
            System.out.println("ENTER THE PRICE ");
            String pp = s.nextLine();
            price.add(pp);
            avl.add("YES");
            System.out.println("ENTER THE TOTAL KMS :");
            int n = s.nextInt();
            if (n <= 500)
                System.out.println("PAY THE AMOUNT =====" + (n * Integer.parseInt(pp)));
            else {
                int adi = n * Integer.parseInt(pp) * (15 / 100);
                System.out.println("PAY THE AMOUNT ====== " + (adi + n * Integer.parseInt(pp)));
            }

            System.out.println("THE CAR HAS BEEN RETURNED");
            System.out.println();
            System.out.println("THANK YOU VISIT AGAIN");

        }

    }

    // static void newCustomer(String s4, String
    // s5,ArrayList<String>carname,ArrayList<String>carplate,ArrayList<String>price,
    // ArrayList<String>avl) {
    // customerBlock(s4,s5,ArrayList<String>carname,ArrayList<String>carplate,ArrayList<String>price,
    // ArrayList<String>avl);
    // }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String us = "kiruba";
        String ps = "kiruba";
        ArrayList<String> carname = new ArrayList<>();
        ArrayList<String> carplate = new ArrayList<>();
        ArrayList<String> price = new ArrayList<>();
        ArrayList<String> avl = new ArrayList<>();
        carname.add("HYNDAI");
        carplate.add("TN04");
        price.add("1500");
        avl.add("YES");

        HashMap<String, String> a = new HashMap<>();
        while (true) {
            System.out.println("WELCOME TO VEHICLE RENTAL SYSTEM");
            System.out.println("1.LOG IN");
            System.out.println("2.SIGN UP");
            System.out.println("3.EXIT");
            int choice = s.nextInt();
            if (choice == 1) {
                System.out.println("1.ADMINISTRATIVE");
                System.out.println("2.CUSTOMER");
                int ch = s.nextInt();
                s.nextLine();
                if (ch == 1) {
                    System.out.println("ENTER USERNAME");
                    String str = s.nextLine();
                    System.out.println("ENTER PASSWORD");
                    String str1 = s.nextLine();
                    if (str.equals(us) && str1.equals(ps))
                        Admin(us, carname, carplate, price, avl);
                    else
                        System.out.println("USERNAME OR PASSWORD IS NOT CORRECT");
                } else if (ch == 2) {
                    System.out.println("ENTER CUSTOMER ID");
                    String str2 = s.nextLine();
                    System.out.println("ENTER PASSWORD");
                    String str3 = s.nextLine();
                    if (a.containsKey(str2) && a.get(str2).equals(str3))
                        customerBlock(str2, str3, carname, carplate, price, avl);
                    else
                        System.out.println("ID OR NAME IS NOT CORRECT");
                }

            } else if (choice == 2) {
                s.nextLine();
                System.out.println("KINDLY  ENTER YOUR NAME:");
                String s1 = s.nextLine();
                System.out.println("ENTER YOUR ADDRESS:");
                String s2 = s.nextLine();
                System.out.println("ENTER CONTACT N0:");
                String s3 = s.nextLine();
                System.out.println("ENTER CUSTOMER ID:");
                String s4 = s.nextLine();
                System.out.println("CREATE NEW PASSWORD:");
                String s5 = s.nextLine();
                System.out.println("PAY THE SECURITY DEPOSIT");
                long sd = s.nextLong();
                if (sd >= 10000) {
                    a.put(s4, s5);
                    customerBlock(s4, s5, carname, carplate, price, avl);
                } else {
                    System.out.println("ENTER REASONABLE AMOUNT");
                }

            } else if (choice == 3) {
                System.out.println("THANKYOU VISIT AGAIN");
                break;
            }

        }
        // System.out.print("INVALID ENTRY");
    }
}
