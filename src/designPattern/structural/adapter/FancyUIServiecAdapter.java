package designPattern.structural.adapter;

public class FancyUIServiecAdapter implements IMultiRestoApp{
    private FancyUiServie fancyUiServie;

    FancyUIServiecAdapter(FancyUiServie fancyUiServie){
        this.fancyUiServie = fancyUiServie;
    }
    @Override
    public void displayMenu(String xml) {
       String json  = convertXmlToJson(xml);
       fancyUiServie.displayMenu(json);
    }

    @Override
    public void displayRecomendation(String xml) {
        String json  = convertXmlToJson(xml);
        fancyUiServie.displayRecommendation(json);
    }

    String convertXmlToJson(String xml){
        return "Json";
    }
}
