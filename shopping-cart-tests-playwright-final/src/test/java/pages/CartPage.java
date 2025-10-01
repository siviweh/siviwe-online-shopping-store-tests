package pages;

import com.microsoft.playwright.Page;

import static org.junit.Assert.assertEquals;

public class CartPage {
    private Page page;
    private String cartItems = ".cart-item";
    private String removeBtn = ".cart-item button";
    private String quantityText = ".cart-item-quantity";
    private String increaseBtn = ".cart-item button:has-text('+' )";

    public CartPage(Page page) {
        this.page = page;
    }

    public int getCartItemCount() {
        return page.locator(cartItems).count();
    }

    public void removeFirstItem() {
        page.click(removeBtn);
    }

    public void assertCartEmpty() {
        assertEquals(0, getCartItemCount());
    }

    public void assertCartHasItems(int expected) {
        assertEquals(expected, getCartItemCount());
    }

    public void increaseQuantity() {
        page.click(increaseBtn);
    }

    public void assertQuantity(String expectedQty) {
        String qty = page.textContent(quantityText).trim();
        assertEquals(expectedQty, qty);
    }
}