package tests.cucumber.app.dto;

import cucumber.api.DataTable;
import org.apache.commons.lang3.StringUtils;
import tests.cucumber.android.utils.TypeChoose;
import tests.cucumber.app.utils.Utils;

import java.math.BigDecimal;
import java.util.*;

public class OrderedArticles {
    public HashMap<String, Article> articles = new HashMap<>();
    public DataTable data;

    public void setArticles(Article article) {
        articles.put(article.id, article);
    }
    public Article getArticleAtIndex(int index) {
        List values = new ArrayList(articles.values());
        return  (Article)values.get(index);
    }
    public BigDecimal sumOfOrder() {
        BigDecimal sum = BigDecimal.valueOf(0);
        for (Article ar : articles.values()) {
            sum = sum.add(ar.quantity.multiply(ar.price));
        }
        return sum;
    }

    private boolean isPortion(Map<String, String> map){
        String isPortion = map.get("Is Portion");
        if (StringUtils.isEmpty(isPortion) ){
            return false;
        }
        return Boolean.parseBoolean(isPortion);
    }

    private TypeChoose isCheckAge(Map<String, String> map){
        String value = map.get("Age restriction");
        if (StringUtils.isEmpty(value) ){
            return TypeChoose.EMPTY;
        }
        TypeChoose typeChoose = TypeChoose.valueOf(value.toUpperCase());
        return typeChoose;
    }
    private String noted(Map<String, String> map){
        String noted = map.get("Noted");
        if (StringUtils.isEmpty(noted)){
            return "";
        }
        return noted;
    }

    private BigDecimal getAmount(Map<String, String> map) {
        String amount = map.get("Amount");
        if (StringUtils.isEmpty(amount) || !StringUtils.isAlphanumeric(amount)) {
            return BigDecimal.ONE;
        }
        return BigDecimal.valueOf(Double.parseDouble(amount));
    }

    private String getMainFoodId(Map<String, String> map) {
        String Id = map.get("Main Food Id");
        if (StringUtils.isEmpty(Id) || !StringUtils.isAlphanumeric(Id)) {
            return StringUtils.EMPTY;
        }
        return Id;
    }

    public void removeArticle(String id){
        articles.remove(id);
    }

    private String isResetDeposit(Map<String, String> map){
        String isDeposit = map.get("Is Deposit");
        if (StringUtils.isEmpty(isDeposit)){
            return "";
        }
        return isDeposit;
    }
    public List<Article> mapDataFromDataTable() {
        List<Article> lst = new ArrayList<>();
        if (data!=null){
            List<Map<String, String>> list = data.asMaps(String.class, String.class);
            for (int i=0;i<list.size();i++) {
                Article article = new Article();
                try {
                    if (!StringUtils.isEmpty(list.get(i).get("Main Food"))) {
                        article.name = list.get(i).get("Main Food");
                        article.price = Utils.ConvertToBigDecimal(list.get(i).get("Price"));
                        article.stringPrice = list.get(i).get("Price");
                        article.quantity = getAmount(list.get(i));
                        article.articleId = getMainFoodId(list.get(i));
                    }
                    else {
                        article.name = "";
                        article.price = BigDecimal.valueOf(0);
                        article.quantity = BigDecimal.valueOf(0);
                    }
                    if (StringUtils.isNotEmpty(list.get(i).get("Secondary Food"))){
                        article.isAdditional = true;
                        article.ageRestriction = isCheckAge(list.get(i));
                        article.isPortion = isPortion(list.get(i));
                        article.isDeposit = isResetDeposit(list.get(i));
                        article.noted = noted(list.get(i));
                        article.setArticleAdditional(new Article(list.get(i).get("Secondary Food"),
                                BigDecimal.valueOf(1),
                                Utils.ConvertToBigDecimal(list.get(i).get("Secondary Price"))));
                    }

                    lst.add(article);

                } catch (NullPointerException nullEx){
                    nullEx.printStackTrace();
                }

            }
        }
        return lst;
    }


}
