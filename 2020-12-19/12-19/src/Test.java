public class Test {
    public static void main(String[] args)
    {
        Customer customer=new Customer();
        /*customer.customerId="1800800509";
        customer.customerName="曹洋";
        customer.address="桂林电子科技大学";
        customer.phone="18233334444";*/

        customer.setCustomerId("1800800509");
        customer.setCustomerName("曹洋");
        customer.setAddress("桂林电子科技大学");
        customer.setPhone("18233334444");

        Order order=new Order();
        /*order.orderId="12345";
        order.ammount=880F;*/

        order.setOrderId("12345");
        order.setAmmount(880F);
       /* customer.order=order;

        System.out.println("订单金额："+customer.order.ammount);*/
    }
}
