package tests.cucumber.app.action;

import cucumber.api.DataTable;
import tests.cucumber.app.dto.Article;

import java.math.BigDecimal;
import java.util.List;

public interface Booking {
    void booking(Article arc);
    BigDecimal bookingForData(DataTable articles);
}
