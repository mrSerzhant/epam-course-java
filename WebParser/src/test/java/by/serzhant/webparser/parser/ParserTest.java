package by.serzhant.webparser.parser;

import by.serzhant.webparser.entity.Gem;
import by.serzhant.webparser.entity.NaturalGem;
import by.serzhant.webparser.entity.SynthesizedGem;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ParserTest {

    @DataProvider(name = "data-parser-positive")
    public Object[][] dataParserPositive() {
        List<Gem> list = new ArrayList<>();
        list.add(new NaturalGem("almaz",1,"Hight","precious","Canada","different",80,8,10,"manual"));
        list.add(new SynthesizedGem("spinel",2,null,"precious","Brazil","red",2,8,20,"2012-11-22"));
        return new Object[][]{{list}};
    }

    @DataProvider(name = "data-parser-negative")
    public Object[][] dataParserNegative() {
        List<Gem> list = new ArrayList<>();
        list.add(new NaturalGem("almaz",1,"Hight","precious","Canada","different",22,8,10,"manual"));
        list.add(new SynthesizedGem("topaz",2,null,"precious","Brazil","red",2,8,55,"2012-11-05"));
        return new Object[][]{{list}};
    }

    @Test(dataProvider = "data-parser-positive")
    public void domParserTestPositive(List<Gem> inputData) {
        DomParser domParser = new DomParser();
        URL xmlUrl = ParserTest.class.getClassLoader().getResource("valid.xml");
        Assert.assertEquals(domParser.parse(xmlUrl.getPath()),inputData);
    }

    @Test(dataProvider = "data-parser-negative")
    public void domParserTestNegative(List<Gem> inputData) {
        DomParser domParser = new DomParser();
        URL xmlUrl = ParserTest.class.getClassLoader().getResource("valid.xml");
        Assert.assertNotEquals(domParser.parse(xmlUrl.getPath()),inputData);
    }

    @Test(dataProvider = "data-parser-positive")
    public void saxParserTestPositive(List<Gem> inputData) {
        SaxParser saxParser = new SaxParser();
        URL xmlUrl = ParserTest.class.getClassLoader().getResource("valid.xml");
        Assert.assertEquals(saxParser.parse(xmlUrl.getPath()),inputData);
    }

    @Test(dataProvider = "data-parser-negative")
    public void saxParserTestNegative(List<Gem> inputData) {
        SaxParser saxParser = new SaxParser();
        URL xmlUrl = ParserTest.class.getClassLoader().getResource("valid.xml");
        Assert.assertNotEquals(saxParser.parse(xmlUrl.getPath()),inputData);
    }

    @Test(dataProvider = "data-parser-positive")
    public void staxParserTestPositive(List<Gem> inputData) {
        StaxParser staxParser = new StaxParser();
        URL xmlUrl = ParserTest.class.getClassLoader().getResource("valid.xml");
        Assert.assertEquals(staxParser.parse(xmlUrl.getPath()),inputData);
    }

    @Test(dataProvider = "data-parser-negative")
    public void staxParserTestNegative(List<Gem> inputData) {
       StaxParser staxParser = new StaxParser();
        URL xmlUrl = ParserTest.class.getClassLoader().getResource("valid.xml");
        Assert.assertNotEquals(staxParser.parse(xmlUrl.getPath()),inputData);
    }

}
