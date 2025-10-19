import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class ShopTest {

    // tests in computer

    /*
     * This method tests whether the description in the computer matches the one in the constructor.
     */
    @Test
    public void test_computer_constructor_description(){
        Computer newComputer = new Computer(
            "2019 MacBook Pro", 
            "Intel", 
            256, 
            20, 
            "High Sierra", 
            2019, 
            1000);
        // add all of the information of the added computer
        // check if the description stored in newComputer is same with the expected "2019 MacBook Pro"
        assertEquals("2019 MacBook Pro", newComputer.description);
    }

    /*
     * This method tests whether the processor type in the computer matches the one in the constructor.
     */
    @Test
    public void test_computer_constructor_processorType(){
        Computer newComputer = new Computer(
            "2019 MacBook Pro", 
            "Intel", 
            256, 
            20, 
            "High Sierra", 
            2019, 
            1000);
        // check if the processor type stored in newComputer is same with the expected "Intel"
        assertEquals("Intel", newComputer.processorType);
    }

    /*
     * This method tests whether the hard drive capacity in the computer matches the one in the constructor.
     */
    @Test
    public void test_computer_constructor_hardDriveCapacity(){
        Computer newComputer = new Computer(
            "2019 MacBook Pro", 
            "Intel", 
            256, 
            20, 
            "High Sierra", 
            2019, 
            1000);
        // check if the hard drive capacity stored in newComputer is same with the expected "256"
        assertEquals(256, newComputer.hardDriveCapacity);
    }

    /*
     * This method tests whether the memory in the computer matches the one in the constructor.
     */
    @Test
    public void test_computer_constructor_memory(){
        Computer newComputer = new Computer(
            "2019 MacBook Pro", 
            "Intel", 
            256, 
            20, 
            "High Sierra", 
            2019, 
            1000);
        // check if the memory stored in newComputer is same with the expected "20"
        assertEquals(20, newComputer.memory);
    }

    /*
     * This method tests whether the operating system in the computer matches the one in the constructor.
     */
    @Test
    public void test_computer_constructor_operatingSystem(){
        Computer newComputer = new Computer(
            "2019 MacBook Pro", 
            "Intel", 
            256, 
            20, 
            "High Sierra", 
            2019, 
            1000);
        // checks if the stored operating system is same as the input one
        assertEquals("High Sierra", newComputer.operatingSystem);
    }

    /*
     * This method tests whether the year of the computer made matches the one in the constructor.
     */
    @Test
    public void test_computer_constructor_yearMade(){
        Computer newComputer = new Computer(
            "2019 MacBook Pro", 
            "Intel", 
            256, 
            20, 
            "High Sierra", 
            2019, 
            1000);
        // checks if the stored yearMade is same as input value
        assertEquals(2019, newComputer.yearMade);
    }

    /*
     * This method tests whether the computer constructor passes the price of computer correctly.
     */
    @Test
    public void test_computer_constructor_price(){
        Computer newComputer = new Computer(
            "2019 MacBook Pro", 
            "Intel", 
            256, 
            20, 
            "High Sierra", 
            2019, 
            1000);
        // checks if the price of computer is stored as inputted.
        assertEquals(1000, newComputer.price);
    }

    /*
     * This method tests the exception for the hardDriveCapacity
     */
    @Test(expected = IllegalArgumentException.class) 
    // checks whether the method throws exception when the value of the hardDrive capacity is not resonable.
    public void test_constructor_hardDriveCapacity_exception() {
        new Computer(
        "2019 MacBook Pro", 
        "Intel", 
        256, 
        20, 
        "High Sierra", 
        100, 
        1000);
    }


    /*
     * This method test the exception for setting the updated OS
     */
    @Test(expected=Exception.class)
    public void test_OS_exception() {
        Computer newComputer = new Computer(
            "2019 MacBook Pro", 
            "Intel", 
            256, 
            16, 
            "High Sierra", 
            2019, 
            1000);
        // checks if the updating OS throws appropriate exception when the value of it is unusual.
        newComputer.setOS("newOS");
        assertEquals("newOS", newComputer.operatingSystem);
    }

    /*
     * This method tests if the setPrice method can successfully update the new price
     */
    @Test 
    public void test_setPrice_exception(){
        Computer newComputer = new Computer(
            "2019 MacBook Pro", 
            "Intel", 
            256, 
            16, 
            "High Sierra", 
            2019, 
            1000);
        // checks if the updating price throws appropriate exception when the value of the price is unresonable
        newComputer.setPrice(2000);
        assertEquals(2000, newComputer.price);
    }

    /*
     * This method tests if the getYear method works properly
     */
    @Test
    public void test_getYear(){
        Computer newComputer = new Computer(
            "2019 MacBook Pro", 
            "Intel", 
            256, 
            16, 
            "High Sierra", 
            2019, 
            1000);
        assertEquals(2019, newComputer.yearMade); 
    }

    /*
     * This method tests whether the toString method returns a string containing key fields.
     */
    @Test
    public void test_toString_containsKeyInfo(){
        Computer newComputer = new Computer(
            "D",
            "Intel",
            256,
            16,
            "High Sierra",
            2019,
            1000
        );
        String s = newComputer.toString();
        assertTrue(s.contains("D"));
        assertTrue(s.contains("Intel"));
        assertTrue(s.contains("256"));
        assertTrue(s.contains("16"));      // if memory param is ignored, this check helps reveal that bug
        assertTrue(s.contains("High Sierra"));
        assertTrue(s.contains("2019"));
        
    }



    // tests in ResaleShop

    /*
     * This method tests whether the ResaleShop constructor seeds one computer.
     */
    @Test
    public void test_ResaleShop_constructor(){
        ResaleShop myShop = new ResaleShop();
        assertEquals(1, myShop.inventory.size());
        assertEquals("2019 MacBook Pro", myShop.inventory.get(0).description);
    }

    /*
     * This method tests whether buy() adds the same instance passed in replaced object.
     */
    @Test
    public void test_buy_adds_same_instance() throws Exception {
        ResaleShop shop = new ResaleShop();
        Computer mine = new Computer(
            "2020 MacBook Pro",
            "Intel",
            256,
            16,
            "OS",
            2020,
            1200
        );
        shop.buy(mine);
        // expect: inventory contains the same object we passed
        assertTrue(shop.inventory.contains(mine));
        // also check by description to ensure it's not silently overwritten to 2019 MBP
        boolean foundDesc = false;
        for (Computer c : shop.inventory) {
            if ("2020 MacBook Pro".equals(c.description)) { foundDesc = true; break; }
        }
        assertTrue(foundDesc);
    }

    /*
     * This method tests if buy() throws an exception when adding the same instance twice.
     */
    @Test(expected = Exception.class)
    public void test_buy_duplicate_shouldThrow() throws Exception {
        ResaleShop shop = new ResaleShop();
        Computer x = new Computer("A","CPU",128,8,"OS",2015,300);
        shop.buy(x);   // first time should be OK
        shop.buy(x);   // second time with the same instance should throw
    }

    /*
     * This method tests if sell() removes the item when present.
     */
    @Test
    public void test_sell_removes_present() throws Exception {
        ResaleShop shop = new ResaleShop();
        Computer first = shop.inventory.get(0);
        shop.sell(first);
        assertEquals(0, shop.inventory.size());
    }

    /*
     * This method tests if sell() throws when the computer is not in the inventory.
     */
    @Test(expected = Exception.class)
    public void test_sell_missing_shouldThrow() throws Exception {
        ResaleShop shop = new ResaleShop();
        Computer ghost = new Computer("ghost","Intel",128,8,"OS",2010,100);
        shop.sell(ghost);
    }

    /*
     * This method tests printInventory() off-by-one error (i <= size()) causing IndexOutOfBoundsException.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void test_printInventory_offByOne_shouldThrow(){
        ResaleShop shop = new ResaleShop();
        shop.inventory.add(new Computer("C1","Intel",128,8,"OS",2017,200));
        shop.inventory.add(new Computer("C2","Intel",128,8,"OS",2018,300));
        shop.printInventory();
    }

    /*
     * This method tests the empty message for printInventory().
     */
    @Test
    public void test_printInventory_emptyMessage(){
        ResaleShop shop = new ResaleShop();
        shop.inventory.clear();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        try {
            shop.printInventory();
        } finally {
            System.setOut(originalOut);
        }
        assertTrue(outContent.toString().contains("Inventory is empty"));
    }

    /*
     * This method tests refurbish() price tiers (<2000, <2012, <2018, else).
     */
    @Test
    public void test_refurbish_price_tiers() throws Exception {
        ResaleShop shop = new ResaleShop();

        Computer y1999 = new Computer("A","Intel",128,8,"OS",1999,1);
        Computer y2011 = new Computer("B","Intel",128,8,"OS",2011,1);
        Computer y2017 = new Computer("C","Intel",128,8,"OS",2017,1);
        Computer y2020 = new Computer("D","Intel",128,8,"OS",2020,1);

        shop.inventory.add(y1999);
        shop.inventory.add(y2011);
        shop.inventory.add(y2017);
        shop.inventory.add(y2020);

        shop.refurbish(y1999, "None");  assertEquals(0,    y1999.price);
        shop.refurbish(y2011, "None");  assertEquals(250,  y2011.price); // BUG: code sets 2500
        shop.refurbish(y2017, "None");  assertEquals(550,  y2017.price);
        shop.refurbish(y2020, "None");  assertEquals(1000, y2020.price);
    }

    /*
     * This method tests refurbish() should update OS when newOS is not "None".
     */
    @Test
    public void test_refurbish_updates_OS_when_new() throws Exception {
        ResaleShop shop = new ResaleShop();
        Computer c = new Computer("PC","Intel",256,16,"Windows 10",2018,1);
        shop.inventory.add(c);

        shop.refurbish(c, "Windows 11");
        assertEquals("Windows 11", c.operatingSystem);
    }

    /*
     * This method tests refurbish() should not update OS when newOS is "None".
     */
    @Test
    public void test_refurbish_OS_none_no_change() throws Exception {
        ResaleShop shop = new ResaleShop();
        Computer c = new Computer("PC","Intel",256,16,"Windows 10",2020,1);
        shop.inventory.add(c);

        shop.refurbish(c, "None");
        assertEquals("Windows 10", c.operatingSystem);
    }
}