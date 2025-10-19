import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class ShopTest {

    // tests in Computer

    /*
     * Tests if the description matches the value passed in the constructor.
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
        assertEquals("2019 MacBook Pro", newComputer.description);
    }

    /*
     * Tests if the processor type matches the constructor input.
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
        assertEquals("Intel", newComputer.processorType);
    }

    /*
     * Tests if the hard drive capacity matches the constructor input.
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
        assertEquals(256, newComputer.hardDriveCapacity);
    }

    /*
     * Tests if the memory is stored correctly from the constructor.
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
        assertEquals(20, newComputer.memory);
    }

    /*
     * Tests if the operating system matches the constructor input.
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
        assertEquals("High Sierra", newComputer.operatingSystem);
    }

    /*
     * Tests if the year made matches the constructor input.
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
        assertEquals(2019, newComputer.yearMade);
    }

    /*
     * Tests if the price matches the constructor input.
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
        assertEquals(1000, newComputer.price);
    }

    /*
     * Tests if setOS() correctly updates the OS.
     */
    @Test
    public void test_setOS_updates(){
        Computer newComputer = new Computer(
            "2019 MacBook Pro", 
            "Intel", 
            256, 
            16, 
            "High Sierra", 
            2019, 
            1000);
        newComputer.setOS("Monterey");
        assertEquals("Monterey", newComputer.operatingSystem);
    }

    /*
     * Tests if setPrice() correctly updates the price.
     */
    @Test 
    public void test_setPrice_updates(){
        Computer newComputer = new Computer(
            "2019 MacBook Pro", 
            "Intel", 
            256, 
            16, 
            "High Sierra", 
            2019, 
            1000);
        newComputer.setPrice(2000);
        assertEquals(2000, newComputer.price);
    }

    /*
     * Tests if getYear() returns the correct year.
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
        assertEquals(2019, newComputer.getYear()); 
    }

    /*
     * Tests if toString() includes all main attributes.
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
        assertTrue(s.contains("16"));
        assertTrue(s.contains("High Sierra"));
        assertTrue(s.contains("2019"));
    }

    /*
     * Tests if toString() ends with the price given to the constructor.
     * Expected: "...1000" at the end; current code prints "...0".
     */
    @Test
    public void test_toString_includes_price_from_constructor(){
        Computer newComputer = new Computer(
            "2019 MacBook Pro",
            "Intel",
            256,
            16,
            "High Sierra",
            2019,
            1000
        );
        String s = newComputer.toString();
        assertTrue(s.endsWith("1000"));
    }


    // tests in ResaleShop

    /*
     * Tests if the shop starts with one computer in inventory.
     */
    @Test
    public void test_ResaleShop_constructor(){
        ResaleShop myShop = new ResaleShop();
        assertEquals(1, myShop.inventory.size());
        assertEquals("2019 MacBook Pro", myShop.inventory.get(0).description);
    }

    /*
     * Tests if buy() adds the same instance instead of replacing it.
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
        assertTrue(shop.inventory.contains(mine));
        boolean foundDesc = false;
        for (Computer c : shop.inventory) {
            if ("2020 MacBook Pro".equals(c.description)) { foundDesc = true; break; }
        }
        assertTrue(foundDesc);
    }

    /*
     * Tests if buying the same computer twice throws an exception.
     */
    @Test(expected = Exception.class)
    public void test_buy_duplicate_shouldThrow() throws Exception {
        ResaleShop shop = new ResaleShop();
        Computer x = new Computer("A","CPU",128,8,"OS",2015,300);
        shop.buy(x);
        shop.buy(x);
    }

    /*
     * Tests if selling removes a computer that exists in the shop.
     */
    @Test
    public void test_sell_removes_present() throws Exception {
        ResaleShop shop = new ResaleShop();
        Computer first = shop.inventory.get(0);
        shop.sell(first);
        assertEquals(0, shop.inventory.size());
    }

    /*
     * Tests if selling a computer not in the shop throws an exception.
     */
    @Test(expected = Exception.class)
    public void test_sell_missing_shouldThrow() throws Exception {
        ResaleShop shop = new ResaleShop();
        Computer ghost = new Computer("ghost","Intel",128,8,"OS",2010,100);
        shop.sell(ghost);
    }

    /*
     * Tests if printInventory() throws IndexOutOfBounds due to <= condition.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void test_printInventory_offByOne_shouldThrow(){
        ResaleShop shop = new ResaleShop();
        shop.inventory.add(new Computer("C1","Intel",128,8,"OS",2017,200));
        shop.inventory.add(new Computer("C2","Intel",128,8,"OS",2018,300));
        shop.printInventory();
    }

    /*
     * Tests if printInventory() prints "Inventory is empty" when empty.
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
     * Tests if refurbish() assigns correct prices for each year range.
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
        shop.refurbish(y2011, "None");  assertEquals(250,  y2011.price);
        shop.refurbish(y2017, "None");  assertEquals(550,  y2017.price);
        shop.refurbish(y2020, "None");  assertEquals(1000, y2020.price);
    }

    /*
     * Tests if refurbish() updates OS when given a new OS.
     */
    @Test
    public void test_refurbish_updates_OS_when_new() throws Exception {
        ResaleShop shop = new ResaleShop();
        Computer newComputer = new Computer("PC","Intel",256,16,"Windows 10",2018,1);
        shop.inventory.add(newComputer);

        shop.refurbish(newComputer, "Windows 11");
        assertEquals("Windows 11", newComputer.operatingSystem);
    }

    /*
     * Tests if refurbish() does not change OS when newOS is "None".
     */
    @Test
    public void test_refurbish_OS_none_no_change() throws Exception {
        ResaleShop shop = new ResaleShop();
        Computer newComputer = new Computer("PC","Intel",256,16,"Windows 10",2020,1);
        shop.inventory.add(newComputer);

        shop.refurbish(newComputer, "None");
        assertEquals("Windows 10", newComputer.operatingSystem);
    }

    /*
     * Tests that fields are directly writable from outside (should not be allowed).
     * This exposes the lack of encapsulation as a design bug.
     */
    @Test
    public void test_direct_field_write_is_possible() {
        Computer newComputer = new Computer(
            "2019 MacBook Pro", 
            "Intel", 
            256, 
            16, 
            "High Sierra", 
            2019, 
            1000);
        newComputer.operatingSystem = "HackedOS";
        newComputer.price = -42;
        assertEquals("HackedOS", newComputer.operatingSystem);
        assertEquals(-42, newComputer.price);
    }
    /*
     * Tests that refurbish() should not change OS when newOS is "None"
     * even if it's a new String object. This reveals the '!=' string check bug.
     */
    @Test
    public void test_refurbish_OS_none_newString_should_not_change() throws Exception {
        ResaleShop myShop = new ResaleShop();
        Computer newComputer = new Computer("PC","Intel",256,16,"Windows 10",2020,1);
        myShop.inventory.add(newComputer);

        // different reference but same content
        String noneArg = new String("None");
        myShop.refurbish(newComputer, noneArg);

        // should stay "Windows 10", but code updates OS due to '!=' and setOS bug
        assertEquals("Windows 10", newComputer.operatingSystem);
    }

}
