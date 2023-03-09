package com.neu.learn;
import java.util.*;
/* DraftKings phone interview */

public class DiscountValidator {

    /// <summary>
    /// Determines whether or not a list of assignment discounts are valid
    /// </summary>
    /// <param name="assignedDiscounts">collection of DiscountAssignments that contain a mapping between DiscountId and CustomerId</param>
    /// <param name="customers">A collection of customers of the super store</param>
    /// <param name="discounts">A collection of discounts that are available to offer to customers of the super store</param>
    /// <returns><c>Boolean</c> Determines whether or not it is a valid assignment of discounts to customers</returns>
    /// <remarks>
    public static boolean validateDiscounts(List<DiscountAssignment> assignedDiscounts, List<Customer> customers, List<Discount> discounts) {
        // solution goes here

        //Rule 1: No customer has more than 3 discounts assigned to them
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(Customer customer : customers) {
            map.put(customer.getCustomerId(), new ArrayList<>());
        }
        for(DiscountAssignment discount : assignedDiscounts) {
            if (map.get(discount.getCustomerId()).size() > 3){
                return false;
            }else {
                map.get(discount.getCustomerId()).add(discount.getDiscountId());
            }
        }

        //Rule 2: Every Discount must be assigned to atleast one customer
        for(List<Integer> dis: map.values()){
            if(dis.size() == 0){
                return false;
            }
        }

        //Rule 3: No customer can have a total discount value more than 20% of their yearly spend
        Map<Integer, Float> discValue = new HashMap<>();
        for(Discount disc: discounts) {
            discValue.put(disc.getDiscountId(), disc.getDollarValue());
        }
        for (Customer customer: customers) {
            float spend = customer.getYearlySpend() * 0.2f;
            for(Integer dis: map.get(customer.getCustomerId())){
                if (spend >= 0) {
                    spend -= discValue.get(dis);
                }
            }
            if(spend < 0) {
                return false;
            }
        }

        //Rule 4: Customers must have a higher total discount value than other customers with lower yearly spends
        Map<Customer, Float> mapCustToTotalDiscountValue = new HashMap<>();
        for(Customer customer : customers){
            float totalDiscount = 0;
            for(int disValue : map.get(customer.getCustomerId())) {
                totalDiscount += disValue;
            }
            mapCustToTotalDiscountValue.put(customer, totalDiscount);
        }
        //Defining a custom comparator for comparing yearly Spend
        Comparator<Customer> comparator = (c1, c2) -> {
            int yearlySpend1 = (int)c1.getYearlySpend();
            int yearlySpend2 = (int)c2.getYearlySpend();
            if(yearlySpend1 >  yearlySpend2) {
                return 1;
            }else {
                return -1;
            }
        };
        PriorityQueue<Customer> maxHeap = new PriorityQueue<>(comparator);

        maxHeap.addAll(customers);
        while(!maxHeap.isEmpty()) {
            Customer customer = maxHeap.remove();
            float custYearSpend = customer.getYearlySpend();
            float totDiscounts = mapCustToTotalDiscountValue.get(customer);
            for(Map.Entry<Customer, Float> entry : mapCustToTotalDiscountValue.entrySet()) {
                if(entry.getKey().equals(customer)){
                    continue;
                }else if(entry.getKey().getYearlySpend() > custYearSpend && entry.getValue() > totDiscounts){
                    return false;
                }
            }

        }
        return true;
    }

    /* Do not modify the main method, this is just IO setup for running test cases */
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        boolean isCustomer = false;
        boolean isDiscount = false;

        List<DiscountAssignment> assignedDiscounts = new ArrayList<DiscountAssignment>();
        List<Customer> customers = new ArrayList<Customer>();
        List<Discount> discounts = new ArrayList<Discount>();
        while (scanner.hasNextLine()) {
            String arg = scanner.nextLine();
            if (arg.equals("discountAssignment")) {
                continue;
            }

            if (arg.equals("customer")) {
                isCustomer = true;
                continue;
            }

            if (arg.equals("discount")) {
                isCustomer = false;
                isDiscount = true;
                continue;
            }

            if (!isCustomer && !isDiscount) {
                int[] values = splitStr(arg);
                assignedDiscounts.add(new DiscountAssignment(values[0], values[1]));
            }
            else if (isCustomer) {
                int[] values = splitStr(arg);
                customers.add(new Customer(values[0], values[1]));
            }
            else if (isDiscount) {
                int[] values = splitStr(arg);
                discounts.add(new Discount(values[0], 0, (float)values[1]));
            }
        }

        System.out.println(validateDiscounts(assignedDiscounts, customers, discounts));
    }

    private static int[] splitStr(String arg) {
        String[] splitString = arg.split(",");
        int[] nums = new int[2];
        for (int i = 0; i < 2; i++) {
            nums[i] = Integer.parseInt(splitString[i].trim());
        }

        return nums;
    }
}

class Customer {
    private int customerId;
    private float yearlySpend;

    public Customer(int customerId, float yearlySpend) {
        this.customerId = customerId;
        this.yearlySpend = yearlySpend;
    }

    public int getCustomerId() {
        return customerId;
    }

    public float getYearlySpend() {
        return yearlySpend;
    }
}

class Discount {
    private int discountId;
    private int productId;
    private float dollarValue;

    public Discount(int discountId, int productId, float value) {
        this.discountId = discountId;
        this.productId = productId;
        this.dollarValue = value;
    }

    public int getDiscountId() {
        return discountId;
    }

    public int getProductId() {
        return productId;
    }

    public float getDollarValue() {
        return dollarValue;
    }
}

class DiscountAssignment {
    private int discountId;
    private int customerId;

    public DiscountAssignment(int discountId, int customerId) {
        this.discountId = discountId;
        this.customerId = customerId;
    }

    public int getDiscountId() {
        return discountId;
    }

    public int getCustomerId() {
        return customerId;
    }
}
