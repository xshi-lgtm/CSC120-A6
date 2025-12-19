## Bug 1
Brief description: Computer constructor ignores the memory parameter (hard-coded to 16).
Failed unit test: test_computer_constructor_memory()

## Bug 2
Brief description: Computer constructor ignores the price parameter (hard-coded to 0).
Failed unit test: test_computer_constructor_price()

## Bug 3
Brief description: setOS(String) sets the OS to "None" instead of the provided value.
Failed unit test: test_setOS_updates()

## Bug 4
Brief description: Computer fields are not private, so callers can mutate them directly (breaks encapsulation).
Failed unit test: test_fields_should_be_private()

## Bug 5
Brief description: ResaleShop.buy(Computer) does not add the same instance; it creates a new Computer instead.
Failed unit test: test_buy_adds_same_instance()

## Bug 6
Brief description: ResaleShop.buy(Computer) does not reject duplicates (adding the same instance twice should throw).
Failed unit test: test_buy_duplicate_shouldThrow()

## Bug 7
Brief description: ResaleShop.sell(Computer) does not throw when the computer is not in the inventory.
Failed unit test: test_sell_missing_shouldThrow()

## Bug 8
Brief description: printInventory() uses i <= size() and goes out of bounds (off-by-one).
Failed unit test: test_printInventory_offByOne_shouldThrow()

## Bug 9
Brief description: refurbish(<2012) sets price to 2500 instead of 250 (wrong tier).
Failed unit test: test_refurbish_price_tiers()

## Bug 10
Brief description: refurbish compares strings with '!='; passing new String("None") incorrectly triggers the OS update path (and setOS is also wrong).
Failed unit test: test_refurbish_OS_none_newString_should_not_change()
