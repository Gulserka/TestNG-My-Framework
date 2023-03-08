package utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

    @DataProvider
    public Object[][] musteriVerileri(){
        Object[][] musteriGirisBilgileri = {
                {"menejer1", "12345", "besiktas"},
                {"menejer2", "98765", "karsiyaka"},
                {"menejer3", "5678", "sisli"}
        };
        return musteriGirisBilgileri;
    }

    @DataProvider
    public Object[][] musteriHizmetleriVerileri(){
        Object[][] musteriHizmetleriGirisBilgileri = {
                {"adam1", "3456"},
                {"ali2", "1234"},
                {"nancy3", "7890"}
        };
        return musteriHizmetleriGirisBilgileri;
    }


    @DataProvider
    public Object[][] personelVerileri(){
        Object[][] personelGirisBilgileri = {
                {"rukiye1", "abc1"},
                {"mehmet2", "123r"},
                {"emin3", "3edc"},
                {"baran3", "4asd"},
                {"okumus3", "6e45"}
        };
        return personelGirisBilgileri;
    }

    //Excelden dataProvider a data gelir
    //Burdan da Test Case e gider
    @DataProvider
    public Object[][] customerData(){
        //DataProviderTest2 ile bu method arasindaki tek fark bu method da datalar Excel den gelir
        //Bu kullanim daha guzeldir
        String path = "src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName = "customer_info";
        ExcelUtils excelUtils = new ExcelUtils(path, sheetName);

        Object[][] musteriBilgileri = excelUtils.getDataArrayWithoutFirstRow();//ilk datalar hariç hepsini ver
        return musteriBilgileri;
    }

    @DataProvider()
    public Object[][] sifreler(){
        Object[][] sifreListesi = {
                {"Üg1*Ad","Strong"},
                {"Üg1*","Too short"},
                {"üg1*ad","Good"},
                {"ÜG1*AD","Good"},
                {"123456","Weak"}
        };
        return sifreListesi;
    }
}
