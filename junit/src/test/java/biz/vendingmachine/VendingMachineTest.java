package biz.vendingmachine;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {

    @Test
    public void testGetChangeAmount() throws Exception{
        VendingMachine machine = new VendingMachine();
        machine.putCoin(100);
        assertEquals("투입금액 100원", 100, machine.getChangeAmount());

        machine.putCoin(500);
        assertEquals("추가 투입금액 500원", 600, machine.getChangeAmount());
    }

    @Test
    public void testReturnChangeCoinSet_oneCoin_50() throws Exception{
        ChangeModule module = new ChangeModule();
        CoinSet expectedCoinSet = new CoinSet();
        expectedCoinSet.add(50);
        assertEquals("700원 투입 후 650원 음료선택", expectedCoinSet, module.getChangeCoinSet(50));
    }

    @Test
    public void testReturnChangeCoinSet_coins_180() throws Exception{
        ChangeModule module = new ChangeModule();
        CoinSet expectedCoinSet = new CoinSet();
        expectedCoinSet.add(100);
        expectedCoinSet.add(50);
        expectedCoinSet.add(10);
        expectedCoinSet.add(10);
        expectedCoinSet.add(10);
        assertEquals("700원 투입 후 520원 음료선택", expectedCoinSet, module.getChangeCoinSet(180));
    }
}
